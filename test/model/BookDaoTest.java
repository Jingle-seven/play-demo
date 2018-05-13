package model;

import io.ebean.Ebean;
import io.ebean.SqlQuery;
import io.ebean.SqlRow;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class BookDaoTest {

    @BeforeClass
    public static void initDB(){
        GenTestDataSource.getEbeanSever();
    }

    @Test
    public void testFind(){
        List<Book> books = Ebean.find(Book.class)
                .setFirstRow(10).setMaxRows(10)
                .findList();
        books.forEach(System.out::println);
    }

    @Test
    public void testSqlFind(){
        SqlQuery query = Ebean.createSqlQuery("select user_id, user_name,count(*) count from book " +
                "where user_id = :userId group by user_id");
        query.setParameter("userId",121542310);
        List<SqlRow> rows = query.setFirstRow(0).setMaxRows(10).findList();
        rows.forEach(System.out::println);
        String sql = "select user_id, user_name,count(*) from book where 1=1 group by user_id";
        String countSql = "select count(*) count from (%s) t1";
        countSql = String.format(countSql,sql);
        Integer count = Ebean.createSqlQuery(countSql).findOne().getInteger("count");
        System.out.println(count);
    }
}
