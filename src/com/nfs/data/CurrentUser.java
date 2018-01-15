package com.nfs.data;

import java.util.ArrayList;

public class CurrentUser {
   static public int currentSubscriber;
   static public int currentProfile;
   static public ArrayList<String[]> currentSubscribers;
   static public ArrayList<String[]> currentProfiles;


    public static void setCurrentSubscriber(int subscriberID){
        currentSubscriber = subscriberID;
    }

    public static void setCurrentProfile(int profileID) {
        currentProfile = profileID;
    }
}
