package com.quack.db;

import com.quack.backEnd.Case;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author paras
 */
public class CaseDAO {
    
    	public void createCase(Case krousma) throws Exception{
            Connection con = null ;
            String querry = "INSERT INTO Persons(CaseID, ContactsNumber, FirstName, LastName,"+
                            "Age, PhoneNumber, Diagnosis, DimosID, Address,"+ 
                            "StreetNumber, ZipCode) "+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            try {
                con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(querry);
                stmt.setString(1, krousma.getCaseID());
                stmt.setInt(2, krousma.getContactsNumber());
                stmt.setString(3, krousma.getFirstName());
                stmt.setString(4, krousma.getLastName());
                stmt.setInt(5, krousma.getAge());
                stmt.setString(6, krousma.getPhoneNumber());
                stmt.setString(7, krousma.getDiagnosis());
                stmt.setInt(8, krousma.getDimosID());
                stmt.setString(9, krousma.getAddress());
                stmt.setString(10, krousma.getStreetNumber());
                stmt.setString(11, krousma.getZipCode());
            

                stmt.executeUpdate();
                stmt.close();
                DB.close();
            } catch (Exception e) {
                throw new Exception("Error while trying to create case " + e.getMessage());
            } finally {
                if(con != null)
                    con.close();
            }
            
	}

}
