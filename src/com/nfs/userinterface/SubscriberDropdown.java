package com.nfs.userinterface;

import javax.swing.*;

public class SubscriberDropdown extends JComboBox {

    private String[] subscriberArray;
    private JComboBox<String> subscriberDropdown;

    public SubscriberDropdown()    {
        this.subscriberArray = new String[] {"Sander", "Robin", "Jac"};
        this.subscriberDropdown = new JComboBox<>(subscriberArray);
    }

    public JComboBox createSubscriberDropdown() {
        this.subscriberDropdown.setSelectedIndex(0);

        return this.subscriberDropdown;
    }

    private String getSelectedSubscriber() {
        return subscriberArray[subscriberDropdown.getSelectedIndex()];
    }
}
