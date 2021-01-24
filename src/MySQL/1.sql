CREATE database covid19;
use covid19;

show tables;

DROP TABLE Contacts;
DROP TABLE Dimoi;
DROP TABLE Persons;

SELECT * FROM Persons WHERE 1=1 AND FirstName = 'Paraskevas';

SELECT * FROM Contacts;

SELECT * FROM Dimoi;

describe Persons;

SELECT * FROM Persons WHERE ContactID IS NULL;

SELECT * FROM Persons WHERE FirstName = 'Paraskevas';

SELECT Persons.*, COUNT(Contacts.ContactID) FROM Persons, Contacts WHERE Contacts.AFM = 111111111 AND Contacts.ContactID = Persons.ContactID;