package com.nfs.userinterface;

import com.nfs.connections.DatabaseFetcher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import com.nfs.data.CurrentUser;

public class SubscriberDropdown extends JComboBox {



    public static int subscriberID;
    private String[] subscriberArray;
    private JComboBox<String> subscriberDropdown;



    public SubscriberDropdown()    {


        //Makes a new database fetcher object to retrieve data
        DatabaseFetcher con = new DatabaseFetcher();



        //Results are stored in an ArrayList which gets object in the form of a String array
        //One String array contains one row of retrieved data from the query
        String query = "SELECT SubscriberID, Name FROM Subscriber";
        ArrayList<String[]> subscribers = con.getDataReturnArrayList(query);



        //Stores all the current subscribers to the CurrentUser class in the currentSubscribers variable
        CurrentUser.currentSubscribers = subscribers;



        //Set the current Subscriber to the first in the list
        CurrentUser.currentSubscriber = Integer.parseInt(subscribers.get(0)[0]);



        //Defines how big the new subscriberArray should be
        this.subscriberArray = new String[subscribers.size()];



        //Set-up for the for-loop
        int i = 0;



        //Fills the subscriberArray with data
        for (String[] subscriber : subscribers) {



            //Puts all the necessary data from one subscriber in a string format
            String subscriberData = subscriber[1];

            //puts the subscriber data in one slot of the subsciberArray
            this.subscriberArray[i] = subscriberData;
            i++;


        }


        //Create a new subscriberDropdown with the data from the SubscriberArray
        this.subscriberDropdown = new JComboBox<>(subscriberArray);




        //Adds an ActionListener to the dropdown menu of subscribers.
        this.subscriberDropdown.addItemListener(new ItemListener() {


            @Override
            public void itemStateChanged(ItemEvent e) {


                //Loops through all the subscribers in the Database
                for (String[] subscriber : subscribers) {



                    //If the iterated subscriber matches the current selected subscriber, then the Current Subscriber is
                    //set to the selected subscriber
                    if (getSelectedSubscriber().equals( (subscriber[1]))) {
                        CurrentUser.setCurrentSubscriber(Integer.parseInt(subscriber[0]));
                    }


                }

                //Updates the profiles to match the current subscribers' profiles
                ProfileDropdown.updateProfiles();

            }

        });
    }




    //Creates the subscriber dropdown + 'Account' label
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



    //Return the current selected subscriber from the combobox
    private String getSelectedSubscriber() {
        return subscriberArray[subscriberDropdown.getSelectedIndex()];
    }



}
