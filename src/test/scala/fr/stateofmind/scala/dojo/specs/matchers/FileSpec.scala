package fr.stateofmind.scala.dojo.specs.matchers

import org.specs2.mutable.Specification
import org.specs2.matcher.PathMatchers._
import org.specs2.matcher.ResultMatchers

class FileSpec extends Specification with ResultMatchers {

  "Same path regardless of separator" in {
    "c:\\temp\\hello" must beEqualToIgnoringSep("c:/temp/hello")
  }

  "beAnExistingPath" in {
    "/" must beAnExistingPath
  }

  "beAReadablePath" in {
    "/" must beAReadablePath
  }

  "beAWritablePath" in {
    "/tmp" must beAWritablePath
  }

  "beAnAbsolutePath" in {
    "/tmp" must beAnAbsolutePath
  }

  "beAHiddenPath" in {
    ("/tmp" must beAHiddenPath) must beFailing
  }

  "beAFilePath" in {
    ("/tmp/foo.txt" must beAFilePath) must beFailing
  }

  "beADirectoryPath" in {
    "/tmp" must beADirectoryPath
  }
}
