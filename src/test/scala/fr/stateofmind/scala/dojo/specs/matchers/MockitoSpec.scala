package fr.stateofmind.scala.dojo.specs.matchers

import org.specs2.mock._
import org.specs2.Specification
import java.util
import org.specs2.mock.Mockito

class MockitoSpec extends Specification { def is = s2"""

  A java list can be mocked
    You can make it return a stubbed value                                     ${MockitoWithDefault().stub}
    You can verify that a method was called                                    ${MockitoWithDefault().verify}
    You can verify that a method was not called                                ${MockitoWithDefault().verify_no_call}
    You can make it return default null value                                  ${MockitoSimple().stub}
    You can use partial mock with spy                                          ${Spy().spying}
    Here is a classical example of mocking                                     ${Example().concreteMock}
    Here is a classical example of spying                                     ${Example().concreteSpy}
  """
  case class MockitoWithDefault() extends Mockito {
    val m = mock[java.util.List[String]].defaultReturn("ten")

    def stub = {
      m.get(0) returns "one"
      m.get(1) throws new IllegalArgumentException("Foo")

      m.get(0) must_== "one"
      m.get(1) must throwA[IllegalArgumentException]("Foo")
      m.get(99) must_== "ten"
    }

    def verify = {
      m.get(0) returns "one"

      m.get(0)
      there was one(m).get(0)
    }

    def verify_no_call = {
      there was no(m).get(0)
    }
  }

  case class MockitoSimple() extends Mockito {
    val m = mock[java.util.List[String]]

    def stub = {
      m.get(0) must beNull
    }
  }

  case class Spy() extends Mockito {

    def spying = {
      val list = new util.LinkedList[String]
      val spiedList = spy(list)

      spiedList.size returns 10
      spiedList.add("one")
      spiedList.add("two")
      org.mockito.Mockito.doReturn("three").when(spiedList).get(2)

      spiedList must haveLength(10)
      there was one(spiedList).add("one")
      there was one(spiedList).add("two")
      there was no(spiedList).add("three")

      "three" must_==(spiedList.get(2))
    }
  }

  //--------------------------------------------------------------

  class FooService {
    def hi() = "Hi"
  }

  class FooControler(service: FooService) {
    def hello(name: String) = service.hi() + " " + name
  }

  case class Example() extends Mockito {

    def concreteMock = {
      val service = mock[FooService]
      service.hi() returns "Hello"
      val controler = new FooControler(service)

      controler.hello("Olivier") must be_==("Hello Olivier")
    }

    def concreteSpy = {
      val service = new FooService
      val spiedService = spy(service)
      org.mockito.Mockito.doReturn("Hello").when(spiedService).hi()
      val controler = new FooControler(spiedService)

      controler.hello("Olivier") must be_==("Hello Olivier")
    }
  }
}