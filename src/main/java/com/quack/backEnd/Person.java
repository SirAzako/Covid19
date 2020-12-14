package com.quack.backEnd;

/**
 *
 * @author Azako
 */
abstract class Person {
    protected String personalID;
    protected String firstName;
    protected String lastName;
    protected int age;	
    protected String phoneNumber;
    protected String dimosID;
    protected String address;
    protected String streetNumber;
    protected String zipCode;

    public Person(String firstName, String lastName, int age, String phoneNumber, String dimosID, String address, String streetNumber, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.dimosID = dimosID;
        this.address = address;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
    }

    

    public String getPersonalID() {
        return personalID;
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

    public String getDimosID() {
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

    public void setDimosID(String dimosID) {
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
