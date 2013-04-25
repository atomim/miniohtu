/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.DataSourceConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ohtu.miniohtu.citation.BibRef;
import ohtu.miniohtu.citation.RefKey;
import ohtu.miniohtu.exceptions.NoShorthandException;
import ohtu.miniohtu.exceptions.ShorthandTakenException;
import org.springframework.stereotype.Component;

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
        RefKey rk = bc.getEntries().get("shorthand");
        if (bc.getShorthand().equals("")) {
            bc.setShorthand(BibRef.getUnique(bc));
            throw new NoShorthandException("You Didn't provide a shorthand. Is this okay?");
        } else {
            if (es.find(BibRef.class).where().like("shorthand", bc.getShorthand()).findUnique() != null) {
                throw new ShorthandTakenException("The shorthand is already in use. Please take another one.");
            }
        }
        String sh = bc.getShorthand();
        int i = 1;
        while (true) {
            BibRef shorthandUsed = es.find(BibRef.class).where().like("shorthand", bc.getShorthand()).findUnique();
            if (shorthandUsed == null) {
                es.insert(bc);
                return;
            }
            i++;
            bc.setShorthand(sh + "" + i);
        }
    }

    @Override
    public List<BibRef> getCitations() {
        return es.find(BibRef.class).findList();
    }

    @Override
    public List<BibRef> getSortedBy(String attrib) {
        final String sortAttrib = attrib;
        List<BibRef> ar = es.find(BibRef.class).findList();
        Collections.sort(ar, new Comparator<BibRef>() {
            public int compare(BibRef o1, BibRef o2) {
                if (o1.getEntries().get(sortAttrib).getKey() == null
                        || o2.getEntries().get(sortAttrib).getKey() == null) {
                    return -1;
                }
                return o1.getEntries().get(sortAttrib).getKey().compareTo(o2.getEntries().get(sortAttrib).getKey());
            }
        });
        return ar;
    }

    @Override
    public void removeCitation(String shorthand) {
        BibRef destroyable = es.find(BibRef.class).where().like("shorthand", shorthand).findUnique();
        if (destroyable != null) {
            es.delete(destroyable);
        }
    }

    @Override
    public BibRef getCitation(String shorthand) {
        return es.find(BibRef.class).where().like("shorthand", shorthand).findUnique();
    }

    @Override
    public void updateCitation(String previousShorthand, BibRef newItem) {
        BibRef old = es.find(BibRef.class).where().like("shorthand", previousShorthand).findUnique();
        System.out.println(newItem.getShorthand());

        addCitation(newItem);//throws if not unique
        if (old != null) {
            System.out.println("-----------------------------");
            es.delete(old);
        }

    }
}
