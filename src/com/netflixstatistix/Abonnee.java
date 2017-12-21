package com.netflixstatistix;

import com.netflixstatistix.connections.DatabaseConnection;


import java.sql.ResultSet;
import java.util.ArrayList;

public class Abonnee{
    private int ID;
    private String naam;
    private String straat;
    private String huisNr;
    private String toevoeging;
    private String postcode;
    private String woonPlaats;
    private ArrayList<Profiel> profielen;

    public ArrayList<Profiel> getProfielen() {
        return profielen;
    }

    public void setProfielen(ArrayList<Profiel> profielen) {
        this.profielen = profielen;
    }

    public Abonnee(int lookupID){
        DatabaseConnection con = new DatabaseConnection();

        try {
        ResultSet rs = con.getData("SELECT * FROM Abonnee WHERE AbonneeID = '"+ lookupID + "';" );

            rs.next();
            this.ID =  rs.getInt("AbonneeID");
            this.naam = rs.getString("Naam");
            this.straat = rs.getString("Straat");
            this.huisNr = rs.getString("Huisnummer");
            this.toevoeging = rs.getString("Toevoeging");
            this.postcode = rs.getString("Postcode");
            this.woonPlaats = rs.getString("Woonplaats");
            this.profielen = buildProfiles(this.ID);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private ArrayList<Profiel> buildProfiles(int abonneeID){    //Zoekt bijhorende profielen en brengt deze onder in het Parents Abbo object.
        ArrayList<Profiel> profielen = new ArrayList();
        DatabaseConnection con = new DatabaseConnection();

        try {


            ResultSet rs = con.getData("SELECT COUNT(*) AS AantalRows FROM Profiel WHERE AbonneeID = '" + abonneeID + "';");
            rs.next();
            int amountOfRows = rs.getInt("AantalRows");
            System.out.println("Aantal rows in return "+amountOfRows);
            int i = 0;

            while (i < amountOfRows){
                profielen.add(new Profiel(abonneeID, amountOfRows - i));
                i++;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return profielen;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public void setHuisNr(String huisNr) {
        this.huisNr = huisNr;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonPlaats() {
        return woonPlaats;
    }

    public void setWoonPlaats(String woonPlaats) {
        this.woonPlaats = woonPlaats;
    }
}