package com.quack.backend;

//SELECT * FROM Persons;
//SELECT * FROM Persons WHERE ContactID IS NULL;
//SELECT * FROM Persons WHERE ContactID IS NOT NULL;
public class Filters {
    /**
     * <p>This method is responsible for returning a string table's name.</p>
     *
     * @param table
     * @return Stirng
     */
    public String chooseTable(String table) {
        if (table.equals("Persons")) {
            return "1 = 1";
        } else if (table.equals("Cases")) {
            return "ContactID IS NULL";
        } else if (table.equals("Contacts")) {
            return "ContactID IS NOT NULL";
        } else {
            return null;
        }
    }

    /**
     * <p>This method is responsible for returning a string columns's name.</p>
     *
     * @param column
     * @return String
     */
    public String chooseColumn(String column) {
        if (column.equals("ΑΦΜ")) {
            return "AFM =";
        } else if (column.equals("First Name")) {
            return "FirstName =";
        } else if (column.equals("Last Name")) {
            return "LastName =";
        } else if (column.equals("Age")) {
            return "Age =";
        } else if (column.equals("Phone Number")) {
            return "PhoneNumber =";
        } else if (column.equals("Municipality")) {
            return "DimosID =";
        } else if (column.equals("Address")) {
            return "Address =";
        } else if (column.equals("Street Number")) {
            return "StreetNumber =";
        } else if (column.equals("Zip Code")) {
            return "Zip Code =";
        } else if (column.equals("Diagnosis Date")) {
            return "Diagnosis =";
        } else if (column.equals("Recovery Date")) {
            return "Recovery =";
        } else if (column.equals("Death Date")) {
            return "Death =";
        } else {
            return null;
        }
    }
}
