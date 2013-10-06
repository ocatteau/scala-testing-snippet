package fr.stateofmind.scala.dojo.specs.matchers

import org.specs2.mutable.Specification
import org.specs2.matcher.{Expectable, Matcher}

class CustomMatcherSpec extends Specification {

  def beBetween(i: Int, j: Int) = be_>=(i) and be_<=(j)

  "Custom beBetween" in {
    4 must beBetween(2, 5)
  }

  //----------------------------------------------------------------------------------------
  def beAllPositive: Matcher[Seq[Int]] = be_>=(0).foreach

  "Custom allPositive" in {
    Seq(1, 2, 3) must beAllPositive
  }

  //----------------------------------------------------------------------------------------

  def haveToStringShorterThan(max: Int) = be_<=(max) ^^ { (t: Any) => t.toString.size aka "toString size" }
  "Custom haveToStringShorterThan" in {
    "Hello" must haveToStringShorterThan(6)
    // if max=3 then error message will be "toString size '5' is greater than 3"
    // and without "aka "toString size" then error message will be "5 is greater than 3"
  }

  //----------------------------------------------------------------------------------------
  case class Person(firstname: String, lastname: String)

  def bePersonEqualTo = (be_==(_: Person)) ^^^ ((_: Person).copy(firstname = ""))

  "Custom Person comparaison" in {
    Person("Joe", "Dalton") must bePersonEqualTo(Person("Avrel", "Dalton"))
  }

  //----------------------------------------------------------------------------------------

  val startWithHi: Matcher[String]  = ((_: String).startsWith("Hi"), "doesn't start with Hi")
  val startWithHi2: Matcher[String]  = ((_: String).startsWith("Hi"), (s:String) => s+ " doesn't start with Hi")
  val startWithHi3: Matcher[String]  = (s: String) => (s.startsWith("Hi"), s+" doesn't start with Hi")

  "Custom startWith" in {
    "Hi Bob" must startWithHi
  }

  //----------------------------------------------------------------------------------------
  val containBar = new Matcher[String] {
    def apply[S <: String](s: Expectable[S]) = {
      result(s.value.contains("Bar"),
        s.description + " contains Bar",
        s.description + " does not contain Bar",
        s)
    }
  }

  "Custom matcher" in {
    "Foo Bar Baz" must containBar
  }
}
