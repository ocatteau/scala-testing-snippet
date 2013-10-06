package fr.stateofmind.scala.dojo.matchers

import org.specs2.mutable.Specification

class MapsSpec extends Specification {

  "Maps" should {
    "haveKey checking" in {
      Map(1 -> "1", 2 -> "2") must haveKey(1)
    }

    "haveKeys checking" in {
      Map(1 -> "1", 2 -> "2") must haveKeys(1, 2)
    }

    "haveValue checking" in {
      Map(1 -> "1", 2 -> "2") must haveValue("1")
    }

    "haveKeys checking" in {
      Map(1 -> "1", 2 -> "2") must haveValues("1", "2")
    }

    "havePair checking" in {
      Map(1 -> "1", 2 -> "2") must havePair(1 -> "1")
    }

    "haveKeys checking" in {
      Map(1 -> "1", 2 -> "2") must havePairs(1 -> "1", 2 -> "2")
    }

    "beDefinedAt checking" in {
      Map(1 -> "1", 2 -> "2") must beDefinedAt(1)
    }

    "beDefinedBy checking" in {
      Map(1 -> "1", 2 -> "2") must beDefinedBy(1 -> "1")
    }


  }
}
