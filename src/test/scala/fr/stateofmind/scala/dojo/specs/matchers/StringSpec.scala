package fr.stateofmind.scala.dojo.matchers

import org.specs2.mutable.Specification


class StringSpec extends Specification {

    "String lenght" should {

      "have length" in {
        "Hello" must have length 5
        "Hello" must haveLength(5)
        "Hello" must have size 5
      }

      "empty" in {
        "" must be empty
      }

      "start with" in {
        "Hello" must startWith("He")
        "Hello" must startingWith("He")
      }

      "start with" in {
        "Hello" must endWith("lo")
        "Hello" must endingWith("lo")
      }

      "contain" in {
        "Hello" must contain("el")
        "Hello" must containing("el")
      }

      "equalTo" in {
        "Hello" must equalTo("Hello")
        "Hello" must beEqualTo("Hello")

        " Hello " must equalTo("Hello").trimmed
        "HELLO" must equalTo("Hello").ignoreCase
        "He llo" must equalTo("Hell o").ignoreSpace
        "He llo" must equalTo("HELL O").ignoreSpace.ignoreCase
      }

      "regex" in {
        "Hello" must be matching("H.*")

        "abbcccdddd" must find("a(b*)(c*)").withGroups("bb", "ccc")
      }

      "containAllOf - containAnyOf" in {
        Seq("Hello", "Hi", "Hey", "Yo") must containAllOf(Seq("Hi", "Yo"))

        Seq("Hello", "Hi", "Hey", "Yo") must containAnyOf(Seq("Hi", "Bonjour"))
      }
    }

}
