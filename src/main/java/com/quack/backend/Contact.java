package com.quack.backend;

public class Contact extends Person {
    /**
     * private integer contactID.
     */
    private int contactID;

    public Contact(int AFM, int contactID, String firstName,
                   String lastName, int age, String phoneNumber, int dimosID,
                   String address, String streetNumber, String zipCode) {
        super(AFM, firstName, lastName, age, phoneNumber, dimosID, address,
                streetNumber, zipCode);
        this.contactID = contactID;
    }

    /**
     * <p>This method return contactID.</p>
     * @return contactID
     */
    public int getContactID() {
        return contactID;
    }
    /**
     * <p>Setting the contactID.</p>
     * @param contactID
     */
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }
    /**
     * <p>This method return AFM.</p>
     * @return AFM
     */
    public int getAFM() {
        return AFM;
    }
    /**
     * <p>Setting the AFM.</p>
     * @param AFM
     */
    public void setAFM(int AFM) {
        this.AFM = AFM;
    }
    /**
     * <p>This method return firstName.</p>
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * <p>Setting the firstName.</p>
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * <p>This method return lastName.</p>
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * <p>Setting the lastName.</p>
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * <p>This method return age.</p>
     * @return age
     */
    public int getAge() {
        return age;
    }
    /**
     * <p>Setting the age.</p>
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * <p>This method return phoneNumber.</p>
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * <p>Setting the phoneNumber.</p>
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * <p>This method return dimosID.</p>
     * @return dimosID
     */
    public int getDimosID() {
        return dimosID;
    }
    /**
     * <p>Setting the dimosID.</p>
     * @param dimosID
     */
    public void setDimosID(int dimosID) {
        this.dimosID = dimosID;
    }
    /**
     * <p>This method return address.</p>
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**
     * <p>Setting the address.</p>
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * <p>This method return streetNumber.</p>
     * @return streetNumber
     */
    public String getStreetNumber() {
        return streetNumber;
    }
    /**
     * <p>Setting the streetNumber.</p>
     * @param streetNumber
     */
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    /**
     * <p>This method return zipCode.</p>
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }
    /**
     * <p>Setting the zipCode.</p>
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
