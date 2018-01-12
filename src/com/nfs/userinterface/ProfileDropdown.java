package com.nfs.userinterface;

import com.nfs.connections.DatabaseFetcher;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import com.nfs.data.currentUser;

public class ProfileDropdown extends JComboBox {
    private String[] profileArray ;
    private JComboBox<String> profileDropdown;

    public ProfileDropdown()    {

        DatabaseFetcher con = new DatabaseFetcher();
        ArrayList<String[]> subs = con.getDataReturnArrayList("SELECT SubscriberID, ProfileName FROM UserProfile WHERE SubscriberID = '" + currentUser.currentSubscriber + "';");
        int i = 0;
        currentUser.currentProfiles = subs;
        this.profileArray = new String[subs.size()];

        for (String[] container:subs) {
            this.profileArray[i] = container[1];
            i++;
        }

        this.profileDropdown = new JComboBox<>(profileArray);
    }


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

    private String getSelectedIem() {
        return profileArray[profileDropdown.getSelectedIndex()];
    }

    public void updateValues(){
        int i = 0;

        this.profileArray = new String[currentUser.currentProfiles.size()];

        for (String[] container:currentUser.currentProfiles) {
            this.profileArray[i] = container[1];
            i++;
        }

        this.profileDropdown = new JComboBox<>(profileArray);
    }

}
