/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu.citation;

import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXFormatter;
import org.jbibtex.BibTeXParser;
import org.jbibtex.BibTeXString;
import org.jbibtex.Key;
import org.jbibtex.LaTeXObject;
import org.jbibtex.LaTeXParser;
import org.jbibtex.LaTeXPrinter;
import org.jbibtex.ParseException;
import org.springframework.beans.factory.annotation.Autowired;


public class Citation {
    
    BibTeXEntry bibtex; 
    BibTeXFormatter bf;
    @Autowired
    public Citation(BibTeXFormatter bf) {
        bibtex = new BibTeXEntry(new Key(""), new Key(""));
        this.bf=bf;
    }
    @Override
    public String toString(){
        return null;
    }
    
    public void setName(){
        
    }
    
    public void setYear(){
        
    }
    
    public void setTitle(){
        
    }
    
    public void setPublisher(){
        
    }
    
    
}
