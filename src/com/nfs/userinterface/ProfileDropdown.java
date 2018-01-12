package com.nfs.userinterface;
import javax.swing.*;

public class ProfileDropdown extends JComboBox {
    private String[] userArray ;
    private JComboBox<String> profileDropdown;

    public ProfileDropdown()    {
        this.userArray = new String[] {"Sander", "Robin", "Jac"};
        this.profileDropdown = new JComboBox<>(userArray);
    }

    public JComboBox createProfileDropdown() {

        this.profileDropdown.setSelectedIndex(0);


        return this.profileDropdown;
    }

    private String getSelectedIem() {
        return userArray[profileDropdown.getSelectedIndex()];
    }
}
