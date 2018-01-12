package com.nfs.userinterface;

import com.nfs.connections.DatabaseFetcher;
import javax.swing.*;
import java.awt.*;
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
        currentUser.currentSubscribers = subs;
        int i = 0;

        this.subscriberArray = new String[subs.size()];

        for (String[] container:subs) {
            this.subscriberArray[i] = container[1];
            i++;
        }

        this.subscriberDropdown = new JComboBox<>(subscriberArray);
    }

    public JPanel createSubscriberDropdownPanel() {

        //Profile dropdowns
        JPanel dropdowns = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Label subscriber combobox
        JLabel subscriberLabel = new JLabel("Account: ");
        c.gridx = 0;
        c.weightx = 0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        dropdowns.add(subscriberLabel, c);

        //Combobox subscribers
        c.gridx = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_END;
        dropdowns.add(this.subscriberDropdown, c);

        return dropdowns;
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
