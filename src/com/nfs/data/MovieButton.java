package com.nfs.data;

import com.nfs.connections.DatabaseFetcher;

import javax.swing.*;
import java.awt.*;

public class MovieButton extends JButton {
    private int movieID;
    public MovieButton(int movieID){
        this.movieID = movieID;
        DatabaseFetcher con = new DatabaseFetcher();

        String buttonText = con.getDataResultSingleCellAsString("SELECT Title FROM Movie WHERE MovieID = '"+ movieID + "'; ");
        buttonText = buttonText.replace("","\n");

        super.setText(buttonText);
        super.setEnabled(true);
        super.setPreferredSize(new Dimension(65,55));
        super.setMaximumSize(new Dimension(65,55));
        super.setMinimumSize(new Dimension(65,55));
      //  super.addActionListener(new ActionListener() {
      //      @Override
      //     public void actionPerformed(ActionEvent e) {
      //          PanelManager.UpdateContainer(new MovieStatisticsPanel(movieID));
      //          System.out.println(movieID);
//
      //      }
      //  });
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }
}
