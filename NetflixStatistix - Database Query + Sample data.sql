USE master;
DROP DATABASE IF EXISTS NetflixStatistix;
CREATE DATABASE NetflixStatistix;

USE NetflixStatistix;

/* TABLES VAN DE DATABASE */

CREATE TABLE Abonnee(
AbonneeID int NOT NULL PRIMARY KEY,
Naam nvarchar(20) NOT NULL,
Straat nvarchar(40) NOT NULL,
Huisnummer nvarchar(8) NOT NULL,
Toevoeging nvarchar(8),
Postcode nvarchar(7) NOT NULL,
Woonplaats nvarchar(20) NOT NULL
);

CREATE TABLE Profiel(
Profielnaam nvarchar(30) NOT NULL PRIMARY KEY,
Geboortedatum date NOT NULL,
ProfielID int CONSTRAINT Profiel_FK REFERENCES Abonnee(AbonneeID)
);

CREATE TABLE Programma(
ProgrammaID int NOT NULL PRIMARY KEY,
Titel nvarchar(40) NOT NULL,
Genre nvarchar(40) NOT NULL,
Taal nvarchar(30) NOT NULL,
Leeftijdsindicatie nvarchar(4) NOT NULL,
Tijdsduur time (7) NOT NULL
);

CREATE TABLE Film(
FilmID int PRIMARY KEY CONSTRAINT Film_PK REFERENCES Programma(ProgrammaID) ON DELETE CASCADE
);

CREATE TABLE Serie(
SerieNaam nvarchar(20) NOT NULL PRIMARY KEY,
GerelateerdeSerie nvarchar(20) NOT NULL,
ProgrammaID int CONSTRAINT SerieNaam_FK REFERENCES Programma(ProgrammaID) ON DELETE CASCADE
);

CREATE TABLE Aflevering(
AfleveringID int NOT NULL PRIMARY KEY,
Seizoen nvarchar(7) NOT NULL,
SerieNaam nvarchar(20) CONSTRAINT Serie_FK REFERENCES Serie(SerieNaam) ON DELETE CASCADE,
ProgrammaID int CONSTRAINT Aflevering_FK REFERENCES Programma(ProgrammaID) ON DELETE CASCADE
);

CREATE TABLE BekekenProgrammas(
Percentage int NOT NULL,
ProfielID int CONSTRAINT ProgrammaAbonnee_FK REFERENCES Abonnee(AbonneeID) ON DELETE CASCADE,
Profielnaam nvarchar(30) CONSTRAINT ProgrammaProfiel_FK REFERENCES Profiel(Profielnaam) ON DELETE CASCADE,
ProgrammaID int CONSTRAINT ProgrammaBekeken_FK REFERENCES Programma(ProgrammaID) ON DELETE CASCADE
);


/* ACCOUNTS */

/* Fam. van Raalte */
INSERT INTO Abonnee (AbonneeID,Naam,Straat,Huisnummer,Postcode,Woonplaats) 
VALUES (1215426,'Fam. van Raalte','Schopenhauerdijkje','5','3991 ML','Houten');

INSERT INTO Profiel (Profielnaam,Geboortedatum,ProfielID) VALUES
('Frank','1968-01-25',1215426),
('Madelief','2001-08-19',1215426);

/* J. van Betlehem */
INSERT INTO Abonnee (AbonneeID,Naam,Straat,Huisnummer,Postcode,Woonplaats) 
VALUES (5602533,'J. van Betlehem','Nietzschestraat','99','8542 BE','Breda');

INSERT INTO Profiel (Profielnaam,Geboortedatum,ProfielID) VALUES 
('Petrus','1999-06-26',5602533),
('Paulus','1999-06-26',5602533);

/* F. de Kat */
INSERT INTO Abonnee (AbonneeID,Naam,Straat,Huisnummer,Postcode,Woonplaats) 
VALUES (5285824,'F. de Kat','Kantlaan','11','8542 CD','Breda');

INSERT INTO Profiel (Profielnaam,Geboortedatum,ProfielID) VALUES
('Fritz','1968-08-19',5285824),
('Diana','1988-12-25',5285824);


/* PROGRAMMA'S */

INSERT INTO Serie (SerieNaam, GerelateerdeSerie) VALUES 
('Sherlock', 'Fargo'),				/* Sherlock */
('Breaking Bad', 'Fargo'),			/* Breaking Bad */
('Fargo', 'Breaking Bad');			/* Fargo */

/* Sherlock */
INSERT INTO Aflevering (AfleveringID, Seizoen) VALUES 
(1001, 'S01E01'),
(1002, 'S01E02'),
(1003, 'S01E03'),
(1004, 'S02E01'),
(1005, 'S02E02'),
(1006, 'S02E03'),
(1007, 'S03E01'),
(1008, 'S03E02'),
(1009, 'S03E03');

/* Breaking Bad */
INSERT INTO Aflevering (AfleveringID, Seizoen) VALUES 
(2000, 'S01E01'),
(2001, 'S01E02'),
(2002, 'S01E03'),
(2003, 'S01E04'),
(2004, 'S01E05'),
(2005, 'S01E06'),
(2006, 'S01E07'),
(2007, 'S02E01'),
(2008, 'S02E02'),
(2009, 'S02E03'),
(2010, 'S02E04'),
(2011, 'S02E05'),
(2012, 'S02E06'),
(2013, 'S02E07'),
(2014, 'S02E08'), 
(2015, 'S02E09'),
(2016, 'S02E10'),
(2017, 'S02E11'),
(2018, 'S02E12'),
(2019, 'S02E13');

/* Fargo */
INSERT INTO Aflevering (AfleveringID, Seizoen) VALUES 
(3001, 'S01E01'),
(3002, 'S01E02'),
(3003, 'S01E03'),
(3004, 'S01E04'),
(3005, 'S01E05'),
(3006, 'S01E06'),
(3007, 'S01E07'),
(3008, 'S01E08'),
(3009, 'S01E09'),
(3010, 'S01E10'),
(3101, 'S02E01'),
(3102, 'S02E02'),
(3103, 'S02E03'),
(3104, 'S02E04'),
(3105, 'S02E05'),
(3106, 'S02E06'),
(3107, 'S02E07'),
(3108, 'S02E08'),
(3109, 'S02E09'),
(3110, 'S02E10');


/* FILMS */

INSERT INTO Film (FilmID) VALUES
(1010),
(8001),
(8002),
(8004),
(8008),
(8010),
(8011),
(8012),
(8014),
(8016),
(8017);


/* PROGRAMMA */
INSERT INTO Programma (ProgrammaID, Titel, Genre, Taal, Leeftijdsindicatie, Tijdsduur)
VALUES ();


/* BEKEKEN */

INSERT INTO BekekenProgrammas (Percentage,ProfielID,Profielnaam,ProgrammaID) VALUES
(100, 1215426, 'Frank', 1001),
(100, 1215426, 'Frank', 1002),
(78, 1215426, 'Frank', 1003),
(100, 1215426, 'Madelief', 1001),
(60, 1215426, 'Madelief', 1002),
(91, 1215426, 'Madelief', 3001),
(100, 1215426, 'Madelief', 2001),
(100, 1215426, 'Madelief', 2002),
(100, 1215426, 'Madelief', 2003),
(22, 1215426, 'Madelief', 2004),
(100, 5602533, 'Petrus', 3001),
(100, 5602533, 'Petrus', 3002),
(60, 5602533, 'Petrus', 3010),
(100, 5602533, 'Petrus', 8001),
(99, 5602533, 'Petrus', 8002),
(100, 5602533, 'Paulus', 3001),
(74, 5602533, 'Paulus', 3002),
(60, 5602533, 'Paulus', 3010),
(100, 5602533, 'Paulus', 8001),
(10, 5602533, 'Paulus', 2019),
(100, 5285824, 'Fritz', 1001),
(100, 5285824, 'Fritz', 1002),
(5, 5285824, 'Fritz', 1010),
(100, 5285824, 'Diana', 8002),
(45, 5285824, 'Diana', 1001);