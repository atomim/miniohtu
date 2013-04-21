/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springapp.mvc;

import ohtu.miniohtu.citation.BibRef;
import ohtu.miniohtu.citation.RefKey;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RefKeyTests {

    RefKey key;
    BibRef bibref;
    
    @Before
    public void setUp() {
        bibref = new BibRef("book");
        key = new RefKey();
        key = new RefKey("asdf");
    }
    
    @Test
    public void keyIsCorrect() {
        assertEquals("asdf", key.getKey());
        assertEquals("asdf", key.toString());
    }
    
    @Test
    public void bibRefCanBeSet() {
        key.setBibref(bibref);
        assertEquals(bibref, key.getBibref());
    }
    
    @Test
    public void IDNumbersCanBeSet() {
        key.setId(1337);
        assertEquals(1337, (int)key.getId());
    }
    
    @Test
    public void mapKeysWork() {
        key.setMapkey("foo");
        assertEquals("foo", key.getMapkey());
    }
}
