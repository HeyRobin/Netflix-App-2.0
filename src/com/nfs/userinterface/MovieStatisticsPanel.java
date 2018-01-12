package com.nfs.userinterface;

import com.nfs.connections.DatabaseFetcher;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;

public class MovieStatisticsPanel extends JPanel {
    public MovieStatisticsPanel(int movieID){
        DatabaseFetcher con = new DatabaseFetcher();
      //  super.add(
        super.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        super.add(topPanel,BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        super.add(bottomPanel,BorderLayout.SOUTH);

        JLabel header = new JLabel(con.getDataResultSingleCellAsString("SELECT Title FROM Movie WHERE MovieID = '"+ movieID +"'"));
        header.setFont(new Font("Serif", Font.PLAIN, 30));
        topPanel.add(header,BorderLayout.NORTH);

      //  con.getDataReturnArrayList("SELECT SpokenLangauge ")

        JLabel infoTopPanel = new JLabel("TEST \n TEST \n TEST\n TEST\n TEST\n TEST\n TEST");
        topPanel.add(infoTopPanel,BorderLayout.CENTER);

    }

}
