package com.quack.backEnd;

import java.util.UUID;

/**
 * @author Azako
 */
public abstract class Person {
    protected int AFM;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String phoneNumber;
    protected int dimosID;
    protected String address;
    protected String streetNumber;
    protected String zipCode;

    public Person(int AFM, String firstName, String lastName, int age,
                  String phoneNumber, int dimosID, String address,
                  String streetNumber, String zipCode) {
        this.AFM = AFM;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.dimosID = dimosID;
        this.address = address;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
    }


    public int getAFM() {
        return AFM;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getDimosID() {
        return dimosID;
    }

    public String getAddress() {
        return address;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setAFM(int AFM) {
        this.AFM = AFM;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDimosID(int dimosID) {
        this.dimosID = dimosID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
