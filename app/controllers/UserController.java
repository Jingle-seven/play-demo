package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import io.ebean.Ebean;
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


    public Result listUser(Long userId,Long id) {
        System.out.println(id);
        List<User> users ;
        if(userId==-1) {
            users = Ebean.find(User.class).findList();
        }else{
            users = Ebean.find(User.class).where().eq("id",userId).findList();
        }
        Logger.info("queryString "+ request().queryString());
        return ok(Json.toJson(users));
    }
    public Result addUser() {
        Map<String,String[]> queryString = request().queryString();
        Http.RequestBody reqBody = request().body();
        //值是数组,对应这种参数名一样的几个参数:http://localhost:9001/user?id=8&id=3
        Map<String,String[]> userMap = request().body().asFormUrlEncoded();
        Logger.info("queryString "+ queryString);
        Logger.info("asText "+reqBody.asText());

        Form<User> userForm = formFactory.form(User.class);
        User formFactoryUser = userForm.bindFromRequest().get();

        Map<String,Object> resMap = new HashMap<>();
        resMap.put("asText ",reqBody.asText());
        resMap.put("queryString",queryString);
        resMap.put("formFactoryUser",formFactoryUser);
        resMap.put("userMap",userMap);

        Ebean.save(formFactoryUser);

        return ok(Json.toJson(resMap));
    }
}
