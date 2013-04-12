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
    public void AuthorWorks() {
        citation.setAuthor("asdfgasgasdf");
        assertEquals("asdfgasgasdf", citation.getAuthor().toString());
    }
}