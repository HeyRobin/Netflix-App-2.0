package com.nfs.data;

import com.nfs.connections.DatabaseConnection;


import java.sql.ResultSet;
import java.util.ArrayList;

public class Subscriber {
    private int ID;
    private String naam;
    private String straat;
    private String huisNr;
    private String toevoeging;
    private String postcode;
    private String woonPlaats;
    private ArrayList<Profile> profielen;

    public ArrayList<Profile> getProfielen() {
        return profielen;
    }

    public void setProfielen(ArrayList<Profile> profielen) {
        this.profielen = profielen;
    }

    public Subscriber(int lookupID){
        DatabaseConnection con = new DatabaseConnection();

        try {
        ResultSet rs = con.getData("SELECT * FROM Subscriber WHERE AbonneeID = '"+ lookupID + "';" );

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

    //Zoekt bijhorende profielen en brengt deze onder in het Parents Abbo object.
    private ArrayList<Profile> buildProfiles(int abonneeID){
        ArrayList<Profile> profielen = new ArrayList<>();
        DatabaseConnection con = new DatabaseConnection();

        try {
            ResultSet rs = con.getData("SELECT COUNT(*) AS AantalRows FROM Profile WHERE AbonneeID = '" + abonneeID + "';");
            rs.next();
            int amountOfRows = rs.getInt("AantalRows");
            System.out.println("Aantal rows in return "+amountOfRows);
            int i = 0;

            while (i < amountOfRows){
                profielen.add(new Profile(abonneeID, amountOfRows - i));
                i++;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return profielen;
    }
}