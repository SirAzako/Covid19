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

    public int countCases() throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE Diagnosis IS NOT NULL;";
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

    public int countActiveCases() throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE Diagnosis IS NOT NULL AND Recovery IS NULL AND Death IS NULL;";
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

    public int countRecoveryCases() throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE Diagnosis IS NOT NULL AND Recovery IS NOT NULL AND Death IS NULL;";
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

    public int countDeathCases() throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE Diagnosis IS NOT NULL AND Recovery IS NULL AND Death IS NOT NULL;";
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

    public int countContacts() throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE ContactID IS NOT NULL;";

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

    public int countContactsSick() throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE ContactID IS NOT NULL AND Diagnosis IS NOT NULL;";

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

    public int countCasesByDimosID(int dimosID) throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE DimosID = " + dimosID + " AND Diagnosis IS NOT NULL;";
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

    public int countActiveCasesByDimosID(int dimosID) throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE DimosID = " + dimosID + " AND Diagnosis IS NOT NULL AND Recovery IS NULL AND Death IS NULL;";
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

    public int countRecoveryCasesByDimosID(int dimosID) throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE DimosID = " + dimosID + " AND Diagnosis IS NOT NULL AND Recovery IS NOT NULL AND Death IS NULL;";
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

    public int countDeathCasesByDimosID(int dimosID) throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE DimosID = " + dimosID + " AND Diagnosis IS NOT NULL AND Recovery IS NULL AND Death IS NOT NULL;";
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

    public int countContactsByDimosID(int dimosID) throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE DimosID = " + dimosID + " AND ContactID IS NOT NULL;";

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

    public int countContactsSickByDimosID(int dimosID) throws Exception {
        int counter = 0;
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT count(AFM) Counter " +
                    "FROM Persons " +
                    "WHERE DimosID = " + dimosID + " AND ContactID IS NOT NULL AND Diagnosis IS NOT NULL;";

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
                            "WHERE " + querryTable + " AND " + querryColumn + " '" + filterInput + "' AND D.DimosID = P.DimosID;";
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
            String querry = "SELECT * FROM Persons WHERE AFM = " + afmInput + ";";
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

    public ObservableList<Case> getContactsOfCase(String afmInput) throws Exception {
        ObservableList<Case> oblist = FXCollections.observableArrayList();
        try {
            Connection con = DB.getConnection();
            String querry = "SELECT Persons.* FROM Persons, Contacts WHERE Contacts.AFM = " + afmInput + " AND Contacts.ContactID = Persons.ContactID;";
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

    public void updatePerson(int afm, Case krousma) throws Exception {
        Connection con = null;
        String querry = "UPDATE Persons SET FirstName = ?, LastName = ?, ContactsNumber = ?, Age = ?, " +
                "PhoneNumber = ?, Diagnosis = ?, Recovery = ?, Death = ?, DimosID = ?, Address = ?," +
                "StreetNumber = ?, ZipCode = ? WHERE AFM = ?";
        try {
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(querry);
            stmt.setString(1, krousma.getFirstName());
            stmt.setString(2, krousma.getLastName());
            stmt.setInt(3, krousma.getContactsNumber());
            stmt.setInt(4, krousma.getAge());
            stmt.setString(5, krousma.getPhoneNumber());
            stmt.setString(6, krousma.getDiagnosis());
            stmt.setString(7, krousma.getRecovery());
            stmt.setString(8, krousma.getDeath());
            stmt.setInt(9, krousma.getDimosID());
            stmt.setString(10, krousma.getAddress());
            stmt.setString(11, krousma.getStreetNumber());
            stmt.setString(12, krousma.getZipCode());
            stmt.setInt(13, krousma.getAFM());
            stmt.executeUpdate();
            stmt.close();
            DB.close();
        } catch (Exception e) {
            throw new Exception("Error while trying to update Person " + e.getMessage());
        } finally {
            if (con != null)
                con.close();
        }
    }


}
