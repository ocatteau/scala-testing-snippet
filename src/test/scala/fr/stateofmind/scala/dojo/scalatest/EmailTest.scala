package fr.stateofmind.scala.dojo.scalatest

import org.scalatest.FunSuite
import fr.stateofmind.scala.dojo.Email

class EmailTest extends FunSuite {

  test("Email with valid address") {
    val email: Email = Email("ocatteau@gmail.com")
    assert(email.address != null)
  }

  test("Email with invalid address") {
    intercept[IllegalArgumentException] {
      new Email("ocatteau")
    }
  }
}
