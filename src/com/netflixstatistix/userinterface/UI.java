package com.netflixstatistix.userinterface;

import com.netflixstatistix.connections.DatabaseConnection;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

/*
    Pas alle objectnamen aan, aangezien Bas hoogstwaarschijnlijk dezelfde namen zal gebruiken.
    Dit in verband met plagiaat.
 */

public class UI implements Runnable /*, ActionListener */ {
    // Initializing different classes
    private AppDetails appDetails = new AppDetails();
    private TimeKeeper timeKeeper = new TimeKeeper();

    // Makkelijke variabele voor grijze achtergrond
    private Border grey = BorderFactory.createLineBorder(Color.lightGray);

    // Creating JFrame which acts as main container.
    private JFrame frame;
    private JMenuBar topMenuBar;
    private JMenu accountMenu;
    private JMenuItem loginMenuItem;
    private JMenuItem logoutMenuItem;
    private JMenu infoMenu;
    private JMenuItem avansItemMenu;
    private JMenuItem aboutItemMenu;

    private boolean loggedIn;

    @Override
    public void run() {
        this.frame = new JFrame("Netflix Statistix");
        this.frame.setPreferredSize(new Dimension(800, 800));
        this.frame.setMinimumSize(new Dimension(650, 500));
        this.frame.setResizable(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        // For testing purposes set loggedIn to true                                                //<< TESTING SETTING
        loggedIn = false;

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

//TOPMENU
        // build the menu bar container
        JMenuBar topMenuBar = new JMenuBar();

        // Build the account menu
        accountMenu = new JMenu("Account");

        // login
        loginMenuItem = new JMenuItem("Inloggen");
        loginMenuItem.setEnabled(loggedIn);                                                         //<< TESTING SETTING
        accountMenu.add(loginMenuItem);

        // logout
        logoutMenuItem = new JMenuItem("Afmelden");
        logoutMenuItem.setEnabled(!loggedIn);                                                       //<< TESTING SETTING
        accountMenu.add(logoutMenuItem);

        // Build the info menu
        infoMenu = new JMenu("Info");

        // Avans website
        avansItemMenu = new JMenuItem("Avans website");
        infoMenu.add(avansItemMenu);

        // about the app
        aboutItemMenu = new JMenuItem("Over deze app");
        infoMenu.add(aboutItemMenu);

        // add menus to menubar
        topMenuBar.add(accountMenu);
        topMenuBar.add(infoMenu);

        frame.setJMenuBar(topMenuBar);
//END TOPMENU

//GUI
    //Right Menu
        //Greeting
        JLabel label1 = new JLabel(timeKeeper.greeting(), JLabel.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 36));
        label1.setBorder(grey);
        pane.add(label1, BorderLayout.CENTER);

    //left menu
        //User Dropdown Menu
        JPanel userContainer = new JPanel(new BorderLayout());

        String[] userArray = {"Sander", "Robin", "Jac"};        //NAMEN VAN PROFIELEN VAN ABONNEMENT HIER.
        JComboBox usersDropdown = new JComboBox(userArray);
        usersDropdown.setSelectedIndex(0);
        userContainer.add(usersDropdown, BorderLayout.NORTH);

        // UserDetails Menu
        JPanel userSubContainer = new JPanel(new BorderLayout());
        userSubContainer.setBorder(new EmptyBorder(20, 20, 20, 20));
        JLabel greeting = new JLabel(timeKeeper.greeting() + " " + usersDropdown.getSelectedItem(), JLabel.CENTER);
        greeting.setFont(new Font("Arial", Font.PLAIN, 18));
        userSubContainer.add(greeting);

        userContainer.add(userSubContainer, BorderLayout.SOUTH);

        // TV-Show Selector
        JPanel showSubContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //SERIES
        JButton show1 = new JButton("Sherlock");
        show1.setMargin(new Insets(5, 0, 5, 0));

        //Commando om Sherlock te weergeven
        show1.setActionCommand("showSherlock");
        JButton show2 = new JButton("Breaking Bad");
        show2.setMargin(new Insets(5, 0, 5, 0));
        JButton show3 = new JButton("Fargo");
        show3.setMargin(new Insets(5, 0, 5, 0));

        //FILMS
        JButton show4 = new JButton("The Life Of Brian");
        show4.setMargin(new Insets(5, 0, 5, 0));
        JButton show5 = new JButton("Pulp Fiction");
        show5.setMargin(new Insets(5, 0, 5, 0));
        JButton show6 = new JButton("Pruimenbloesem");
        show6.setMargin(new Insets(5, 0, 5, 0));
        JButton show7 = new JButton("Reservoir Dogs");
        show7.setMargin(new Insets(5, 0, 5, 0));
        JButton show8 = new JButton("The Good, the Bad and the Ugly");
        show8.setMargin(new Insets(5, 0, 5, 0));
        JButton show9 = new JButton("Andy Warhol's Dracula");
        show9.setMargin(new Insets(5, 0, 5, 0));

        showSubContainer.add(show1, gbc);
        showSubContainer.add(show2, gbc);
        showSubContainer.add(show3, gbc);
        showSubContainer.add(show4, gbc);
        showSubContainer.add(show5, gbc);
        showSubContainer.add(show6, gbc);
        showSubContainer.add(show7, gbc);
        showSubContainer.add(show8, gbc);
        showSubContainer.add(show9, gbc);

        JPanel westContainer = new JPanel(new BorderLayout());
        westContainer.setBorder(grey);
        westContainer.add(userContainer, BorderLayout.NORTH);
        westContainer.add(showSubContainer, BorderLayout.SOUTH);

        pane.add(westContainer, BorderLayout.WEST);

        // Build the credits menu
        JPanel creditsContainer = new JPanel(new BorderLayout());
        creditsContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        JLabel creditsAppVersion = new JLabel("Netflix Statistix versie " + appDetails.getVersion(), JLabel.LEFT);
        JLabel credits = new JLabel("Informatica 2017 - Klas E - " + appDetails.getAuthors(), JLabel.RIGHT);
        creditsContainer.add(creditsAppVersion, BorderLayout.WEST);
        creditsContainer.add(credits, BorderLayout.EAST);
        pane.add(creditsContainer, BorderLayout.SOUTH);

//END GUI
    }

    public JFrame getFrame() {
        return frame;
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if ("showSherlock".equals(e.getActionCommand()))    {
//
//        }
//    }
}
