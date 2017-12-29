package com.nfs.databasefetcher;

import com.nfs.connections.DatabaseConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    //Declarations
    private DatabaseConnection dbc;
    private List<String> movies;


    //Constructor
    public Movie()   {
        this.dbc = new DatabaseConnection();
        this.movies = new ArrayList<>();
    }


    //Gives all the movies and their corresponding titles
    public List<String> getAllFilmsInDB() {

        //Declarations
        String query =  "SELECT Titel \n" +
                        "FROM Movie";
        ResultSet rs = dbc.getData(query);

        try {

            //First, check for an empty ResultSet
            if (rs == null) {
                throw new IllegalStateException("The ResultSet was empty");
            }

            else {
                //Adding every value
                while (rs.next()) {
                    movies.add(rs.getString("Titel"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.movies;
    }


    public String getInformationAboutFilm(String movieName) {

        //Declarations
        String query =  "SELECT *\n" +
                        "FROM Movie\n" +
                        "WHERE Titel = '" + movieName + "';";
        ResultSet rs = dbc.getData(query);
        TextFormatter tf = new TextFormatter();
        String title = null;
        String genre = null;
        String language = null;
        int age = 0;
        int duration = 0;

        //Retrieving and sorting all the data
        try {

            //First, check for an empty ResultSet
            if (rs == null) {
                throw new IllegalStateException("The ResultSet was empty");


            //NEEDS FIX. CANT FIND CURRENT ROW
            } else {
                rs.first();
                title = rs.getString("Titel");
                genre = rs.getString("Genre");
                language = rs.getString("SpokenLanguage");
                age = rs.getInt("Age");
                duration = rs.getInt("LengthInSeconds");
            }

        } catch (Exception e)   {
            e.printStackTrace();
        }

        return tf.formatterMovie(title, genre, language, age, duration);
    }
}
