package com.quack.backEnd;



/**
 *
 * @author paras
 */
public class Case extends Person {
    private String Diagnosis;
    private String Recovery;
    private String Death;
    private int contactsNumber;

    //Το κρούσμα ανάρρωσε 
    public Case(int contactsNo, String Diagnosis,  String Recovery, int AFM, String firstName, String lastName, int age, String phoneNumber, int dimosID, String address, String streetNumber, String zipCode) {
        super(AFM, firstName, lastName, age, phoneNumber, dimosID, address, streetNumber, zipCode);
        this.Diagnosis = Diagnosis;
        this.Recovery = Recovery;
        this.contactsNumber = contactsNo;
    }

  
    //Το κρούσμα πέθανε
    public Case(String Diagnosis, String Death, int contactsNo,int AFM, String firstName, String lastName, int age, String phoneNumber, int dimosID, String address, String streetNumber, String zipCode) {
        super(AFM, firstName, lastName, age, phoneNumber, dimosID, address, streetNumber, zipCode);
        this.Diagnosis = Diagnosis;
        this.Death = Death;
        this.contactsNumber = contactsNo;
    }
    
    //Το κρούσμα δεν ανάρρωσε ούτε και πέθανε
    public Case(String Diagnosis, int contactsNumber, int AFM, String firstName, String lastName, int age, String phoneNumber, int dimosID, String address, String streetNumber, String zipCode) {
        super(AFM, firstName, lastName, age, phoneNumber, dimosID, address, streetNumber, zipCode);
        this.Diagnosis = Diagnosis;
        this.contactsNumber = contactsNumber;
    }



    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }

    public String getRecovery() {
        return Recovery;
    }

    public void setRecovery(String Recovery) {
        this.Recovery = Recovery;
    }

    public String getDeath() {
        return Death;
    }

    public void setDeath(String Death) {
        this.Death = Death;
    }

    public int getContactsNumber() {
        return contactsNumber;
    }

    public void setContactsNumber(int contactsNumber) {
        this.contactsNumber = contactsNumber;
    }

    public int getAFM() {
        return AFM;
    }

    public void setAFM(int AFM) {
        this.AFM = AFM;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDimosID() {
        return dimosID;
    }

    public void setDimosID(int dimosID) {
        this.dimosID = dimosID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
