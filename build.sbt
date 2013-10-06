name := "scala-testing-snippet"

version := "1.0"
 
scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.10" % "test",
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "org.specs2" %% "specs2" % "2.2.2" % "test",
  "org.mockito" % "mockito-core" % "1.9.0" % "test"
)
