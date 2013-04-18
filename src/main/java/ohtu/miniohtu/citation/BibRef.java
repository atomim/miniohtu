package ohtu.miniohtu.citation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ppurokur
 */
@Entity
public class BibRef {

    @Id
    String id;
    String type;
    HashMap<String, String> entries;
    private static final String[] types = {"book", "inproceedings", "articles", "misc"};

    public BibRef(String type) {
        this.type = type;
        entries = new HashMap<String, String>();
        id = "";
    }

    public BibRef() {
    }

    public static String getUnique(BibRef br) {
        
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public HashMap<String, String> getEntries() {
        return entries;
    }

    public void setEntries(HashMap<String, String> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        String bibtexSource = "@" + type + "{";
        bibtexSource += id + ",\n";
        for (Map.Entry<String, String> e : entries.entrySet()) {
            bibtexSource += "\t" + e.getKey() + "=";
            bibtexSource += "\"" + e.getValue() + "\",\n";
        }
        bibtexSource += "}";

        return bibtexSource;
    }
}
