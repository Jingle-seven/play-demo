// @GENERATOR:play-routes-compiler
// @SOURCE:E:/workspace/play-demo/conf/routes
// @DATE:Sun Apr 08 09:58:27 CST 2018


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