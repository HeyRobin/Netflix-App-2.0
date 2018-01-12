package com.nfs.data;

import com.nfs.connections.DatabaseConnection;
<<<<<<< HEAD

import javax.swing.*;
import java.awt.*;
=======
import com.nfs.connections.DatabaseFetcher;
import com.nfs.userinterface.InterfaceCreator;

import javax.swing.*;
import java.util.ArrayList;
>>>>>>> f020e3be37f1b8a000035cb70bde3f8aa8a9cc71
import java.util.List;

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



<<<<<<< HEAD
    //Constructor
    public Movie() {
        this.dbc = new DatabaseConnection();
//        this.movies = new ArrayList<>();
    }
=======
    public Movie(int movieID){
        DatabaseFetcher con = new DatabaseFetcher();
        ArrayList<String[]> results = con.getDataReturnArrayList("SELECT Title, SpokenLanguage, MinAge, LengthInMinutes, Genre FROM Movie WHERE MovieID = '" + movieID + "';");
        //Haal basis gegevens film op.

        for (String[] resultSet: results
                ) {
            this.movieTitle = resultSet[0];
            this.language = resultSet[1];
            this.age = Integer.parseInt(resultSet[2]);
            this.length = Integer.parseInt(resultSet[3]);
            this.genre = resultSet[4];
        }
>>>>>>> f020e3be37f1b8a000035cb70bde3f8aa8a9cc71

    public JComponent createFilmButtons()  {
        return new JLabel("Film Buttons");
    }
}


<<<<<<< HEAD



=======
        if (con.getDataResultSingleCellAsString("SELECT AVG(PercentageSeen) FROM MoviesSeen WHERE MovieID = '"+ movieID +"';") != null) {
            sharedWatchedProgress = Integer.parseInt(con.getDataResultSingleCellAsString("SELECT AVG(PercentageSeen) FROM MoviesSeen WHERE MovieID = '" + movieID + "';"));
        } else{
            sharedWatchedProgress = 0;
        }
        //Check statistic

        timesSeen = Integer.parseInt(con.getDataResultSingleCellAsString("SELECT * FROM MoviesSeen WHERE MovieID = '"+ movieID +"';"));

        if (con.getDataResultSingleCellAsString("SELECT PercentageSeen FROM MoviesSeen WHERE MovieID = '"+ movieID +"' AND Subscriber = '" + currentUser.currentSubscriber +"' AND UserProfile = '" + currentUser.currentProfile + "';") != null){
            individualWatchedProgress = Integer.parseInt(con.getDataResultSingleCellAsString("SELECT PercentageSeen FROM MoviesSeen WHERE MovieID = '" + movieID + "' AND Subscriber = ' " + currentUser.currentSubscriber + "' AND UserProfile = ' " + currentUser.currentProfile +  "'; "));
        }else {
            individualWatchedProgress = 0;
        }
        //Check statistic

    }
        public int getMovieID() {
            return movieID;
        }public String getMovieTitle() {
            return movieTitle;
        }public int getSharedWatchedProgress() {
            return sharedWatchedProgress;
        }public int getTimesSeen() {
            return timesSeen;
        }public int getIndividualWatchedProgress() {
            return individualWatchedProgress;
        }public int getAge() {
            return age;
        }public String getLanguage() {
            return language;
        }public String getGenre() {
            return genre;
        }public int getLength() {
            return length;
        }


}
>>>>>>> f020e3be37f1b8a000035cb70bde3f8aa8a9cc71
