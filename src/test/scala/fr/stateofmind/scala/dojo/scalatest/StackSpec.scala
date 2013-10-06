package fr.stateofmind.scala.dojo.scalatest

import scala.collection.mutable.Stack
import org.scalatest.FlatSpec
import scala.NoSuchElementException

class StackSpec extends FlatSpec {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
  }

  it should "throw NoSuchElementException if an empty stack is popped and check error message" in {
    val emptyStack = new Stack[String]
    val exception = intercept[NoSuchElementException] {
      emptyStack.pop()
    }
    assert(exception.getMessage === "head of empty list")
  }

  it should "throw NoSuchElementException if an empty stack is popped and check error message with try catch" in {
    val emptyStack = new Stack[String]
    try {
      emptyStack.pop()
    }
    catch {
      case e: NoSuchElementException => assert(e.getMessage === "head of empty list")
    }
  }

  ignore should "not pass" in {
    assert(1 === 2)
  }

}