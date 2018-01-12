package com.nfs.userinterface;

import com.nfs.connections.DatabaseFetcher;
import com.nfs.data.Movie;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;

public class MovieStatisticsPanel extends JPanel {
    public MovieStatisticsPanel(int movieID){
        DatabaseFetcher con = new DatabaseFetcher();
      //  super.add(
        super.setLayout(new BorderLayout());

        Movie movie = new Movie(movieID);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        super.add(topPanel,BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        super.add(bottomPanel,BorderLayout.SOUTH);

        JLabel header = new JLabel(movie.getMovieTitle());
        header.setFont(new Font("Serif", Font.PLAIN, 30));
        topPanel.add(header,BorderLayout.NORTH);




        JLabel infoTopPanel = new JLabel("<HTML>   Tijdsduur: "+ movie.getLength() +"</br>" +
                                                        "Genre: "+ movie.getGenre() + "</br>" +
                                                        "Taal: " + movie.getLanguage() +"</br>" +
                                                        "Minimum leeftijd: "+ movie.getAge() +"</br></HTML>");
        topPanel.add(infoTopPanel,BorderLayout.CENTER);

    }

}
