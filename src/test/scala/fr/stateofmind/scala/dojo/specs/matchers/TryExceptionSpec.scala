package fr.stateofmind.scala.dojo.specs.matchers

import org.specs2.mutable.Specification
import scala.util.Try
import java.lang.IllegalArgumentException
import scala.IllegalArgumentException

class TryExceptionSpec extends Specification {

  "Try" should {
    "beSuccessful" in {
      Try(1) must beSuccessfulTry

      Try(1) must beSuccessfulTry.withValue(1)

      Try(1) must beSuccessfulTry.which(_ > 0)

    }

    "beFailedTry" in {
      Try(throw new IllegalArgumentException("Bad parameter")) must beFailedTry

      Try(throw new IllegalArgumentException("Bad parameter")) must beFailedTry.withThrowable[IllegalArgumentException]

      Try(throw new IllegalArgumentException("Bad parameter")) must beFailedTry.withThrowable[IllegalArgumentException]("Bad parameter")
    }
  }

  "Exception" should {
    def throwIllegalArgException(s : String) = {
      if (s == "0")
        0
      else
        throw new IllegalArgumentException("Bad parameter : " + s)
    }

    "throwA" in {
      throwIllegalArgException("bad") must throwA[IllegalArgumentException]

      throwIllegalArgException("bad") must throwA[IllegalArgumentException]("Bad parameter : bad")

      throwIllegalArgException("bad") must throwA("Bad parameter : bad")
    }
  }

}
