// @GENERATOR:play-routes-compiler
// @SOURCE:D:/workspace/idea/play-demo/conf/routes
// @DATE:Sun May 06 12:22:48 CST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def sum(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "test/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:10
    def testView(what:String, age:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "test-view" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("what", what)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("age", age)))))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:16
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:12
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def addUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:12
    def listUser(id1:Long = (-1), id2:Long = (-1)): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user" + play.core.routing.queryString(List(if(id1 == (-1)) None else Some(implicitly[play.api.mvc.QueryStringBindable[Long]].unbind("id1", id1)), if(id2 == (-1)) None else Some(implicitly[play.api.mvc.QueryStringBindable[Long]].unbind("id2", id2)))))
    }
  
  }


}
