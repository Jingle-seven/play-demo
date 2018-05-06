// @GENERATOR:play-routes-compiler
// @SOURCE:D:/workspace/idea/play-demo/conf/routes
// @DATE:Sun May 06 12:22:48 CST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
