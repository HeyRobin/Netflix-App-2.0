package com.nfs.data;

import com.nfs.connections.DatabaseFetcher;

import javax.swing.*;
import java.awt.*;

public class SerieButton extends JButton {

    private int serieID;




    public SerieButton(int serieID){

        this.serieID = serieID;
        DatabaseFetcher con = new DatabaseFetcher();
        String buttonText = con.getDataResultSingleCellAsString("Select Title FROM Serie WHERE SerieID = '" + serieID + "';");


        super.setText(buttonText);
        super.setEnabled(true);

        super.setPreferredSize(new Dimension(65,55));
        super.setMaximumSize(new Dimension(65,55));
        super.setMinimumSize(new Dimension(65,55));
    }

    public int getSerieID() {
        return serieID;
    }
}
