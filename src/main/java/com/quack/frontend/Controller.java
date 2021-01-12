package com.quack.frontend;

import com.quack.backend.Case;
import com.quack.backend.Contact;
import com.quack.backend.Filters;
import com.quack.db.CaseDAO;
import com.quack.db.ContactDAO;
import com.quack.db.DB;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.JOptionPane;

/**
 * In Controller done all management for the gui
 *
 * @version 1.0.1 11 Jan 2021
 */
public class Controller implements Initializable {
  private boolean menuHide = true;
  private boolean createCaseHide = true;
  private boolean addContactsHide = true;
  private boolean addContactUniqueHide = true;
  private boolean findPersonHide = true;
  private int totalContacts = 0;
  private int counterContacts = 1;
  private int parseAfm = 0;
  private int contactsNumberSql = 0;

  /*  Here we will initialize all the fields, button, datePickers and AnchorPane
   *   that we will need in our use cases
   */

  // Main anchorPane
  @FXML
  private AnchorPane anchorPane;


  // Menu bar items
  @FXML
  private ImageView menuButton;

  @FXML
  private AnchorPane toolBar;

  @FXML
  private AnchorPane menuBar;

  @FXML
  private Group menuCreateButton;

  @FXML
  private Group menuContactButton;

  @FXML
  private Group menuFindPersonButton;


  // Create Case Panel (AnchorPane, Fields, ComboBox, DatePickers, Button)
  @FXML
  private AnchorPane createCasePanel;

  @FXML
  private TextField firstNameInput;

  @FXML
  private TextField lastNameInput;

  @FXML
  private TextField ageInput;

  @FXML
  private TextField phoneNumberInput;

  @FXML
  private TextField addressInput;

  @FXML
  private TextField streetInput;

  @FXML
  private TextField zipCodeInput;

  @FXML
  private TextField contactsInput;

  @FXML
  private TextField afmInput;

  @FXML
  private ComboBox<String> municipalityInput;

  @FXML
  private DatePicker diagnosisInput;

  @FXML
  private DatePicker recoveryInput;

  @FXML
  private DatePicker deathInput;

  @FXML
  private Button submitCaseButton;


  // Add contacts to the created case (AnchorPane, Fields, Button, Labels)
  @FXML
  private AnchorPane addContactsPanel;

  @FXML
  private Label numberLabel;

  @FXML
  private Label counterLabel;

  @FXML
  private TextField firstNameCoInput;

  @FXML
  private TextField lastNameCoInput;

  @FXML
  private TextField ageCoInput;

  @FXML
  private TextField phoneNumberCoInput;

  @FXML
  private ComboBox<String> municipalityCoInput;

  @FXML
  private TextField addressCoInput;

  @FXML
  private TextField streetCoInput;

  @FXML
  private TextField zipCodeCoInput;

  @FXML
  private TextField afmCoInput;

  @FXML
  private Button submitContactButton;


  // Add a contact to a specific case (AnchorPane, Fields, Button)
  @FXML
  private AnchorPane addContactUniquePanel;

  @FXML
  private TextField firstNameCoUnInput;

  @FXML
  private TextField lastNameCoUnInput;

  @FXML
  private TextField ageCoUnInput;

  @FXML
  private TextField phoneNumberCoUnInput;

  @FXML
  private ComboBox<String> municipalityCoUnInput;

  @FXML
  private TextField addressCoUnInput;

  @FXML
  private TextField streetCoUnInput;

  @FXML
  private TextField zipCodeCoUnInput;

  @FXML
  private TextField afmCoUnInput;

  @FXML
  private TextField afmCoUnKrousmatosInput;

  @FXML
  private Button submitContactUniqueButton;

  @FXML
  private Button clearAddContactUniqButton;

  @FXML
  private Button cancelAddContactUniqButton;


  //Find persons (AnchorPane, Fields, Button)
  @FXML
  private AnchorPane findPersonPanel;

  @FXML
  private TableView<Case> personsTable;

  @FXML
  private TableColumn<Case, Integer> afmTable;

  @FXML
  private TableColumn<Case, Integer> numberOfContactsTable;

  @FXML
  private TableColumn<Case, String> firstNameTable;

  @FXML
  private TableColumn<Case, String> lastNameTable;

  @FXML
  private TableColumn<Case, Integer> ageTable;

  @FXML
  private TableColumn<Case, String> phoneNumberTable;

  @FXML
  private TableColumn<Case, Integer> dimosTable;

  @FXML
  private TableColumn<Case, String> addressTable;

  @FXML
  private TableColumn<Case, String> stNumberTable;

  @FXML
  private TableColumn<Case, String> zipCodeTable;

  @FXML
  private TableColumn<Case, String> diagnosisTable;

  @FXML
  private TableColumn<Case, String> recoveryTable;

  @FXML
  private TableColumn<Case, String> deathTable;

  @FXML
  private TableColumn<?, ?> infoTable;

  @FXML
  private TableColumn<?, ?> actionTable;


  @FXML
  private Button allPersonsButton;

  @FXML
  private Button allCasesButton;

  @FXML
  private Button allContactButton;

  @FXML
  private Button searchFilterButton;

  @FXML
  private TextField filterInput;

  @FXML
  private ComboBox<String> chooseColumnComboBox;

  @FXML
  private ComboBox<String> chooseTableComboBox;



  /* Here we will initialize all the functions and events on click */


  // Click event that open and close the menu bar
  @FXML
  public void menuClick(MouseEvent event) {
    openPanels(menuBar);
  }


  // Click event that opens and close the create case panel
  @FXML
  public void menuCreateClick(MouseEvent event) {
    openPanels(createCasePanel);
  }


  // Click event that opens and close the find persons panel
  @FXML
  public void menuFindPersonClick(MouseEvent event) {
    openPanels(findPersonPanel);
  }


  @FXML
  public void menuContactClick(MouseEvent event) {
    openPanels(addContactUniquePanel);
  }


  // Click event that will take the value from the create case panel
  // and create the case in the database
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
            || lastNameInput.getText().isEmpty() || ageInput.getText().isEmpty()
            || phoneNumberInput.getText().isEmpty() || addressInput.getText().isEmpty()
            || streetInput.getText().isEmpty() || zipCodeInput.getText().isEmpty()
            || contactsInput.getText().isEmpty()
            || afmInput.getText().isEmpty()
            || diagnosisInput.getValue() == null) {
      JOptionPane.showMessageDialog(null, "Please fill all the field with *");
    } else {
      try {
        // Initialize all the values we will need to create and insert the case in database
        // Municipality index must be +1 in order to match
        // the case with the right municipality in database
        mun = municipalityInput.getSelectionModel().getSelectedIndex() + 1;
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


        // There are 3 chances (new Case, new Recovered Case or new Dead Case)
        if (recoveryInput.getValue() == null && deathInput.getValue() == null) {
          parseAfm = af;
          Case krousma = new Case(dd, cn, af, fn, ln, ag, pn, mun, ad,
                  st, zc);

          try {
            insertCase(krousma);
            clearNewCasePane(event);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
          }

        } else if (recoveryInput.getValue() != null && deathInput.getValue() == null) {
          parseAfm = af;
          Case krousma = new Case(cn, dd, rd, af, fn, ln, ag, pn, mun,
                  ad, st, zc);
          try {
            insertCase(krousma);
            clearNewCasePane(event);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
          }

        } else if (recoveryInput.getValue() == null && deathInput.getValue() != null) {
          parseAfm = af;
          Case krousma = new Case(dd, dt, cn, af, fn, ln, ag, pn, mun, ad,
                  st, zc);
          try {
            insertCase(krousma);
            clearNewCasePane(event);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
          }

        } else {
          JOptionPane.showMessageDialog(null,
                  "You cant enter both recovery date and death date",
                  "Warning", JOptionPane.WARNING_MESSAGE);
        }

      } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "An error occurred: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
      }


    }

  }


  // Clear button. It clears the fields of new case pane
  @FXML
  void clearNewCasePane(MouseEvent event) {
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
  }


  // Cancel button. It cancels the creation of a case in new case pane
  @FXML
  void cancelNewCase(MouseEvent event) {
    clearNewCasePane(event);
    createCasePanel.setVisible(false);
    createCaseHide = true;
  }


  // In this method we give the case object and it automatically insert it
  // Also depend to the contactNumber it goes to the next Panel or not
  public void insertCase(Case krousma) throws Exception {
    // Creating a instance of CaseDAO in order to insert the case in database
    CaseDAO caseDao = new CaseDAO();

    if (krousma.getContactsNumber() == 0) {
      // If the case didnt had contacts then just create the case and close the pane

      try {
        // Insert the case
        caseDao.createCaseActive(krousma);
        JOptionPane.showMessageDialog(null, "Case has been created successfully!");

        // Close the createCasePanel
        createCasePanel.setVisible(false);
        createCaseHide = true;
      } catch (Exception e) {
        JOptionPane.showMessageDialog(
                null, "An error oquired: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
      }

    } else if (krousma.getContactsNumber() > 0) {
      // If the case had contacts then create the case and open the addContactsPanel
      try {
        // Insert the case
        caseDao.createCaseActive(krousma);
        JOptionPane.showMessageDialog(null,
                "Case has been created successfully!");

        // Update the variables that count how many contacts you will add
        totalContacts = krousma.getContactsNumber();
        numberLabel.setText(String.valueOf(totalContacts));
        counterLabel.setText(String.valueOf(counterContacts));

        // Close the createCasePanel and open addContactPanel
        // in order to add the number of contacts the user said
        addContactsPanel.setVisible(true);
        addContactsHide = false;
        createCasePanel.setVisible(false);
        createCaseHide = true;
      } catch (Exception e) {
        JOptionPane.showMessageDialog(
                null, "An error oquired: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
      }

    } else {
      throw new Exception(
              "What do you mean you contacted with " + krousma.getContactsNumber() + " people??");
    }
  }


  // Click event that will take the value from the create contact panel
  // and create the number contacts that the user inserted on the create case panel
  // This panel is auto open when the user finish the creation of a case
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

    if (firstNameCoInput.getText().isEmpty() || lastNameCoInput.getText().isEmpty()
            || ageCoInput.getText().isEmpty() || phoneNumberCoInput.getText().isEmpty()
            || municipalityCoInput.getSelectionModel().getSelectedIndex() == -1
            || addressCoInput.getText().isEmpty() || streetCoInput.getText().isEmpty()
            || zipCodeCoInput.getText().isEmpty() || afmCoInput.getText().isEmpty()) {

      JOptionPane.showMessageDialog(
              null, "Please fill all the fields with *",
              "Warning", JOptionPane.WARNING_MESSAGE);
    } else {
      try {
        fnC = firstNameCoInput.getText();
        lnC = lastNameCoInput.getText();
        ageC = Integer.parseInt(ageCoInput.getText());
        pnC = phoneNumberCoInput.getText();
        munC = municipalityCoInput.getSelectionModel().getSelectedIndex() + 1;
        addC = addressCoInput.getText();
        stC = streetCoInput.getText();
        zcC = zipCodeCoInput.getText();
        afmC = Integer.parseInt(afmCoInput.getText());
        conId = Integer.parseInt(afmCoInput.getText());

        // Create the object and an instance of the ContactDAO to add it to DB
        Contact contact = new Contact(afmC, conId, fnC, lnC, ageC, pnC,
                munC, addC, stC, zcC);
        ContactDAO contactDao = new ContactDAO();

        try {
          // Create the contact and create also the "connection" case to contact
          contactDao.createContact(contact);
          contactDao.connectCaseContact(parseAfm, contact);
          JOptionPane.showMessageDialog(null, "Contact has been successfully created");

          // Clear the fields to add a new contact
          // if the contact number given from the previous panel is not yet reached
          clearAddContacts(event);

        } catch (Exception e) {
          try {
            contactDao.deleteContact(afmC);
          } catch (Exception ignored) {
            System.out.println(e.getMessage());
          }
          throw new Exception("An error occured: " + e.getMessage());
        } finally {
          if (counterContacts > totalContacts) {
            addContactsPanel.setVisible(false);
            addContactsHide = true;
            counterContacts = 0;
          }
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }

    }

  }


  // On click event in the addContacts Panel that cancel rest of the process
  @FXML
  void cancelAddContacts(MouseEvent event) {
    // Clear the fields to add a new contact
    clearAddContacts(event);
    addContactsPanel.setVisible(false);
    addContactsHide = true;
  }


  // On click event in the addContacts Panel that clear the fields
  @FXML
  void clearAddContacts(MouseEvent event) {
    firstNameCoInput.clear();
    lastNameCoInput.clear();
    ageCoInput.clear();
    phoneNumberCoInput.clear();
    municipalityCoInput.getSelectionModel().clearSelection();
    addressCoInput.clear();
    streetCoInput.clear();
    zipCodeCoInput.clear();
    afmCoInput.clear();
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

    if (firstNameCoUnInput.getText().isEmpty() || lastNameCoUnInput.getText().isEmpty()
            || ageCoUnInput.getText().isEmpty() || phoneNumberCoUnInput.getText().isEmpty()
            || municipalityCoUnInput.getSelectionModel().getSelectedIndex() == -1
            || addressCoUnInput.getText().isEmpty() || streetCoUnInput.getText().isEmpty()
            || zipCodeCoUnInput.getText().isEmpty() || afmCoUnInput.getText().isEmpty()
            || afmCoUnKrousmatosInput.getText().isEmpty()) {

      JOptionPane.showMessageDialog(null, "Please fill all the field with *");
    } else {
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

        Contact contact = new Contact(afmC, afmC, fnC, lnC, ageC, pnC,
                munC, addC, stC, zcC);
        ContactDAO contactDao = new ContactDAO();

        try {
          contactDao.createContact(contact);
          contactDao.connectCaseContact(afmK, contact);
          JOptionPane.showMessageDialog(null,
                  "The contact has been insert to its case successfully");

          // Clear and close the panel
          cancelAddContactUniq(event);
        } catch (Exception e) {
          throw new Exception(e.getMessage());
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(
                null, "An error occurred: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

  }


  @FXML
  void cancelAddContactUniq(MouseEvent event) {
    // clear the field and close the panel
    clearAddContactUniq(event);
    addContactUniquePanel.setVisible(false);
    addContactUniqueHide = true;
  }


  @FXML
  void clearAddContactUniq(MouseEvent event) {
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
  }

  public String convertDimosId(String dimosId) {
    if (dimosId.equals("1")) {
      return "Αθηναίων";
    }
    if (dimosId.equals("2")) {
      return "Βύρωνος";
    }
    if (dimosId.equals("3")) {
      return "Γαλατσίου";
    }
    if (dimosId.equals("4")) {
      return "Δάφνης – Υμηττού";
    }
    if (dimosId.equals("5")) {
      return "Ζωγράφου";
    }
    if (dimosId.equals("6")) {
      return "Ηλιουπόλεως";
    }
    if (dimosId.equals("7")) {
      return "Καισαριανής";
    }
    if (dimosId.equals("8")) {
      return "Φιλαδελφείας – Χαλκηδόνος";
    }
    if (dimosId.equals("9")) {
      return "Αγίας Παρασκευής";
    }
    if (dimosId.equals("10")) {
      return "Αμαρουσίου";
    }
    if (dimosId.equals("11")) {
      return "Βριλησσίων";
    }
    if (dimosId.equals("12")) {
      return "Ηρακλείου";
    }
    if (dimosId.equals("13")) {
      return "Κηφισιάς";
    }
    if (dimosId.equals("14")) {
      return "Λυκόβρυσης – Πεύκης";
    }
    if (dimosId.equals("15")) {
      return "Μεταμορφώσεως";
    }
    if (dimosId.equals("16")) {
      return "Νέας Ιωνίας";
    }
    if (dimosId.equals("17")) {
      return "Παπάγου – Χολαργού";
    }
    if (dimosId.equals("18")) {
      return "Πεντέλης";
    }
    if (dimosId.equals("19")) {
      return "Φιλοθέης – Ψυχικού";
    }
    if (dimosId.equals("20")) {
      return "Χαλανδρίου";
    }
    if (dimosId.equals("21")) {
      return "Περιστερίου";
    }
    if (dimosId.equals("22")) {
      return "Αγίας Βαρβάρας";
    }
    if (dimosId.equals("23")) {
      return "Αγίων Αναργύρων – Καματερού";
    }
    if (dimosId.equals("24")) {
      return "Αιγάλεω";
    }
    if (dimosId.equals("25")) {
      return "Ιλίου";
    }
    if (dimosId.equals("26")) {
      return "Πετρουπόλεως";
    }
    if (dimosId.equals("27")) {
      return "Χαϊδαρίου";
    }
    if (dimosId.equals("28")) {
      return "Καλλιθέας";
    }
    if (dimosId.equals("29")) {
      return "Αγίου Δημητρίου";
    }
    if (dimosId.equals("30")) {
      return "Αλίμου";
    }
    if (dimosId.equals("31")) {
      return "Γλυφάδας";
    }
    if (dimosId.equals("32")) {
      return "Ελληνικού – Αργυρούπολης";
    }
    if (dimosId.equals("33")) {
      return "Μοσχάτου – Ταύρου";
    }
    if (dimosId.equals("34")) {
      return "Νέας Σμύρνης";
    }
    if (dimosId.equals("35")) {
      return "Παλαιού Φαλήρου";
    }
    if (dimosId.equals("36")) {
      return "Αχαρνών";
    }
    if (dimosId.equals("37")) {
      return "Βάρης – Βούλας – Βουλιαγμένης";
    }
    if (dimosId.equals("38")) {
      return "Διονύσου";
    }
    if (dimosId.equals("39")) {
      return "Κρωπίας";
    }
    if (dimosId.equals("40")) {
      return "Λαυρεωτικής";
    }
    if (dimosId.equals("41")) {
      return "Μαραθώνα";
    }
    if (dimosId.equals("42")) {
      return "Μαρκοπούλου Μεσογαίας";
    }
    if (dimosId.equals("43")) {
      return "Παιανίας";
    }
    if (dimosId.equals("44")) {
      return "Παλλήνης";
    }
    if (dimosId.equals("45")) {
      return "Ραφήνας – Πικερμίου";
    }
    if (dimosId.equals("46")) {
      return "Σαρωνικού";
    }
    if (dimosId.equals("47")) {
      return "Σπάτων – Αρτέμιδος";
    }
    if (dimosId.equals("48")) {
      return "Ωρωπού";
    }
    if (dimosId.equals("49")) {
      return "Ελευσίνας";
    }
    if (dimosId.equals("50")) {
      return "Ασπροπύργου";
    }
    if (dimosId.equals("51")) {
      return "Μάνδρας – Ειδυλλίας";
    }
    if (dimosId.equals("52")) {
      return "Μεγαρέων";
    }
    if (dimosId.equals("53")) {
      return "Φυλής";
    }
    if (dimosId.equals("54")) {
      return "Πειραιώς";
    }
    if (dimosId.equals("55")) {
      return "Κερατσινίου – Δραπετσώνας";
    }
    if (dimosId.equals("56")) {
      return "Κορυδαλλού";
    }
    if (dimosId.equals("57")) {
      return "Νίκαιας – Αγίου Ιωάννη Ρέντη";
    }
    if (dimosId.equals("58")) {
      return "Περάματος";
    }
    if (dimosId.equals("59")) {
      return "Σαλαμίνος";
    }
    if (dimosId.equals("60")) {
      return "Αγκιστρίου";
    }
    if (dimosId.equals("61")) {
      return "Αίγινας";
    }
    if (dimosId.equals("62")) {
      return "Κυθήρων";
    }
    if (dimosId.equals("63")) {
      return "Πόρου";
    }
    if (dimosId.equals("64")) {
      return "Σπετσών";
    }
    if (dimosId.equals("65")) {
      return "Τροιζηνίας";
    }
    if (dimosId.equals("66")) {
      return "Ύδρας";
    }
    return null;
  }

  @FXML
  public void allCasesClick(MouseEvent event) throws Exception {
    CaseDAO caseDao = new CaseDAO();
    ObservableList<Case> oblist = caseDao.getCases();
    try {
      caseDao.getPersons();
    } catch (Exception e) {
      e.printStackTrace();
    }

    firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
    phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    dimosTable.setCellValueFactory(new PropertyValueFactory<>(convertDimosId("dimosID")));
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

    CaseDAO caseDao = new CaseDAO();
    ObservableList<Case> oblist = caseDao.getContacts();
    try {
      caseDao.getPersons();
    } catch (Exception e) {
      e.printStackTrace();
    }

    firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
    phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    dimosTable.setCellValueFactory(new PropertyValueFactory<>(convertDimosId("dimosID")));
    addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
    stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
    zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
    afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
    personsTable.setItems(oblist);

  }


  @FXML
  public void allPersonsClick(MouseEvent event) throws Exception {

    CaseDAO caseDao = new CaseDAO();
    ObservableList<Case> oblist = caseDao.getPersons();
    try {
      caseDao.getPersons();
    } catch (Exception e) {
      e.printStackTrace();
    }
    firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
    phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    dimosTable.setCellValueFactory(new PropertyValueFactory<>(convertDimosId("dimosID")));
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
    CaseDAO caseDao = new CaseDAO();
    Filters filter = new Filters();
    String table  = filter.chooseTable(chooseTableComboBox.getValue());
    String column = filter.chooseColumn(chooseColumnComboBox.getValue());
    ObservableList<Case> oblist = caseDao.getPersonFilter(table, column, filterInput.getText());


    firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
    phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    dimosTable.setCellValueFactory(new PropertyValueFactory<>(convertDimosId("dimosID")));
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



  public void openPanels(AnchorPane panelOpen) {
    if (panelOpen == menuBar) {
      if (menuHide) {
        menuBar.setVisible(true);
        menuHide = false;
      } else {
        menuBar.setVisible(false);
        menuHide = true;
      }
    }
    if (panelOpen == createCasePanel) {
      if (createCaseHide) {
        createCasePanel.setVisible(true);
        createCaseHide = false;

        findPersonPanel.setVisible(false);
        findPersonHide = true;
        addContactUniquePanel.setVisible(false);
        addContactUniqueHide = true;
      } else {
        createCasePanel.setVisible(false);
        createCaseHide = true;
      }
    }

    if (panelOpen == findPersonPanel) {
      if (findPersonHide) {
        findPersonPanel.setVisible(true);
        findPersonHide = false;

        createCasePanel.setVisible(false);
        createCaseHide = true;
        addContactUniquePanel.setVisible(false);
        addContactUniqueHide = true;
      } else {
        findPersonPanel.setVisible(false);
        findPersonHide = true;
      }
    }

    if (panelOpen == addContactUniquePanel) {
      if (addContactUniqueHide) {
        addContactUniquePanel.setVisible(true);
        addContactUniqueHide = false;
        findPersonPanel.setVisible(false);
        findPersonHide = true;
        createCasePanel.setVisible(false);
        createCaseHide = true;

      } else {
        addContactUniquePanel.setVisible(false);
        addContactUniqueHide = true;
      }
    }
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {

    // Initialize in all comboBox that the use choose a municipality to have a default value
    municipalityInput.getSelectionModel().select("Select municipality");
    municipalityCoInput.getSelectionModel().select("Select municipality");
    municipalityCoUnInput.getSelectionModel().select("Select municipality");

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

    chooseTableComboBox.getSelectionModel().select("Select Table");
    chooseTableComboBox.getItems().addAll("Persons", "Cases", "Contacts");

    chooseColumnComboBox.getSelectionModel().select("Select Column");
    chooseColumnComboBox.getItems().addAll("ΑΦΜ", "First Name", "Last Name", "Phone Number",
            "Age", "Municipality", "Address", "Street Number", "Zip Code", "Diagnosis Date",
            "Recovery Date", "Death Date");


  }

}


