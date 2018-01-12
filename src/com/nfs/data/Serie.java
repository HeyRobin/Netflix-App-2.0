package com.nfs.data;

import com.nfs.connections.DatabaseConnection;
import com.nfs.connections.DatabaseFetcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Serie {
    private int serieID;
    private int minAge;
    private String title;
    private String language;
    private String genre;
    private String[] episodes;

    public Serie(int serieID){
        DatabaseFetcher con = new DatabaseFetcher();

        ArrayList<String[]> serieGegevens = con.getDataReturnArrayList("SELECT Title, SerieID, Genre, SpokenLanguage, MinAge FROM Serie WHERE SerieID = '" + serieID + "';");
        this.title = serieGegevens.get(0)[0];
        this.serieID = Integer.parseInt(serieGegevens.get(0)[1]);
        this.genre = serieGegevens.get(0)[2];
        this.language = serieGegevens.get(0)[3];
        this.minAge = Integer.parseInt(serieGegevens.get(0)[4]);

        ArrayList<String[]> episodeGegevens = con.getDataReturnArrayList("SELECT EpisodeNumber, Title, LengthInMinutes FROM Episode WHERE SerieID = '" + this.serieID + "';" );




    }

}



