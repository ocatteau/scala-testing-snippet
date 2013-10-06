package fr.stateofmind.scala.dojo.specs.matchers

import org.specs2.mutable.Specification
import org.specs2.matcher.ResultMatchers

class ResultSpec extends Specification with ResultMatchers {

  "Checking the successful result of another matcher" in {
    ("Foo" must startingWith("Fo")) must beSuccessful
  }

  "Checking the result of another matcher" in {
    ("Foo" must startingWith("Bar")) must beFailing
  }
}
