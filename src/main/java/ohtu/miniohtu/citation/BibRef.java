package ohtu.miniohtu.citation;

import com.avaje.ebean.common.BeanMap;
import java.sql.Ref;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;


@Entity
public class BibRef {

    @Id
    private Integer id;
    
    @Column(unique=true)
    private String shorthand;

    public String getShorthand() {
        return shorthand;
    }

    public void setShorthand(String shorthand) {
        this.shorthand = shorthand;
    }
    String type;
    
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="bibref")
    @MapKey(name = "mapkey")
    private Map<String, RefKey> entries = new HashMap<String,RefKey>();

    
    private static final String[] types = {"book", "inproceedings", "article", "misc"};

    public BibRef(String type) {
        this.type = type;
        
    }

    public BibRef() {
    }

    public static String getUnique(BibRef br) {
        String sh="";
        Map<String,RefKey> entries = br.getEntries();
        for (String field: entries.keySet()) {
            String t=entries.get(field).getKey();
            if (t!=null && t.length()>0) {
                sh=sh+Character.toUpperCase(t.charAt(0));
            }
        }
        return sh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public static String[] getValidTypes() {
        return types;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, RefKey> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, RefKey> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        String bibtexSource = "\n@" + type + "{";
        bibtexSource += shorthand + ",\n";
        for (Map.Entry<String, RefKey> e : entries.entrySet()) {
            bibtexSource += "\t" + e.getKey() + "=";
            bibtexSource += "\"" + e.getValue().getKey() + "\",\n";
        }
        bibtexSource += "}";
        bibtexSource = bibtexSource.replaceAll("ä", "\\\\\"{a}");
        bibtexSource = bibtexSource.replaceAll("ö", "\\\\\"{o}");
        bibtexSource = bibtexSource.replaceAll("Ä", "\\\\\"{A}");
        bibtexSource = bibtexSource.replaceAll("Ö", "\\\\\"{O}");
        
        return bibtexSource;
    }
}
