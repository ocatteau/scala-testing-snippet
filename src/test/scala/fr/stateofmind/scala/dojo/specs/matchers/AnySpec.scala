package fr.stateofmind.scala.dojo.specs.matchers

import scala.util.matching.Regex
import org.specs2.mutable.Specification
import scala.Serializable

class AnySpec extends Specification {

  val Name = new Regex( """(\w+)\s+(\w+)""")

  trait Bar

  abstract class AbstractFoo

  class Foo extends AbstractFoo with Bar


  "beLike with partial function" should {
    "beLike ok" in {
      "Olivier Catteau" must beLike {
        case Name(first, last) => ok
        case _ => ko
      }
    }

    "beLike with partial function" in {
      "Olivier Catteau" must beLike { case s => s must be matching(Name) }
    }
  }

  "beOneOf" in {
    "Joe" must beOneOf("Bill", "Joe", "Luke")
  }

  "haveClass" in {
    new Foo must haveClass[Foo]
  }

  "haveSuperclass" in {
    new Foo must haveSuperclass[AbstractFoo]
  }

  "haveInterface" in {
    new Foo must haveInterface[Bar]
  }

  "beAnInstanceOf" in {
    val foo = new Foo
    foo must beAnInstanceOf[Foo]
  }
}
