package model;

import com.google.common.collect.ImmutableMap;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.Evolutions;

public class DaoTest {
    private EbeanServer ebeanServer;
    private User user1 = new User("Tony","Tom@qq.com");
    private User user2 = new User("Nancy","Nancy@qq.com");
    private Dept dept1 = new Dept("英雄科");
    private Dept dept2 = new Dept("支援科");
    @Before
    public void createDatabase() {
        Database playDb = Databases.createFrom(
                "world",
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf-8&useSSL=false",
                ImmutableMap.of(
                        "username", "root",
                        "password", "root"
                )
        );
        ServerConfig ebeanConf = new ServerConfig();
        // register as the 'Default' server
//        ebeanConf.setDefaultServer(true);
        ebeanConf.setDataSource(playDb.getDataSource());
        ebeanServer = EbeanServerFactory.create(ebeanConf);
        //生成数据表结构sql?
        Evolutions.applyEvolutions(playDb);
    }

    @Test
    public void testListUser(){
        System.out.println(ebeanServer.find(Dept.class).findList());
        System.out.println(Ebean.find(User.class).findList());
    }
    @Test
    public void testSaveUser(){
        user1.setDept(dept1);
        ebeanServer.save(user1);
        ebeanServer.save(user2);
    }
}
