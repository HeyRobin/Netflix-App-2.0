package com.nfs.data;

import com.nfs.connections.DatabaseFetcher;

import javax.swing.*;
import java.awt.*;

public class MovieButton extends JButton {

    private int movieID;

    public MovieButton(int movieID){ // meant for the movie selection panel.
        this.movieID = movieID;
        DatabaseFetcher con = new DatabaseFetcher();

        String buttonText = con.getDataResultSingleCellAsString("SELECT Title FROM Movie WHERE MovieID = '"+ movieID + "'; ");

        super.setText(buttonText);
        super.setEnabled(true);
        super.setPreferredSize(new Dimension(65,55));
        super.setMaximumSize(new Dimension(65,55));
        super.setMinimumSize(new Dimension(65,55));

    }

    public int getMovieID() {
        return movieID;
    }
}
