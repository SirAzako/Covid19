CREATE database covid19;
use covid19;

show tables;

#DROP TABLE Contacts;
#DROP TABLE Dimoi;
#DROP TABLE Persons;

SELECT * FROM Persons;

SELECT * FROM Contacts;

SELECT * FROM Dimoi;

describe Persons;

SELECT * FROM Persons WHERE ContactID IS NULL;

SELECT * FROM Persons WHERE FirstName = 'Paraskevas';