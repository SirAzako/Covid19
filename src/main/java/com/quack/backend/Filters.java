package com.quack.backend;
//SELECT * FROM Persons;
//SELECT * FROM Persons WHERE ContactID IS NULL;
//SELECT * FROM Persons WHERE ContactID IS NOT NULL;
public class Filters {
  public String chooseTable(String table) {
    if (table.equals("Persons")) {
      return "WHERE 1 = 1";
    } else if (table.equals("Cases")) {
      return "WHERE ContactID IS NULL";
    } else if (table.equals("Contacts")) {
      return "WHERE ContactID IS NOT NULL";
    } else {
      return null;
    }
  }
//AND AFM = "";
  public String chooseColumn(String column){
    if(column.equals("ΑΦΜ")){
      return "AND AFM =";
    }else if(column.equals("First Name")){
      return "AND FirstName =";
    }else if(column.equals("Last Name")){
      return "AND LastName =";
    }else if(column.equals("Age")){
      return "AND Age =";
    }else if(column.equals("Phone Number")){
      return "AND PhoneNumber =";
    }else if(column.equals("Municipality")){
      return "AND DimosID =";
    }else if(column.equals("Address")){
      return "AND Address =";
    }else if(column.equals("Street Number")){
      return "AND StreetNumber =";
    }else if(column.equals("Zip Code")){
      return "AND Zip Code =";
    }else if(column.equals("Diagnosis Date")){
      return "AND Diagnosis =";
    }else if(column.equals("Recovery Date")){
      return "AND Recovery =";
    }else if(column.equals("Death Date")) {
      return "AND Death =";
    }else {
      return null;
    }
  }
}
