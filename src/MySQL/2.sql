CREATE TABLE Dimoi (
	DimosID int auto_increment,
	Name varchar(50) NOT NULL UNIQUE,
    Population int NOT NULL,
	PRIMARY KEY (DimosID)
);

CREATE TABLE Persons (
	PersonID INT AUTO_INCREMENT,
    CaseID varchar(20) UNIQUE,
    ContactID varchar(20) UNIQUE,
    ContactsNumber INT,
    FirstName varchar(50) NOT NULL,
    LastName varchar(50) NOT NULL,
    Age INT NOT NULL,
    PhoneNumber VARCHAR(20) NOT NULL,
	Diagnosis DATE,
    Recovery DATE,
    Death DATE,
    DimosID INT NOT NULL,
	Address VARCHAR(50) NOT NULL,
    StreetNumber VARCHAR(10) NOT NULL,
    ZipCode  VARCHAR(8),
    PRIMARY KEY (PersonID),
    FOREIGN KEY(DimosID) REFERENCES Dimoi(DimosID)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT dateDeathBigerDateRecovery CHECK (Death > Recovery) ENFORCED,
    CONSTRAINT dateRecoveryBigerDateDiag CHECK (Recovery > Diagnosis) ENFORCED
);

CREATE TABLE Contacts (
	CaseID VARCHAR(20) NOT NULL,
    ContactID VARCHAR(20) NOT NULL,
    FOREIGN KEY(CaseID) REFERENCES Persons(CaseID)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(ContactID) REFERENCES Persons(ContactID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
