package com.nfs.userinterface;

import com.nfs.connections.DatabaseFetcher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import com.nfs.data.CurrentUser;


public class ProfileDropdown extends JComboBox {
    private String[] profileArray ;
    private static JComboBox<String> profileDropdown;

    public ProfileDropdown()    {


        //Adds the profiles from getprofiles() to a new ArrayList
        ArrayList<String[]> profiles = getProfiles();



        //Defines how big the new profiledropdown should be
        int currentProfilesSize = profiles.size();
        this.profileArray = new String[currentProfilesSize];



        //Set-up for the for-loop
        int i = 0;



        //Fills the profileArray with data
        for (String[] profile : profiles) {



            //Puts the profile name (stored at profile[1]) in the profileArray at spot [i]
            this.profileArray[i] = profile[1];
            i++;


        }



        //Creates an new profileDropdown with the data gathered from the for-loop
        profileDropdown = new JComboBox<>(profileArray);



        //Add a new itemlistener to the combobox
        profileDropdown.addItemListener(new ItemListener() {


            @Override
            public void itemStateChanged(ItemEvent e) {


                //Loops through all the profiles
                for (String[] profile : CurrentUser.currentProfiles)  {

                    //if the current profile equals the iterated profile, then the Current profile from
                    //CurrentUser.currentProfile is set to the active profile.
                    if (getSelectedIem().equals(profile[1]))    {
                        CurrentUser.currentProfile =  Integer.parseInt(profile[2]);
                        System.out.println(profile[2]);
                    }
                }


            }
        });


    }

    public static void updateProfiles()    {

        //Creates an new profile array with new profiles
        String[] newProfileArray = new String[getProfiles().size()];


        //Loops through all the profiles of the current subscriber
        int i = 0;
        for (String[] profile : CurrentUser.currentProfiles)  {

            newProfileArray[i] = profile[1];
            i++;

        }


        //Adds the new subscribers to the combobox via a new combobox model
        DefaultComboBoxModel model = new DefaultComboBoxModel( newProfileArray );
        profileDropdown.setModel(model);


        profileDropdown.addItemListener(new ItemListener() {


            @Override
            public void itemStateChanged(ItemEvent e) {


                //Loops through all the profiles
                for (String[] profile : CurrentUser.currentProfiles)  {

                    //if the current profile equals the iterated profile, then the Current profile from
                    //CurrentUser.currentProfile is set to the active profile.
                    if (profileDropdown.getSelectedItem().equals(profile[1]))    {
                        CurrentUser.currentProfile =  Integer.parseInt(profile[2]);
                    }
                }


            }
        });

    }


    //Gets all the profiles corresponding to the current subscriber
    private static ArrayList<String[]> getProfiles()  {



        //Makes a new database fetcher object to retrieve data
        DatabaseFetcher con = new DatabaseFetcher();



        //Results are stored in an ArrayList which gets object in the form of a String array
        //One String array contains one row of retrieved data from the query
        String query = "SELECT SubscriberID, ProfileName, profileID FROM UserProfile WHERE SubscriberID = '" + CurrentUser.currentSubscriber + "';";
        ArrayList<String[]> profiles = con.getDataReturnArrayList(query);


        //Sets the current profiles from CurrentUser to the profiles gathered by the query
        CurrentUser.currentProfiles = profiles;



        return profiles;
    }



    //Crreate the actual dropdown and label
    public JPanel createProfileDropdown() {

        //Profile dropdowns
        JPanel dropdowns = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Label profile combobox
        JLabel profileLabel = new JLabel("Profiel: ");
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0,0,0,5);
        dropdowns.add(profileLabel, c);

        //Combobox profile
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(0,5,0,0);
        dropdowns.add(this.profileDropdown, c);

        return dropdowns;
    }


    //Return the selected item from the combobox
    private String getSelectedIem() {
        return profileArray[profileDropdown.getSelectedIndex()];
    }



}
