package com.quack.db;

import com.quack.backend.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContactDAO {

    public void createContact(Contact contact) throws Exception {
        Connection con = null;
        String querry = "INSERT INTO Persons(AFM, ContactID, FirstName, " +
                "LastName, Age, PhoneNumber, DimosID, Address, StreetNumber, " +
                "ZipCode) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
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
        }catch (Exception e){
            throw new Exception("Error while trying to create contact " + e.getMessage());
        }finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void connectCaseContact(int afm, Contact contact) throws Exception {
        Connection con = null;
        String querry = "INSERT INTO Contacts(AFM, ContactID) VALUES(?, ?);";
        try{
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(querry);
            stmt.setInt(1, afm);
            stmt.setInt(2, contact.getContactID());
            stmt.executeUpdate();
            stmt.close();
            DB.close();

        }catch (Exception e){
            throw new Exception("Error while trying to create contact " + e.getMessage());
        }finally {
            if (con != null){
                con.close();
            }
        }
    }

    public void deleteContact(int afmC) throws Exception {
        Connection con = null;
        String querry = "Delete from Persons where AFM = ?;";
        try{
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(querry);
            stmt.setInt(1, afmC);
            stmt.executeUpdate();
            stmt.close();
            DB.close();

        }catch (Exception e){
            throw new Exception("Error occurred while: " + e.getMessage());
        }finally {
            if (con != null){
                con.close();
            }
        }
    }
}
