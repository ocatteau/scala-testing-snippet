package fr.stateofmind.scala.dojo.specs.matchers

import org.specs2.mutable.Specification

class OptionEitherSpec extends Specification {

  "Option" should {
    "beSome" in {
      Some("one") must beSome
      Some("one") must beSome("one")

      Some("one") must beSome.which(s => s == "one")

      Some("one") must beSome.like { case s if (s == "one") =>  ok }
    }

    "beNone" in {
      val a = None
      a must beNone

      val b = None
      a must beAsNoneAs(b)
    }
  }

  def toInt(string: String): Either[String, Int] = {
    try { Right(string.toInt)} catch { case e => Left("Error : " + e.getMessage)}
  }

  "Either" should {
    "beRight" in {
      toInt("1") must beRight
      toInt("1") must beRight(1)

      toInt("1") must beRight.like { case s if (s.toInt % 2 == 1) => ok }
    }

    "beLeft" in {
      toInt("abc") must beLeft
      toInt("abc") must beLeft("Error : For input string: \"abc\"")
      toInt("abc") must beLeft.like { case s: String if (s.contains("abc")) => ok }
    }
  }

}
