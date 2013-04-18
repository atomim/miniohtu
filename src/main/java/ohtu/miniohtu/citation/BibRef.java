/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu.citation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ppurokur
 */
public class BibRef {
    String id;

    String type;
    HashMap<String,String> entries;
    private static final String[]  types = { "book", "inproceedings", "articles", "misc" };
    
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
    
    private BibRef(String type) {
        this.type = type;
        entries = new HashMap<String,String>();
        id = "";
    }
    
    public static BibRef createBook() {
        return new BibRef("book");
    }
    
    public static BibRef createArticle() {
        return new BibRef("article");
    }
    
    public static BibRef createInproceedings() {
        return new BibRef("inproceedings");
    }
    
    @Override
    public String toString() {
        String bibtexSource = "@" + type + "{";
        bibtexSource += id + ",\n";
        for(Map.Entry<String,String> e : entries.entrySet()) {
            bibtexSource += "\t" + e.getKey() + "=";
            bibtexSource += "\"" +e.getValue() + "\",\n";
        }
        bibtexSource += "}";
        
        return bibtexSource;
    }
    
}
