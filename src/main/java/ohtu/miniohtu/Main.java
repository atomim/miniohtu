/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.SQLitePlatform;

import com.avaje.ebean.Transaction;
import ohtu.miniohtu.citation.BibRef;

public class Main {

    enum Database {
        H2, SQLite, PostgreSQL
    }

    public static void main(String[] args) {
        boolean dropAndCreateTables = true;
        EbeanServer server = initializeDatabase(dropAndCreateTables, Database.SQLite);
        //new Application(server).run(dropAndCreateTables);
    }

    private static EbeanServer initializeDatabase(boolean dropAndCreateDatabase, Database db) {
        ServerConfig config = new ServerConfig();
        config.setName("ohtuDb");

        if (db == Database.H2) {
            DataSourceConfig hdDB = new DataSourceConfig();
            hdDB.setDriver("org.h2.Driver");
            hdDB.setUsername("test");
            hdDB.setPassword("test");
            hdDB.setUrl("jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1");
            hdDB.setHeartbeatSql("select 1 ");
            config.setDataSourceConfig(hdDB);
        } else if (db == Database.SQLite) {
            DataSourceConfig sqLite = new DataSourceConfig();
            sqLite.setDriver("org.sqlite.JDBC");
            sqLite.setUsername("test");
            sqLite.setPassword("test");
            //sqLite.setUrl("jdbc:sqlite:/home/mluukkai/sqlite/kannat/beer.db");
            sqLite.setUrl("jdbc:sqlite:ohtu.db");
            config.setDataSourceConfig(sqLite);
            config.setDatabasePlatform(new SQLitePlatform());
            config.getDataSourceConfig().setIsolationLevel(Transaction.READ_UNCOMMITTED);
        } else {
            DataSourceConfig postgresDb = new DataSourceConfig();  
            postgresDb.setDriver("org.postgresql.Driver");  
            postgresDb.setUsername("test");  
            postgresDb.setPassword("test");  
            postgresDb.setUrl("jdbc:postgresql:ohtu.db"); 
        }

        config.setDefaultServer(false);
        config.setRegister(false);

        config.addClass(BibRef.class);

        if (dropAndCreateDatabase) {
            config.setDdlGenerate(true);
            config.setDdlRun(true);
            //config.setDebugSql(true);
        }        
        
        return EbeanServerFactory.create(config);
    }
}
