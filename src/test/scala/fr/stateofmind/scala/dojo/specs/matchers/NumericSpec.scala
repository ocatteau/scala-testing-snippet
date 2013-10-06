package fr.stateofmind.scala.dojo.matchers

import org.specs2.mutable.{BeforeAfter, Specification}

class NumericSpec extends Specification {

  "Equal or Not Equal with BeforeAfter" should {
    lazy val context = new BeforeAfter {
      def before = println("Before Equal or Not")

      def after = println("After Equal or Not")
    }

    "Equal" in context {
      println("Equal")
      1 + 1 mustEqual 2
      1 + 1 must beEqualTo(2)
      1 + 1 must be_==(2)
      1 + 1 must_== 2
      1 + 1 must be equalTo 2
      1 + 1 === 2
    }

    "Not equal" in context {
      println("Not equal")
      1 + 1 mustNotEqual  3
      1 + 1 must not be_==(3)
      1 + 1 must_!=  3
      1 + 1 must not be equalTo(3)
      1 + 1 !== 3
    }
  }

  // -----------------------------------------------------

  case class MyContext() extends BeforeAfter {
    def before = println("MyContext Before")

    def after = println("MyContext After")
  }

  "Equality between different types" should {
    lazy implicit val context = new MyContext

    "Equality between int and BigDecimal" in {
      println("Equality between int and BigDecimal")
      val i = 5
      val bi = BigDecimal(5)

      i must_== bi
    }
  }

  // -----------------------------------------------------

  "comparison" should {
    "less than" in {
      4 must be lessThan 6
      4 must beLessThan(6)
      4 must be_<(6)

      4 must be lessThanOrEqualTo 6
      4 must be_<=(6)
    }

    "greater than" in {
      4 must be greaterThan 2
      4 must beGreaterThan(2)
      4 must be_>(2)

      4 must be greaterThanOrEqualTo 2
      4 must be_>=(2)
    }

    "close to" in {
      4 must beCloseTo(3, 1)
      4 must be ~(3 +/- 1)
    }

    "between" in {
      4 must beBetween(4, 6)
      5 must beBetween(4, 6).excludingStart
      5 must beBetween(4, 6).excludingEnd
      5 must beBetween(4, 6).excludingBounds
    }
  }
}
