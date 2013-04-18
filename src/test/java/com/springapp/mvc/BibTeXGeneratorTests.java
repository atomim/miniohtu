/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springapp.mvc;

import java.io.IOException;
import java.util.ArrayList;
import ohtu.miniohtu.citation.Citation;
import ohtu.miniohtu.citation.BibTeXGenerator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BibTeXGeneratorTests {

    BibTeXGenerator generator;
    
    @Before
    public void setUp() {
        generator = new BibTeXGenerator();
    }
    
    @Test
    public void generatesBibTeXCorrectly() {
        Citation citation = new Citation();
        citation.setAuthor("asdf");
        citation.setPages("311");
        
        ArrayList<Citation> citations = new ArrayList<Citation>();
        citations.add(citation);
        
        try {
            assertEquals("@article{,\n\tauthor = asdf,\n\tpages = 311\n}",
                generator.generateBibtex(citations));
        } catch(IOException exception) {}
    }
}
