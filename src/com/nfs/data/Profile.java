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
                + subscriberID + "' AND ProfileID = '" + profileID +"';");

        ArrayList<String[]> data = con.getDataReturnArrayList("SELECT ProfileName, DateOfBirth, ProfileID FROM UserProfile WHERE SubscriberID = '"
                + subscriberID + "' AND ProfileID = '" + profileID +"';");


        System.out.println(data.size());


        this.profileName = data.get(0)[0];
        this.dateOfBirth = data.get(0)[1];
        this.profileID = Integer.parseInt(data.get(0)[2]);

    }



    public String getProfileName() {
        return profileName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getSubScriberID() {
        return subScriberID;
    }

    public int getProfileID() {
        return profileID;
    }

    public String getSubScriberName() {
        return subScriberName;
    }
}
