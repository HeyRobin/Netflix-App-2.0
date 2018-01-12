package com.nfs.userinterface;

import javax.swing.*;

public class Interface {


    public static JMenuBar createTopMenuBar()  {

        //Declarations
        JMenuBar topMenuBar = new JMenuBar();
        JMenu accountMenu = new JMenu("Account");
        JMenuItem loginMenuItem = new JMenuItem("Inloggen");
        JMenuItem logoutMenuItem = new JMenuItem("Afmelden");

        //Add Items to Menu Account
        accountMenu.add(loginMenuItem);
        accountMenu.add(logoutMenuItem);
        topMenuBar.add(accountMenu);

        //Return Menu Bar
        return topMenuBar;
    }
}
