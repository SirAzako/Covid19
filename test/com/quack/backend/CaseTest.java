package com.quack.backend;

import static org.junit.jupiter.api.Assertions.*;

class CaseTest {
    Case krousma =  new Case("2020/12/12", 1, 111111111, "Paraskevas",
            "Hadjigeorgiou", 88, "97773232", 1, "Penteli", "15", "11523");

    @org.junit.jupiter.api.Test
    void getDiagnosis() {
       assertEquals("2020/12/12", krousma.getDiagnosis());
    }

    @org.junit.jupiter.api.Test
    void setDiagnosis() {
        krousma.setDiagnosis("2020/12/13");
        assertEquals("2020/12/13", krousma.getDiagnosis());
    }

    @org.junit.jupiter.api.Test
    void getRecovery() {
        assertEquals(null, krousma.getRecovery());
    }

    @org.junit.jupiter.api.Test
    void setRecovery() {
        krousma.setRecovery("2020/12/24");
        assertEquals("2020/12/24", krousma.getRecovery());
    }

    @org.junit.jupiter.api.Test
    void getDeath() {
        assertEquals(null, krousma.getDeath());
    }

    @org.junit.jupiter.api.Test
    void setDeath() {
        krousma.setDeath("2020/12/30");
        assertEquals("2020/12/30", krousma.getDeath());
    }

    @org.junit.jupiter.api.Test
    void getContactsNumber() {
        assertEquals(1, krousma.getContactsNumber());
    }

    @org.junit.jupiter.api.Test
    void setContactsNumber() {
        krousma.setContactsNumber(2);
        assertEquals(2, krousma.getContactsNumber());
    }

    @org.junit.jupiter.api.Test
    void getAFM() {
        assertEquals(111111111, krousma.getAFM());
    }

    @org.junit.jupiter.api.Test
    void setAFM() {
        krousma.setAFM(111111112);
        assertEquals(111111112, krousma.getAFM());
    }

    @org.junit.jupiter.api.Test
    void getFirstName() {
        assertEquals("Paraskevas", krousma.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void setFirstName() {
        krousma.setFirstName("Kiriakos");
        assertEquals("Kiriakos", krousma.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void getLastName() {
        assertEquals("Hadjigeorgiou", krousma.getLastName());
    }

    @org.junit.jupiter.api.Test
    void setLastName() {
        krousma.setLastName("Kiriakou");
        assertEquals("Kiriakou", krousma.getLastName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals(88, krousma.getAge());
    }

    @org.junit.jupiter.api.Test
    void setAge() {
        krousma.setAge(24);
        assertEquals(24, krousma.getAge());
    }

    @org.junit.jupiter.api.Test
    void getPhoneNumber() {
        assertEquals("97773232", krousma.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void setPhoneNumber() {
        krousma.setPhoneNumber("97773643");
        assertEquals("97773643", krousma.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void getDimosID() {
        assertEquals(1, krousma.getDimosID());
    }

    @org.junit.jupiter.api.Test
    void setDimosID() {
        krousma.setDimosID(2);
        assertEquals(2, krousma.getDimosID());
    }

    @org.junit.jupiter.api.Test
    void getAddress() {
        assertEquals("Penteli", krousma.getAddress());
    }

    @org.junit.jupiter.api.Test
    void setAddress() {
        krousma.setAddress("Plakentias");
        assertEquals("Plakentias", krousma.getAddress());
    }

    @org.junit.jupiter.api.Test
    void getStreetNumber() {
        assertEquals("15", krousma.getStreetNumber());
    }

    @org.junit.jupiter.api.Test
    void setStreetNumber() {
        krousma.setStreetNumber("16");
        assertEquals("16", krousma.getStreetNumber());
    }

    @org.junit.jupiter.api.Test
    void getZipCode() {
        assertEquals("11523", krousma.getZipCode());
    }

    @org.junit.jupiter.api.Test
    void setZipCode() {
        krousma.setZipCode("11522");
        assertEquals("11522", krousma.getZipCode());
    }

    @org.junit.jupiter.api.Test
    void getDimosName() {
        assertEquals(null,krousma.getDimosName());
    }

    @org.junit.jupiter.api.Test
    void setDimosName() {
        krousma.setDimosName("Αττική");
        assertEquals("Αττική", krousma.getDimosName());
    }
}