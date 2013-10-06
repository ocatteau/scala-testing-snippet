package fr.stateofmind.scala.dojo.scalatest

import org.scalatest.FunSuite
import fr.stateofmind.scala.dojo.Something

class SomethingTest extends FunSuite {

  test("Something is really Something") {
    val actual: Something = new Something

    assert(actual.something=="Something")
  }
}
