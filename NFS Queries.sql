USE NFS;

/* Naam */
SELECT FirstName, NameExt, LastName
FROM Subscriber;

/* Adres */
SELECT Street, HouseNr, PostalCode, City
FROM Subscriber;

/* Films */
SELECT Title, Genre, SpokenLanguage, MinAge, LengthInMinutes
FROM Movie;

/* Series */
SELECT Title, Genre, SpokenLanguage, MinAge
FROM Serie;

/* Afleveringen */
SELECT EpisodeNumber, Title, LengthInMinutes
FROM Episode;

/* Profiel */
SELECT ProfileName, DateOfBirth
FROM UserProfile;

/* Bekeken films */ 
SELECT *
FROM MoviesSeen;

/* Bekeken series */
SELECT *
FROM SeriesSeen;




/* Globaal gem % afgekeken van een serie */
SELECT AVG(PercentageSeen) AS AverageSeenSeries
FROM SeriesSeen
WHERE PercentageSeen > 1;

/* Totaal aantal kijkers van een film */
--SELECT Title, COUNT(ProfileID) AS NumberOfViewers
--FROM Movie
--WHERE Movie.MovieID = ( SELECT MovieID
--						FROM MoviesSeen
--						WHERE UserName = (	SELECT UserName, ProfileID
--											FROM UserProfile		
--											WHERE ProfileID >1		));

/* Gem % afgekeken films */
SELECT AVG(MoviesSeen.PercentageSeen) AS AverageSeenMovies
FROM MoviesSeen
WHERE PercentageSeen > 1;				/* Gemiddelde is in werkelijkheid 81 */

/* Gem % bekeken van alle afleveringen van 1 serie */
SELECT Title, AVG(PercentageSeen) AS AverageSeenSeries
FROM Serie
	JOIN SeriesSeen
	ON Serie.SerieID = SeriesSeen.SerieID
WHERE PercentageSeen > 1
GROUP BY Title;

/* Totaal aantal gebruikers dat een serie/film heeft bekeken */
--SELECT COUNT(ProfileName) AS TotalUsers
--FROM UserProfile

/* Accounts met 1 profiel */
--SELECT SubscriberID, Name
--FROM Subscriber
--GROUP BY SubscriberID
--HAVING COUNT(SubscriberID) <= 1;

/* Film met langste kijkduur onder de 16jr */
SELECT TOP 1 Title
FROM Movie
WHERE MinAge < 16
ORDER BY LengthInMinutes DESC;

/* Gem percentage bekeken van alle profielen over 1 film */
