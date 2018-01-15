package com.nfs.data;

import com.nfs.connections.DatabaseFetcher;
import java.util.ArrayList;

public class Profile {
    private String profileName;
    private String dateOfBirth;
    private int subScriberID;
    private int profileID;
    private String subScriberName;



    public Profile(int subscriberID, int profileID) {

        DatabaseFetcher con = new DatabaseFetcher();


        this.subScriberName = con.getDataResultSingleCellAsString("SELECT Name FROM Subscriber WHERE SubscriberID = '" + subscriberID + "';");
        this.subScriberID = subscriberID;


        System.out.println("SELECT ProfileName, DateOfBirth, ProfileID FROM UserProfile WHERE SubscriberID = '"
                + CurrentUser.currentSubscriber + "' AND ProfileID = '" + CurrentUser.currentProfile +"';");

        ArrayList<String[]> data = con.getDataReturnArrayList("SELECT ProfileName, DateOfBirth, ProfileID FROM UserProfile WHERE SubscriberID = '"
                + CurrentUser.currentSubscriber + "' AND ProfileID = '" + CurrentUser.currentProfile +"';");


        System.out.println(data.size());


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
