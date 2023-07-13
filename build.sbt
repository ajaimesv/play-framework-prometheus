ThisBuild / scalaVersion := "2.13.11"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """prometheus""",
    libraryDependencies ++= Seq(
      guice,
      "io.prometheus" % "simpleclient" % "0.16.0",
      "io.prometheus" % "simpleclient_httpserver" % "0.16.0",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
    )
  )