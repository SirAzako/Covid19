package com.quack.db;

import com.quack.backend.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
