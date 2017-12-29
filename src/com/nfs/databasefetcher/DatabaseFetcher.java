package com.nfs.databasefetcher;

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
    public String getInformationAboutFilm(String movieName) {
        return movie.getInformationAboutFilm(movieName);
    }

    //Giving the information corresponding to a show
    public String getInformationAboutShow(String serieName)    { return show.getInformationAboutShow(serieName); }
}
