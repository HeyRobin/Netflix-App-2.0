package com.nfs.data;

import java.util.ArrayList;

public class currentUser {
   static public int currentSubscriber;
   static public int currentProfile;
   static public ArrayList<String[]> currentSubs;
   static public ArrayList<String[]> currentProfs;


    public static void setCurrentSubscriber(int subscriberID){
        currentSubscriber = subscriberID;
    }

    public static void setCurrentProfile(int profileID){
        currentProfile = profileID;
    }
}
