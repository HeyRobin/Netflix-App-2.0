package com.nfs.data;

import com.nfs.connections.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Movie {

    //Declarations
    private DatabaseConnection dbc;
    private List<String> movies;


    //Constructor
    public Movie() {
        this.dbc = new DatabaseConnection();
//        this.movies = new ArrayList<>();
    }

    public JComponent createFilmButtons()  {
        return new JLabel("Film Buttons");
    }
}





