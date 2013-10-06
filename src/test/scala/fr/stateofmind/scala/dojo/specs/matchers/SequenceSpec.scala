package fr.stateofmind.scala.dojo.matchers

import org.specs2.mutable.Specification

class SequenceSpec extends Specification {

  "Sequence matchers" should {
    "empty" in {
      Nil must beEmpty
      Nil must be empty
    }

    "size" in {
      Seq(1, 2, 3) must have size 3
      Seq(1, 2, 3) must have length 3
    }

    "sorted" in {
      Seq(1, 2, 3) must be sorted

      Seq(1, 2, 3) must beSorted

      Seq(3, 2, 1) must not beSorted
    }

    "contain" in {
      Seq(1, 2, 3) must contain(1)
      Seq(1, 2, 3) must not contain(99)

      Seq(1, 2, 3) must contain(be_>(2))

      Seq(1, 2, 3) must contain((i: Int) => i%2 must be_==(0))
    }

    "contain all" in {
      Seq(1, 2, 3) must containAllOf(List(1, 2, 3))
    }

    "equalTo" in {
      Seq(1, 2, 3) must equalTo(List(1, 2, 3))
      Seq(1, 2, 3) must not equalTo(List(1, 3, 2))
    }

    "same elements" in {
      List(1, List(2, 3, List(4)), 5) must haveTheSameElementsAs(List(5, List(List(4), 2, 3), 1))

      Seq(3, 2, 1) must containTheSameElementsAs(Seq(1, 2, 3))
    }
  }

  "Sequences and string specialied matcher" should {
    "one element must contain" in {
      Seq("abcdef", "xy") must contain("cd")
    }

    "no element must contain" in {
      Seq("abcdef", "xy") must not contain("pq")
    }

    "one element must contain a value matching a pattern" in {
      Seq("abcdef", "xy") must containPattern(".*ef")
    }
  }

  "Checking occurs n times" should {
    "The checking must occur at least once" in  {
      Seq(1, 2, 3) must contain(be_>(1)).atLeastOnce
    }

    "The checking must occur at most once" in  {
      Seq(1, 2, 3) must contain(be_>(2)).atMostOnce
    }
    "The checking must occur 2 times" in  {
      Seq(1, 2, 3) must contain(be_>(1)).exactly(2)
      Seq(1, 2, 3) must contain(be_>(1)).exactly(2.times)
    }

    "The checking must occur between 1 and 2 times" in  {
      Seq(1, 2, 3) must contain(be_>(1)).between(1, 2)
      Seq(1, 2, 3) must contain(be_>(1)).between(1.times, 2.times)
    }

    "Specifying number of times the checking must occur for each elements and throw an exception by printing first failure" in  {
      Seq(1, 2, 3) must contain(be_>(0)).forall
    }

    "Specifying number of times the checking must occur for each elements and throw an exception by printing all failures" in  {
      Seq(1, 2, 3) must contain(be_>(0)).foreach
    }
  }

  "Checking a set of values" should {
    "Checking contains values 2 and 3" in {
      Seq(1, 2, 3) must contain(2, 3)
      Seq(1, 2, 3) must contain(allOf(2, 3))
    }

    "Checking by combining matchers" in {
      Seq(1, 2, 3) must contain(allOf(be_>(0), be_>(2)))
    }
  }

  "Checking beLike with partial function" in {
    Seq(1, 2, 3) must beLike { case x :: y :: z :: Nil => ok }
  }

  "Checking foreach or forall" in {
    ((_:Int) must be_>(0)).foreach(Seq(1, 2, 3))

    foreach(Seq(1, 2, 3)) ((_:Int) must be_>(0))

    foreachWhen(Seq(1, 4, 6)) { case i if i > 2 => i must be_<(10) }
  }
}
