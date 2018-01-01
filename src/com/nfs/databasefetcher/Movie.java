package com.nfs.databasefetcher;

import com.nfs.connections.DatabaseConnection;
import com.nfs.userinterface.InterfaceCreator;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.List;

public class Movie {

    //Declarations
    private DatabaseConnection dbc;
    private List<String> movies;


    //Constructor
    public Movie()   {
        this.dbc = new DatabaseConnection();
//        this.movies = new ArrayList<>();
    }


    public JPanel getInformationAboutFilm(String movieName) {

        //BUG BELOW
//        //Declarations
//        String query =  "SELECT * " +
//                        "FROM Movie " +
//                        "WHERE Titel = '" + movieName + "';";
//        ResultSet rs = dbc.getData(query);

        //Testing purposes
        String title = "Breaking Bad";
        String genre = "Avontuur";
        String language = "Engels";
        int age = 12;
        int duration = 136;

        //BUG BELOW
//        //Retrieving and sorting all the data
//        try {
//            title = rs.getString("Titel");
//            genre = rs.getString("Genre");
//            language = rs.getString("SpokenLanguage");
//            age = rs.getInt("Age");
//            duration = rs.getInt("LengthInSeconds");
//        }
//
//        catch (Exception e)   {
//            e.printStackTrace();
//        }

        return new InterfaceCreator().createMoviePanel(title, genre, language, age, duration);
    }
















    //UNNECESSARY METHOD
//    //Gives all the movies and their corresponding titles
//    public List<String> getAllFilmsInDB() {
//
//        //Declarations
//        String query =  "SELECT Titel \n" +
//                        "FROM Movie";
//        ResultSet rs = dbc.getData(query);
//
//        try {
//
//            //First, check for an empty ResultSet
//            if (rs == null) {
//                throw new IllegalStateException("The ResultSet was empty");
//            }
//
//            else {
//                //Adding every value
//                while (rs.next()) {
//                    movies.add(rs.getString("Titel"));
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return this.movies;
//    }
}
