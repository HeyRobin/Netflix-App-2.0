package com.netflixstatistix;

import com.netflixstatistix.connections.DatabaseConnection;
import com.netflixstatistix.userinterface.UI;

import javax.swing.SwingUtilities;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

DatabaseConnection con = new DatabaseConnection();

Abonnee ab = new Abonnee(5285824);
        System.out.println("Aantal; profielen in arraylist" + ab.getProfielen().size());

        for (Profiel profiel:ab.getProfielen()
             ) {
            System.out.println(profiel.getProfielNaam());

        }


        System.out.println(ab.getHuisNr());


        UI ui = new UI();
        ui.run();
    }
}
