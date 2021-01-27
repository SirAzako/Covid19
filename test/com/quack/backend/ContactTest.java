package com.quack.backend;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    Contact contact = new Contact(123456789, 123456789,
            "kostas", "Hadjigeorgiou", 23,
            "6986524589", 2, "perikleos",
            "56", "11526");

    @org.junit.jupiter.api.Test
    void getContactID() {
        assertEquals(123456789, contact.getContactID());
    }

    @org.junit.jupiter.api.Test
    void setContactID() {
        contact.setContactID(12354789);
        assertEquals(12354789, contact.getContactID());
    }

    @org.junit.jupiter.api.Test
    void getAFM() {
        assertEquals(123456789, contact.getAFM());
    }

    @org.junit.jupiter.api.Test
    void setAFM() {
        contact.setAFM(111111112);
        assertEquals(111111112, contact.getAFM());
    }

    @org.junit.jupiter.api.Test
    void getFirstName() {
        assertEquals("kostas", contact.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void setFirstName() {
        contact.setFirstName("Kiriakos");
        assertEquals("Kiriakos", contact.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void getLastName() {
        assertEquals("Hadjigeorgiou", contact.getLastName());
    }

    @org.junit.jupiter.api.Test
    void setLastName() {
        contact.setLastName("Kiriakou");
        assertEquals("Kiriakou", contact.getLastName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals(23, contact.getAge());
    }

    @org.junit.jupiter.api.Test
    void setAge() {
        contact.setAge(24);
        assertEquals(24, contact.getAge());
    }

    @org.junit.jupiter.api.Test
    void getPhoneNumber() {
        assertEquals("6986524589", contact.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void setPhoneNumber() {
        contact.setPhoneNumber("97773643");
        assertEquals("97773643", contact.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void getDimosID() {
        assertEquals(2, contact.getDimosID());
    }

    @org.junit.jupiter.api.Test
    void setDimosID() {
        contact.setDimosID(2);
        assertEquals(2, contact.getDimosID());
    }

    @org.junit.jupiter.api.Test
    void getAddress() {
        assertEquals("perikleos", contact.getAddress());
    }

    @org.junit.jupiter.api.Test
    void setAddress() {
        contact.setAddress("Plakentias");
        assertEquals("Plakentias", contact.getAddress());
    }

    @org.junit.jupiter.api.Test
    void getStreetNumber() {
        assertEquals("56", contact.getStreetNumber());
    }

    @org.junit.jupiter.api.Test
    void setStreetNumber() {
        contact.setStreetNumber("16");
        assertEquals("16", contact.getStreetNumber());
    }

    @org.junit.jupiter.api.Test
    void getZipCode() {
        assertEquals("11526", contact.getZipCode());
    }

    @org.junit.jupiter.api.Test
    void setZipCode() {
        contact.setZipCode("11522");
        assertEquals("11522", contact.getZipCode());
    }
}