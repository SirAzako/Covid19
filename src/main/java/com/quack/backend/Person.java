package com.quack.backend;

/**
 * @author Azako
 */
public abstract class Person {
    /* every person (Case or Contact) have tha following stats. */
    /** person's AFM. */
    protected int AFM;

    /** person's first name. */
    protected String firstName;

    /** person's last name. */
    protected String lastName;

    /** person's age. */
    protected int age;

    /** person's phone number. */
    protected String phoneNumber;

    /** person's municipality id. */
    protected int dimosID;

    /** person's address. */
    protected String address;

    /** person's street number. */
    protected String streetNumber;

    /** person's postal code. */
    protected String zipCode;

    /**
     * <p>
     *     A constructor that create person with the standard stats.
     * </p>
     * */
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

    /** Getter for afm. */
    public int getAFM() {
        return AFM;
    }

    /** Getter for first name. */
    public String getFirstName() {
        return firstName;
    }

    /** Getter for last name. */
    public String getLastName() {
        return lastName;
    }

    /** Getter for age. */
    public int getAge() {
        return age;
    }

    /** Getter for phone number. */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /** Getter for dimos id. */
    public int getDimosID() {
        return dimosID;
    }

    /** Getter for address. */
    public String getAddress() {
        return address;
    }

    /** Getter for street number. */
    public String getStreetNumber() {
        return streetNumber;
    }

    /** Getter for postal code. */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter for afm.
     * @param AFM the new afm
     * */
    public void setAFM(int AFM) {
        this.AFM = AFM;
    }

    /**
     * Setter for first name.
     * @param firstName the new first name
     * */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Setter for last name.
     * @param lastName the new last name
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Setter for age.
     * @param age the new age
     * */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Setter for phone number.
     * @param phoneNumber the new phone
     * */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Setter for dimos id.
     * @param dimosID the new id
     * */
    public void setDimosID(int dimosID) {
        this.dimosID = dimosID;
    }

    /**
     * Setter for address.
     * @param address the new address
     * */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Setter for street number.
     * @param streetNumber the new street number
     * */
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Setter for postal code.
     * @param zipCode the new postal code
     * */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
