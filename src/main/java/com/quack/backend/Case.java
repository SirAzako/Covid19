package com.quack.backend;

/**
 *
 * @author paras
 */
public class Case extends Person {
    /** the date of diagnosis. */
    private String Diagnosis;

    /** the date of recovery. */
    private String Recovery;

    /** the date of death. */
    private String Death;

    /**
     * the number of contacts that
     * the case had when the diagnosis made.
     * */
    private int contactsNumber;

    /**
     * the name of the municipality that the case lives.
     *  this variable is used only in the find person panel
     *  to print the name of the municipality
     *  */
    private String dimosName;

    /**
     * <p>The case recovered.</p>
     * @param contactsNo numbers of contacts found that date
     * @param Diagnosis date of diagnosis
     * @param Recovery date of recovery
     * @param AFM the afm of case
     * @param firstName the case's first name
     * @param lastName the case's last name
     * @param age case's age
     * @param phoneNumber case's phone number
     * @param dimosID municipality id
     * @param address case's address name
     * @param streetNumber case's street number
     * @param zipCode case's postal code
     */
    public Case(int contactsNo, String Diagnosis,  String Recovery, int AFM,
                String firstName, String lastName, int age, String phoneNumber,
                int dimosID, String address,
                String streetNumber, String zipCode) {
        super(AFM, firstName, lastName, age, phoneNumber, dimosID, address,
                streetNumber, zipCode);
        this.Diagnosis = Diagnosis;
        this.Recovery = Recovery;
        this.contactsNumber = contactsNo;
    }

    /**
     *<p>The case died.</p>
     * @param Diagnosis date of diagnosis
     * @param Death date of death
     * @param contactsNo numbers of contacts found that date
     * @param AFM the afm of case
     * @param firstName the case's first name
     * @param lastName the case's last name
     * @param age case's age
     * @param phoneNumber case's phone number
     * @param dimosID municipality id
     * @param address case's address name
     * @param streetNumber case's street number
     * @param zipCode case's postal code
     */
    public Case(String Diagnosis, String Death, int contactsNo,int AFM,
                String firstName, String lastName, int age, String phoneNumber,
                int dimosID, String address, String streetNumber, String zipCode) {
        super(AFM, firstName, lastName, age, phoneNumber,
                dimosID, address, streetNumber, zipCode);
        this.Diagnosis = Diagnosis;
        this.Death = Death;
        this.contactsNumber = contactsNo;
    }


    /**
     *<p>The case is active.</p>
     * @param Diagnosis date of diagnosis
     * @param contactsNumber numbers of contacts found that date
     * @param AFM the afm of case
     * @param firstName the case's first name
     * @param lastName the case's last name
     * @param age case's age
     * @param phoneNumber case's phone number
     * @param dimosID municipality id
     * @param address case's address name
     * @param streetNumber case's street number
     * @param zipCode case's postal code
     */
    public Case(String Diagnosis, int contactsNumber, int AFM, String firstName,
                String lastName, int age, String phoneNumber,
                int dimosID, String address, String streetNumber,
                String zipCode) {
        super(AFM, firstName, lastName, age, phoneNumber,
                dimosID, address, streetNumber, zipCode);
        this.Diagnosis = Diagnosis;
        this.contactsNumber = contactsNumber;
    }

    /**
     *<p>This constructor is used for returning data from database.</p>
     * @param contactsNo numbers of contacts found that date
     * @param Diagnosis date of diagnosis
     * @param Death the death date
     * @param Recovery the recovery date
     * @param AFM the afm of case
     * @param firstName the case's first name
     * @param lastName the case's last name
     * @param age case's age
     * @param phoneNumber case's phone number
     * @param dimosID municipality id
     * @param address case's address name
     * @param streetNumber case's street number
     * @param zipCode case's postal code
     * @param dimosName municipality name
     */
    public Case(int contactsNo, String Diagnosis, String Death, String Recovery,
                int AFM, String firstName, String lastName, int age,
                String phoneNumber, int dimosID, String address,
                String streetNumber, String zipCode, String dimosName) {
        super(AFM, firstName, lastName, age, phoneNumber,
                dimosID, address, streetNumber, zipCode);

        this.dimosName = dimosName;
        this.Diagnosis = Diagnosis;
        this.Death = Death;
        this.contactsNumber = contactsNo;
        this.Recovery = Recovery;
    }

    /**
     *<p>This constructor is used for returning data from database.</p>
     * @param contactsNo numbers of contacts found that date
     * @param Diagnosis date of diagnosis
     * @param Death date of death
     * @param Recovery date of recovery
     * @param AFM the afm of case
     * @param firstName the case's first name
     * @param lastName the case's last name
     * @param age case's age
     * @param phoneNumber case's phone number
     * @param dimosID municipality id
     * @param address case's address name
     * @param streetNumber case's street number
     * @param zipCode case's postal code
     */
    public Case(int contactsNo, String Diagnosis, String Death, String Recovery,
                int AFM, String firstName, String lastName, int age,
                String phoneNumber, int dimosID, String address,
                String streetNumber, String zipCode) {
        super(AFM, firstName, lastName, age, phoneNumber, dimosID, address,
                streetNumber, zipCode);

        this.Diagnosis = Diagnosis;
        this.Death = Death;
        this.contactsNumber = contactsNo;
        this.Recovery = Recovery;
    }

    /**
     * <p>This method returning Diagnosis.</p>
     * @return the date of diagnosis
     */
    public String getDiagnosis() {
        return Diagnosis;
    }

    /**
     * <p>Setting value to Diagnosis</p>
     * @param Diagnosis the new date of diagnosis
     */
    public void setDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }
    /**
     * <p>This method returning Recovery.</p>
     * @return the recovery date
     */
    public String getRecovery() {
        return Recovery;
    }
    /**
     * <p>Setting value to Recovery</p>
     * @param Recovery the new date of recovery
     */
    public void setRecovery(String Recovery) {
        this.Recovery = Recovery;
    }
    /**
     * <p>This method returning Death.</p>
     * @return the date of death
     */
    public String getDeath() {
        return Death;
    }
    /**
     * <p>Setting value to Death</p>
     * @param Death the new date of death
     */
    public void setDeath(String Death) {
        this.Death = Death;
    }
    /**
     * <p>This method returning contactsNumber.</p>
     * @return the number of contacts the case had on the diagnosis date
     */
    public int getContactsNumber() {
        return contactsNumber;
    }
    /**
     * <p>Setting value to contactsNumber</p>
     * @param contactsNumber the new contacts number
     */
    public void setContactsNumber(int contactsNumber) {
        this.contactsNumber = contactsNumber;
    }
    /**
     * <p>This method returning dimosName.</p>
     * @return the name of the municipality
     */
    public String getDimosName() {
        return dimosName;
    }
    /**
     * <p>Setting value to dimosName</p>
     * @param dimosName the new name of the municipality
     */
    public void setDimosName(String dimosName) {
        this.dimosName = dimosName;
    }

}
