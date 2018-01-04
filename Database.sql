-- TODO
-- - Cascade's opzetten




USE MASTER;

IF EXISTS(SELECT * FROM sys.databases where name  ='NFS')
DROP DATABASE NFS;

CREATE DATABASE NFS;
USE NFS;

--Setting up the tables;
CREATE TABLE	Subscriber(
	SubscriberID 	int			NOT NULL PRIMARY KEY,
	Name 		varchar (50)		NOT NULL,
	Street 		varchar (40)		NOT NULL,
	HouseNr 	int			NOT NULL,
	HouseNrExt 	varchar(8),
	City 		varchar (60)		NOT NULL	);

CREATE TABLE	UserProfile(
	SubscriberID 	int FOREIGN KEY REFERENCES Subscriber(SubScriberID),
	ProfileID 	int			NOT NULL PRIMARY KEY,
	ProfileName 	varchar (40)		NOT NULL,
	DateOfBirth	date			NOT NULL	);

CREATE TABLE	Movie(
	Title 		varchar(40) 		NOT NULL,
	MovieID		int			NOT NULL PRIMARY KEY,
	Genre 		varchar(20),
	SpokenLanguage 	varchar(40),
	MinAge 		int,
	LengthInMinutes	int					);

CREATE TABLE	Serie(
	Title 		varchar(40) 		NOT NULL ,
	SerieID 	int 			NOT NULL PRIMARY KEY,
	Genre 		varchar(20),
	SpokenLanguage 	varchar(40),
	MinAge 		int					);

CREATE TABLE	Episode(
	EpisodeNumber 	int 			NOT NULL,
	Title 		varchar(40) 		NOT NULL,
	SerieID 	int FOREIGN KEY REFERENCES Serie(SerieID),
	LengthInMinutes int 			NOT NULL,
		CONSTRAINT PK_Episode PRIMARY KEY (EpisodeNumber, SerieID)
								);

CREATE TABLE	SeriesSeen(
	SerieID		int FOREIGN KEY REFERENCES Serie(SerieID),
	PercentageSeen 	int,
	UserName	int FOREIGN KEY REFERENCES UserProfile(ProfileName)
	UserProfile	int FOREIGN KEY REFERENCES UserProfile(ProfileID)
		CONSTRAINT PK_SeriesSeen PRIMARY KEY (SerieID)	);
								
CREATE TABLE	MoviesSeen(
	MovieID 	int FOREIGN KEY REFERENCES Movie(MovieID),
	PercentageSeen 	int,
	UserName	int FOREIGN KEY REFERENCES UserProfile(ProfileName)
	UserProfile	int FOREIGN KEY REFERENCES UserProfile(ProfileID)
		CONSTRAINT PK_MoviesSeen PRIMARY KEY (MovieID)	);

CREATE TABLE	SerieAssociations(
	SerieID int FOREIGN KEY REFERENCES Serie(SerieID),
	LooksLike int FOREIGN KEY REFERENCES Serie(SerieID)
		CONSTRAINT PK_SerieAssociations PRIMARY KEY (SerieID, LooksLike)
								);

INSERT INTO Subscriber (SubscriberID, Name, Street, HouseNr, City) VALUES 
(1215426, 'Fam. van Raalte', 'Schopenhauerdijkje', 5, '3991 ML', 'Houten'),
(5602533, 'J. van Betlehem', 'Nietzschestraat', 99, '8542 BE', 'Breda'),
(5285824, 'F. de Kat', 'Kantlaan', 11, '8542 CD', 'Breda');

INSERT INTO UserProfile (SubscriberID, ProfileID, ProfileName, DateOfBirth) VALUES
(1215426, 01, 'Frank', '1968-01-25'),
(1215426, 02, 'Madelief', '2001-08-19'),
(5602533, 01, 'Petrus', '1999-06-26'),
(5602533, 02, 'Paulus', '1999-06-26'),
(5285824, 01, 'Fritz', '1968-08-19'),
(5285824, 02, 'Diana', '1988-12-25');

INSERT INTO Movie (Title, MovieID, Genre, SpokenLanguage, MinAge, LengthInMinutes) VALUES
('The Abominable Bride', 1010, 'Detective', 'Engels', 12 , 89),
('The Life of Brian', 8001, 'Humor', 'Engels', 12, 94),
('Pulp Fiction', 8002, 'Misdaad', 'Engels-Amerikaans', 16, 154),
('Pruimebloesem', 8004, 'Erotiek', 'Nederlands', 18, 80),
('Reservoir Dogs', 8008, 'Misdaad', 'Engels-Amerikaans', 16, 99),
('The Good, the Bad and the Ugly', 8010, 'Western', 'Engels-Amerikaans', 12, 161),
('Andy Warhols Dracula', 8011, 'Humor', 'Engels-Amerikaans', 16, 103),
('Ober', 8012, 'Humor', 'Nederlands', 6, 97),
('Der Untergang', 8014, 'Oorlog', 'Duits', 6, 178),
('De helaasheid der dingen', 8016, 'Humor', 'Vlaams', 12, 108),
('A Clockwork Orange', 8017, 'Sci-Fi', 'Engels', 16, 136);

INSERT INTO Serie (Title, SerieID, Genre, SpokenLanguage, MinAge) VALUES
('Sherlock', 001, 'Detective', 'Engels', 12),
('Breaking Bad', 002, 'Spanning', 'Engels-Amerikaans', 16),
('Fargo', 003, 'Spanning', 'Engels-Amerikaans', 16);

INSERT INTO Episode (EpisodeNumber, Title, SerieID, LengthInMinutes) VALUES
/* Sherlock */
(1001, 'A Study in Pink' 001, 88),
(1002, 'The Blind Banker', 001, 88),
(1003, 'The Great Game', 001, 88),
(1004, 'A Scandal in Belgravia', 001, 88),
(1005, 'The Hounds of Baskerville', 001, 88),
(1006, 'The Reichenbach Fall', 001, 88),
(1007, 'The Empty Hearse', 001, 88),
(1008, 'The Sign of Three', 001, 88),
(1009, 'His Last Vow', 001, 88);

/* Breaking Bad */
(2000, 'Pilot', 002, 58),
(2001, 'Cat is in the Bag…', 002, 48),
(2002, '…And the Bag is in the River', 002, 48),
(2003, 'Cancer Man', 002, 48),
(2004, 'Gray Matter', 002, 48),
(2005, 'Crazy Handful of Nothin', 002, 48),
(2006, 'A No-Rough-Stuff-Type Deal', 002, 48),
(2007, 'Seven Thirty-Seven', 002, 48),
(2008, 'Grilled', 002, 48),
(2009, 'Bit by a Dead Bee', 002, 48),
(2011, 'Down', 002, 48),
(2012, 'Breakage', 002, 48),
(2013, 'Peekaboo', 002, 48),
(2014, 'Negro Y Azul', 002, 48), 
(2015, '4 Days Out', 002, 48),
(2016, 'Over', 002, 48),
(2017, 'Mandala', 002, 48),
(2018, 'Phoenix', 002, 48),
(2019, 'ABQ', 002, 48);

/* Fargo */
(3001, 'The Crocodiles Dilemma', 003, 68),
(3002, 'The Rooster Prince', 003, 68),
(3003, 'A Muddy Road', 003, 68),
(3004, 'Eating the Blame', 003, 68),
(3005, 'The Six Ungraspables', 003, 68),
(3006, 'Buridans Ass', 003, 68),
(3007, 'Who Shaves the Barber?', 003, 68),
(3008, 'The Heap', 003, 68),
(3009, 'A Fox, a Rabbit, and a Cabbage', 003, 68),
(3010, 'Mortons Fork', 003, 68),
(3101, 'Waiting for Dutch', 003, 68),
(3102, 'Before the Law', 003, 68),
(3103, 'The Myth of Sisyphus', 003, 68),
(3104, 'The Gift of the Magi', 003, 68),
(3105, 'Fear and Trembling', 003, 68),
(3106, 'Rhinoceros', 003, 68),
(3107, 'Did you do this? No, you did it!', 003, 68),
(3108, 'Loplop', 003, 68),
(3109, 'The Castle', 003, 68),
(3110, 'Palindrome', 003, 68);

INSERT INTO SeriesSeen (SerieID, PercentageSeen, UserName, UserProfile) VALUES
(1001, 100, 'Frank', 1215426),
(1001, 100, 'Madelief', 1215426),
(1001, 100, 'Fritz', 5285824),
(1001, 45, 'Diana', 5285824),
(1002, 100, 'Frank', 1215426),
(1002, 60,  'Madelief', 1215426),
(1002, 100, 'Fritz', 5285824),
(1003, 78, 'Frank', 1215426),
(2001, 100, 'Madelief', 1215426),
(2002, 100, 'Madelief', 1215426),
(2003, 100, 'Madelief', 1215426),
(2004, 22, 'Madelief', 1215426),
(2019, 10, 'Paulus', 5602533),
(3001, 91, 'Madelief', 1215426),
(3001, 100, 'Petrus', 5602533),
(3001, 100, 'Paulus', 5602533),
(3002, 100, 'Petrus', 5602533),
(3002, 74, 'Paulus', 5602533),
(3010, 60, 'Paulus', 5602533),
(3010, 60, 'Petrus', 5602533);

INSERT INTO MoviesSeen (MovieID, PercentageSeen, UserName, UserProfile) VALUES
(1010, 5, 'Fritz', 5285824),
(8001, 100, 'Petrus', 5602533),
(8001, 100, 'Paulus', 5602533),
(8002, 99, 'Petrus', 5602533),
(8002, 100, 'Diana', 5285824);

/* 
001 - Sherlock
002 - Breaking Bad
003 - Fargo
*/
INSERT INTO SerieAssociations (SerieID, LooksLike) VALUES
(001, 003),
(002, 003),
(003, 002);

