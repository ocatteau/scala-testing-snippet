package fr.stateofmind.scala.dojo.specs

import org.specs2.Specification
import org.specs2.matcher.Matchers
import org.specs2.matcher.StandardMatchResults._
import org.specs2.specification.Grouped

class GroupAcceptanceSpec extends Specification with Examples{ def is =  s2"""
  first example in first group                                        ${g1.e1}
  second example in first group                                       ${g1.e2}

  first example in second group                                       ${g2.e1}
  second example in second group                                      ${g2.e2}
  third example in second group, not yet implemented                  ${g2.e3}
  """

}

trait Examples extends Grouped with Matchers {
  // group of examples with no description
  new g1 {
    e1 := ok
    e2 := ok
  }

  // group of examples with a description for the group
  "second group of examples" - new g2 {
    e1 := ok
    e2 := ok
  }
}
