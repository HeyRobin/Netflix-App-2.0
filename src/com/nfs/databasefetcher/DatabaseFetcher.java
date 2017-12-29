package com.nfs.databasefetcher;

import com.nfs.connections.DatabaseConnection;

public class DatabaseFetcher {

    //Declarations
    DatabaseConnection dbc;
    Movie movie;

    //Constructor
    public DatabaseFetcher()    {
        dbc = new DatabaseConnection();
        movie = new Movie();
    }

    //Giving the information corresponding to a movie
    public String getInformationAboutFilm(String movieName) {
        return movie.getInformationAboutFilm(movieName);
    }
}
