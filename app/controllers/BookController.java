package controllers;

import com.google.inject.Inject;
import io.ebean.Ebean;
import io.ebean.Query;
import io.ebean.SqlQuery;
import io.ebean.SqlRow;
import model.Book;
import model.User;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.test;
import xz.model.JsonResp;
import xz.model.PageSize;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class BookController extends Controller {
    @Inject
    private FormFactory formFactory;

    public Result listBook(Long userId) {
        Query<Book> query = Ebean.find(Book.class);
        if (userId >0) {
            query.where().eq("user_id", userId);
        }
        int count = query.findCount();
        PageSize pageSize = getPageSize();
        List<Book> books = query.orderBy("date asc")
                .setFirstRow(pageSize.getOffset())
                .setMaxRows(pageSize.getMaxRow())
                .findList();
        return ok(Json.toJson(JsonResp.create(count,books)));
    }

    public Result listUserBook(Long userId) {
        String sql = "select user_id, user_name,count(*) from book where 1=1 %s group by user_id";
        String countSql = "select count(*) count from (%s) t_user_book";
        if (userId >0) {
            sql= String.format(sql,"and user_id = "+userId);
        }else{
            sql = (String.format(sql,""));
        }
        countSql = String.format(countSql,sql);
        PageSize pageSize = getPageSize();
        sql = sql + String.format(" order by user_id limit %d,%d",pageSize.getOffset(),pageSize.getSize());
        Integer count = Ebean.createSqlQuery(countSql).findOne().getInteger("count");
        List<SqlRow> rows = Ebean.createSqlQuery(sql).findList();
        return ok(Json.toJson(JsonResp.create(count,rows)));
    }

    private PageSize getPageSize() {
        PageSize pageSize;
        try {
            pageSize = formFactory.form(PageSize.class).bindFromRequest().get();
            Logger.info(pageSize.toString());
        }catch (NumberFormatException | NoSuchElementException e){
            pageSize = new PageSize();
        }
        Logger.info(pageSize.toString());
        return pageSize;
    }
}
