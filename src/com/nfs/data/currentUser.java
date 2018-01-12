package com.nfs.data;

public class currentUser {
   static public int currentSubscriber;
   static public int currentProfile;

    public static void setCurrentSubscriber(int subscriberID){
        currentSubscriber = subscriberID;
    }

    public static void setCurrentProfile(int profileID){
        currentProfile = profileID;
    }
}
