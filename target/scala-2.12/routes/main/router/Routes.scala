// @GENERATOR:play-routes-compiler
// @SOURCE:D:/workspace/idea/play-demo/conf/routes
// @DATE:Sun May 06 22:47:53 CST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:12
  UserController_1: controllers.UserController,
  // @LINE:20
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:12
    UserController_1: controllers.UserController,
    // @LINE:20
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_0, UserController_1, Assets_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, UserController_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """test/""" + "$" + """id<[^/]+>""", """controllers.HomeController.sum(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """test-view""", """controllers.HomeController.testView(what:String, age:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.UserController.listUser(id1:Long ?= (-1), id2:Long ?= (-1))"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserController.listUser(id:Long, id2:Long = (-1))"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.UserController.addUser()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.UserController.updateUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_sum1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("test/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_sum1_invoker = createInvoker(
    HomeController_0.sum(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "sum",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """test/""" + "$" + """id<[^/]+>""",
      """ path parameter，the para's name in uri should same as in route""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_testView2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("test-view")))
  )
  private[this] lazy val controllers_HomeController_testView2_invoker = createInvoker(
    HomeController_0.testView(fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "testView",
      Seq(classOf[String], classOf[Int]),
      "GET",
      this.prefix + """test-view""",
      """ nomal paramater""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_listUser3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UserController_listUser3_invoker = createInvoker(
    UserController_1.listUser(fakeValue[Long], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "listUser",
      Seq(classOf[Long], classOf[Long]),
      "GET",
      this.prefix + """user""",
      """ match param by order rather name""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserController_listUser4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_listUser4_invoker = createInvoker(
    UserController_1.listUser(fakeValue[Long], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "listUser",
      Seq(classOf[Long], classOf[Long]),
      "GET",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UserController_addUser5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UserController_addUser5_invoker = createInvoker(
    UserController_1.addUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addUser",
      Nil,
      "POST",
      this.prefix + """user""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UserController_updateUser6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UserController_updateUser6_invoker = createInvoker(
    UserController_1.updateUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateUser",
      Nil,
      "PUT",
      this.prefix + """user""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:8
    case controllers_HomeController_sum1_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_sum1_invoker.call(HomeController_0.sum(id))
      }
  
    // @LINE:10
    case controllers_HomeController_testView2_route(params@_) =>
      call(params.fromQuery[String]("what", None), params.fromQuery[Int]("age", None)) { (what, age) =>
        controllers_HomeController_testView2_invoker.call(HomeController_0.testView(what, age))
      }
  
    // @LINE:12
    case controllers_UserController_listUser3_route(params@_) =>
      call(params.fromQuery[Long]("id1", Some((-1))), params.fromQuery[Long]("id2", Some((-1)))) { (id1, id2) =>
        controllers_UserController_listUser3_invoker.call(UserController_1.listUser(id1, id2))
      }
  
    // @LINE:13
    case controllers_UserController_listUser4_route(params@_) =>
      call(params.fromPath[Long]("id", None), Param[Long]("id2", Right((-1)))) { (id, id2) =>
        controllers_UserController_listUser4_invoker.call(UserController_1.listUser(id, id2))
      }
  
    // @LINE:14
    case controllers_UserController_addUser5_route(params@_) =>
      call { 
        controllers_UserController_addUser5_invoker.call(UserController_1.addUser())
      }
  
    // @LINE:15
    case controllers_UserController_updateUser6_route(params@_) =>
      call { 
        controllers_UserController_updateUser6_invoker.call(UserController_1.updateUser())
      }
  
    // @LINE:20
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
