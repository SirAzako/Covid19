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
     * @param addr Address name
     * @param postalCode the postal code
     * @param streetNum the street number
     * @param afm the afm of the person
     * @param personAge the age
     * @param municipID municipality id
     * @param firstNam first name
     * @param lastNam last name
     * @param phone phone number
     * */
    public Person(final int afm, final String firstNam, final String lastNam,
                  final int personAge, final String phone, final int municipID,
                  final String addr, final String streetNum,
                  final String postalCode) {
        this.AFM = afm;
        this.firstName = firstNam;
        this.lastName = lastNam;
        this.age = personAge;
        this.phoneNumber = phone;
        this.dimosID = municipID;
        this.address = addr;
        this.streetNumber = streetNum;
        this.zipCode = postalCode;
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
     * @param afm the new afm
     * */
    public void setAFM(final int afm) {
        this.AFM = afm;
    }

    /**
     * Setter for first name.
     * @param firstNam the new first name
     * */
    public void setFirstName(final String firstNam) {
        this.firstName = firstNam;
    }

    /**
     * Setter for last name.
     * @param lastNam the new last name
     * */
    public void setLastName(final String lastNam) {
        this.lastName = lastNam;
    }

    /**
     * Setter for age.
     * @param personAge the new age
     * */
    public void setAge(final int personAge) {
        this.age = personAge;
    }

    /**
     * Setter for phone number.
     * @param phone the new phone
     * */
    public void setPhoneNumber(final String phone) {
        this.phoneNumber = phone;
    }

    /**
     * Setter for dimos id.
     * @param municipID the new id
     * */
    public void setDimosID(final int municipID) {
        this.dimosID = municipID;
    }

    /**
     * Setter for address.
     * @param addr the new address
     * */
    public void setAddress(final String addr) {
        this.address = addr;
    }

    /**
     * Setter for street number.
     * @param streetNum the new street number
     * */
    public void setStreetNumber(final String streetNum) {
        this.streetNumber = streetNum;
    }

    /**
     * Setter for postal code.
     * @param postalCode the new postal code
     * */
    public void setZipCode(final String postalCode) {
        this.zipCode = postalCode;
    }

}
