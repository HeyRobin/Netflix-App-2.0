package com.nfs.data;

import com.nfs.connections.DatabaseConnection;
import com.nfs.connections.DatabaseFetcher;


import java.sql.ResultSet;
import java.util.ArrayList;

public class Subscriber {

    private int subScriberID;
    private ArrayList<Profile> profileContainer;
    private String name;
    private String street;
    private String zipcode;
    private String city;
    private String houseNr;
    private String houseNrExt;

    public Subscriber(int subScriberID){

        DatabaseFetcher con = new DatabaseFetcher();

        ArrayList<String[]> accountData = con.getDataReturnArrayList("SELECT NameExt,Street,PostalCode,City,HouseNr,HouseNrExt FROM Subscriber WHERE SubscriberID = '" + subScriberID + "';");

            this.subScriberID = subScriberID;
            this.name = accountData.get(0)[0];
            this.street = accountData.get(0)[1];
            this.zipcode = accountData.get(0)[2];
            this.city = accountData.get(0)[3];
            this.houseNr = accountData.get(0)[4];
            this.houseNrExt = accountData.get(0)[5];
            if (this.houseNrExt == null){
                this.houseNrExt = "";
            }

            ArrayList<String[]> profileData = con.getDataReturnArrayList("SELECT ProfileID FROM UserProfile WHERE SubScriberID = '" + this.subScriberID + "'");

            this.profileContainer = new ArrayList<Profile>();

        for (String[] profiel:profileData
             ) {profileContainer.add(new Profile(this.subScriberID, Integer.parseInt(profiel[0])));
        }


    }

    public int getSubScriberID() {
        return subScriberID;
    }

    public void setSubScriberID(int subScriberID) {
        this.subScriberID = subScriberID;
    }

    public ArrayList<Profile> getProfileContainer() {
        return profileContainer;
    }

    public void setProfileContainer(ArrayList<Profile> profileContainer) {
        this.profileContainer = profileContainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    public String getHouseNrExt() {
        return houseNrExt;
    }

    public void setHouseNrExt(String houseNrExt) {
        this.houseNrExt = houseNrExt;
    }
}