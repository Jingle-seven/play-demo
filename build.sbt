name := "play-demo"

organization := "xz.com"

version := "1.0-SNAPSHOT"

//lazy val root = (project in file(".")).enablePlugins(PlayJava)
lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, PlayEnhancer)


scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  evolutions,
  jdbc,
  guice,
  "mysql" % "mysql-connector-java" % "5.1.40"
)

