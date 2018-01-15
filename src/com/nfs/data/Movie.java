package com.nfs.data;


import com.nfs.connections.DatabaseFetcher;
import java.util.ArrayList;


public class Movie {
    private int movieID;
    private String movieTitle;
    private int sharedWatchedProgress;
    private int timesSeen;
    private int individualWatchedProgress;
    private int age;
    private String language;
    private String genre;
    private int length;



    //Constructor
    public Movie(int movieID) {
        DatabaseFetcher con = new DatabaseFetcher();
        ArrayList<String[]> results = con.getDataReturnArrayList("SELECT Title, SpokenLanguage, MinAge, LengthInMinutes, Genre FROM Movie WHERE MovieID = '" + movieID + "';");
        //Haal basis gegevens film op.

        for (String[] resultSet : results
                ) {
            this.movieTitle = resultSet[0];
            this.language = resultSet[1];
            this.age = Integer.parseInt(resultSet[2]);
            this.length = Integer.parseInt(resultSet[3]);
            this.genre = resultSet[4];
        }


        if (con.getDataResultSingleCellAsString("SELECT AVG(PercentageSeen) FROM MoviesSeen WHERE MovieID = '" + movieID + "';") != null)

        {
            sharedWatchedProgress = Integer.parseInt(con.getDataResultSingleCellAsString("SELECT AVG(PercentageSeen) FROM MoviesSeen WHERE MovieID = '" + movieID + "';"));
        } else

        {
            sharedWatchedProgress = 0;
        }
        //Check statistic

        timesSeen = Integer.parseInt(con.getDataResultSingleCellAsString("SELECT COUNT(*) FROM MoviesSeen WHERE MovieID = '" + movieID + "';"));

        String movieSeen = con.getDataResultSingleCellAsString("SELECT AVG(PercentageSeen) FROM MoviesSeen WHERE MovieID = '"+ movieID +"';");
        if (movieSeen == null){
            sharedWatchedProgress = 0;
        } else {
            sharedWatchedProgress = Integer.parseInt(movieSeen);
        }


        //Check statistic


        if (!con.getDataResultSingleCellAsString("SELECT PercentageSeen FROM MoviesSeen WHERE MovieID = '" + movieID + "' AND Subscriber = '" + CurrentUser.currentSubscriber + "' AND UserProfile = '" + CurrentUser.currentProfile + "';").equals(""))

        {
            individualWatchedProgress = Integer.parseInt(con.getDataResultSingleCellAsString("SELECT PercentageSeen FROM MoviesSeen WHERE MovieID = '" + movieID + "' AND Subscriber = ' " + CurrentUser.currentSubscriber + "' AND UserProfile = ' " + CurrentUser.currentProfile + "'; "));
        } else

        {
            individualWatchedProgress = 0;
        }
    }
    //Check statistic


    public String getMovieTitle() {
        return movieTitle;
    }

    public int getSharedWatchedProgress() {
        return sharedWatchedProgress;
    }

    public int getTimesSeen() {
        return timesSeen;
    }

    public int getIndividualWatchedProgress() {
        return individualWatchedProgress;
    }

    public int getAge() {
        return age;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }
}

