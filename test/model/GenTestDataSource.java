package model;

import com.google.common.collect.ImmutableMap;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.junit.Before;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.Evolutions;

public class GenTestDataSource {
    public static EbeanServer  getEbeanSever() {
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
        //生成数据表结构sql?
        Evolutions.applyEvolutions(playDb);
        return EbeanServerFactory.create(ebeanConf);
    }
}
