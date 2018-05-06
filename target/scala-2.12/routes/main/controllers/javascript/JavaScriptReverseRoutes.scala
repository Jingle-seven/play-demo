// @GENERATOR:play-routes-compiler
// @SOURCE:D:/workspace/idea/play-demo/conf/routes
// @DATE:Sun May 06 12:22:48 CST 2018

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
        function(what0,age1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test-view" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("what", what0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("age", age1)])})
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

  // @LINE:16
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
        }
      """
    )
  
    // @LINE:12
    def listUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.listUser",
      """
        function(id10,id21) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user" + _qS([(id10 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Long]].javascriptUnbind + """)("id1", id10)), (id21 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Long]].javascriptUnbind + """)("id2", id21))])})
        }
      """
    )
  
  }


}
