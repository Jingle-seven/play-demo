package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import io.ebean.Ebean;
import model.Dept;
import model.User;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.*;

public class UserController extends Controller {
    @Inject
    private FormFactory formFactory;


    public Result listUser(Long userId, Long redundantId) {
        List<User> users;
        if (userId == -1) {
            users = Ebean.find(User.class).findList();
        } else {
            users = Ebean.find(User.class).where().eq("id", userId).findList();
        }
        Logger.info("queryString " + request().queryString());
        Logger.info("paramReceived " + userId + " " + redundantId);
        return ok(Json.toJson(users));
    }

    public Result addUser() {
        Map<String, String[]> queryString = request().queryString();
        Http.Headers headers = request().getHeaders();
        Http.RequestBody reqBody = request().body();
        //值是数组,对应这种参数名一样的几个参数:http://localhost:9001/user?id=8&id=3
        Map<String, String[]> userMap = request().body().asFormUrlEncoded();
        for(String k: headers.toMap().keySet()){
            Logger.info(k+" : " + headers.toMap().get(k));
        }
        Logger.info("queryString " + queryString);
        Logger.info("asText " + reqBody.asText());

        Form<User> userForm = formFactory.form(User.class);
        User formFactoryUser = userForm.bindFromRequest().get();

        Map<String, Object> resMap = new HashMap<>();
        resMap.put("asText ", reqBody.asText());
        resMap.put("queryString", queryString);
        resMap.put("formFactoryUser", formFactoryUser);
        resMap.put("userMap", userMap);

        Long deptId = formFactoryUser.dept.id;
        Dept dept = Ebean.find(Dept.class,deptId!=null?deptId:-1);
        formFactoryUser.setDept(dept);
        Logger.info(formFactoryUser.toString());
        Ebean.save(formFactoryUser);

        return ok(Json.toJson(resMap));
    }

    public Result updateUser() {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        User user = userForm.get();
        Logger.info("before set dept"+user.toString());

        //其实只有一个id,没有dept的其他属性也可以设置外键,不过总喜欢查一下
        Long deptId = user.dept.id;
        Dept dept = Ebean.find(Dept.class,deptId!=null?deptId:-1);
        if(dept!=null)
            dept.name = user.name+"之家";
        user.setDept(dept);
        Logger.info("after set dept"+user.toString());

        Ebean.update(user);

        return ok(Json.toJson(user));
    }
    //参数似乎不能是自定义类型
    public Result delUser(User user) {
        Logger.info("deleting user"+user.toString());
        Ebean.delete(user);
        return ok(Json.toJson(user));
    }
}
