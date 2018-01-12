package com.nfs.data;

import javax.swing.*;

public class SerieButton extends JButton {
    public SerieButton(String serieID){
        super.setText("SELECT Title FROM Serie WHERE SerieID='" + serieID + "';");
        super.setEnabled(true);
    }

}
