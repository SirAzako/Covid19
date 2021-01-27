package com.quack.backend;

import static org.junit.jupiter.api.Assertions.*;

class FiltersTest {

    Filters filters = new Filters();
    @org.junit.jupiter.api.Test
    void chooseTable() {
        assertEquals("1 = 1", filters.chooseTable("Persons"));
        assertEquals("ContactID IS NULL", filters.chooseTable("Cases"));
        assertEquals("ContactID IS NOT NULL", filters.chooseTable("Contacts"));
    }



    @org.junit.jupiter.api.Test
    void chooseColumn() {
        assertEquals("AFM =", filters.chooseColumn("ΑΦΜ"));
        assertEquals("FirstName =", filters.chooseColumn("First Name"));
        assertEquals("LastName =", filters.chooseColumn("Last Name"));
        assertEquals("Age =", filters.chooseColumn("Age"));
        assertEquals("PhoneNumber =", filters.chooseColumn("Phone Number"));
        assertEquals("DimosID =", filters.chooseColumn("Municipality"));
        assertEquals("Address =", filters.chooseColumn("Address"));
        assertEquals("StreetNumber =", filters.chooseColumn("Street Number"));
        assertEquals("ZipCode =", filters.chooseColumn("Zip Code"));
        assertEquals("Diagnosis =", filters.chooseColumn("Diagnosis Date"));
        assertEquals("Recovery =", filters.chooseColumn("Recovery Date"));
        assertEquals("Death =", filters.chooseColumn("Death Date"));
        assertEquals(null, filters.chooseColumn("qebvq"));
    }
}