package com.quack.db;

import com.quack.backend.Case;
import com.quack.backend.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContactDAO {

    /**
     * <p>
     *     A method that inserting a new contact in the database.
     * </p>
     * @param contact Object instance of Contact class
     * */
    public void createContact(final Contact contact) throws Exception {
        Connection con = null;
        String querry = "INSERT INTO Persons(AFM, ContactID, FirstName, "
                            + "LastName, Age, PhoneNumber, DimosID, Address, "
                            + "StreetNumber, ZipCode) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(querry);
            stmt.setInt(1, contact.getAFM());
            stmt.setInt(2, contact.getContactID());
            stmt.setString(3, contact.getFirstName());
            stmt.setString(4, contact.getLastName());
            stmt.setInt(5, contact.getAge());
            stmt.setString(6, contact.getPhoneNumber());
            stmt.setInt(7, contact.getDimosID());
            stmt.setString(8, contact.getAddress());
            stmt.setString(9, contact.getStreetNumber());
            stmt.setString(10, contact.getZipCode());
            stmt.executeUpdate();
            stmt.close();
            DB.close();
        } catch (Exception e) {
            throw new Exception("Error while trying to create contact "
                    + e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * <p>
     *    A method that creating the connection Case - Contact in the db.
     * </p>
     * @param afm the afm of the case that the contact had met
     * @param contact Object instance of Contact class
     * */
    public void connectCaseContact(
            final int afm, final Contact contact) throws Exception {
        Connection con = null;
        String querry = "INSERT INTO Contacts(AFM, ContactID) VALUES(?, ?);";
        try {
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(querry);
            stmt.setInt(1, afm);
            stmt.setInt(2, contact.getContactID());
            stmt.executeUpdate();
            stmt.close();
            DB.close();

        } catch (Exception e) {
            throw new Exception("Error while trying to create contact "
                    + e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * <p>
     *     A method that delete a contact from the db with the given.
     * </p>
     * @param afmC the afm of the contact that the method delete
     * */
    public void deleteContact(final int afmC) throws Exception {
        Connection con = null;
        String querry = "Delete from Persons where AFM = ?;";
        try {
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(querry);
            stmt.setInt(1, afmC);
            stmt.executeUpdate();
            stmt.close();
            DB.close();

        } catch (Exception e) {
            throw new Exception("Error occurred while: "
                    + e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


    /**
     * <p>
     *     A method that returns all the contacts of a specific case in a list.
     * </p>
     * @param afmInput the afm of the case.
     * @return A list that contains all the contacts of a specific case.
     *         This list type is used in the javaFX table to automatic insert
     *         the list's content in the table.
     * */
    public ObservableList<Case> getContactsOfCase(
            final String afmInput) throws Exception {

        ObservableList<Case> oblist = FXCollections.observableArrayList();
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT Persons.*, D.Name dimosName "
                    + "FROM Persons, Contacts, Dimoi D "
                    + "WHERE Persons.DimosID = D.DimosID AND Contacts"
                    + ".AFM " + "= " + afmInput + " AND "
                    + "Contacts.ContactID = Persons.ContactID;";
            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int contactsNumberSql;
                if (rs.getString("contactsNumber") != null) {
                    contactsNumberSql = Integer.parseInt(
                            rs.getString("contactsNumber"));
                } else {
                    contactsNumberSql = 0;
                }
                oblist.add(new Case(
                        contactsNumberSql,
                        rs.getString("Diagnosis"),
                        rs.getString("Death"),
                        rs.getString("Recovery"),
                        Integer.parseInt(rs.getString("AFM")),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        Integer.parseInt(rs.getString("age")),
                        rs.getString("phoneNumber"),
                        Integer.parseInt(rs.getString("dimosID")),
                        rs.getString("address"),
                        rs.getString("streetNumber"),
                        rs.getString("zipCode"),
                        rs.getString("dimosName")));
            }
            rs.close();
            stmt.close();
            DB.close();
            return oblist;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                DB.close();
            } catch (Exception e) {

            }
        }

    }


    /**
     * <p>This method get all Contacts from database and parse the values
     * to ObservableList.</p>
     * @return oblist
     */
    public ObservableList<Case> getContacts() throws Exception {
        ObservableList<Case> oblist = FXCollections.observableArrayList();
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT P.*, D.Name dimosName "
                    + "FROM Persons P, Dimoi D "
                    + "WHERE ContactID IS NOT NULL and "
                    + "P.DimosID = D.DimosID;";
            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int contactsNumberSql;
                if (rs.getString("contactsNumber") != null) {
                    contactsNumberSql = Integer.parseInt(
                            rs.getString("contactsNumber"));
                } else {
                    contactsNumberSql = 0;
                }
                oblist.add(new Case(
                        contactsNumberSql,
                        rs.getString("Diagnosis"),
                        rs.getString("Death"),
                        rs.getString("Recovery"),
                        Integer.parseInt(rs.getString("AFM")),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        Integer.parseInt(rs.getString("age")),
                        rs.getString("phoneNumber"),
                        Integer.parseInt(rs.getString("dimosID")),
                        rs.getString("address"),
                        rs.getString("streetNumber"),
                        rs.getString("zipCode"),
                        rs.getString("dimosName")));
            }
            rs.close();
            stmt.close();
            DB.close();
            return oblist;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                DB.close();
            } catch (Exception e) {

            }
        }

    }


    /**
     * <p>
     *     A method that create the connection with the
     *     database and return the number of all the sick contacts in a
     *     specific municipality that have been inserted.
     * </p>
     * @param dimosID the id of the municipality
     * @return the number of total sick contacts in a specific municipality
     * */
    public int countContactsSickByDimosID(final int dimosID) throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter "
                    + "FROM Persons "
                    + "WHERE DimosID = " + dimosID + " AND "
                    + "ContactID IS NOT NULL AND "
                    + "Diagnosis IS NOT NULL;";

            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                counter = rs.getInt("Counter");
            }

            rs.close();
            stmt.close();
            DB.close();
            return counter;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                DB.close();
            } catch (Exception e) {

            }
        }

    }



    /**
     * <p>
     *     A method that create the connection with the
     *     database and return the number of all the sick contacts
     *     that have been inserted.
     * </p>
     * @return the number of total contacts that got sick
     * */
    public int countContactsSick() throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter "
                    + "FROM Persons "
                    + "WHERE ContactID IS NOT NULL AND "
                    + "Diagnosis IS NOT NULL;";

            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                counter = rs.getInt("Counter");
            }

            rs.close();
            stmt.close();
            DB.close();
            return counter;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                DB.close();
            } catch (Exception e) {

            }
        }

    }


    /**
     * <p>
     *     A method that create the connection with the
     *     database and return the number of all the contacts in a
     *     specific municipality that have been inserted.
     * </p>
     * @param dimosID the id of the municipality
     * @return the number of total contacts in a specific municipality
     * */
    public int countContactsByDimosID(final int dimosID) throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter "
                    + "FROM Persons "
                    + "WHERE DimosID = " + dimosID + " AND "
                    + "ContactID IS NOT NULL;";

            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                counter = rs.getInt("Counter");
            }

            rs.close();
            stmt.close();
            DB.close();
            return counter;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                DB.close();
            } catch (Exception e) {

            }
        }

    }


    /**
     * <p>
     *     A method that create the connection with the
     *     database and return the number of all the contacts
     *     that have been inserted.
     * </p>
     * @return the number of total contacts
     * */
    public int countContacts() throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter "
                    + "FROM Persons "
                    + "WHERE ContactID IS NOT NULL;";

            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                counter = rs.getInt("Counter");
            }

            rs.close();
            stmt.close();
            DB.close();
            return counter;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                DB.close();
            } catch (Exception e) {

            }
        }

    }

}
