package com.netflixstatistix.userinterface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI implements Runnable {

    // Initializing different classes
    private AppDetails appDetails = new AppDetails();
    private TimeKeeper timeKeeper = new TimeKeeper();

    // Makkelijke variabele voor grijze achtergrond
    private Border grey = BorderFactory.createLineBorder(Color.lightGray);

    // Creating JFrame which acts as main container.
    private JFrame frame;


    @Override
    public void run() {

        //Title of UI
        this.frame = new JFrame("Netflix Statistix Version " + new AppDetails().getVersion());

        //Shaping the UI
        this.frame.setSize(new Dimension(800, 800));
        this.frame.setMinimumSize(new Dimension(650, 650));
        this.frame.setResizable(true);

        //Set action when closed
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Fills the UI
        createComponents(this.frame.getContentPane());

        this.frame.pack();

        //Centers the window relative to the screen
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    private void createComponents(Container container) {

//Top Menu Bar
        // Initiates the top menu bar
        JMenuBar topMenuBar = new JMenuBar();

        // Menu for Account
        JMenu accountMenu = new JMenu("Account");

        //Items for Menu Account
        JMenuItem loginMenuItem = new JMenuItem("Inloggen");
        JMenuItem logoutMenuItem = new JMenuItem("Afmelden");

        //Add Items to Menu Account
        accountMenu.add(loginMenuItem);
        accountMenu.add(logoutMenuItem);

        // Menu for Info
        JMenu infoMenu = new JMenu("Info");

        //Items for Menu Info
        JMenuItem avansItemMenu = new JMenuItem("Avans website");
        JMenuItem aboutItemMenu = new JMenuItem("Over deze app");

        //Add items to Menu Info
        infoMenu.add(avansItemMenu);
        infoMenu.add(aboutItemMenu);

        // Add Account-menu and Info-Menu to the top menu bar
        topMenuBar.add(accountMenu);
        topMenuBar.add(infoMenu);

        // Set JMenuBar for this frame
        this.frame.setJMenuBar(topMenuBar);

        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

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
        JButton show10 = new JButton("Ober");
        show9.setMargin(new Insets(5, 0, 5, 0));
        JButton show11 = new JButton("Der Untergang");
        show9.setMargin(new Insets(5, 0, 5, 0));
        JButton show12 = new JButton("De helaasheid der dingen");
        show9.setMargin(new Insets(5, 0, 5, 0));
        JButton show13 = new JButton("A Clockwork Orange");
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
        showSubContainer.add(show10, gbc);
        showSubContainer.add(show11, gbc);
        showSubContainer.add(show12, gbc);
        showSubContainer.add(show13, gbc);

        JPanel westContainer = new JPanel(new BorderLayout());
        westContainer.setBorder(grey);
        westContainer.add(userContainer, BorderLayout.NORTH);
        westContainer.add(showSubContainer, BorderLayout.SOUTH);

        pane.add(westContainer, BorderLayout.WEST);

//Credits Bar bottom
        //Create panel for labels
        JPanel creditsContainer = new JPanel(new BorderLayout());
        creditsContainer.setBorder(new EmptyBorder(3, 10, 3, 10));

        //Create Labels with information
        JLabel creditsAppVersion = new JLabel("Netflix Statistix versie " + appDetails.getVersion(), JLabel.LEFT);
        JLabel credits = new JLabel("Informatica 2017 - Klas E - " + appDetails.getAuthors(), JLabel.RIGHT);

        //Add labels to the container
        creditsContainer.add(creditsAppVersion, BorderLayout.WEST);
        creditsContainer.add(credits, BorderLayout.EAST);

        //add container to pane
        pane.add(creditsContainer, BorderLayout.SOUTH);
    }
}