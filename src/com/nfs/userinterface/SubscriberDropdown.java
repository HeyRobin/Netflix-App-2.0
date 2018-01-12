package com.nfs.userinterface;

import com.nfs.connections.DatabaseFetcher;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.nfs.data.currentUser;

public class SubscriberDropdown extends JComboBox {
    public static int subscriberID;
    private String[] subscriberArray;
    private JComboBox<String> subscriberDropdown;

    public SubscriberDropdown()    {
        DatabaseFetcher con = new DatabaseFetcher();
        ArrayList<String[]> subs = con.getDataReturnArrayList("SELECT SubscriberID, Name FROM Subscriber");
        currentUser.currentSubs = subs;
        int i = 0;

        this.subscriberArray = new String[subs.size()];
        for (String[] container:subs
             ) {this.subscriberArray[i] = container[1]; i++;

        }


        this.subscriberDropdown = new JComboBox<>(subscriberArray);



    }

    public JComboBox createSubscriberDropdown() {
        this.subscriberDropdown.setSelectedIndex(0);

        return this.subscriberDropdown;
    }

    private String getSelectedSubscriber() {
        return subscriberArray[subscriberDropdown.getSelectedIndex()];
    }

    public static int getSubscriberID() {
        return subscriberID;
    }

    public static void setSubscriberID(int subscriberID) {
        SubscriberDropdown.subscriberID = subscriberID;
    }

    public String[] getSubscriberArray() {
        return subscriberArray;
    }

    public void setSubscriberArray(String[] subscriberArray) {
        this.subscriberArray = subscriberArray;
    }

    public JComboBox<String> getSubscriberDropdown() {
        return subscriberDropdown;
    }

    public void setSubscriberDropdown(JComboBox<String> subscriberDropdown) {
        this.subscriberDropdown = subscriberDropdown;
    }
}
