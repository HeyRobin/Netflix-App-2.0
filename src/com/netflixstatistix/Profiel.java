package com.netflixstatistix;

import com.netflixstatistix.connections.DatabaseConnection;

import java.sql.ResultSet;

public class Profiel {
    private String profielNaam;
    private String geboorteDatum;
    private int abonneeID;

    public Profiel(int inputAbonneeID, int profielVolgNummer) {
        DatabaseConnection con = new DatabaseConnection();

        try {
            ResultSet rs = con.getData("SELECT * FROM Profiel where AbonneeID = '" + inputAbonneeID + "'");

            while (profielVolgNummer > 0) {

                rs.next();
                profielVolgNummer--;

            }

            this.profielNaam = rs.getString("Profielnaam");
            this.geboorteDatum = rs.getString("Geboortedatum");
            this.abonneeID = rs.getInt("AbonneeID");

        } catch (Exception e) {

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

