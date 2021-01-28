package com.quack.backend;


import com.quack.db.CaseDAO;
import com.quack.db.ContactDAO;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import org.decimal4j.util.DoubleRounder;

import javax.swing.JOptionPane;

/**
 * In Controller done all management for the gui.
 *
 * @version 1.0.1 11 Jan 2021
 */

public class Controller implements Initializable {
    /**
     * private integer totalContacts.
     */
    private int totalContacts = 0;

    /**
     * private integer counterContacts.
     */
    private int counterContacts = 1;

    /**
     * private integer parseAfm.
     */
    private int parseAfm = 0;

    /*
     *  Here we will initialize all the  that we have
     *  in our gui, and we read them from the fxml file.
     */

    /**
     * private AnchorPane menuBar.
     */
    @FXML
    private AnchorPane menuBar;


    // Create Case Panel items.
    /**
     * private AnchorPane createCasePanel.
     */
    @FXML
    private AnchorPane createCasePanel;

    /**
     * private TextField firstNameInput.
     */
    @FXML
    private TextField firstNameInput;

    /**
     * private TextField lastNameInput.
     */
    @FXML
    private TextField lastNameInput;

    /**
     * private TextField ageInput.
     */
    @FXML
    private TextField ageInput;

    /**
     * private TextField phoneNumberInput.
     */
    @FXML
    private TextField phoneNumberInput;

    /**
     * private TextField addressInput.
     */
    @FXML
    private TextField addressInput;

    /**
     * private TextField streetInput.
     */
    @FXML
    private TextField streetInput;

    /**
     * private TextField zipCodeInput.
     */
    @FXML
    private TextField zipCodeInput;

    /**
     * private TextField contactsInput.
     */
    @FXML
    private TextField contactsInput;

    /**
     * private TextField afmInput.
     */
    @FXML
    private TextField afmInput;

    /**
     * private ComboBox<String> municipalityInput.
     */
    @FXML
    private ComboBox<String> municipalityInput;

    /**
     * private DatePicker diagnosisInput.
     */
    @FXML
    private DatePicker diagnosisInput;

    /**
     * private DatePicker recoveryInput.
     */
    @FXML
    private DatePicker recoveryInput;

    /**
     * private DatePicker deathInput.
     */
    @FXML
    private DatePicker deathInput;

    // Add contacts panel, after the create case panel, items.

    /**
     * private AnchorPane addContactsPanel.
     */
    @FXML
    private AnchorPane addContactsPanel;

    /**
     * private Label numberLabel.
     */
    @FXML
    private Label numberLabel;

    /**
     * private Label counterLabel.
     */
    @FXML
    private Label counterLabel;

    /**
     * private TextField firstNameCoInput.
     */
    @FXML
    private TextField firstNameCoInput;

    /**
     * private TextField lastNameCoInput.
     */
    @FXML
    private TextField lastNameCoInput;

    /**
     * private TextField ageCoInput.
     */
    @FXML
    private TextField ageCoInput;

    /**
     * private TextField phoneNumberCoInput.
     */
    @FXML
    private TextField phoneNumberCoInput;

    /**
     * private ComboBox<String> municipalityCoInput.
     */
    @FXML
    private ComboBox<String> municipalityCoInput;

    /**
     * private TextField addressCoInput.
     */
    @FXML
    private TextField addressCoInput;

    /**
     * private TextField streetCoInput.
     */
    @FXML
    private TextField streetCoInput;

    /**
     * private TextField zipCodeCoInput.
     */
    @FXML
    private TextField zipCodeCoInput;

    /**
     * private TextField afmCoInput.
     */
    @FXML
    private TextField afmCoInput;


    //Edit profile Panel items.

    /**
     * private AnchorPane editProfilePanel.
     */
    @FXML
    private AnchorPane editProfilePanel;

    /**
     * private TextField afmEditInput.
     */
    @FXML
    private TextField afmEditInput;

    /**
     * private TextField firstNameEditInput.
     */
    @FXML
    private TextField firstNameEditInput;

    /**
     * private TextField lastNameEditInput.
     */
    @FXML
    private TextField lastNameEditInput;

    /**
     * private TextField ageEditInput.
     */
    @FXML
    private TextField ageEditInput;

    /**
     * private TextField phoneNumberEditInput.
     */
    @FXML
    private TextField phoneNumberEditInput;

    /**
     * private ComboBox<String> municipalityEditInput.
     */
    @FXML
    private ComboBox<String> municipalityEditInput;

    /**
     * private TextField addressEditInput.
     */
    @FXML
    private TextField addressEditInput;

    /**
     * private TextField streetEditInput.
     */
    @FXML
    private TextField streetEditInput;

    /**
     * private TextField zipCodeEditInput.
     */
    @FXML
    private TextField zipCodeEditInput;

    /**
     * private TextField contactsEditInput.
     */
    @FXML
    private TextField contactsEditInput;

    /**
     * private DatePicker diagnosisEditInput.
     */
    @FXML
    private DatePicker diagnosisEditInput;

    /**
     * private DatePicker recoveryEditInput.
     */
    @FXML
    private DatePicker recoveryEditInput;

    /**
     * private DatePicker deathEditInput.
     */
    @FXML
    private DatePicker deathEditInput;


    // Add a contact to a specific case panel items

    /**
     * private AnchorPane addContactUniquePanel.
     */
    @FXML
    private AnchorPane addContactUniquePanel;

    /**
     * private TextField firstNameCoUnInput.
     */
    @FXML
    private TextField firstNameCoUnInput;

    /**
     * private TextField lastNameCoUnInput.
     */
    @FXML
    private TextField lastNameCoUnInput;

    /**
     * private TextField ageCoUnInput.
     */
    @FXML
    private TextField ageCoUnInput;

    /**
     * private TextField phoneNumberCoUnInput.
     */
    @FXML
    private TextField phoneNumberCoUnInput;

    /**
     * private ComboBox<String> municipalityCoUnInput.
     */
    @FXML
    private ComboBox<String> municipalityCoUnInput;

    /**
     * private TextField addressCoUnInput.
     */
    @FXML
    private TextField addressCoUnInput;

    /**
     * private TextField streetCoUnInput.
     */
    @FXML
    private TextField streetCoUnInput;

    /**
     * private TextField zipCodeCoUnInput.
     */
    @FXML
    private TextField zipCodeCoUnInput;

    /**
     * private TextField afmCoUnInput.
     */
    @FXML
    private TextField afmCoUnInput;

    /**
     * private TextField afmCoUnKrousmatosInput.
     */
    @FXML
    private TextField afmCoUnKrousmatosInput;

    //Find persons items.

    /**
     * private AnchorPane findPersonPanel.
     */
    @FXML
    private AnchorPane findPersonPanel;

    /**
     * private TableView<Case> personsTable.
     */
    @FXML
    private TableView<Case> personsTable;

    /**
     * private TableColumn<Case, Integer> afmTable.
     */
    @FXML
    private TableColumn<Case, Integer> afmTable;

    /**
     * private TableColumn<Case, Integer> numberOfContactsTable.
     */
    @FXML
    private TableColumn<Case, Integer> numberOfContactsTable;

    /**
     * private TableColumn<Case, String> firstNameTable.
     */
    @FXML
    private TableColumn<Case, String> firstNameTable;

    /**
     * private TableColumn<Case, String> lastNameTable.
     */
    @FXML
    private TableColumn<Case, String> lastNameTable;

    /**
     * private TableColumn<Case, Integer> ageTable.
     */
    @FXML
    private TableColumn<Case, Integer> ageTable;

    /**
     * private TableColumn<Case, String> phoneNumberTable.
     */
    @FXML
    private TableColumn<Case, String> phoneNumberTable;

    /**
     * private TableColumn<Case, Integer> dimosTable.
     */
    @FXML
    private TableColumn<Case, Integer> dimosTable;

    /**
     * private TableColumn<Case, String> addressTable.
     */
    @FXML
    private TableColumn<Case, String> addressTable;

    /**
     * private TableColumn<Case, String> stNumberTable.
     */
    @FXML
    private TableColumn<Case, String> stNumberTable;

    /**
     * private TableColumn<Case, String> zipCodeTable.
     */
    @FXML
    private TableColumn<Case, String> zipCodeTable;

    /**
     * private TableColumn<Case, String> diagnosisTable.
     */
    @FXML
    private TableColumn<Case, String> diagnosisTable;

    /**
     * private TableColumn<Case, String> recoveryTable.
     */
    @FXML
    private TableColumn<Case, String> recoveryTable;

    /**
     * private TableColumn<Case, String> deathTable.
     */
    @FXML
    private TableColumn<Case, String> deathTable;

    /**
     * private TextField filterInput.
     */
    @FXML
    private TextField filterInput;

    /**
     * private TextField filterContactInput.
     */
    @FXML
    private TextField filterContactInput;

    /**
     * private Label resultsInput.
     */
    @FXML
    private Label resultsInput;

    /**
     * private ComboBox<String> chooseColumnComboBox.
     */
    @FXML
    private ComboBox<String> chooseColumnComboBox;

    /**
     * private ComboBox<String> chooseTableComboBox.
     */
    @FXML
    private ComboBox<String> chooseTableComboBox;

    //Stats panel items.

    /**
     * private AnchorPane statsPanel.
     */
    @FXML
    private AnchorPane statsPanel;

    /**
     * private ComboBox<String> municipalityStats.
     */
    @FXML
    private ComboBox<String> municipalityStats;

    /**
     * private Label casesStLabel.
     */
    @FXML
    private Label casesStLabel;

    /**
     * private Label activeCasesStLabel.
     */
    @FXML
    private Label activeCasesStLabel;

    /**
     * private Label recoveryCasesStLabel.
     */
    @FXML
    private Label recoveryCasesStLabel;

    /**
     * private Label deathCasesStLabel.
     */
    @FXML
    private Label deathCasesStLabel;

    /**
     * private Label contactsStLabel.
     */
    @FXML
    private Label contactsStLabel;

    /**
     * private Label contactsSickStLabel.
     */
    @FXML
    private Label contactsSickStLabel;

    /**
     * private Label avCasesStLabel.
     */
    @FXML
    private Label avCasesStLabel;

    /**
     * private Label avActiveCasesStLabel.
     */
    @FXML
    private Label avActiveCasesStLabel;

    /**
     * private Label avRecoveryCasesStLabel.
     */
    @FXML
    private Label avRecoveryCasesStLabel;

    /**
     * private Label avDeathCasesStLabel.
     */
    @FXML
    private Label avDeathCasesStLabel;

    /**
     * private Label avContactsStLabel.
     */
    @FXML
    private Label avContactsStLabel;

    /**
     * private Label avContactsSickStLabel.
     */
    @FXML
    private Label avContactsSickStLabel;

    /**
     * private Label municipalityStLabel.
     */
    @FXML
    private Label municipalityStLabel;
    /**
     * private Label casesStLabelP.
     */
    @FXML
    private Label casesStLabelP;
    /**
     * private Label activeCasesStLabelP.
     */
    @FXML
    private Label activeCasesStLabelP;
    /**
     * private Label recoveryCasesStLabelP.
     */
    @FXML
    private Label recoveryCasesStLabelP;
    /**
     * private Label deathCasesStLabelP.
     */
    @FXML
    private Label deathCasesStLabelP;
    /**
     * private Label contactsStLabelP.
     */
    @FXML
    private Label contactsStLabelP;
    /**
     * private Label contactsSickStLabelP.
     */
    @FXML
    private Label contactsSickStLabelP;
    /**
     * private AnchorPane for app manual.
     */
    @FXML
    private AnchorPane helpPanel;
    /**
     * private hbox.
     */
    @FXML
    private HBox quack;
    /*
     * Here we will initialize a method to clear automatic
     *  the fields in the panel we insert
     */

    /**
     * <p>
     * A method that clears all the field from the panel we insert.
     * </p>
     *
     * @param panel the panel that we want to clear
     */

    public void clearFields(final AnchorPane panel) {
        if (panel == createCasePanel) {
            firstNameInput.clear();
            lastNameInput.clear();
            ageInput.clear();
            phoneNumberInput.clear();
            addressInput.clear();
            streetInput.clear();
            zipCodeInput.clear();
            contactsInput.clear();
            diagnosisInput.setValue(null);
            deathInput.setValue(null);
            recoveryInput.setValue(null);
            afmInput.clear();
            municipalityInput.getSelectionModel().clearSelection();
        } else if (panel == addContactsPanel) {
            firstNameCoInput.clear();
            lastNameCoInput.clear();
            ageCoInput.clear();
            phoneNumberCoInput.clear();
            municipalityCoInput.getSelectionModel().clearSelection();
            addressCoInput.clear();
            streetCoInput.clear();
            zipCodeCoInput.clear();
            afmCoInput.clear();
        } else if (panel == addContactUniquePanel) {
            firstNameCoUnInput.clear();
            lastNameCoUnInput.clear();
            ageCoUnInput.clear();
            phoneNumberCoUnInput.clear();
            municipalityCoUnInput.getSelectionModel().clearSelection();
            addressCoUnInput.clear();
            streetCoUnInput.clear();
            zipCodeCoUnInput.clear();
            afmCoUnInput.clear();
            afmCoUnKrousmatosInput.clear();
        } else if (panel == editProfilePanel) {
            firstNameEditInput.clear();
            lastNameEditInput.clear();
            ageEditInput.clear();
            phoneNumberEditInput.clear();
            addressEditInput.clear();
            streetEditInput.clear();
            zipCodeEditInput.clear();
            contactsEditInput.clear();
            diagnosisEditInput.setValue(null);
            deathEditInput.setValue(null);
            recoveryEditInput.setValue(null);
            afmEditInput.clear();
            municipalityEditInput.getSelectionModel().clearSelection();
        }

    }


    /*
     * Here we will initialize all the actions on createCase panel.
     */

    /**
     * <p>Click event that will take the value
     * from the create case panel and create
     * the case in the database.
     * </p>
     */
    @FXML
    public void submitCaseClick() {
        String fn = null;
        String ln = null;
        String pn = null;
        String ad = null;
        String st = null;
        String zc = null;
        String dd = null;
        String rd = null;
        String dt = null;
        int af = 0;
        int ag = 0;
        int cn = 0;
        int mun = 0;

        // If at least one of the "must fill" fields is empty
        // then show a message else continue the process
        if (municipalityInput.getSelectionModel().getSelectedIndex() == -1
                || firstNameInput.getText().isEmpty()
                || lastNameInput.getText().isEmpty()
                || ageInput.getText().isEmpty()
                || phoneNumberInput.getText().isEmpty()
                || addressInput.getText().isEmpty()
                || streetInput.getText().isEmpty()
                || zipCodeInput.getText().isEmpty()
                || contactsInput.getText().isEmpty()
                || afmInput.getText().isEmpty()
                || diagnosisInput.getValue() == null) {
            JOptionPane.showMessageDialog(null,
                    "Please fill all the field with *");
        } else {
            try {
                // Initialize all the values we will need to create and
                // insert the case in database
                // Municipality index must be +1 in order to match
                // the case with the right municipality in database
                mun = municipalityInput
                        .getSelectionModel().getSelectedIndex() + 1;
                fn = firstNameInput.getText();
                ln = lastNameInput.getText();
                ag = Integer.parseInt(ageInput.getText());
                pn = phoneNumberInput.getText();
                ad = addressInput.getText();
                st = streetInput.getText();
                zc = zipCodeInput.getText();
                cn = Integer.parseInt(contactsInput.getText());
                dd = String.valueOf(diagnosisInput.getValue());
                af = Integer.parseInt(afmInput.getText());

                // Recovered data and death date
                rd = String.valueOf(recoveryInput.getValue());
                dt = String.valueOf(deathInput.getValue());


                // There are 3 chances ( Case, Recovered Case or Dead Case)
                if (recoveryInput.getValue() == null
                        && deathInput.getValue() == null) {
                    parseAfm = af;

                    Case krousma = new Case(dd, cn, af, fn, ln, ag, pn, mun, ad,
                            st, zc);
                    checkContactsNum(krousma);
                    clearNewCasePane();

                } else if (recoveryInput.getValue() != null
                        && deathInput.getValue() == null) {
                    parseAfm = af;

                    Case krousma = new Case(cn, dd, rd, af, fn, ln, ag, pn, mun,
                            ad, st, zc);
                    checkContactsNum(krousma);
                    clearNewCasePane();

                } else if (recoveryInput.getValue() == null
                        && deathInput.getValue() != null) {
                    parseAfm = af;

                    Case krousma =
                            new Case(dd, dt, cn, af, fn, ln, ag, pn, mun, ad,
                                    st, zc);
                    checkContactsNum(krousma);
                    clearNewCasePane();

                } else {
                    JOptionPane.showMessageDialog(null,
                            "You cant enter both recovery date and death date",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }


    /**
     * <p>This method clear fields of createCasePanel.</p>
     */
    @FXML
    public void clearNewCasePane() {
        clearFields(createCasePanel);
    }


    /**
     * <p>This method cancel (close and clear) createCasePanel.</p>
     */
    @FXML
    public void cancelNewCase() {
        clearNewCasePane();
        openPanels(createCasePanel);
    }


    /**
     * <p>In this method we give the case object and
     * depend to the contactNumber it goes
     * to the next Panel or not.</p>
     *
     * @param krousma type Case.
     */
    public void checkContactsNum(final Case krousma) throws Exception {

        if (krousma.getContactsNumber() == 0) {
            // If the case didn't had contacts then just create the case
            // and close the pane
            insertCase(krousma);

        } else if (krousma.getContactsNumber() > 0) {
            // If the case had contacts then create the case
            // and open the addContactsPanel
            insertCase(krousma);

            // Update the variables that count how many contacts you will add
            totalContacts = krousma.getContactsNumber();
            numberLabel.setText(String.valueOf(totalContacts));
            counterLabel.setText(String.valueOf(counterContacts));

            // Open addContactPanel
            // in order to add the number of contacts the user said
            addContactsPanel.setVisible(true);
            createCasePanel.setVisible(false);

        } else {
            // if the contacts number is < 0 then an error will occur
            throw new Exception(
                    "What do you mean you contacted with "
                            + krousma.getContactsNumber() + " people??");
        }

        // Close the createCasePanel
        createCasePanel.setVisible(false);
    }

    /**
     * <p>This method is doing the insertion
     * of the case in the database.</p>
     *
     * @param krousma type Case.
     */
    public void insertCase(final Case krousma) throws Exception {
        // Creating a instance of CaseDAO in order to insert the case in db
        CaseDAO casedao = new CaseDAO();

        // Insert the case
        casedao.createCaseActive(krousma);
        JOptionPane.showMessageDialog(null,
                "Case has been created successfully!");

    }


    /*
     * Here we will initialize the actions on AddContact Panel.
     */

    /**
     * <p>Click event that will take the value
     * from the create contact panel
     * and create the contact .
     * </p>
     */
    @FXML
    public void submitContactClick() {
        String fnC = null;
        String lnC = null;
        int ageC = 0;
        String pnC = null;
        int munC = 0;
        String addC = null;
        String stC = null;
        String zcC = null;
        int afmC = 0;
        int conId = 0;

        counterContacts++;
        counterLabel.setText(String.valueOf(counterContacts));

        if (firstNameCoInput.getText().isEmpty()
                || lastNameCoInput.getText().isEmpty()
                || ageCoInput.getText().isEmpty()
                || phoneNumberCoInput.getText().isEmpty()
                || municipalityCoInput.getSelectionModel()
                .getSelectedIndex() == -1
                || addressCoInput.getText().isEmpty()
                || streetCoInput.getText().isEmpty()
                || zipCodeCoInput.getText().isEmpty()
                || afmCoInput.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null, "Please fill all the fields with *");
        } else {
            try {
                fnC = firstNameCoInput.getText();
                lnC = lastNameCoInput.getText();
                ageC = Integer.parseInt(ageCoInput.getText());
                pnC = phoneNumberCoInput.getText();
                munC = municipalityCoInput.
                        getSelectionModel().getSelectedIndex() + 1;
                addC = addressCoInput.getText();
                stC = streetCoInput.getText();
                zcC = zipCodeCoInput.getText();
                afmC = Integer.parseInt(afmCoInput.getText());
                conId = Integer.parseInt(afmCoInput.getText());

                // Create the object to add it to DB
                Contact contact = new Contact(afmC, conId, fnC, lnC, ageC, pnC,
                        munC, addC, stC, zcC);
                insertContact(contact, parseAfm);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        // Clear the fields to add a new contact
        // if the contact number given from the previous panel is not yet
        // reached
        clearAddContacts();

        // if the counter of contacts added surpass the contact number given
        // from the createCase panel then close this panel
        if (counterContacts > totalContacts) {
            addContactsPanel.setVisible(false);
            counterContacts = 1;
        }

    }


    /**
     * <p>A method that take the contact and insert it in the database
     * Also it creates the connection with the case from the previous
     * panel (createCase).
     * </p>
     *
     * @param contact    the object that we will insert in db.
     * @param krousmaAFM the afm of the case.
     */
    public void insertContact(final Contact contact,
                              final int krousmaAFM) throws Exception {
        ContactDAO contactDao = new ContactDAO();

        try {
            // Create the contact
            // Create the "connection" case to contact
            contactDao.createContact(contact);
            contactDao.connectCaseContact(krousmaAFM, contact);
            JOptionPane.showMessageDialog(null,
                    "Contact has been successfully created");

        } catch (Exception e) {
            // If something went wrong then delete the created contact
            contactDao.deleteContact(contact.getAFM());
            throw new Exception("An error occurred: " + e.getMessage());
        }
    }


    /**
     * <p>On click event in the addContacts Panel that
     * cancel rest of the process and close the panel.
     * </p>
     */
    @FXML
    public void cancelAddContacts() {
        // Clear the fields to add a new contact
        clearAddContacts();
        openPanels(addContactsPanel);
    }


    /**
     * <p>On click event in the addContacts Panel
     * that clear the fields.</p>
     */
    @FXML
    public void clearAddContacts() {
        clearFields(addContactsPanel);
    }


    /*
     * Here we will initialize the actions on AddContactUnique panel.
     */

    /**
     * <p>Click event that take the values from the panel
     * that creates a contact for a specific case
     * and create the new contact. Also it initialize
     * the case-contact bond in the database.
     * </p>
     */
    @FXML
    public void submitContactUniqueClick() {
        String fnC = null;
        String lnC = null;
        int ageC = 0;
        String pnC = null;
        int munC = 0;
        String addC = null;
        String stC = null;
        String zcC = null;
        int afmC = 0;
        int conId = 0;
        int afmK = 0;

        // All the must fill field must not be null
        if (firstNameCoUnInput.getText().isEmpty()
                || lastNameCoUnInput.getText().isEmpty()
                || ageCoUnInput.getText().isEmpty()
                || phoneNumberCoUnInput.getText().isEmpty()
                || municipalityCoUnInput.getSelectionModel()
                .getSelectedIndex() == -1
                || addressCoUnInput.getText().isEmpty()
                || streetCoUnInput.getText().isEmpty()
                || zipCodeCoUnInput.getText().isEmpty()
                || afmCoUnInput.getText().isEmpty()
                || afmCoUnKrousmatosInput.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Please fill all the field with *");
        } else {
            // Reading all the values in order to continue the process
            try {
                fnC = firstNameCoUnInput.getText();
                lnC = lastNameCoUnInput.getText();
                ageC = Integer.parseInt(ageCoUnInput.getText());
                pnC = phoneNumberCoUnInput.getText();
                munC = municipalityCoUnInput.getSelectionModel()
                        .getSelectedIndex() + 1;
                addC = addressCoUnInput.getText();
                stC = streetCoUnInput.getText();
                zcC = zipCodeCoUnInput.getText();
                afmC = Integer.parseInt(afmCoUnInput.getText());
                afmK = Integer.parseInt(afmCoUnKrousmatosInput.getText());

                // Creating the contact object and inserting it in the
                // database with the method insertContact
                Contact contact = new Contact(afmC, afmC, fnC, lnC, ageC, pnC,
                        munC, addC, stC, zcC);
                insertContact(contact, afmK);

                // Clear and close the panel
                cancelAddContactUniq();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "An error occurred: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }


    /**
     * <p>On click event in the addContactsUnique Panel that
     * cancel rest of the process and close the panel.
     * </p>
     */
    @FXML
    public void cancelAddContactUniq() {
        // clear the field and close the panel
        clearAddContactUniq();
        openPanels(addContactUniquePanel);
    }


    /**
     * <p>On click event in the addContactsUnique Panel
     * that clear the fields.</p>
     */
    @FXML
    public void clearAddContactUniq() {
        clearFields(addContactUniquePanel);
    }


    /*
     * Here we initialize the actions in find person panel.
     */

    /**
     * <p>On click event in the FindPerson Panel
     * that shows all the cases in the table.
     * </p>
     */
    @FXML
    public void allCasesClick() {
        try {
            // Search for all the cases
            CaseDAO caseDao = new CaseDAO();
            ObservableList<Case> oblist = caseDao.getCases();

            // Initialize the label with the number of the results
            resultsInput.setText(String.valueOf(oblist.size()));

            // Initialize the table
            firstNameTable.setCellValueFactory(
                    new PropertyValueFactory<>("firstName"));
            lastNameTable.setCellValueFactory(
                    new PropertyValueFactory<>("lastName"));
            ageTable.setCellValueFactory(
                    new PropertyValueFactory<>("age"));
            phoneNumberTable.setCellValueFactory(
                    new PropertyValueFactory<>("phoneNumber"));
            dimosTable.setCellValueFactory(
                    new PropertyValueFactory<>("dimosName"));
            addressTable.setCellValueFactory(
                    new PropertyValueFactory<>("address"));
            stNumberTable.setCellValueFactory(
                    new PropertyValueFactory<>("streetNumber"));
            zipCodeTable.setCellValueFactory(
                    new PropertyValueFactory<>("zipCode"));
            diagnosisTable.setCellValueFactory(
                    new PropertyValueFactory<>("Diagnosis"));
            recoveryTable.setCellValueFactory(
                    new PropertyValueFactory<>("Recovery"));
            deathTable.setCellValueFactory(
                    new PropertyValueFactory<>("Death"));
            numberOfContactsTable.setCellValueFactory(
                    new PropertyValueFactory<>("contactsNumber"));
            afmTable.setCellValueFactory(
                    new PropertyValueFactory<>("AFM"));
            personsTable.setItems(oblist);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * <p>On click event in the FindPerson Panel
     * that shows all the contacts in the table.
     * </p>
     */
    @FXML
    public void allContactsClick() {

        try {
            // Search for the results
            ContactDAO contactDao = new ContactDAO();
            ObservableList<Case> oblist = contactDao.getContacts();

            // Initialize the label with the number of the results
            resultsInput.setText(String.valueOf(oblist.size()));

            // Initialize the table
            firstNameTable.setCellValueFactory(
                    new PropertyValueFactory<>("firstName"));
            lastNameTable.setCellValueFactory(
                    new PropertyValueFactory<>("lastName"));
            ageTable.setCellValueFactory(
                    new PropertyValueFactory<>("age"));
            phoneNumberTable.setCellValueFactory(
                    new PropertyValueFactory<>("phoneNumber"));
            dimosTable.setCellValueFactory(
                    new PropertyValueFactory<>(("dimosName")));
            addressTable.setCellValueFactory(
                    new PropertyValueFactory<>("address"));
            stNumberTable.setCellValueFactory(
                    new PropertyValueFactory<>("streetNumber"));
            zipCodeTable.setCellValueFactory(
                    new PropertyValueFactory<>("zipCode"));
            afmTable.setCellValueFactory(
                    new PropertyValueFactory<>("AFM"));
            personsTable.setItems(oblist);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    /**
     * <p>On click event in the FindPerson Panel
     * that shows all the persons in the table.
     * </p>
     */
    @FXML
    public void allPersonsClick() {

        try {
            // Find all the persons
            CaseDAO caseDao = new CaseDAO();
            ObservableList<Case> oblist = caseDao.getPersons();

            // Initialize the label with the number of the results
            resultsInput.setText(String.valueOf(oblist.size()));

            // Initialize the table
            firstNameTable.setCellValueFactory(
                    new PropertyValueFactory<>("firstName"));
            lastNameTable.setCellValueFactory(
                    new PropertyValueFactory<>("lastName"));
            ageTable.setCellValueFactory(
                    new PropertyValueFactory<>("age"));
            phoneNumberTable.setCellValueFactory(
                    new PropertyValueFactory<>("phoneNumber"));
            dimosTable.setCellValueFactory(
                    new PropertyValueFactory<>(("dimosName")));
            addressTable.setCellValueFactory(
                    new PropertyValueFactory<>("address"));
            stNumberTable.setCellValueFactory(
                    new PropertyValueFactory<>("streetNumber"));
            zipCodeTable.setCellValueFactory(
                    new PropertyValueFactory<>("zipCode"));
            diagnosisTable.setCellValueFactory(
                    new PropertyValueFactory<>("Diagnosis"));
            recoveryTable.setCellValueFactory(
                    new PropertyValueFactory<>("Recovery"));
            deathTable.setCellValueFactory(
                    new PropertyValueFactory<>("Death"));
            numberOfContactsTable.setCellValueFactory(
                    new PropertyValueFactory<>("contactsNumber"));
            afmTable.setCellValueFactory(
                    new PropertyValueFactory<>("AFM"));
            personsTable.setItems(oblist);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * <p>On click event in the FindPerson Panel
     * that takes the values from the search fields
     * and shows the results in the table.
     * </p>
     */
    @FXML
    public void searchFilterClick() {

        if (filterInput.getText().isEmpty()
                || chooseTableComboBox.getSelectionModel()
                .getSelectedIndex() == -1
                || chooseColumnComboBox.getSelectionModel()
                .getSelectedIndex() == -1) {

            JOptionPane.showMessageDialog(null, "Please insert values in the "
                    + "filters fields");
        } else {
            try {
                CaseDAO caseDao = new CaseDAO();
                Filters filter = new Filters();

                // Read the variables from the filters
                String table = filter.chooseTable(
                        chooseTableComboBox.getValue());
                String column = filter.chooseColumn(
                        chooseColumnComboBox.getValue());
                String input = filterInput.getText();

                // Search the data with the filters values
                ObservableList<Case> oblist = caseDao.getPersonFilter(table,
                        column, input);

                // Initialize the label with the number of the results
                resultsInput.setText(String.valueOf(oblist.size()));

                // Initialize table
                firstNameTable.setCellValueFactory(
                        new PropertyValueFactory<>("firstName"));
                lastNameTable.setCellValueFactory(
                        new PropertyValueFactory<>("lastName"));
                ageTable.setCellValueFactory(
                        new PropertyValueFactory<>("age"));
                phoneNumberTable.setCellValueFactory(
                        new PropertyValueFactory<>("phoneNumber"));
                dimosTable.setCellValueFactory(
                        new PropertyValueFactory<>(("dimosName")));
                addressTable.setCellValueFactory(
                        new PropertyValueFactory<>("address"));
                stNumberTable.setCellValueFactory(
                        new PropertyValueFactory<>("streetNumber"));
                zipCodeTable.setCellValueFactory(
                        new PropertyValueFactory<>("zipCode"));
                diagnosisTable.setCellValueFactory(
                        new PropertyValueFactory<>("Diagnosis"));
                recoveryTable.setCellValueFactory(
                        new PropertyValueFactory<>("Recovery"));
                deathTable.setCellValueFactory(
                        new PropertyValueFactory<>("Death"));
                numberOfContactsTable.setCellValueFactory(
                        new PropertyValueFactory<>("contactsNumber"));
                afmTable.setCellValueFactory(
                        new PropertyValueFactory<>("AFM"));
                personsTable.setItems(oblist);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }


    /**
     * <p>On click event in the FindPerson Panel
     * that shows all the contacts of
     * a specific afm in the table.
     * </p>
     */
    @FXML
    public void searchFilterContactClick() {
        String afm = filterContactInput.getText();

        if (afm != null) {
            try {
                // Find the contacts
                ContactDAO contactDao = new ContactDAO();
                ObservableList<Case> oblist = contactDao.getContactsOfCase(afm);

                // Initialize the label with the number of the results
                resultsInput.setText(String.valueOf(oblist.size()));

                // Initialize table
                firstNameTable.setCellValueFactory(
                        new PropertyValueFactory<>("firstName"));
                lastNameTable.setCellValueFactory(
                        new PropertyValueFactory<>("lastName"));
                ageTable.setCellValueFactory(
                        new PropertyValueFactory<>("age"));
                phoneNumberTable.setCellValueFactory(
                        new PropertyValueFactory<>("phoneNumber"));
                dimosTable.setCellValueFactory(
                        new PropertyValueFactory<>(("dimosName")));
                addressTable.setCellValueFactory(
                        new PropertyValueFactory<>("address"));
                stNumberTable.setCellValueFactory(
                        new PropertyValueFactory<>(
                                "streetNumber"));
                zipCodeTable.setCellValueFactory(
                        new PropertyValueFactory<>("zipCode"));
                diagnosisTable.setCellValueFactory(
                        new PropertyValueFactory<>("Diagnosis"));
                recoveryTable.setCellValueFactory(
                        new PropertyValueFactory<>("Recovery"));
                deathTable.setCellValueFactory(
                        new PropertyValueFactory<>("Death"));
                numberOfContactsTable.setCellValueFactory(
                        new PropertyValueFactory<>("contactsNumber"));
                afmTable.setCellValueFactory(
                        new PropertyValueFactory<>("AFM"));
                personsTable.setItems(oblist);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter an AFM");
        }
    }


    /*
     * Here we initialize the actions of the buttons in edit person panel.
     */

    /**
     * <p>On click event in the EditPerson Panel
     * that update a person's data in the db.
     * </p>
     */
    @FXML
    public void submitEditPersonClick() {
        // If at least one of the "must fill" fields is empty
        // then show a message else continue the process
        if (municipalityEditInput.getSelectionModel().getSelectedIndex() == -1
                || firstNameEditInput.getText().isEmpty()
                || lastNameEditInput.getText().isEmpty()
                || ageEditInput.getText().isEmpty()
                || phoneNumberEditInput.getText().isEmpty()
                || addressEditInput.getText().isEmpty()
                || streetEditInput.getText().isEmpty()
                || zipCodeEditInput.getText().isEmpty()
                || afmEditInput.getText().isEmpty()
                || contactsEditInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Please fill all the field with *");
        } else {
            try {
                // Create the needed variables
                String firstname = null;
                String lastname = null;
                String phone = null;
                String address = null;
                String streetnum = null;
                String zipcode = null;
                String diagnosi = null;
                String recovery = null;
                String death = null;
                int afm = 0;
                int age = 0;
                int coctactsnum = 0;
                int municip = 0;

                CaseDAO caseDao = new CaseDAO();

                // Initialize all the values we will need to create and
                // insert the case in database
                // Municipality index must be +1 in order to match
                // the case with the right municipality in database
                municip = municipalityEditInput.getSelectionModel()
                        .getSelectedIndex() + 1;
                firstname = firstNameEditInput.getText();
                lastname = lastNameEditInput.getText();
                age = Integer.parseInt(ageEditInput.getText());
                phone = phoneNumberEditInput.getText();
                address = addressEditInput.getText();
                streetnum = streetEditInput.getText();
                zipcode = zipCodeEditInput.getText();
                coctactsnum = Integer.parseInt(contactsEditInput.getText());
                if (diagnosisEditInput.getValue() != null) {
                    diagnosi = String.valueOf(diagnosisEditInput.getValue());
                }

                afm = Integer.parseInt(afmEditInput.getText());

                // Recovered data and death date
                recovery = String.valueOf(recoveryEditInput.getValue());
                death = String.valueOf(deathEditInput.getValue());

                // There are 3 chances (Case, Recovered Case or Dead Case)
                if (recoveryEditInput.getValue() == null
                        && deathEditInput.getValue() == null) {

                    Case krousma1 = new Case(diagnosi, coctactsnum,
                            afm, firstname, lastname, age, phone,
                            municip, address, streetnum, zipcode);

                    caseDao.updatePerson(krousma1);

                } else if (recoveryEditInput.getValue() != null
                        && deathEditInput.getValue() == null) {

                    Case krousma1 = new Case(coctactsnum, diagnosi,
                            recovery, afm, firstname, lastname,
                            age, phone, municip, address,
                            streetnum, zipcode);

                    caseDao.updatePerson(krousma1);
                } else if (recoveryEditInput.getValue() == null
                        && deathEditInput.getValue() != null) {

                    Case krousma1 = new Case(diagnosi, death,
                            coctactsnum, afm, firstname, lastname, age,
                            phone, municip, address, streetnum, zipcode);

                    caseDao.updatePerson(krousma1);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "You cant enter both recovery date and death date",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }

                JOptionPane.showMessageDialog(null,
                        "Case has been updated successfully!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }


    /**
     * <p>On click event in the EditPerson Panel
     * that search for the person with
     * the afm you inserted, in the db, and print
     * it's data in the field in order to make changes.
     * </p>
     */
    @FXML
    public void editPersonClick() {
        if (afmEditInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please give an AFM to "
                    + "proceed");
        } else {
            // Read the afm
            String amfInput = afmEditInput.getText();
            CaseDAO caseDao = new CaseDAO();

            try {
                Case person = caseDao.getPersonByAfm(amfInput);

                if (person != null) {
                    // Set the values in the fields
                    firstNameEditInput.setText(person.getFirstName());
                    lastNameEditInput.setText(person.getLastName());
                    ageEditInput.setText(String.valueOf(person.getAge()));
                    phoneNumberEditInput.setText(person.getPhoneNumber());
                    addressEditInput.setText(person.getAddress());
                    streetEditInput.setText(person.getStreetNumber());
                    zipCodeEditInput.setText(person.getZipCode());
                    contactsEditInput.setText(
                            String.valueOf(person.getContactsNumber()));
                    municipalityEditInput.getSelectionModel()
                            .select(person.getDimosID() - 1);

                    if (person.getDiagnosis() != null) {
                        diagnosisEditInput.setValue(
                                LocalDate.parse(person.getDiagnosis()));
                    } else {
                        diagnosisEditInput.setValue(null);
                    }

                    if (person.getRecovery() != null) {
                        recoveryEditInput.setValue(
                                LocalDate.parse(person.getRecovery()));
                    } else {
                        recoveryEditInput.setValue(null);
                    }

                    if (person.getDeath() != null) {
                        deathEditInput.setValue(
                                LocalDate.parse(person.getDeath()));
                    } else {
                        deathEditInput.setValue(null);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Not such person "
                            + "found");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null, "Error: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

        }

    }


    /**
     * <p>On click event in the EditPerson Panel
     * that clear the fields.</p>
     */
    @FXML
    public void clearEditPerson() {
        clearFields(editProfilePanel);
    }


    /**
     * <p>On click event in the EditPerson Panel
     * that cancel (close) the panel.</p>
     */
    @FXML
    public void cancelEditPerson() {
        clearEditPerson();
        openPanels(editProfilePanel);
    }


    /*
     * Here we will initialize the actions in stats panel.
     */

    /**
     * <p>
     * The action of the button in the stats panel.
     * </p>
     */
    @FXML
    public void findStatsClick() {
        if (municipalityStats.getSelectionModel().getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a municipality");
        } else {
            try {
                CaseDAO caseDao = new CaseDAO();
                ContactDAO contactDao = new ContactDAO();

                // The municipality stats variables
                double counterCases;
                double counterActiveCase;
                double counterRecoveryCase;
                double counterDeathCase;
                double counterContacts;
                double counterSickContacts;
                // Total stats variables
                double counterAllCases;
                double counterAllActiveCases;
                double counterAllRecoveryCases;
                double counterAllDeathCases;
                double counterAllContacts;
                double counterAllSickContacts;

                // Set the label equal to the municipality value
                municipalityStLabel.setText(municipalityStats.getValue());

                int municipality =
                        municipalityStats.getSelectionModel()
                                .getSelectedIndex() + 1;

                // Set the municipality label stats
                counterCases = caseDao.countCasesByDimosID(municipality);
                casesStLabel.setText(String.valueOf((int) counterCases));

                counterActiveCase = caseDao
                        .countActiveCasesByDimosID(municipality);
                activeCasesStLabel.setText(
                        String.valueOf((int) counterActiveCase));

                counterRecoveryCase = caseDao
                        .countRecoveryCasesByDimosID(municipality);
                recoveryCasesStLabel.setText(String.valueOf(
                        (int) counterRecoveryCase));

                counterDeathCase = caseDao
                        .countDeathCasesByDimosID(municipality);
                deathCasesStLabel.setText(
                        String.valueOf((int) counterDeathCase));

                counterContacts = contactDao
                        .countContactsByDimosID(municipality);
                contactsStLabel.setText(
                        String.valueOf((int) counterContacts));

                counterSickContacts = contactDao
                        .countContactsSickByDimosID(municipality);
                contactsSickStLabel.setText(
                        String.valueOf((int) counterSickContacts));

                // Search for the total stats in order to make the avg stats
                counterAllCases = caseDao.countCases();
                counterAllActiveCases = caseDao.countActiveCases();
                counterAllRecoveryCases = caseDao.countRecoveryCases();
                counterAllDeathCases = caseDao.countDeathCases();
                counterAllContacts = contactDao.countContacts();
                counterAllSickContacts = contactDao.countContactsSick();

                // Set the avg stats from the total stats (municipality/total)
                if (counterAllCases == 0) {
                    avCasesStLabel.setText(String.valueOf(0));
                } else {
                    avCasesStLabel.setText(
                            String.valueOf((DoubleRounder.round(
                                    66 / counterAllCases, 2))));
                    casesStLabelP.setText(
                            String.valueOf((DoubleRounder.round(
                                    (counterCases / counterAllCases) * 100,
                                    2)) + "%"));
                }
                if (counterAllActiveCases == 0) {
                    avActiveCasesStLabel.setText(
                            String.valueOf(0));
                } else {
                    avActiveCasesStLabel.setText(
                            String.valueOf((DoubleRounder.round(66
                                    / counterAllActiveCases, 2))));
                    activeCasesStLabelP.setText(
                        String.valueOf((
                            DoubleRounder.round(
                                    (counterActiveCase / counterAllActiveCases)
                                            * 100, 2)) + "%"));
                }
                if (counterAllRecoveryCases == 0) {
                    avRecoveryCasesStLabel.setText(
                            String.valueOf(0));
                } else {
                    avRecoveryCasesStLabel.setText(
                            String.valueOf((DoubleRounder.round(66
                                    / counterAllRecoveryCases, 2))));
                    recoveryCasesStLabelP.setText(
                            String.valueOf((DoubleRounder.round(
                                (counterRecoveryCase / counterAllRecoveryCases)
                                * 100, 2)) + "%"));
                }
                if (counterAllDeathCases == 0) {
                    avDeathCasesStLabel.setText(String.valueOf(0));
                } else {
                    avDeathCasesStLabel.setText(
                            String.valueOf((DoubleRounder.round(66
                                    / counterAllDeathCases, 2))));
                    deathCasesStLabelP.setText(
                            String.valueOf((DoubleRounder.round(
                                (counterDeathCase / counterAllDeathCases) * 100,
                                            2)) + "%"));
                }

                if (counterAllContacts == 0) {
                    avContactsStLabel.setText(String.valueOf(0));
                } else {
                    avContactsStLabel.setText(
                            String.valueOf((DoubleRounder.round(66
                                    / counterAllContacts, 2))));
                    contactsStLabelP.setText(
                        String.valueOf((DoubleRounder.round(
                            (counterContacts / counterAllContacts) * 100,
                            2)) + "%"));
                }
                if (counterAllSickContacts == 0) {
                    avContactsSickStLabel.setText(String.valueOf(0));
                } else {
                    avContactsSickStLabel.setText(
                            String.valueOf((DoubleRounder.round(66
                                    / counterAllSickContacts, 2))));
                    contactsSickStLabelP.setText(
                        String.valueOf(
                            (DoubleRounder.round((
                            counterSickContacts / counterAllSickContacts) * 100,
                            2)) + "%"));
                }


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /*
     * Here we will initialize the methods that
     * we open and close panel from the menu bar
     */

    /**
     * <p>
     * A method that is used from every menu bar button
     * in order to be sure that only one panel is open
     * and they haven't stack one upon another.
     * </p>
     *
     * @param panelOpen panel we want to open and.
     */
    public void openPanels(final AnchorPane panelOpen) {
        quack.setVisible(false); // set not visible the QUACK
        // Close all the other panels except the panel you wanna open
        if (panelOpen != createCasePanel) {
            if (createCasePanel.isVisible()) {
                createCasePanel.setVisible(false);
            }
        } else {
            createCasePanel.setVisible(!this.createCasePanel.isVisible());
        }

        if (panelOpen != addContactsPanel) {
            if (addContactsPanel.isVisible()) {
                addContactsPanel.setVisible(false);
            }
        } else {
            addContactsPanel.setVisible(
                    !addContactsPanel.isVisible());
        }

        if (panelOpen != addContactUniquePanel) {
            if (addContactUniquePanel.isVisible()) {
                addContactUniquePanel.setVisible(false);
            }
        } else {
            addContactUniquePanel.setVisible(
                    !addContactUniquePanel.isVisible());
        }

        if (panelOpen != findPersonPanel) {
            if (findPersonPanel.isVisible()) {
                findPersonPanel.setVisible(false);
            }
        } else {
            findPersonPanel.setVisible(
                    !findPersonPanel.isVisible());
        }

        if (panelOpen != editProfilePanel) {
            if (editProfilePanel.isVisible()) {
                editProfilePanel.setVisible(false);
            }
        } else {
            editProfilePanel.setVisible(
                    !editProfilePanel.isVisible());
        }

        if (panelOpen != statsPanel) {
            if (statsPanel.isVisible()) {
                statsPanel.setVisible(false);
            }
        } else {
            statsPanel.setVisible(
                    !statsPanel.isVisible());
        }

        if (panelOpen != helpPanel) {
            if (helpPanel.isVisible()) {
                helpPanel.setVisible(false);
            }
        } else {
            helpPanel.setVisible(
                    !helpPanel.isVisible());
        }

    }


    /**
     * <p>Click event that open and close the menu bar.
     * </p>
     */
    @FXML
    public void menuClick() {
        this.menuBar.setVisible(!this.menuBar.isVisible());
    }


    /**
     * <p>
     * Click event that open and close the stats panel.
     * </p>
     */
    @FXML
    public void menuStatsClick() {
        openPanels(statsPanel);
    }


    /**
     * <p>
     * Click event that opens and close the create case panel.
     * </p>
     */
    @FXML
    public void menuCreateClick() {
        openPanels(createCasePanel);
    }


    /**
     * <p>
     * Click event that opens and close the find persons panel.
     * </p>
     */
    @FXML
    public void menuFindPersonClick() {
        openPanels(findPersonPanel);
    }


    /**
     * <p>
     * Click event that opens and close the addContactsUniquePanel panel.
     * </p>
     */
    @FXML
    public void menuContactClick() {
        openPanels(addContactUniquePanel);
    }


    /**
     * <p>
     * Click event that opens and close the edit persons panel.
     * </p>
     */
    @FXML
    public void menuEditProfileClick() {
        openPanels(editProfilePanel);
    }

    /**
     * <p>
     *     Click event that opens and close the help Panel.
     * </p>
     */
    @FXML
    void helpClick() {
        openPanels(helpPanel);
    }

    /*
     * Here is the implement method the initialize.
     */

    /**
     * <p>
     * A method that initialize fields on the start of the app,
     * set values and do stuff.
     * </p>
     *
     * @param location  Don't know its automated created :)
     * @param resources the same with the location :)
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        // Initialize in all comboBox to have a default value
        municipalityInput.getSelectionModel().select("Select municipality");
        municipalityCoInput.getSelectionModel().select("Select municipality");
        municipalityCoUnInput.getSelectionModel().select("Select municipality");
        municipalityEditInput.getSelectionModel().select("Select municipality");
        municipalityStats.getSelectionModel().select("Select municipality");

        // Initialize the chooses that the comboBox will have
        municipalityInput.getItems().addAll("Αθηναίων", "Βύρωνος", "Γαλατσίου",
                "Δάφνης – Υμηττού", "Ζωγράφου", "Ηλιουπόλεως",
                "Καισαριανής", "Φιλαδελφείας – Χαλκηδόνος",
                "Αγίας Παρασκευής", "Αμαρουσίου",
                "Βριλησσίων", "Ηρακλείου", "Κηφισιάς",
                "Λυκόβρυσης – Πεύκης", "Μεταμορφώσεως", "Νέας Ιωνίας",
                "Παπάγου – Χολαργού", "Πεντέλης",
                "Φιλοθέης – Ψυχικού", "Χαλανδρίου", "Περιστερίου",
                "Αγίας Βαρβάρας", "Αγίων Αναργύρων – Καματερού",
                "Αιγάλεω", "Ιλίου", "Πετρουπόλεως", "Χαϊδαρίου",
                "Καλλιθέας", "Αγίου Δημητρίου", "Αλίμου", "Γλυφάδας",
                "Ελληνικού – Αργυρούπολης", "Μοσχάτου – Ταύρου", "Νέας Σμύρνης",
                "Παλαιού Φαλήρου", "Αχαρνών",
                "Βάρης – Βούλας – Βουλιαγμένης", "Διονύσου", "Κρωπίας",
                "Λαυρεωτικής", "Μαραθώνα", "Μαρκοπούλου Μεσογαίας",
                "Παιανίας", "Παλλήνης",
                "Ραφήνας – Πικερμίου", "Σαρωνικού",
                "Σπάτων – Αρτέμιδος", "Ωρωπού",
                "Ελευσίνας", "Ασπροπύργου",
                "Μάνδρας – Ειδυλλίας", "Μεγαρέων", "Φυλής", "Πειραιώς",
                "Κερατσινίου – Δραπετσώνας",
                "Κορυδαλλού", "Νίκαιας – Αγίου Ιωάννη Ρέντη", "Περάματος",
                "Σαλαμίνος", "Αγκιστρίου",
                "Αίγινας", "Κυθήρων", "Πόρου",
                "Σπετσών", "Τροιζηνίας", "Ύδρας");

        municipalityCoInput.setItems(municipalityInput.getItems());
        municipalityCoUnInput.setItems(municipalityInput.getItems());
        municipalityEditInput.setItems(municipalityInput.getItems());
        municipalityStats.setItems(municipalityInput.getItems());
        chooseTableComboBox.getSelectionModel().select("Select Table");
        chooseTableComboBox.getItems().addAll("Persons", "Cases", "Contacts");

        chooseColumnComboBox.getSelectionModel().select("Select Column");
        chooseColumnComboBox.getItems().addAll(
                "ΑΦΜ", "First Name", "Last Name", "Phone Number",
                "Age", "Municipality", "Address",
                "Street Number", "Zip Code", "Diagnosis Date",
                "Recovery Date", "Death Date");
    }

}
