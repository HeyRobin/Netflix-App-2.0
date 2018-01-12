package com.nfs.data;

import com.nfs.connections.DatabaseFetcher;

import javax.swing.*;

public class FilmButton extends JButton {
    public FilmButton(int movieID){
        DatabaseFetcher con = new DatabaseFetcher();
        super.setText(con.getDataResultSingleCellAsString("SELECT Title FROM Movie WHERE MovieID = '"+ movieID + "'; "));

    }
}
