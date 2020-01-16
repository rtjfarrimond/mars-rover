import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.rtjfarrimond"
ThisBuild / organizationName := "rtjfarrimond"

lazy val root = (project in file("."))
  .settings(
    name := "mars-rover",
    libraryDependencies += scalaTest % Test
  )
