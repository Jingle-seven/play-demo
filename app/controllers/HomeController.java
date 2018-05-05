package controllers;

import play.mvc.*;
import views.html.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeController extends Controller {

    //首页
    public Result index() {
        return ok(views.html.index.render());
    }
    //传入参数到模板
    public Result testView(String name,int age) {

        List<String> rands = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            int r = (int)(Math.random()*10);
            rands.add(""+r);
        }
        return ok(test.render(name, age,rands));
    }
    //刷新,然后i会叠加,到达100时返回一个文件,超过一百时重置
    public  Result sum(int i){
        String sumStr = session("sum");
        if(sumStr==null)
            sumStr = "0";
        int sum = Integer.parseInt(sumStr);
        if(sum > 100){
            session("sum","0");
            return ok(test.render("Nancy",sum,Arrays.asList(sumStr,sumStr+"!")));
        } else if(sum==100){
            return ok(new File("./logs/application.log")).as("application/file");
        }else {
            sum += i;
            session("sum",sum+"");
            return ok(test.render("Nancy",sum,Arrays.asList(sumStr,sumStr+"!")));
        }
    }
}
