CREATE TABLE Dimoi (
	DimosID int auto_increment,
	Name varchar(50) NOT NULL UNIQUE,
    Population int NOT NULL,
	PRIMARY KEY (DimosID)
);

CREATE TABLE Persons (
	AFM INT NOT NULL UNIQUE,
	ContactID INT UNIQUE,
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
    PRIMARY KEY (AFM),
    FOREIGN KEY(DimosID) REFERENCES Dimoi(DimosID)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT dateDeathBigerDateRecovery CHECK (Death > Recovery) ENFORCED,
    CONSTRAINT dateRecoveryBigerDateDiag CHECK (Recovery > Diagnosis) ENFORCED
);

CREATE TABLE Contacts (
	AFM INT NOT NULL,
    ContactID INT NOT NULL,
    FOREIGN KEY(AFM) REFERENCES Persons(AFM)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(ContactID) REFERENCES Persons(ContactID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);




