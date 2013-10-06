package fr.stateofmind.scala.dojo.specs.matchers

import org.specs2.mutable.Specification

class SomeEitherSpec extends Specification {
  "foo" should {
    "bar" in {
      util.Try(1) must beSuccessfulTry.which(_ < 0)
    }

    "baz" in {
      Some(1) must beSome.which(_ < 0)
    }
  }
}
