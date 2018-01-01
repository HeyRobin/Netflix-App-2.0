package com.nfs.databasefetcher;

import javax.swing.*;

public class DatabaseFetcher {

    //Declarations
    private Movie movie;
    private Show show;

    //Constructor
    public DatabaseFetcher()    {
        movie = new Movie();
        show = new Show();
    }

    //Giving the information corresponding to a movie
    public JPanel getInformationAboutFilm(String movieName) {
        return movie.getInformationAboutFilm(movieName);
    }

    //Giving the information corresponding to a show
    public JPanel getInformationAboutShow(String serieName)    { return show.getInformationAboutShow(serieName); }
}
