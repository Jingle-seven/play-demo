package controllers;

import play.mvc.*;
import views.html.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }
    public Result testView(String name,int age) {
        return ok(test.render(name, age,Arrays.asList("1","3","5")));
    }
    public  Result test1(int i){
        String sumStr = session("sum");
        if(sumStr==null)
            sumStr = "0";
        int sum = Integer.parseInt(sumStr);
        if(sum >= 100){
            session("sum","0");
            if(sum==100)
                return ok(new File("./logs/application.log")).as("application/file");
            return ok(test.render("Nancy",0,new ArrayList<>()));
        }else {
            sum += i;
            session("sum",sum+"");
            return ok(test.render("Nancy",0,new ArrayList<>()));
        }
    }
}
