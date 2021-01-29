package com.quack.backend;

//SELECT * FROM Persons;
//SELECT * FROM Persons WHERE ContactID IS NULL;
//SELECT * FROM Persons WHERE ContactID IS NOT NULL;
public class Filters {
    /**
     * <p>This method is responsible for returning a string table's name.</p>
     *
     * @param table the table we must search
     * @return a part of the query in the find person panel actions
     */
    public String chooseTable(final String table) {
        switch (table) {
            case "Persons":
                return "1 = 1";
            case "Cases":
                return "ContactID IS NULL";
            case "Contacts":
                return "ContactID IS NOT NULL";
            default:
                return null;
        }
    }

    /**
     * <p>This method is responsible for returning a string columns's name.</p>
     *
     * @param column the column we must search
     * @return a part of the query in the find person panel actions
     */
    public String chooseColumn(final String column) {
        switch (column) {
            case "ΑΦΜ":
                return "AFM =";
            case "First Name":
                return "FirstName =";
            case "Last Name":
                return "LastName =";
            case "Age":
                return "Age =";
            case "Phone Number":
                return "PhoneNumber =";
            case "Municipality":
                return "D.Name =";
            case "Address":
                return "Address =";
            case "Street Number":
                return "StreetNumber =";
            case "Zip Code":
                return "ZipCode =";
            case "Diagnosis Date":
                return "Diagnosis =";
            case "Recovery Date":
                return "Recovery =";
            case "Death Date":
                return "Death =";
            default:
                return null;
        }
    }

}
