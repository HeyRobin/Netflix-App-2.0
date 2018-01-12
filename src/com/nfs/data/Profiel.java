package com.nfs.data;

import com.nfs.appdetails.TimeKeeper;
import com.nfs.connections.DatabaseConnection;
import com.nfs.userinterface.InterfaceCreator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;

public class Profiel {
    private String profielNaam;
    private String geboorteDatum;
    private int abonneeID;


    private String[] userArray = new String[] {"Sander", "Robin", "Jac"};
    private JComboBox<String> profileDropdown = new JComboBox<>(userArray);
    private JLabel greeting = new JLabel(TimeKeeper.greeting() + " " + getSelectedIem(), JLabel.CENTER);

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

    public JPanel createProfileDropdown()    {

        //Creating the pane to add the dropdown and greeting
        JPanel profileContainer = new JPanel(new BorderLayout());

        //Setting up the dropdown. UserArray is a placeholder
        this.profileDropdown.setSelectedIndex(0);

        //Adding the Listener to the dropdown
        this.profileDropdown.addItemListener(new ProfileDropdownListener());

        //Creating a sub-container for better alignment
        JPanel subContainer = new JPanel(new BorderLayout());
        subContainer.setBorder(new EmptyBorder(20, 20, 20, 20));

        //Adding the components to the containers
        subContainer.add(this.greeting);
        profileContainer.add(this.profileDropdown, BorderLayout.NORTH);
        profileContainer.add(subContainer, BorderLayout.SOUTH);

        return profileContainer;
    }

    private String getSelectedIem() {
        return userArray[profileDropdown.getSelectedIndex()];
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


    //subclasses
    class ProfileDropdownListener implements java.awt.event.ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            //Changes text of label greeting when profile is changed
            greeting.setText(TimeKeeper.greeting() + " " + getSelectedIem());
        }
    }
}

