package com.netflixstatistix;

import com.netflixstatistix.connections.DatabaseConnection;
import com.netflixstatistix.userinterface.UI;

import javax.swing.SwingUtilities;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

DatabaseConnection con = new DatabaseConnection();

ResultSet rs = con.getData("SELECT * FROM Abonnee");
try {
    while (rs.next()) {

        System.out.println(rs.getString(1));
    }

}catch(Exception e) {
            System.out.println("fout");
        }


    }
}
