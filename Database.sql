-- TODO
-- - Vullen met data
-- - Cascade's opzetten




USE MASTER;

IF EXISTS(SELECT * FROM sys.databases where name  ='NFS')
DROP DATABASE NFS;


CREATE DATABASE NFS;
USE NFS;




--Setting up the tables;
CREATE TABLE	Subscriber(

					SubscriberID int		NOT NULL PRIMARY KEY,
					FirstName varchar(20)	NOT NULL,
					LastName varchar (40)	NOT NULL,
					Street varchar (40)		NOT NULL,
					HouseNr varchar(8)		NOT NULL,
					HouseNrExt varchar(8)			,
					City varchar (60)		NOT NULL		
													);

CREATE TABLE	UserProfile(

					SubscriberID int FOREIGN KEY REFERENCES Subscriber(SubScriberID),
					ProfileID int			NOT NULL PRIMARY KEY,
					ProfileName varchar (40)NOT NULL,
					DateOfBirth date		NOT NULL,

												);

CREATE TABLE	Movie(
					
					Titel varchar(40) NOT NULL PRIMARY KEY,
					Genre varchar(20),
					SpokenLanguage varchar(40),
					MinAge int,
					LengthInSeconds	int
												);

CREATE TABLE	Serie(
					Titel varchar(40) NOT NULL ,
					SerieID int NOT NULL PRIMARY KEY,
					Genre varchar(20),
					SpokenLangauge varchar(40),
					MinAge int
												);

CREATE TABLE	Episode(
					EpisodeNumber int NOT NULL,
					Titel varchar(40) NOT NULL,
					SerieID int FOREIGN KEY REFERENCES Serie(SerieID),
					LengthInSeconds int NOT NULL,
					CONSTRAINT PK_Episode PRIMARY KEY (EpisodeNumber, SerieID)
												);

CREATE TABLE	Seen(
					SerieID int FOREIGN KEY REFERENCES Serie(SerieID),
					EpisodeNumber int,
					PercentageSeen int,
					UserProfile int FOREIGN KEY REFERENCES UserProfile(ProfileID)
					CONSTRAINT PK_Seen PRIMARY KEY (SerieID,EpisodeNumber),
					FOREIGN KEY (EpisodeNumber, SerieID) REFERENCES Episode(EpisodeNumber, SerieID)
												);

CREATE TABLE	SerieAssociations(
					SerieID int FOREIGN KEY REFERENCES Serie(SerieID),
					LooksLike int FOREIGN KEY REFERENCES Serie(SerieID)
					CONSTRAINT PK_SerieAssociations PRIMARY KEY (SerieID, LooksLike)
												);


