package com.quack.test;

import com.quack.backend.Filters;

import static org.junit.jupiter.api.Assertions.*;

class FiltersTest {

    Filters filters = new Filters();
    @org.junit.jupiter.api.Test
    void chooseTableTest() {
        assertEquals("1 = 1", filters.chooseTable("Persons"));
        assertEquals("ContactID IS NULL", filters.chooseTable("Cases"));
        assertEquals("ContactID IS NOT NULL", filters.chooseTable("Contacts"));
    }



    @org.junit.jupiter.api.Test
    void chooseColumnTest() {

    }
}