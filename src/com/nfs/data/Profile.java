package com.nfs.data;

import com.nfs.appdetails.TimeKeeper;
import com.nfs.connections.DatabaseConnection;
import com.nfs.connections.DatabaseFetcher;
import com.nfs.userinterface.Interface;
import com.nfs.userinterface.InterfaceCreator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Profile {
    private String profileName;
    private String dateOfBirth;
    private int subScriberID;
    private int profileID;
    private String subScriberName;



    public Profile(int subScriberID, int profileID) {

        DatabaseFetcher con = new DatabaseFetcher();


        this.subScriberName = con.getDataResultSingleCellAsString("SELECT Name FROM Subscriber WHERE SubscriberID = '" + subScriberID + "';");
        this.subScriberID = subScriberID;


        ArrayList<String[]> data = con.getDataReturnArrayList("SELECT ProfileName, DateOfBirth, ProfileID FROM UserProfile WHERE SubscriberID = '" + subScriberID + "' AND ProfileID = '" +profileID+"';");
        this.profileName = data.get(0)[0];
        this.dateOfBirth = data.get(0)[1];
        this.profileID = Integer.parseInt(data.get(0)[2]);


    }


    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSubScriberID() {
        return subScriberID;
    }

    public void setSubScriberID(int subScriberID) {
        this.subScriberID = subScriberID;
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public String getSubScriberName() {
        return subScriberName;
    }

    public void setSubScriberName(String subScriberName) {
        this.subScriberName = subScriberName;
    }
}
