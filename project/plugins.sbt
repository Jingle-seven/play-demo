resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// The Play plugin PlayJava 似乎来自这里
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.13")

// Play enhancer - this automatically generates getters/setters for public fields
// and rewrites accessors of these fields to use the getters/setters. Remove this
// plugin if you prefer not to have this feature, or disable on a per project
// basis using disablePlugins(PlayEnhancer) in your build.sbt
addSbtPlugin("com.typesafe.sbt" % "sbt-play-enhancer" % "1.2.2")

// PlayEbean 似乎来自这里,垃圾sbt关于这种基本问题什么都没写
addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "4.1.0")

