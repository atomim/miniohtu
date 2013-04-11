/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu.citation;

import java.util.Map;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXFormatter;
import org.jbibtex.BibTeXParser;
import org.jbibtex.BibTeXString;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.jbibtex.LaTeXObject;
import org.jbibtex.LaTeXParser;
import org.jbibtex.LaTeXPrinter;
import org.jbibtex.ParseException;
import org.jbibtex.Value;
import org.springframework.beans.factory.annotation.Autowired;

public class Citation {

    BibTeXEntry bibtex;
    BibTeXFormatter bf;

    
    public Citation() {
        bibtex = new BibTeXEntry(BibTeXEntry.TYPE_ARTICLE, new Key(""));
        this.bf = new BibTeXFormatter();   
    }

    @Override
    public String toString() {
        return null;
    }

    public void setBooktitle(String s) {
        bibtex.addField(BibTeXEntry.KEY_BOOKTITLE, new KeyValue(s));
    }

    public void setAuthor(String s) {
        bibtex.addField(BibTeXEntry.KEY_AUTHOR, new KeyValue(s));
    }

    public void setYear(String s) {
        bibtex.addField(BibTeXEntry.KEY_YEAR, new KeyValue(s));
    }

    public void setPublisher(String s) {
        bibtex.addField(BibTeXEntry.KEY_PUBLISHER, new KeyValue(s));
    }

    public void setPages(String s) {
        bibtex.addField(BibTeXEntry.KEY_PAGES, new KeyValue(s));
    }

    public void setAddress(String s) {
        bibtex.addField(BibTeXEntry.KEY_ADDRESS, new KeyValue(s));
    }

    public void setVolume(String s) {
        bibtex.addField(BibTeXEntry.KEY_VOLUME, new KeyValue(s));
    }

    public void setNumber(String s) {
        bibtex.addField(BibTeXEntry.KEY_NUMBER, new KeyValue(s));
    }

    public void setJournal(String s) {
        bibtex.addField(BibTeXEntry.KEY_JOURNAL, new KeyValue(s));
    }
    public String getJournal() {
        return bibtex.getField(BibTeXEntry.KEY_JOURNAL).toString();
    }
    public String getNumber() {
        return bibtex.getField(BibTeXEntry.KEY_NUMBER).toString();
    }
    public String getBooktitle() {
        return bibtex.getField(BibTeXEntry.KEY_BOOKTITLE).toString();
    }
    public String getAuthor() {
        return bibtex.getField(BibTeXEntry.KEY_AUTHOR).toString();
    }
    public String getPublisher() {
        return bibtex.getField(BibTeXEntry.KEY_PUBLISHER).toString();
    }
    public String getPages() {
        return bibtex.getField(BibTeXEntry.KEY_PAGES).toString();
    }
    public String getYear() {
        return bibtex.getField(BibTeXEntry.KEY_YEAR).toString();
    }
    
    public Map<Key, Value> getFieldMap()  {
        return bibtex.getFields();
        
    }
}
