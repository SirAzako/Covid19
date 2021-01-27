package com.quack.backend;

/**
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
     *  The name of the municipality that the case lives.
     *  This variable is used only in the find person panel
     *  to print the name of the municipality.
     *  */
    private String dimosName;

    /**
     * <p>A recovered case.</p>
     * @param contactsNo numbers of contacts found that date
     * @param diagnosisDate date of diagnosis
     * @param recoveryDate date of recovery
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
    public Case(final int contactsNo, final String diagnosisDate,
                final String recoveryDate, final int AFM,
                final String firstName, final String lastName,
                final int age, final String phoneNumber,
                final int dimosID, final String address,
                final String streetNumber, final String zipCode) {

        super(AFM, firstName, lastName, age, phoneNumber, dimosID, address,
                streetNumber, zipCode);
        this.Diagnosis = diagnosisDate;
        this.Recovery = recoveryDate;
        this.contactsNumber = contactsNo;
    }

    /**
     *<p>A dead case.</p>
     * @param diagnosisDate date of diagnosis
     * @param deathDate date of death
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
    public Case(final String diagnosisDate, final String deathDate,
                final int contactsNo, final int AFM,
                final String firstName, final String lastName,
                final int age, final String phoneNumber,
                final int dimosID, final String address,
                final String streetNumber, final String zipCode) {

        super(AFM, firstName, lastName, age, phoneNumber,
                dimosID, address, streetNumber, zipCode);
        this.Diagnosis = diagnosisDate;
        this.Death = deathDate;
        this.contactsNumber = contactsNo;
    }


    /**
     *<p>An active case.</p>
     * @param diagnosisDate date of diagnosis
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
    public Case(final String diagnosisDate, final int contactsNo,
                final int AFM, final String firstName,
                final String lastName, final int age,
                final String phoneNumber, final int dimosID,
                final String address, final String streetNumber,
                final String zipCode) {
        super(AFM, firstName, lastName, age, phoneNumber,
                dimosID, address, streetNumber, zipCode);
        this.Diagnosis = diagnosisDate;
        this.contactsNumber = contactsNo;
    }

    /**
     *<p>This constructor is used for returning data from database.</p>
     * @param contactsNo numbers of contacts found that date
     * @param diagnosisDate date of diagnosis
     * @param deathDate the death date
     * @param recoveryDate the recovery date
     * @param AFM the afm of case
     * @param firstName the case's first name
     * @param lastName the case's last name
     * @param age case's age
     * @param phoneNumber case's phone number
     * @param dimosID municipality id
     * @param address case's address name
     * @param streetNumber case's street number
     * @param zipCode case's postal code
     * @param municipName municipality name
     */
    public Case(final int contactsNo, final String diagnosisDate,
                final String deathDate, final String recoveryDate,
                final int AFM, final String firstName,
                final String lastName, final int age,
                final String phoneNumber, final int dimosID,
                final String address, final String streetNumber,
                final String zipCode, final String municipName) {

        super(AFM, firstName, lastName, age, phoneNumber,
                dimosID, address, streetNumber, zipCode);

        this.dimosName = municipName;
        this.Diagnosis = diagnosisDate;
        this.Death = deathDate;
        this.contactsNumber = contactsNo;
        this.Recovery = recoveryDate;
    }

    /**
     *<p>This constructor is used for returning data from database.</p>
     * @param contactsNo numbers of contacts found that date
     * @param diagnosisDate date of diagnosis
     * @param deathDate date of death
     * @param recoveryDate date of recovery
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
    public Case(final int contactsNo, final String diagnosisDate,
                final String deathDate, final String recoveryDate,
                final int AFM, final String firstName,
                final String lastName, final int age,
                final String phoneNumber, final int dimosID,
                final String address, final String streetNumber,
                final String zipCode) {

        super(AFM, firstName, lastName, age, phoneNumber, dimosID, address,
                streetNumber, zipCode);

        this.Diagnosis = diagnosisDate;
        this.Death = deathDate;
        this.contactsNumber = contactsNo;
        this.Recovery = recoveryDate;
    }

    /**
     * <p>This method returning Diagnosis.</p>
     * @return the date of diagnosis
     */
    public String getDiagnosis() {
        return Diagnosis;
    }

    /**
     * <p>Setting value to Diagnosis.</p>
     * @param diagnosisDate the new date of diagnosis
     */
    public void setDiagnosis(final String diagnosisDate) {
        this.Diagnosis = diagnosisDate;
    }
    /**
     * <p>This method returning Recovery.</p>
     * @return the recovery date
     */
    public String getRecovery() {
        return Recovery;
    }
    /**
     * <p>Setting value to Recovery.</p>
     * @param recoveryDate the new date of recovery
     */
    public void setRecovery(final String recoveryDate) {
        this.Recovery = recoveryDate;
    }
    /**
     * <p>This method returning Death.</p>
     * @return the date of death
     */
    public String getDeath() {
        return Death;
    }
    /**
     * <p>Setting value to Death.</p>
     * @param deathDate the new date of death
     */
    public void setDeath(final String deathDate) {
        this.Death = deathDate;
    }
    /**
     * <p>This method returning contactsNumber.</p>
     * @return the number of contacts the case had on the diagnosis date
     */
    public int getContactsNumber() {
        return contactsNumber;
    }
    /**
     * <p>Setting value to contactsNumber.</p>
     * @param contactsNo the new contacts number
     */
    public void setContactsNumber(final int contactsNo) {
        this.contactsNumber = contactsNo;
    }
    /**
     * <p>This method returning dimosName.</p>
     * @return the name of the municipality
     */
    public String getDimosName() {
        return dimosName;
    }
    /**
     * <p>Setting value to dimosName.</p>
     * @param municipName the new name of the municipality
     */
    public void setDimosName(final String municipName) {
        this.dimosName = municipName;
    }

}
