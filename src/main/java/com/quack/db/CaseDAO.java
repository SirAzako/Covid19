package com.quack.db;

import com.quack.backend.Case;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author paras
 */
public class CaseDAO {

  public void createCaseActive(Case krousma) throws Exception {
    Connection con = null;
    String querry = "INSERT INTO Persons(AFM, ContactsNumber, FirstName, " +
            "LastName, Age, PhoneNumber, Diagnosis, DimosID, Address, StreetNumber, ZipCode, Recovery, Death) "
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    try {
      con = DB.getConnection();
      PreparedStatement stmt = con.prepareStatement(querry);
      stmt.setInt(1, krousma.getAFM());
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
      stmt.setString(12, krousma.getRecovery());
      stmt.setString(13, krousma.getDeath());

      stmt.executeUpdate();
      stmt.close();
      DB.close();
    } catch (Exception e) {
      throw new Exception("Error while trying to create case " + e.getMessage());
    } finally {
      if (con != null)
        con.close();
    }

  }

  public ObservableList<Case> getPersons() throws Exception {
    ObservableList<Case> oblist = FXCollections.observableArrayList();
    try {
      Connection con = DB.getConnection();
      String querry = "Select P.*, D.Name dimosName " +
                      "From Persons P, Dimoi D " +
                      "Where P.DimosID = D.DimosID;";
      PreparedStatement stmt = con.prepareStatement(querry);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        int contactsNumberSql;
        if (rs.getString("contactsNumber") != null) {
          contactsNumberSql = Integer.parseInt(rs.getString("contactsNumber"));
        } else {
          contactsNumberSql = 0;
        }
        oblist.add(new Case(
                contactsNumberSql, rs.getString("Diagnosis"), rs.getString("Death"),
                rs.getString("Recovery"), Integer.parseInt(rs.getString("AFM")),
                rs.getString("firstName"), rs.getString("lastName"),
                Integer.parseInt(rs.getString("age")), rs.getString("phoneNumber"),
                Integer.parseInt(rs.getString("dimosID")), rs.getString("address"),
                rs.getString("streetNumber"), rs.getString("zipCode"), rs.getString("dimosName")));
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

  public ObservableList<Case> getCases() throws Exception {
    ObservableList<Case> oblist = FXCollections.observableArrayList();
    try {
      Connection con = DB.getConnection();
      String querry = "SELECT P.*, D.Name dimosName " +
                      "FROM Persons P, Dimoi D " +
                      "WHERE ContactID IS NULL and D.DimosID = P.DimosID;";
      PreparedStatement stmt = con.prepareStatement(querry);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        int contactsNumberSql;
        if (rs.getString("contactsNumber") != null) {
          contactsNumberSql = Integer.parseInt(rs.getString("contactsNumber"));
        } else {
          contactsNumberSql = 0;
        }
        oblist.add(new Case(
                contactsNumberSql, rs.getString("Diagnosis"), rs.getString("Death"),
                rs.getString("Recovery"), Integer.parseInt(rs.getString("AFM")),
                rs.getString("firstName"), rs.getString("lastName"),
                Integer.parseInt(rs.getString("age")), rs.getString("phoneNumber"),
                Integer.parseInt(rs.getString("dimosID")), rs.getString("address"),
                rs.getString("streetNumber"), rs.getString("zipCode"), rs.getString("dimosName")));
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

  public ObservableList<Case> getContacts() throws Exception {
    ObservableList<Case> oblist = FXCollections.observableArrayList();
    try {
      Connection con = DB.getConnection();
      String querry = "SELECT P.*, D.Name dimosName " +
                      "FROM Persons P, Dimoi D " +
                      "WHERE ContactID IS NOT NULL and P.DimosID = D.DimosID;";
      PreparedStatement stmt = con.prepareStatement(querry);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        int contactsNumberSql;
        if (rs.getString("contactsNumber") != null) {
          contactsNumberSql = Integer.parseInt(rs.getString("contactsNumber"));
        } else {
          contactsNumberSql = 0;
        }
        oblist.add(new Case(
                contactsNumberSql, rs.getString("Diagnosis"), rs.getString("Death"),
                rs.getString("Recovery"), Integer.parseInt(rs.getString("AFM")),
                rs.getString("firstName"), rs.getString("lastName"),
                Integer.parseInt(rs.getString("age")), rs.getString("phoneNumber"),
                Integer.parseInt(rs.getString("dimosID")), rs.getString("address"),
                rs.getString("streetNumber"), rs.getString("zipCode"), rs.getString("dimosName")));
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

  public ObservableList<Case> getPersonFilter(String querryTable, String querryColumn,
                                              String filterInput) throws Exception {
    ObservableList<Case> oblist = FXCollections.observableArrayList();
    try {
      Connection con = DB.getConnection();

      String querry =
              "SELECT P.*, D.Name dimosName " +
                      "FROM Persons P, Dimoi D " +
                      "WHERE "+ querryTable+ " AND " + querryColumn + " '"+ filterInput +"' AND D.DimosID = P.DimosID;";
      PreparedStatement stmt = con.prepareStatement(querry);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        int contactsNumberSql;
        if (rs.getString("contactsNumber") != null) {
          contactsNumberSql = Integer.parseInt(rs.getString("contactsNumber"));
        } else {
          contactsNumberSql = 0;
        }
        oblist.add(new Case(
                contactsNumberSql, rs.getString("Diagnosis"), rs.getString("Death"),
                rs.getString("Recovery"), Integer.parseInt(rs.getString("AFM")),
                rs.getString("firstName"), rs.getString("lastName"),
                Integer.parseInt(rs.getString("age")), rs.getString("phoneNumber"),
                Integer.parseInt(rs.getString("dimosID")), rs.getString("address"),
                rs.getString("streetNumber"), rs.getString("zipCode"), rs.getString("dimosName")));
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

  public ObservableList<Case> getPersonAfm(String afmInput) throws Exception {
    ObservableList<Case> oblist = FXCollections.observableArrayList();
    try {
      Connection con = DB.getConnection();
      String querry = "SELECT * FROM Persons WHERE AFM = "+afmInput+";";
      PreparedStatement stmt = con.prepareStatement(querry);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        int contactsNumberSql;
        if (rs.getString("contactsNumber") != null) {
          contactsNumberSql = Integer.parseInt(rs.getString("contactsNumber"));
        } else {
          contactsNumberSql = 0;
        }
        oblist.add(new Case(
                contactsNumberSql, rs.getString("Diagnosis"), rs.getString("Death"),
                rs.getString("Recovery"), Integer.parseInt(rs.getString("AFM")),
                rs.getString("firstName"), rs.getString("lastName"),
                Integer.parseInt(rs.getString("age")), rs.getString("phoneNumber"),
                Integer.parseInt(rs.getString("dimosID")), rs.getString("address"),
                rs.getString("streetNumber"), rs.getString("zipCode")));
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
}
