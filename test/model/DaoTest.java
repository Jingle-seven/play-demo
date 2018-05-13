package model;

import com.google.common.collect.ImmutableMap;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.Evolutions;

public class DaoTest {
    private User user1 = new User("Tony","Tom@qq.com");
    private User user2 = new User("Nancy","Nancy@qq.com");
    private Dept dept1 = new Dept("英雄科","英雄学院");
    private Dept dept2 = new Dept("支援科","英雄学院");
    @BeforeClass
    public static void initDB(){
        GenTestDataSource.getEbeanSever();
    }

    @Test
    public void testListUser(){
        System.out.println(Ebean.find(Dept.class).findList());
        System.out.println(Ebean.find(User.class).findList());
    }
    @Test
    public void testSaveUser(){
        user1.setDept(dept1);
        Ebean.save(user1);
        Ebean.save(user2);
    }
}
