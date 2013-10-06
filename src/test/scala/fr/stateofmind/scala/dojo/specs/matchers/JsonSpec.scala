package fr.stateofmind.scala.dojo.specs.matchers

import org.specs2.mutable.Specification


class JsonSpec extends Specification {

  val json = """{
    "employee": {
      "name": "Bill",
      "age": 30,
      "chief": {
        "employee": {
          "name": "John",
          "age": 45
        }
      }
    }
  }
  """

//  "Json Matcher" should {
//
//    "Correctly match Name->Value pairs" in {
//      val resultJson = """{"name":"Yardies"}"""
//      resultJson must  /("name" -> "Yardies")
//    }
//
//    "Correctly match Name->Value pairs with numbers as doubles" in {
//      val resultJson = """{"id":1}"""
//      resultJson must  /("id" -> 1.0)
//    }
//  }
}
