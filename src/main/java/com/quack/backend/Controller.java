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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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

    /*  Here we will initialize all the fields, button,
     *   datePickers and AnchorPane that we will need in our use cases, and
     * we read them from the fxml file
     */

    // Main anchorPane
    /**
     * private AnchorPane anchorPane.
     */
    @FXML
    private AnchorPane anchorPane;


    // Menu bar items
    /**
     * private AnchorPane menuButton.
     */
    @FXML
    private ImageView menuButton;
    /**
     * private AnchorPane toolBar.
     */
    @FXML
    private AnchorPane toolBar;
    /**
     * private AnchorPane menuBar.
     */
    @FXML
    private AnchorPane menuBar;


    // Create Case Panel (AnchorPane, Fields, ComboBox, DatePickers, Button)
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

    // Add contacts panel after the create case panel.
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


    //Edit profile (AnchorPane, Fields, Button etc.)
    /**
     * private TextField editProfilePanel.
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


    // Add a contact to a specific case panel (AnchorPane, Fields, Button etc.)
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

    //Find persons (AnchorPane, Fields, Button)
    /**
     * private TableColumn<Case, String> findPersonPanel.
     */
    @FXML
    private AnchorPane findPersonPanel;
    /**
     * private TableColumn<Case, String> personsTable.
     */
    @FXML
    private TableView<Case> personsTable;
    /**
     * private TableColumn<Case, String> afmTable.
     */
    @FXML
    private TableColumn<Case, Integer> afmTable;
    /**
     * private TableColumn<Case, String> numberOfContactsTable.
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
     * private TableColumn<Case, String> ageTable.
     */
    @FXML
    private TableColumn<Case, Integer> ageTable;
    /**
     * private TableColumn<Case, String> phoneNumberTable.
     */
    @FXML
    private TableColumn<Case, String> phoneNumberTable;
    /**
     * private TableColumn<Case, String> dimosTable.
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

    //Stats
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


    /* Here we will initialize all the functions and events on click */


    // Click event that will take the value from the create case panel
    // and create the case in the database

    /**
     * <p>This method create new Case.</p>
     *
     * @param event the event of mouse on click.
     * @since 1.0
     */
    @FXML
    public void submitCaseClick(MouseEvent event) {
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
                    clearNewCasePane(event);

                } else if (recoveryInput.getValue() != null
                        && deathInput.getValue() == null) {
                    parseAfm = af;

                    Case krousma = new Case(cn, dd, rd, af, fn, ln, ag, pn, mun,
                            ad, st, zc);
                    checkContactsNum(krousma);
                    clearNewCasePane(event);

                } else if (recoveryInput.getValue() == null
                        && deathInput.getValue() != null) {
                    parseAfm = af;

                    Case krousma =
                            new Case(dd, dt, cn, af, fn, ln, ag, pn, mun, ad,
                            st, zc);
                    checkContactsNum(krousma);
                    clearNewCasePane(event);

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


    // Clear button. It clears the fields of new case pane
    /**
     * <p>This method clear fields of createCasePanel.</p>
     * @param event the event of mouse on click.
     * @since 1.0
     */
    @FXML
    public void clearNewCasePane(MouseEvent event) {
        clearFields(createCasePanel);
    }


    // Cancel button. It cancels the creation of a case in new case pane
    /**
     * <p>This method cancel (close) createCasePanel.</p>
     * @param event the event of mouse on click.
     * @since 1.0
     */
    @FXML
    public void cancelNewCase(MouseEvent event) {
        clearNewCasePane(event);
        createCasePanel.setVisible(false);
    }


    // In this method we give the case object and depend to the contactNumber
    // it goes to the next Panel or not
    /**
     * <p>This method checking if case had contacts and do the insertion.</p>
     * @param krousma type Case.
     * @since 1.0
     */
    public void checkContactsNum(Case krousma) throws Exception {

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
     * <p>This method is doing the insertion in the database.</p>
     * @param krousma type Case.
     * @since 1.0
     */
    public void insertCase(Case krousma) throws Exception {
        // Creating a instance of CaseDAO in order to insert the case in db
        CaseDAO casedao = new CaseDAO();

        // Insert the case
        casedao.createCaseActive(krousma);
        JOptionPane.showMessageDialog(null,
                "Case has been created successfully!");

    }


    // Click event that will take the value from the create contact panel
    // and create the number contacts that the user inserted on the
    // createCase panel
    // This panel is auto open when the user finish the creation of a case
    /**
     * <p>Click event that will take the value from the create contact panel
     *    and create the number contacts that the user inserted on the
     *    createCase panel.
     *    This panel is auto open when the user finish the creation of a case
     *    </p>
     * @param event the event of mouse on click.
     * @since 1.0
     */
    @FXML
    public void submitContactClick(MouseEvent event) {
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
        clearAddContacts(event);

        // if the counter of contacts added surpass the contact number given
        // from the createCase panel then close this panel
        if (counterContacts > totalContacts) {
            addContactsPanel.setVisible(false);
            counterContacts = 1;
        }

    }

//TODO EDO EMINA @paraskos
    // A method that take the contact and insert it in the database
    // Also it creates the connection with the case from the previous
    // panel (createCase)
    /**
     * <p>Click event that will take the value from the create contact panel
     *    and create the number contacts that the user inserted on the
     *    createCase panel.
     *    This panel is auto open when the user finish the creation of a case
     *    </p>
     * @param contact the event of mouse on click.
     * @param krousmaAFM the event of mouse on click.
     * @since 1.0
     */
    public void insertContact(Contact contact,
                              int krousmaAFM) throws Exception {
        ContactDAO contactDao = new ContactDAO();

        try {
            // Create the contact and create also the "connection" case to contact
            contactDao.createContact(contact);
            contactDao.connectCaseContact(krousmaAFM, contact);
            JOptionPane.showMessageDialog(null, "Contact has been successfully created");

        } catch (Exception e) {
            // If something went wrong then delete the created contact in order not to have false data
            contactDao.deleteContact(contact.getAFM());
            throw new Exception("An error occurred: " + e.getMessage());
        }
    }


    // On click event in the addContacts Panel that cancel rest of the process
    @FXML
    public void cancelAddContacts(MouseEvent event) {
        // Clear the fields to add a new contact
        clearAddContacts(event);
        openPanels("addContactsPanel");
    }


    // On click event in the addContacts Panel that clear the fields
    @FXML
    public void clearAddContacts(MouseEvent event) {
        clearFields(addContactsPanel);
    }


    // Click event that take the values from the panel that creates a contact
    // for a specific case and initialize that case-contact bond in the database,
    // and also create the new contact
    @FXML
    public void submitContactUniqueClick(MouseEvent event) {
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
        if (firstNameCoUnInput.getText().isEmpty() || lastNameCoUnInput.getText().isEmpty()
                || ageCoUnInput.getText().isEmpty() || phoneNumberCoUnInput.getText().isEmpty()
                || municipalityCoUnInput.getSelectionModel().getSelectedIndex() == -1
                || addressCoUnInput.getText().isEmpty() || streetCoUnInput.getText().isEmpty()
                || zipCodeCoUnInput.getText().isEmpty() || afmCoUnInput.getText().isEmpty()
                || afmCoUnKrousmatosInput.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please fill all the field with *");
        } else {
            // Reading all the values in order to continue the process
            try {
                fnC = firstNameCoUnInput.getText();
                lnC = lastNameCoUnInput.getText();
                ageC = Integer.parseInt(ageCoUnInput.getText());
                pnC = phoneNumberCoUnInput.getText();
                munC = municipalityCoUnInput.getSelectionModel().getSelectedIndex() + 1;
                addC = addressCoUnInput.getText();
                stC = streetCoUnInput.getText();
                zcC = zipCodeCoUnInput.getText();
                afmC = Integer.parseInt(afmCoUnInput.getText());
                afmK = Integer.parseInt(afmCoUnKrousmatosInput.getText());

                // Creating the contact object and inserting the database with the method insertContact
                Contact contact = new Contact(afmC, afmC, fnC, lnC, ageC, pnC,
                        munC, addC, stC, zcC);
                insertContact(contact, afmK);

                // Clear and close the panel
                cancelAddContactUniq(event);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null, "An error occurred: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }


    @FXML
    public void cancelAddContactUniq(MouseEvent event) {
        // clear the field and close the panel
        clearAddContactUniq(event);
        openPanels("addContactUniquePanel");
    }


    @FXML
    public void clearAddContactUniq(MouseEvent event) {
        clearFields(addContactUniquePanel);
    }


    @FXML
    public void allCasesClick(MouseEvent event) throws Exception {
        int counter = 0;
        CaseDAO caseDao = new CaseDAO();
        ObservableList<Case> oblist = caseDao.getCases();
        for (Case krousma : oblist) {
            counter++;
        }
        resultsInput.setText(String.valueOf(counter));

        try {
            caseDao.getPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>("dimosName"));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        diagnosisTable.setCellValueFactory(new PropertyValueFactory<>("Diagnosis"));
        recoveryTable.setCellValueFactory(new PropertyValueFactory<>("Recovery"));
        deathTable.setCellValueFactory(new PropertyValueFactory<>("Death"));
        numberOfContactsTable.setCellValueFactory(new PropertyValueFactory<>("contactsNumber"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);

    }


    @FXML
    public void allContactsClick(MouseEvent event) throws Exception {
        int counter = 0;
        CaseDAO caseDao = new CaseDAO();
        ObservableList<Case> oblist = caseDao.getContacts();
        for (Case krousma : oblist) {
            counter++;
        }
        resultsInput.setText(String.valueOf(counter));
        try {
            caseDao.getPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>(("dimosName")));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);

    }


    @FXML
    public void allPersonsClick(MouseEvent event) throws Exception {
        int counter = 0;
        CaseDAO caseDao = new CaseDAO();
        ObservableList<Case> oblist = caseDao.getPersons();
        for (Case krousma : oblist) {
            counter++;
        }
        resultsInput.setText(String.valueOf(counter));
        System.out.println(counter);
        try {
            caseDao.getPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }
        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>(("dimosName")));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        diagnosisTable.setCellValueFactory(new PropertyValueFactory<>("Diagnosis"));
        recoveryTable.setCellValueFactory(new PropertyValueFactory<>("Recovery"));
        deathTable.setCellValueFactory(new PropertyValueFactory<>("Death"));
        numberOfContactsTable.setCellValueFactory(new PropertyValueFactory<>("contactsNumber"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);

    }


    @FXML
    public void searchFilterClick(MouseEvent event) throws Exception {
        int counter = 0;
        CaseDAO caseDao = new CaseDAO();
        Filters filter = new Filters();
        String table = filter.chooseTable(chooseTableComboBox.getValue());
        String column = filter.chooseColumn(chooseColumnComboBox.getValue());
        ObservableList<Case> oblist = caseDao.getPersonFilter(table, column, filterInput.getText());
        for (Case krousma : oblist) {
            counter++;
        }
        resultsInput.setText(String.valueOf(counter));


        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>(("dimosName")));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        diagnosisTable.setCellValueFactory(new PropertyValueFactory<>("Diagnosis"));
        recoveryTable.setCellValueFactory(new PropertyValueFactory<>("Recovery"));
        deathTable.setCellValueFactory(new PropertyValueFactory<>("Death"));
        numberOfContactsTable.setCellValueFactory(new PropertyValueFactory<>("contactsNumber"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);
    }


    @FXML
    public void searchFilterContactClick(MouseEvent event) throws Exception {
        CaseDAO caseDao = new CaseDAO();
        int counter = 0;
        String afm = filterContactInput.getText();
        Filters filter = new Filters();
        String table = filter.chooseTable(chooseTableComboBox.getValue());
        String column = filter.chooseColumn(chooseColumnComboBox.getValue());
        ObservableList<Case> oblist = caseDao.getContactsOfCase(afm);
        for (Case krousma : oblist) {
            counter++;
        }
        resultsInput.setText(String.valueOf(counter));


        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>(("dimosName")));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        diagnosisTable.setCellValueFactory(new PropertyValueFactory<>("Diagnosis"));
        recoveryTable.setCellValueFactory(new PropertyValueFactory<>("Recovery"));
        deathTable.setCellValueFactory(new PropertyValueFactory<>("Death"));
        numberOfContactsTable.setCellValueFactory(new PropertyValueFactory<>("contactsNumber"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);

    }


    @FXML
    public void submitEditPersonClick(MouseEvent event) {
        CaseDAO caseDao = new CaseDAO();
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
        if (municipalityEditInput.getSelectionModel().getSelectedIndex() == -1
                || firstNameEditInput.getText().isEmpty()
                || lastNameEditInput.getText().isEmpty() || ageEditInput.getText().isEmpty()
                || phoneNumberEditInput.getText().isEmpty() || addressEditInput.getText().isEmpty()
                || streetEditInput.getText().isEmpty() || zipCodeEditInput.getText().isEmpty()
                || afmEditInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the field with *");
        } else {
            try {
                // Initialize all the values we will need to create and insert the case in database
                // Municipality index must be +1 in order to match
                // the case with the right municipality in database
                mun = municipalityEditInput.getSelectionModel().getSelectedIndex() + 1;
                fn = firstNameEditInput.getText();
                ln = lastNameEditInput.getText();
                ag = Integer.parseInt(ageEditInput.getText());
                pn = phoneNumberEditInput.getText();
                ad = addressEditInput.getText();
                st = streetEditInput.getText();
                zc = zipCodeEditInput.getText();
                cn = Integer.parseInt(contactsEditInput.getText());
                if (diagnosisEditInput.getValue() != null) {
                    dd = String.valueOf(diagnosisEditInput.getValue());
                }

                af = Integer.parseInt(afmEditInput.getText());

                // Recovered data and death date
                rd = String.valueOf(recoveryEditInput.getValue());
                dt = String.valueOf(deathEditInput.getValue());

                // There are 3 chances (new Case, new Recovered Case or new Dead Case)
                if (recoveryEditInput.getValue() == null && deathEditInput.getValue() == null) {


                    Case krousma1 = new Case(dd, cn, af, fn, ln, ag, pn, mun, ad,
                            st, zc);

                    caseDao.updatePerson(af, krousma1);

                } else if (recoveryEditInput.getValue() != null && deathEditInput.getValue() == null) {


                    Case krousma1 = new Case(cn, dd, rd, af, fn, ln, ag, pn, mun,
                            ad, st, zc);

                    caseDao.updatePerson(af, krousma1);
                } else if (recoveryEditInput.getValue() == null && deathEditInput.getValue() != null) {


                    Case krousma1 = new Case(dd, dt, cn, af, fn, ln, ag, pn, mun, ad,
                            st, zc);

                    caseDao.updatePerson(af, krousma1);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "You cant enter both recovery date and death date",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                JOptionPane.showMessageDialog(null,
                        "Case has been updated successfully!");
            }

        }

    }


    @FXML
    public void editPersonClick(MouseEvent event) throws Exception {
        CaseDAO caseDao = new CaseDAO();
        String amfInput = afmEditInput.getText();
        try {
            ObservableList<Case> oblist = caseDao.getPersonAfm(amfInput);
            for (Case krousma : oblist) {

                firstNameEditInput.setText(krousma.getFirstName());
                lastNameEditInput.setText(krousma.getLastName());
                ageEditInput.setText(String.valueOf(krousma.getAge()));
                phoneNumberEditInput.setText(krousma.getPhoneNumber());
                addressEditInput.setText(krousma.getAddress());
                streetEditInput.setText(krousma.getStreetNumber());
                zipCodeEditInput.setText(krousma.getZipCode());
                contactsEditInput.setText(String.valueOf(krousma.getContactsNumber()));
                municipalityEditInput.getSelectionModel().select(krousma.getDimosID() - 1);
                if (krousma.getDiagnosis() != null) {
                    diagnosisEditInput.setValue(LocalDate.parse(krousma.getDiagnosis()));
                }
                if (krousma.getRecovery() != null) {
                    recoveryEditInput.setValue(LocalDate.parse(krousma.getRecovery()));
                }
                if (krousma.getDeath() != null) {
                    deathEditInput.setValue(LocalDate.parse(krousma.getDeath()));
                }


            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Please do not leave the field blank.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    @FXML
    public void clearEditPerson(MouseEvent event) {
        clearFields(editProfilePanel);
    }


    @FXML
    public void cancelEditPerson(MouseEvent event) {
        openPanels("editProfilePanel");
    }


    public void clearFields(AnchorPane panel) {
        if (panel == createCasePanel) {
            firstNameInput.clear();
            lastNameInput.clear();
            ageInput.clear();
            phoneNumberInput.clear();
            addressInput.clear();
            streetInput.clear();
            zipCodeInput.clear();
            contactsInput.clear();
            diagnosisInput.getEditor().clear();
            deathInput.getEditor().clear();
            recoveryInput.getEditor().clear();
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
            diagnosisEditInput.getEditor().clear();
            deathEditInput.getEditor().clear();
            recoveryEditInput.getEditor().clear();
            afmEditInput.clear();
            municipalityEditInput.getSelectionModel().clearSelection();
        }

    }


    // A method to open and close the panels from the menu bar
    public void openPanels(String panelOpen) {
        // Close all the other panels except the panel you wanna open
        if (!panelOpen.equals("createCasePanel")) {
            if (this.createCasePanel.isVisible())
                this.createCasePanel.setVisible(false);
        } else {
            this.createCasePanel.setVisible(!this.createCasePanel.isVisible());
        }

        if (!panelOpen.equals("addContactsPanel")) {
            if (this.addContactsPanel.isVisible())
                this.addContactsPanel.setVisible(false);
        } else {
            this.addContactsPanel.setVisible(!this.addContactsPanel.isVisible());
        }

        if (!panelOpen.equals("addContactUniquePanel")) {
            if (this.addContactUniquePanel.isVisible())
                this.addContactUniquePanel.setVisible(false);
        } else {
            this.addContactUniquePanel.setVisible(!this.addContactUniquePanel.isVisible());
        }

        if (!panelOpen.equals("findPersonPanel")) {
            if (this.findPersonPanel.isVisible())
                this.findPersonPanel.setVisible(false);
        } else {
            this.findPersonPanel.setVisible(!this.findPersonPanel.isVisible());
        }

        if (!panelOpen.equals("editPersonPanel")) {
            if (this.editProfilePanel.isVisible())
                this.editProfilePanel.setVisible(false);
        } else {
            this.editProfilePanel.setVisible(!this.editProfilePanel.isVisible());
        }

        if (!panelOpen.equals("statsPanel")) {
            if (this.statsPanel.isVisible())
                this.statsPanel.setVisible(false);
        } else {
            this.statsPanel.setVisible(!this.statsPanel.isVisible());
        }


    }


    // Click event that open and close the menu bar
    @FXML
    public void menuClick(MouseEvent event) {
        this.menuBar.setVisible(!this.menuBar.isVisible());
    }


    @FXML
    public void menuStatsClick(MouseEvent event) {
        openPanels("statsPanel");
    }


    // Click event that opens and close the create case panel
    @FXML
    public void menuCreateClick(MouseEvent event) {
        openPanels("createCasePanel");
    }


    // Click event that opens and close the find persons panel
    @FXML
    public void menuFindPersonClick(MouseEvent event) {
        openPanels("findPersonPanel");
    }


    // Click event that opens and close the addContactsUniquePanel panel
    @FXML
    public void menuContactClick(MouseEvent event) {
        openPanels("addContactUniquePanel");
    }


    // Click event that opens and close the edit persons panel
    @FXML
    public void menuEditProfileClick(MouseEvent event) {
        openPanels("editPersonPanel");
    }

    @FXML
    public void findStatsClick(MouseEvent event) throws Exception {
        CaseDAO caseDao = new CaseDAO();
        int counterCases = 0;
        int counterActiveCase = 0;
        int counterRecoveryCase = 0;
        int counterDeathCase = 0;
        int counterContacts = 0;
        int counterSickContacts = 0;
        int counterAllCases = 0;
        int counterAllActiveCases = 0;
        int counterAllRecoveryCases = 0;
        int counterAllDeathCases = 0;
        int counterAllContacts = 0;
        int counterAllSickContacts = 0;

        counterAllCases = caseDao.countCases();
        counterActiveCase = caseDao.countActiveCases();
        counterAllRecoveryCases = caseDao.countRecoveryCases();
        counterAllDeathCases = caseDao.countDeathCases();
        counterAllContacts = caseDao.countContacts();
        counterAllSickContacts = caseDao.countContactsSick();

        municipalityStLabel.setText(municipalityStats.getValue());
        counterCases = caseDao.countCasesByDimosID(municipalityStats.getSelectionModel().getSelectedIndex() + 1);
        casesStLabel.setText(String.valueOf(counterCases));
        counterActiveCase = caseDao.countActiveCasesByDimosID(municipalityStats.getSelectionModel().getSelectedIndex() + 1);
        activeCasesStLabel.setText(String.valueOf(counterActiveCase));
        counterRecoveryCase = caseDao.countRecoveryCasesByDimosID(municipalityStats.getSelectionModel().getSelectedIndex() + 1);
        recoveryCasesStLabel.setText(String.valueOf(counterRecoveryCase));
        counterDeathCase = caseDao.countDeathCasesByDimosID(municipalityStats.getSelectionModel().getSelectedIndex() + 1);
        deathCasesStLabel.setText(String.valueOf(counterDeathCase));
        counterContacts = caseDao.countContactsByDimosID(municipalityStats.getSelectionModel().getSelectedIndex() + 1);
        contactsStLabel.setText(String.valueOf(counterContacts));
        counterSickContacts = caseDao.countContactsSickByDimosID(municipalityStats.getSelectionModel().getSelectedIndex() + 1);
        contactsSickStLabel.setText(String.valueOf(counterSickContacts));
        if (counterAllCases == 0) {
            avCasesStLabel.setText(String.valueOf(0));
        } else {
            avCasesStLabel.setText(String.valueOf(counterCases / counterAllCases));
        }
        if (counterAllActiveCases == 0) {
            avActiveCasesStLabel.setText(String.valueOf(0));
        } else {
            avActiveCasesStLabel.setText(String.valueOf(counterActiveCase / counterAllActiveCases));
        }
        if (counterAllRecoveryCases == 0) {
            avRecoveryCasesStLabel.setText(String.valueOf(0));
        } else {
            avRecoveryCasesStLabel.setText(String.valueOf(counterRecoveryCase / counterAllRecoveryCases));
        }
        if (counterAllDeathCases == 0) {
            avDeathCasesStLabel.setText(String.valueOf(0));
        } else {
            avDeathCasesStLabel.setText(String.valueOf(counterDeathCase / counterAllDeathCases));
        }

        if (counterAllContacts == 0) {
            avContactsStLabel.setText(String.valueOf(0));
        } else {
            avContactsStLabel.setText(String.valueOf(counterContacts / counterAllContacts));
        }

        if (counterAllSickContacts == 0) {
            avContactsSickStLabel.setText(String.valueOf(0));
        } else {
            avContactsSickStLabel.setText(String.valueOf(counterSickContacts / counterAllSickContacts));
        }


    }

    // The initialize method in order on the start of the app to set values and do stuff
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initialize in all comboBox that the use choose a municipality to have a default value
        municipalityInput.getSelectionModel().select("Select municipality");
        municipalityCoInput.getSelectionModel().select("Select municipality");
        municipalityCoUnInput.getSelectionModel().select("Select municipality");
        municipalityEditInput.getSelectionModel().select("Select municipality");
        municipalityStats.getSelectionModel().select("Select municipality");
        // Initialize the chooses that the comboBox will have
        municipalityInput.getItems().addAll("Αθηναίων", "Βύρωνος", "Γαλατσίου",
                "Δάφνης – Υμηττού", "Ζωγράφου", "Ηλιουπόλεως", "Καισαριανής", "Φιλαδελφείας – ",
                "Χαλκηδόνος", "Αγίας Παρασκευής", "Αμαρουσίου", "Βριλησσίων", "Ηρακλείου", "Κηφισιάς",
                "Λυκόβρυσης – Πεύκης", "Μεταμορφώσεως", "Νέας Ιωνίας", "Παπάγου – Χολαργού", "Πεντέλης",
                "Φιλοθέης – Ψυχικού", "Χαλανδρίου", "Περιστερίου", "Αγίας Βαρβάρας",
                "Αγίων Αναργύρων – Καματερού", "Αιγάλεω", "Ιλίου", "Πετρουπόλεως", "Χαϊδαρίου",
                "Καλλιθέας", "Αγίου Δημητρίου", "Αλίμου", "Γλυφάδας", "Ελληνικού – Αργυρούπολης",
                "Μοσχάτου – Ταύρου", "Νέας Σμύρνης", "Παλαιού Φαλήρου", "Αχαρνών",
                "Βάρης – Βούλας – Βουλιαγμένης", "Διονύσου", "Κρωπίας",
                "Λαυρεωτικής", "Μαραθώνα", "Μαρκοπούλου Μεσογαίας", "Παιανίας", "Παλλήνης",
                "Ραφήνας – Πικερμίου", "Σαρωνικού", "Σπάτων", "Ωρωπού", "Ελευσίνας", "Ασπροπύργου",
                "Μάνδρας – Ειδυλλίας", "Μεγαρέων", "Φυλής", "Πειραιώς", "Κερατσινίου – Δραπετσώνας",
                "Κορυδαλλού", "Νίκαιας – Αγίου Ιωάννη Ρέντη", "Περάματος", "Σαλαμίνος", "Αγκιστρίου",
                "Αίγινας", "Κυθήρων", "Πόρου", "Σπετσών", "Τροιζηνίας", "Ύδρας");

        municipalityCoInput.setItems(municipalityInput.getItems());
        municipalityCoUnInput.setItems(municipalityInput.getItems());
        municipalityEditInput.setItems(municipalityInput.getItems());
        municipalityStats.setItems(municipalityInput.getItems());
        chooseTableComboBox.getSelectionModel().select("Select Table");
        chooseTableComboBox.getItems().addAll("Persons", "Cases", "Contacts");

        chooseColumnComboBox.getSelectionModel().select("Select Column");
        chooseColumnComboBox.getItems().addAll("ΑΦΜ", "First Name", "Last Name", "Phone Number",
                "Age", "Municipality", "Address", "Street Number", "Zip Code", "Diagnosis Date",
                "Recovery Date", "Death Date");


    }

}

