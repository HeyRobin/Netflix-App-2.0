package com.nfs.connections;

import com.nfs.data.Film;
import com.nfs.data.Show;

import javax.swing.*;

public class DatabaseFetcher {

    //Declarations
    private Film movie;
    private Show show;

    //Constructor
    public DatabaseFetcher()    {
        movie = new Film();
        show = new Show();
    }

    //Giving the information corresponding to a movie
    public JPanel getInformationAboutFilm(String movieName) {
        return movie.getInformationAboutFilm(movieName);
    }

    //Giving the information corresponding to a show
    public JPanel getInformationAboutShow(String serieName)    { return show.getInformationAboutShow(serieName); }
}
