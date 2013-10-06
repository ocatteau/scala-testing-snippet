package fr.stateofmind.scala.dojo.specs

import org.specs2.mutable.Specification
import org.specs2.specification.AllExpectations

class AllExpectationsSpec extends Specification with AllExpectations{

  "In this example all the expectations are evaluated in success" >> {
    1 === 1  // this fails
    3 === 3  // this also fails
    1 === 1
  }

//  "In this example all the expectations are evaluated" >> {
//    1 === 2  // this fails
//    1 === 3  // this also fails
//    1 === 1
//  }

//  "There is no collision with this example" >> {
//    10 === 11 // this fails
//    12 === 12
//    13 === 31 // this also fails
//  }

//  "In this example all the expectations are evaluated" >> {
//    1 === 1            // this is ok
//    1 === 4            // this fails but test continue
//    (1 === 3).orThrow  // this fails but the rest is never executed
//    1 === 5
//  }
}
