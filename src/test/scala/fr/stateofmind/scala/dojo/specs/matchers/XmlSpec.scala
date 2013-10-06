package fr.stateofmind.scala.dojo.specs.matchers

import org.specs2.mutable.Specification
import org.specs2.matcher.XmlMatchers._
import org.specs2.matcher.ResultMatchers

class XmlSpec extends Specification with ResultMatchers {

  val xml =
      <root>
        <child1 att="attVal">text1</child1>
        <child2><child21>child21</child21></child2>
      </root>


  "Xml equalsIgnoreCase" in {
    xml must beEqualToIgnoringSpace(<root>  <child1 att="attVal">text1</child1>  <child2><child21>child21</child21></child2>  </root>)
    xml must beEqualToIgnoringSpace(<root>  <child2><child21>child21</child21></child2>  <child1 att="attVal">text1</child1>  </root>)
  }

  "Checking of direct subnode" in {
    xml must \("child1")
    xml must \(<child2/>)
    (xml must \("child21")) must beFailing
  }

  "Checking of subnodes" in {
    xml must \\("child2").\("child21")
    xml must \\(<child2/>).\(<child21/>)
  }

  "Checking of attributes" in {
    xml must \("child1", "att")

    xml must \("child1", ("att", "attVal"))

    xml must \(<child1 att="attVal" />)
    xml must \(<child1 att="attVal"></child1>)
  }

  "Checking text content" in {
    xml must \("child1") \> "text1"
    xml must \("child1") \>~ "te.*"
  }
}
