package com.nfs.userinterface;

import com.nfs.connections.DatabaseFetcher;
import com.nfs.data.Movie;
import com.nfs.data.MovieButton;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

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




        JLabel infoTopPanel = new JLabel("<HTML> <br/><br/><br/><br/>" +
                                                        "  Tijdsduur: "+ movie.getLength() +"<br/>" +
                                                        "Genre: "+ movie.getGenre() + "<br/>" +
                                                        "Taal: " + movie.getLanguage() +"<br/>" +
                                                        "Minimum leeftijd: "+ movie.getAge() +"<br/>" +
                                                        "Totaal bekeken percentage: " + movie.getSharedWatchedProgress() + "%<br/>" +
                                                        "Totaal aantal keer bekeken: " + movie.getTimesSeen() + "<br/>" +
                                                        "Eigen voortgang: " + movie.getIndividualWatchedProgress() + "%<br/></HTML>");

        infoTopPanel.setFont(new Font("Serif", Font.BOLD, 18));
        topPanel.add(infoTopPanel,BorderLayout.CENTER);
        //   bottomPanel.add(new JLabel("Wij raden u aan:"),BorderLayout.NORTH);
        //    ArrayList<String[]> recommendedMovies = con.getDataReturnArrayList("SELECT MovieID FROM movie;");
        //    Collections.shuffle(recommendedMovies);

        //    bottomPanel.add(new MovieButton(Integer.parseInt(recommendedMovies.get(0)[0])),BorderLayout.WEST);
        //    bottomPanel.add(new MovieButton(Integer.parseInt(recommendedMovies.get(1)[0])),BorderLayout.CENTER);
        //    bottomPanel.add(new MovieButton(Integer.parseInt(recommendedMovies.get(2)[0])),BorderLayout.EAST);


    }

}
