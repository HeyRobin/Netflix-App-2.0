package com.nfs.data;

import com.nfs.appdetails.TimeKeeper;
import com.nfs.connections.DatabaseConnection;
import com.nfs.userinterface.InterfaceCreator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;

public class Profile {
    private String profielNaam;
    private String geboorteDatum;
    private int abonneeID;


    public Profile(int inputAbonneeID, int profielVolgNummer) {

        DatabaseConnection con = new DatabaseConnection();

        try {
            ResultSet rs = con.getData("SELECT * FROM Profile where AbonneeID = '" + inputAbonneeID + "'");

            while (profielVolgNummer > 0) {

                rs.next();
                profielVolgNummer--;

            }

            this.profielNaam = rs.getString("Profielnaam");
            this.geboorteDatum = rs.getString("Geboortedatum");
            this.abonneeID = rs.getInt("AbonneeID");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public String getProfielNaam() {
        return profielNaam;
    }

    public void setProfielNaam(String profielNaam) {
        this.profielNaam = profielNaam;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public int getAbonneeID() {
        return abonneeID;
    }

    public void setAbonneeID(int abonneeID) {
        this.abonneeID = abonneeID;
    }



}
