/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.DataSourceConfig;
import java.util.List;
import ohtu.miniohtu.citation.BibRef;
import ohtu.miniohtu.citation.RefKey;
import org.springframework.stereotype.Component;

/**
 *
 * @author pksu
 */
@Component
public class EbeanDB implements DBService {

    private EbeanServer es;

    EbeanDB() {
        ServerConfig dbCfg = new ServerConfig();
        dbCfg.setName("bibrefs");
        DataSourceConfig h2 = new DataSourceConfig();
        h2.setDriver("org.h2.Driver");
        h2.setUsername("miniohtu");
        h2.setPassword("miniohtu");
        h2.setUrl("jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1");
        dbCfg.setDataSourceConfig(h2);
        dbCfg.setRegister(false);
        dbCfg.addClass(BibRef.class);
        dbCfg.addClass(RefKey.class);
        
        // will flush/create db
        dbCfg.setDdlGenerate(true);
        dbCfg.setDdlRun(true);
        
        es = EbeanServerFactory.create(dbCfg);
    }

    @Override
    public void addCitation(BibRef bc) {
        es.insert(bc);
    }

    @Override
    public List<BibRef> getCitations() {
        return es.find(BibRef.class).findList();
    }
}
