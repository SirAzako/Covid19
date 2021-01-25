CREATE database covid19;
use covid19;

show tables;

DROP TABLE Contacts;
DROP TABLE Dimoi;
DROP TABLE Persons;

SELECT * FROM Persons WHERE 1=1 AND FirstName = 'Paraskevas';

SELECT * FROM Persons;

SELECT * FROM Contacts;

SELECT * FROM Dimoi;

describe Persons;

describe Contacts;

SELECT * FROM Persons WHERE ContactID IS NULL;

SELECT * FROM Persons WHERE FirstName = 'Paraskevas';

SELECT Persons.* FROM Persons, Contacts WHERE Contacts.AFM = 111111111 AND Contacts.ContactID = Persons.ContactID;

SELECT count(AFM) Counter
FROM Persons
WHERE DimosID = 1 AND Diagnosis IS NOT NULL;


INSERT INTO Contacts(AFM, ContactID) VALUES (104770403, 110120981);
INSERT INTO Contacts(AFM, ContactID) VALUES (104770403, 111683935);
INSERT INTO Contacts(AFM, ContactID) VALUES (104770403, 129710590);

INSERT INTO Contacts(AFM, ContactID) VALUES (106300953, 132921748);
INSERT INTO Contacts(AFM, ContactID) VALUES (106300953, 134328305);
INSERT INTO Contacts(AFM, ContactID) VALUES (106300953, 134374613);
INSERT INTO Contacts(AFM, ContactID) VALUES (106300953, 142107080);
INSERT INTO Contacts(AFM, ContactID) VALUES (106300953, 153132073);
INSERT INTO Contacts(AFM, ContactID) VALUES (106300953, 154924090);


INSERT INTO Contacts(AFM, ContactID) VALUES (120016371, 162362035);
INSERT INTO Contacts(AFM, ContactID) VALUES (120016371, 169316953);
INSERT INTO Contacts(AFM, ContactID) VALUES (120016371, 191745070);
INSERT INTO Contacts(AFM, ContactID) VALUES (120016371, 197774016);

SELECT Persons.*, D.Name dimosName 
FROM Persons, Contacts, Dimoi D
WHERE Persons.DimosID = D.DimosID AND Contacts.AFM =  120016371
AND Contacts.ContactID = Persons.ContactID;