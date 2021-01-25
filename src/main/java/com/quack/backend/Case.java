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

    /** the name of the municipality that the case lives. */
    private String dimosName;

    /**
     * <p>The case recovered.</p>
     * @param contactsNo
     * @param Diagnosis
     * @param Recovery
     * @param AFM
     * @param firstName
     * @param lastName
     * @param age
     * @param phoneNumber
     * @param dimosID
     * @param address
     * @param streetNumber
     * @param zipCode
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
     * @param Diagnosis
     * @param Death
     * @param contactsNo
     * @param AFM
     * @param firstName
     * @param lastName
     * @param age
     * @param phoneNumber
     * @param dimosID
     * @param address
     * @param streetNumber
     * @param zipCode
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
     * @param Diagnosis
     * @param contactsNumber
     * @param AFM
     * @param firstName
     * @param lastName
     * @param age
     * @param phoneNumber
     * @param dimosID
     * @param address
     * @param streetNumber
     * @param zipCode
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
     * @param contactsNo
     * @param Diagnosis
     * @param Death
     * @param Recovery
     * @param AFM
     * @param firstName
     * @param lastName
     * @param age
     * @param phoneNumber
     * @param dimosID
     * @param address
     * @param streetNumber
     * @param zipCode
     * @param dimosName
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
     * @param contactsNo
     * @param Diagnosis
     * @param Death
     * @param Recovery
     * @param AFM
     * @param firstName
     * @param lastName
     * @param age
     * @param phoneNumber
     * @param dimosID
     * @param address
     * @param streetNumber
     * @param zipCode
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
     * @return Diagnosis
     */
    public String getDiagnosis() {
        return Diagnosis;
    }

    /**
     * <p>Setting value to Diagnosis</p>
     * @param Diagnosis
     */
    public void setDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }
    /**
     * <p>This method returning Recovery.</p>
     * @return Recovery
     */
    public String getRecovery() {
        return Recovery;
    }
    /**
     * <p>Setting value to Recovery</p>
     * @param Recovery
     */
    public void setRecovery(String Recovery) {
        this.Recovery = Recovery;
    }
    /**
     * <p>This method returning Death.</p>
     * @return Death
     */
    public String getDeath() {
        return Death;
    }
    /**
     * <p>Setting value to Death</p>
     * @param Death
     */
    public void setDeath(String Death) {
        this.Death = Death;
    }
    /**
     * <p>This method returning contactsNumber.</p>
     * @return contactsNumber
     */
    public int getContactsNumber() {
        return contactsNumber;
    }
    /**
     * <p>Setting value to contactsNumber</p>
     * @param contactsNumber
     */
    public void setContactsNumber(int contactsNumber) {
        this.contactsNumber = contactsNumber;
    }
    /**
     * <p>This method returning AFM.</p>
     * @return AFM
     */
    public int getAFM() {
        return AFM;
    }
    /**
     * <p>Setting value to AFM</p>
     * @param AFM
     */
    public void setAFM(int AFM) {
        this.AFM = AFM;
    }
    /**
     * <p>This method returning firstName.</p>
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * <p>Setting value to firstName</p>
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * <p>This method returning lastName.</p>
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * <p>Setting value to lastName</p>
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * <p>This method returning age.</p>
     * @return age
     */
    public int getAge() {
        return age;
    }
    /**
     * <p>Setting value to age</p>
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * <p>This method returning phoneNumber.</p>
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * <p>Setting value to phoneNumber</p>
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * <p>This method returning dimosID.</p>
     * @return dimosID
     */
    public int getDimosID() {
        return dimosID;
    }
    /**
     * <p>Setting value to dimosID</p>
     * @param dimosID
     */
    public void setDimosID(int dimosID) {
        this.dimosID = dimosID;
    }
    /**
     * <p>This method returning address.</p>
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**
     * <p>Setting value to address</p>
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * <p>This method returning streetNumber.</p>
     * @return streetNumber
     */
    public String getStreetNumber() {
        return streetNumber;
    }
    /**
     * <p>Setting value to streetNumber</p>
     * @param streetNumber
     */
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    /**
     * <p>This method returning zipCode.</p>
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }
    /**
     * <p>Setting value to zipCode</p>
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    /**
     * <p>This method returning dimosName.</p>
     * @return dimosName
     */
    public String getDimosName() {
        return dimosName;
    }
    /**
     * <p>Setting value to dimosName</p>
     * @param dimosName
     */
    public void setDimosName(String dimosName) {
        this.dimosName = dimosName;
    }

}
