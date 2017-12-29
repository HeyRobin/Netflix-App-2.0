package com.nfs.databasefetcher;

import com.nfs.connections.DatabaseConnection;

import java.util.List;


public class Show {

    //declarations
    private DatabaseConnection dbc = new DatabaseConnection();
    private Episode episode = new Episode();


    //get the information about a show
    public String getInformationAboutShow(String serieName)    {
        List<String> epidodes = episode.getEpisodes(serieName);

        return "";
    }


}
