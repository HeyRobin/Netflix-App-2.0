package com.nfs.data;

import com.nfs.connections.DatabaseFetcher;

import java.util.ArrayList;


public class Serie {
    private int serieID;
    private int minAge;
    private String title;
    private String language;
    private String genre;
    private String[] episodes;
    private ArrayList<String[]> episodeGegevens;
    private int amountOfViews;
    private int sharedAmountCompleted;
    private String[] associations;
    private int individualProgress;
    private int amountOfEpisodes;

    public int getMinAge() {
        return minAge;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public Serie(int serieID){
        DatabaseFetcher con = new DatabaseFetcher();

        ArrayList<String[]> serieGegevens = con.getDataReturnArrayList("SELECT Title, SerieID, Genre, SpokenLanguage, MinAge FROM Serie WHERE SerieID = '" + serieID + "';");

        this.title = serieGegevens.get(0)[0];
        this.serieID = Integer.parseInt(serieGegevens.get(0)[1]);
        this.genre = serieGegevens.get(0)[2];
        this.language = serieGegevens.get(0)[3];
        this.minAge = Integer.parseInt(serieGegevens.get(0)[4]);

        ArrayList<String[]> episodeGegevens = con.getDataReturnArrayList("SELECT EpisodeNumber, Title, LengthInMinutes FROM Episode WHERE SerieID = '" + serieID + "';" );


        this.amountOfEpisodes = episodeGegevens.size();

        try {
            this.amountOfViews = Integer.parseInt(con.getDataResultSingleCellAsString("SELECT COUNT(*) FROM SeriesSeen WHERE SerieID = '" + this.serieID + "';"));
        }catch (Exception e){

            this.amountOfViews = 0;
        }

        try{
            this.sharedAmountCompleted = Integer.parseInt(con.getDataResultSingleCellAsString("SELECT AVG(PercentageSeen) FROM SeriesSeen WHERE SerieID = '" + serieID + "';"))
                    /
                    (Integer.parseInt(con.getDataResultSingleCellAsString("SELECT COUNT(*) FROM Episode WHERE SerieiD = '" + this.serieID + "';")));
        }catch (Exception e){

            this.sharedAmountCompleted = 0;
        }

        try{
            this.individualProgress = (Integer.parseInt(con.getDataResultSingleCellAsString("SELECT SUM(PercentageSeen) FROM SeriesSeen WHERE SerieID = '" + serieID + "' AND SubScriber = '" + CurrentUser.currentSubscriber + "' AND UserProfile = '" + CurrentUser.currentProfile + "';"))
                                        /
                    (Integer.parseInt(con.getDataResultSingleCellAsString("SELECT COUNT(*) FROM Episode WHERE SerieiD = '" + this.serieID + "';"))));
        }catch (Exception e){

            this.individualProgress = 0;
        }

        ArrayList<String[]> assocationsArrayList = con.getDataReturnArrayList("SELECT LooksLike FROM SerieAssociations WHERE SerieID = '" + serieID + "' ;");

        String[] associations = new String[assocationsArrayList.size()];
int i = 0;
        for (String[] container: assocationsArrayList
             ) {associations[i]= container[0];
             i++;

        }








    }

    public int getAmountOfEpisodes() {
        return amountOfEpisodes;
    }

    public int getSharedAmountCompleted() {
        return sharedAmountCompleted;
    }

    public int getAmountOfViews() {
        return amountOfViews;
    }


    public int getIndividualProgress() {
        return individualProgress;
    }

    }



