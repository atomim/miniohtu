package com.springapp.mvc;

import ohtu.miniohtu.citation.Citation;
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
//@WebAppConfiguration
//@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class CitationTests {

    Citation citation;

    @Before
    public void setup() {
        citation = new Citation();
    }

    @Test
    public void booktitleWorks() {
        citation.setBooktitle("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getBooktitle().toString());
    }

    @Test
    public void YearWorks() {
        citation.setYear("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getYear().toString());
    }

    @Test
    public void AuthorWorks() {
        citation.setAuthor("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getAuthor().toString());
    }

    @Test
    public void PublisherWorks() {
        citation.setPublisher("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getPublisher().toString());
    }

    @Test
    public void PagesWorks() {
        citation.setPages("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getPages().toString());
    }

    @Test
    public void AddressWorks() {
        citation.setAddress("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getAddress().toString());
    }

    @Test
    public void VolumeWorks() {
        citation.setVolume("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getVolume().toString());
    }

    @Test
    public void NumberWorks() {
        citation.setNumber("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getNumber().toString());
    }

    @Test
    public void JournalWorks() {
        citation.setJournal("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getJournal().toString());
    }

    @Test
    public void toStringWorks() {
        citation.setBooktitle("asdf");
        assertEquals("asdf", citation.toString());
    }
    
    @Test
    public void bibtextInstanceIsValid() {
        assertTrue(citation.getBibTeXEntry() != null);
    }
    
    @Test
    public void returnsFieldMapSuccessfully() {
        citation.setAuthor("asdf");
        citation.setBooktitle("Asdf");
        assertEquals(2, citation.getFieldMap().size());
    }
}