package com.nfs.userinterface;
import com.nfs.connections.DatabaseFetcher;

import javax.swing.*;
import java.util.ArrayList;
import com.nfs.data.currentUser;

public class ProfileDropdown extends JComboBox {
    private String[] profileArray ;
    private JComboBox<String> profileDropdown;

    public ProfileDropdown()    {
        DatabaseFetcher con = new DatabaseFetcher();
        ArrayList<String[]> subs = con.getDataReturnArrayList("SELECT SubscriberID, ProfileName FROM UserProfile WHERE SubscriberID = '" + currentUser.currentSubscriber + "';");
        int i = 0;
        currentUser.currentProfs = subs;

        this.profileArray = new String[subs.size()];
        for (String[] container:subs
                ) {this.profileArray[i] = container[1]; i++;

        };
        this.profileDropdown = new JComboBox<>(profileArray);
    }

    public JComboBox createProfileDropdown() {

        this.profileDropdown.setSelectedIndex(0);


        return this.profileDropdown;
    }

    private String getSelectedIem() {
        return profileArray[profileDropdown.getSelectedIndex()];
    }

    public void updateValues(){
        int i = 0;

        this.profileArray = new String[currentUser.currentProfs.size()];
        for (String[] container:currentUser.currentProfs
                ) {this.profileArray[i] = container[1]; i++;

        };
        this.profileDropdown = new JComboBox<>(profileArray);

    }
}
