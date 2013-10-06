package fr.stateofmind.scala.dojo.specs

import org.specs2.Specification

class HelloAcceptanceSpec extends Specification {

  def is = s2"""
    beNone checks if an element is None
    ${ None must beNone }
    ${ Some(1) must not be none }
  """
}
