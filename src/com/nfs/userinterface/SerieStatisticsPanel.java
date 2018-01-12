package com.nfs.userinterface;

import com.nfs.connections.DatabaseFetcher;
import com.nfs.data.Serie;

import javax.swing.*;
import java.awt.*;

public class SerieStatisticsPanel extends JPanel { //placeholder

    public SerieStatisticsPanel(int serieID){
    DatabaseFetcher con = new DatabaseFetcher();
    //  super.add(
        super.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));
        super.setLayout(new BorderLayout());

    Serie serie = new Serie(serieID);

    JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        super.add(topPanel,BorderLayout.NORTH);

    JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        super.add(bottomPanel,BorderLayout.SOUTH);

    JLabel header = new JLabel(serie.getTitle());
        header.setFont(new Font("Serif", Font.PLAIN, 30));
        topPanel.add(header,BorderLayout.NORTH);



        JLabel infoTopPanel = new JLabel("<HTML> <br/><br/><br/><br/>" +
                "Aantal Episodes: " + serie.getAmountOfEpisodes() +"<br/>" +
                "Genre: "+ serie.getGenre() + "<br/>" +
                "Taal: " + serie.getLanguage() +"<br/>" +
                "Minimum leeftijd: "+ serie.getMinAge() +"<br/>" +
                "Totaal aantal views: " + serie.getAmountOfViews() + "<br/>" +
                "Percetage mensen afgekeken: " + serie.getSharedAmountCompleted() + "%<br/>" +
                "Eigen voortgang: " + serie.getIndividualProgress() + "%<br/></HTML>");

        infoTopPanel.setFont(new Font("Serif", Font.BOLD, 18));
        topPanel.add(infoTopPanel,BorderLayout.CENTER);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));

        //   bottomPanel.add(new JLabel("Wij raden u aan:"),BorderLayout.NORTH);
        //    ArrayList<String[]> recommendedMovies = con.getDataReturnArrayList("SELECT MovieID FROM movie;");
        //    Collections.shuffle(recommendedMovies);

        //    bottomPanel.add(new MovieButton(Integer.parseInt(recommendedMovies.get(0)[0])),BorderLayout.WEST);
        //    bottomPanel.add(new MovieButton(Integer.parseInt(recommendedMovies.get(1)[0])),BorderLayout.CENTER);
        //    bottomPanel.add(new MovieButton(Integer.parseInt(recommendedMovies.get(2)[0])),BorderLayout.EAST);

}}
