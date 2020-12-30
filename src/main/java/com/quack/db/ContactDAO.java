package com.quack.db;

import com.quack.backEnd.Case;
import com.quack.backEnd.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContactDAO {

    public void createContact(Contact contact) throws Exception {
        Connection con = null;
        String querry = "INSERT INTO Persons(AFM, ContactID, FirstName, " +
                "LastName, Age, PhoneNumber, DimosID, Address, StreetNumber, " +
                "ZipCode) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(querry);
            stmt.setInt(1, contact.getAFM());
            stmt.setString(2, contact.getContactID());
            stmt.setString(3, contact.getFirstName());
            stmt.setString(4, contact.getLastName());
            stmt.setInt(5, contact.getAge());
            stmt.setString(6, contact.getPhoneNumber());
            stmt.setInt(7, contact.getDimosID());
            stmt.setString(8, contact.getAddress());
            stmt.setString(9, contact.getStreetNumber());
            stmt.setString(10, contact.getZipCode());
        }catch (Exception e){
            throw new Exception("Error while trying to create contact " + e.getMessage());
        }finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
