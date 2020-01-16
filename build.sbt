ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.rtjfarrimond"
ThisBuild / organizationName := "rtjfarrimond"

lazy val root = (project in file("."))
  .settings(
    name := "mars-rover",
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.1.0",
      "com.beachape" %% "enumeratum" % "1.5.15",
      "org.scalatest" %% "scalatest" % "3.1.0" % "test"
    )
  )
