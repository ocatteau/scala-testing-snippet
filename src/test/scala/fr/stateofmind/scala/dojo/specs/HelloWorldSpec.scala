package fr.stateofmind.scala.dojo.specs

import org.specs2.mutable.Specification


class HelloWorldSpec extends Specification {

  "The 'Hello world' string" should {

    "contain 11 characters" in {
      "Hello world" must have size(11)
    }

    "start with 'Hello'" in {
      "Hello world" must startWith("Hello")
    }

    "end with 'world'" in {
      "Hello world" must endWith("world")
    }

    "success" in {
      success
    }
  }

  "Example description" ! {
    "Hello" must contain("ll")
  }

  "Pending" ! {
    pending
  }

  "Another example" ! e1

  def e1 = "hello" must have size 5 and startWith("he")

}
