package com.quack.backend;

public class Contact extends Person {
    /**
     * private integer contactID.
     */
    private int contactID;

    /**
     * Constructor.
     * @param contactID the contact id is equal to the afm and consider if
     *                  this person was a contact of a case
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

}
