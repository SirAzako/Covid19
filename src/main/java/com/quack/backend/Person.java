package com.quack.backend;

/**
 * @author Azako
 */
public abstract class Person {
    /* every person (Case or Contact) have tha following stats. */
    /** person's AFM. */
    private int AFM;

    /** person's first name. */
    private String firstName;

    /** person's last name. */
    private String lastName;

    /** person's age. */
    private int age;

    /** person's phone number. */
    private String phoneNumber;

    /** person's municipality id. */
    private int dimosID;

    /** person's address. */
    private String address;

    /** person's street number. */
    private String streetNumber;

    /** person's postal code. */
    private String zipCode;

    /**
     * <p>
     *     A constructor that create person with the standard stats.
     * </p>
     * @param address Address name
     * @param zipCode the postal code
     * @param streetNumber the street number
     * @param AFM the afm of the person
     * @param age the age
     * @param dimosID municipality id
     * @param firstName first name
     * @param lastName last name
     * @param phoneNumber phone number
     * */
    public Person(final int AFM, final String firstName, final String lastName,
                  final int age, final String phoneNumber, final int dimosID,
                  final String address, final String streetNumber,
                  final String zipCode) {
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

    /**
     * Getter for afm.
     * @return the afm of the case
     * */
    public int getAFM() {
        return AFM;
    }

    /**
     * Getter for first name.
     * @return the first name of the person
     * */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for last name.
     * @return the last name of the person
     * */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for age.
     * @return the age of the person
     * */
    public int getAge() {
        return age;
    }

    /**
     * Getter for phone number.
     * @return the phone number of the person
     * */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for dimos id.
     * @return the municipality id of the person
     * */
    public int getDimosID() {
        return dimosID;
    }

    /**
     * Getter for address.
     * @return the address of the person
     * */
    public String getAddress() {
        return address;
    }

    /**
     * Getter for street number.
     * @return the street number of the person
     * */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Getter for postal code.
     * @return the postal code of the person
     * */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter for afm.
     * @param AFM the new afm
     * */
    public void setAFM(final int AFM) {
        this.AFM = AFM;
    }

    /**
     * Setter for first name.
     * @param firstName the new first name
     * */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Setter for last name.
     * @param lastName the new last name
     * */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Setter for age.
     * @param age the new age
     * */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * Setter for phone number.
     * @param phoneNumber the new phone
     * */
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Setter for dimos id.
     * @param dimosID the new id
     * */
    public void setDimosID(final int dimosID) {
        this.dimosID = dimosID;
    }

    /**
     * Setter for address.
     * @param address the new address
     * */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Setter for street number.
     * @param streetNumber the new street number
     * */
    public void setStreetNumber(final String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Setter for postal code.
     * @param zipCode the new postal code
     * */
    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

}
