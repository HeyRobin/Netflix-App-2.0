-- TODO
-- - Cascade's opzetten

USE MASTER;

IF EXISTS(SELECT * FROM sys.databases WHERE name  ='NFS')
DROP DATABASE NFS;

CREATE DATABASE NFS;
USE NFS;
GO

--Setting up the tables;
CREATE TABLE	Subscriber(
	SubscriberID 	int				PRIMARY KEY,
	FirstName		varchar (30)	NOT NULL,
	NameExt			varchar	(10)	NOT NULL,
	LastName 		varchar (50)	NOT NULL,
	Street 			varchar (40)	NOT NULL,
	HouseNr 		int				NOT NULL,
	HouseNrExt 		varchar(8),
	PostalCode		varchar(7),
	City 			varchar (60)	NOT NULL	);

CREATE TABLE	UserProfile(
	SubscriberID 	int FOREIGN KEY REFERENCES Subscriber(SubscriberID),
	ProfileID 		int				NOT NULL,
	ProfileName 	varchar (40)	NOT NULL PRIMARY KEY,
	DateOfBirth		date			NOT NULL	);

CREATE TABLE	Movie(
	Title 			varchar(40) 	NOT NULL,
	MovieID			int				NOT NULL PRIMARY KEY,
	Genre 			varchar(20)		NOT NULL,
	SpokenLanguage 	varchar(40)		NOT NULL,
	MinAge 			int				NOT NULL,
	LengthInMinutes	int							);

CREATE TABLE	Serie(
	Title 			varchar(40) 	NOT NULL ,
	SerieID 		int 			NOT NULL PRIMARY KEY,
	Genre 			varchar(20)		NOT NULL,
	SpokenLanguage 	varchar(40)		NOT NULL,
	MinAge 			int				NOT NULL	);
		
CREATE TABLE	Episode(
	EpisodeNumber 	int 			NOT NULL,
	Title 			varchar(40) 	NOT NULL,
	SerieID 		int FOREIGN KEY REFERENCES Serie(SerieID),
	LengthInMinutes int 			NOT NULL,
		CONSTRAINT PK_Episode PRIMARY KEY (EpisodeNumber, SerieID)
												);

CREATE TABLE	SeriesSeen(
	SerieID			int PRIMARY KEY REFERENCES Serie(SerieID),
	PercentageSeen 	int,
	UserName		varchar(40)	FOREIGN KEY REFERENCES UserProfile(ProfileName),
												);
								
CREATE TABLE	MoviesSeen(
	MovieID 		int PRIMARY KEY REFERENCES Movie(MovieID),
	PercentageSeen 	int,
	UserName		varchar(40) FOREIGN KEY REFERENCES UserProfile(ProfileName),
												);

CREATE TABLE	SerieAssociations(
	SerieID			int FOREIGN KEY REFERENCES Serie(SerieID),
	LooksLike		int FOREIGN KEY REFERENCES Serie(SerieID),
		CONSTRAINT PK_SerieAssociations PRIMARY KEY (SerieID, LooksLike)
												);

INSERT INTO Subscriber (SubscriberID, FirstName, NameExt, LastName, Street, HouseNr, PostalCode, City) VALUES
(1215426, 'Familie', 'van', 'Raalte', 'Schopenhauerdijkje', 5, '4822ML', 'Breda'),
(5602533, 'Jezus', 'van', 'Betlehem', 'Nietzschestraat', 99, '4815BE', 'Breda'),
(5285824, 'Frank', 'de', 'Kat', 'Kantlaan', 11, '4811CD', 'Breda');

/*
ALTER TABLE Subscriber
DROP COLUMN Name;


ALTER TABLE Subscriber
ADD Firstname varchar(30);

ALTER TABLE Subscriber
ADD NameExt varchar(10);

ALTER TABLE Subscriber
ADD LastName varchar(40);
*/
UPDATE Subscriber
SET FirstName = 'Familie', NameExt = 'van', LastName = 'Raalte'
WHERE SubscriberID = 1215426;

UPDATE Subscriber
SET FirstName = 'Jezus', NameExt = 'van', LastName = 'Betlehem'
WHERE SubscriberID = 5602533;

UPDATE Subscriber
SET FirstName = 'Frank', NameExt = 'de', LastName = 'Kat'
WHERE SubscriberID = 5285824;


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
('Fargo', 003, 'Spanning', 'Engels-Amerikaans', 16),
('Stranger Things', 004, 'Thriller', 'Engels-Amerikaans', 16),
('Black Mirror', 005, 'Spanning', 'Engels-Amerikaans', 16);

INSERT INTO Episode (EpisodeNumber, Title, SerieID, LengthInMinutes) VALUES
/* Sherlock */
(1001, 'A Study in Pink', 001, 88),
(1002, 'The Blind Banker', 001, 88),
(1003, 'The Great Game', 001, 88),
(1004, 'A Scandal in Belgravia', 001, 88),
(1005, 'The Hounds of Baskerville', 001, 88),
(1006, 'The Reichenbach Fall', 001, 88),
(1007, 'The Empty Hearse', 001, 88),
(1008, 'The Sign of Three', 001, 88),
(1009, 'His Last Vow', 001, 88),

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
(2019, 'ABQ', 002, 48),

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
(3110, 'Palindrome', 003, 68),

/* Stranger Things */
(4001, 'The Vanishing of Will Byers', 004, 51),
(4002, 'The Weirdo on Maple Street', 004, 51),
(4003, 'Holly, Jolly', 004, 51),
(4004, 'The Body', 004, 51),
(4005, 'The Flea and the Acrobat', 004, 51),
(4006, 'The Monster', 004, 51),
(4007, 'The Bathtub', 004, 51),
(4008, 'The Upside Down', 004, 51),
(4011, 'MADMAX', 004, 51),
(4012, 'Trick or Treat Freak', 004, 51),
(4013, 'The Pollywog', 004, 51),
(4014, 'Will The Wise', 004, 51),
(4015, 'Dig Dug', 004, 51),
(4016, 'The Spy', 004, 51),
(4017, 'The Lost Sister', 004, 51),
(4018, 'The Mind Flayer', 004, 51),
(4019, 'The Gate', 004, 51),

/* Black Mirror */
(5101, 'The National Anthem', 005, 46),
(5102, 'Fifteen Million Merits', 005, 46),
(5103, 'The Entire History of You', 005, 46),
(5201, 'Be Right Back', 005, 46),
(5202, 'White Bear', 005, 46),
(5203, 'The Waldo Moment', 005, 46),
(5204, 'Special: White Christmas', 005, 73);

INSERT INTO SeriesSeen (SerieID, PercentageSeen, UserName) VALUES
(001, 100, 'Frank'),
(001, 100, 'Madelief'),
(001, 100, 'Fritz'),
(001, 45, 'Diana'),
(002, 100, 'Frank'),
(002, 60,  'Madelief'),
(002, 100, 'Fritz'),
(003, 78, 'Frank'),
(001, 100, 'Madelief'),
(002, 100, 'Madelief'),
(003, 100, 'Madelief'),
(004, 22, 'Madelief'),
(019, 10, 'Paulus'),
(001, 91, 'Madelief'),
(001, 100, 'Petrus'),
(001, 100, 'Paulus'),
(002, 100, 'Petrus'),
(002, 74, 'Paulus'),
(010, 60, 'Paulus'),
(010, 60, 'Petrus'),
(001, 100, 'Madelief'),
(001, 100, 'Fritz'),
(002, 100, 'Madelief'),
(002, 99, 'Fritz'),
(003, 63, 'Madelief'),
(101, 50, 'Petrus'),
(101, 37, 'Paulus'),
(201, 100, 'Madelief'),
(201, 10, 'Diana'),
(201, 33, 'Madelief');

INSERT INTO MoviesSeen (MovieID, PercentageSeen, UserName) VALUES
(1010, 5, 'Fritz'),
(1010, 65, 'Madelief'),
(1010, 95, 'Petrus'),
(8001, 100, 'Petrus'),
(8001, 100, 'Paulus'),
(8002, 100, 'Petrus'),
(8002, 100, 'Diana'),
(8004, 55, 'Petrus'),
(8004, 99, 'Frank'),
(8008, 100, 'Paulus'),
(8008, 100, 'Petrus'),
(8008, 50, 'Madelief'),
(8008, 60, 'Fritz'),
(8010, 100, 'Diana'),
(8010, 100, 'Frank'),
(8010, 99, 'Fritz'),
(8011, 40, 'Madelief'),
(8011, 2, 'Petrus'),
(8012, 50, 'Madelief'),
(8012, 9, 'Fritz'),
(8012, 100, 'Paulus'),
(8014, 39, 'Petrus'),
(8014, 100, 'Fritz'),
(8016, 44, 'Diana'),
(8016, 100, 'Fritz'),
(8017, 25, 'Diana'),
(8017, 10, 'Petrus'),
(8017, 100, 'Madelief');

/* 
001 - Sherlock
002 - Breaking Bad
003 - Fargo
004 - Stranger Things
005 - Black Mirror
*/
INSERT INTO SerieAssociations (SerieID, LooksLike) VALUES
(001, 003),
(001, 002),
(001, 005),
(002, 001),
(002, 003),
(002, 004),
(003, 001),
(003, 002),
(003, 004),
(004, 002),
(004, 003),
(004, 005),
(005, 001),
(005, 002),
(005, 004);


SELECT * FROM Episode;
SELECT * FROM Movie;
SELECT * FROM Seen;
SELECT * FROM Serie;
SELECT * FROM SerieAssociations;
SELECT * FROm Subscriber;
SELECT * FROM UserProfile;

SELECT * FROM UserProfile;
SELECT ProfileName, DateOfBirth, ProfileID FROM UserProfile WHERE SubscriberID = '5602533';