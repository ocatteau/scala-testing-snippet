package fr.stateofmind.scala.dojo.scalatest

import org.scalatest.{FlatSpec, Tag}

class TaggedSpec extends FlatSpec {

  "The Scala language" must "add correctly" taggedAs (SlowTest) in {
    val sum = 1 + 1
    assert(sum === 2)
  }

  it must "subtract correctly" taggedAs(SlowTest, DbTest) in {
    val diff = 4 - 1
    assert(diff === 3)
  }
}

object SlowTest extends Tag("com.mycompany.tags.SlowTest")

object DbTest extends Tag("com.mycompany.tags.DbTest")