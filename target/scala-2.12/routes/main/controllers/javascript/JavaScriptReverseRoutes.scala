// @GENERATOR:play-routes-compiler
// @SOURCE:D:/workspace/idea/play-demo/conf/routes
// @DATE:Sat May 05 16:19:39 CST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def sum: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sum",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:10
    def testView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.testView",
      """
        function(name0,age1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test-view" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("name", name0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("age", age1)])})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
