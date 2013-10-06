package fr.stateofmind.scala.dojo.specs

import org.specs2.mutable.Specification
import org.specs2.matcher.DataTables

class DataTableSpec extends Specification with DataTables { override def is =

  "adding integers should just work in scala"  ^ {
     "a"   | "b" | "c" |
      2    !  2  !  4  |
      1    !  1  !  2  |>
      { (a, b, c) =>  a + b must_== c }
  }
}
