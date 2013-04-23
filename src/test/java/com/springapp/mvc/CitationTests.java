package com.springapp.mvc;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import ohtu.miniohtu.citation.RefKey;
import java.util.Map;
import java.util.HashMap;
import ohtu.miniohtu.citation.BibRef;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class CitationTests {

    BibRef citation;

    @Before
    public void setup() {
        citation = new BibRef("book");
    }
    
    @Test
    public void atFirstEntriesAreEmpty() {
        assertEquals(0, citation.getEntries().size());
    }
    
    @Test
    public void typeIsSetCorrectly() {
        assertEquals("book", citation.getType());
        citation.setType("article");
        assertEquals("article", citation.getType());
    }
    
    @Test
    public void atFirstShorthandIsEmpty() {
        assertEquals(null, citation.getShorthand());
    }

    @Test
    public void toStringWorks() {
        Map<String, RefKey> hashmap = new HashMap<String, RefKey>();
        
        hashmap.put("publisher", new RefKey("asdf"));
        hashmap.put("year", new RefKey("1993"));
        
        citation.setEntries(hashmap);
        assertEquals("\n@book{null,\n\tyear=\"1993\",\n\tpublisher=\"asdf\",\n}", citation.toString());
    }
    
    @Test
    public void shorthandsWork() {
        citation.setShorthand("asdf");
        assertEquals("asdf", citation.getShorthand());
    }

    @Test
    public void IDCanBeSet() {
        citation.setId(1337);
        assertEquals(1337, (int)citation.getId());
    }
    
    @Test
    public void validTypesAreReturnedCorrectly() {
        String[] types = {"book", "inproceedings", "article", "misc"};
        List<String> tested = Arrays.asList(BibRef.getValidTypes());
        
        for(String type : types)
            assertTrue(tested.contains(type));
    }
    
    @Test
    public void uniquesWork() {
        Map<String, RefKey> hashmap = new HashMap<String, RefKey>();
        
        hashmap.put("year", new RefKey("1993"));
        hashmap.put("publisher", new RefKey("asdf"));
        
        citation.setEntries(hashmap);
        assertEquals("1a", BibRef.getUnique(citation));
    }
}