package com.nfs.data;

import com.nfs.connections.DatabaseConnection;


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

    //Zoekt bijhorende profielen en brengt deze onder in het Parents Abbo object.
    private ArrayList<Profiel> buildProfiles(int abonneeID){
        ArrayList<Profiel> profielen = new ArrayList<>();
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
}