package com.netflixstatistix.userinterface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.FixedHeightLayoutCache;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements Runnable {

    // Initializing different classes
    private AppDetails appDetails = new AppDetails();
    private TimeKeeper timeKeeper = new TimeKeeper();

    // Don't Copy Yourself
    private final Border grey = BorderFactory.createLineBorder(Color.lightGray);

    // Creating JFrame which acts as main container.
    private JFrame frame;

    //Creating JLabel variable for the right menu to display data
    private JLabel information;

    //Buttons for the shows
    private JButton buttonSherlock;
    private JButton buttonBB;
    private JButton buttonFargo;
    private JButton buttonTLOB;
    private JButton buttonPF;
    private JButton buttonPruim;
    private JButton buttonRD;
    private JButton buttonGBU;
    private JButton buttonAWD;
    private JButton buttonOber;
    private JButton buttonUntergang;
    private JButton buttonHelaas;
    private JButton buttonACO;

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
        information = new JLabel(timeKeeper.greeting(), JLabel.CENTER);
        information.setFont(new Font("Arial", Font.BOLD, 36));
        information.setBorder(grey);
        pane.add(information, BorderLayout.CENTER);

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

        //Initializes ButtonListener
        ButtonListener bl = new ButtonListener();

        //SERIES
        buttonSherlock= new JButton("Sherlock");
        buttonSherlock.setMargin(new Insets(5, 0, 5, 0));
        buttonSherlock.addActionListener(bl);
        buttonBB = new JButton("Breaking Bad");
        buttonBB.setMargin(new Insets(5, 0, 5, 0));
        buttonBB.addActionListener(bl);
        buttonFargo = new JButton("Fargo");
        buttonFargo.setMargin(new Insets(5, 0, 5, 0));
        buttonFargo.addActionListener(bl);

        //FILMS
        buttonTLOB = new JButton("The Life Of Brian");
        buttonTLOB.setMargin(new Insets(5, 0, 5, 0));
        buttonTLOB.addActionListener(bl);
        buttonPF = new JButton("Pulp Fiction");
        buttonPF.setMargin(new Insets(5, 0, 5, 0));
        buttonPF.addActionListener(bl);
        buttonPruim = new JButton("Pruimenbloesem");
        buttonPruim.setMargin(new Insets(5, 0, 5, 0));
        buttonPruim.addActionListener(bl);
        buttonRD = new JButton("Reservoir Dogs");
        buttonRD.setMargin(new Insets(5, 0, 5, 0));
        buttonRD.addActionListener(bl);
        buttonGBU = new JButton("The Good, the Bad and the Ugly");
        buttonGBU.setMargin(new Insets(5, 0, 5, 0));
        buttonGBU.addActionListener(bl);
        buttonAWD = new JButton("Andy Warhol's Dracula");
        buttonAWD.setMargin(new Insets(5, 0, 5, 0));
        buttonAWD.addActionListener(bl);
        buttonOber = new JButton("Ober");
        buttonOber.setMargin(new Insets(5, 0, 5, 0));
        buttonOber.addActionListener(bl);
        buttonUntergang = new JButton("Der Untergang");
        buttonUntergang.setMargin(new Insets(5, 0, 5, 0));
        buttonUntergang.addActionListener(bl);
        buttonHelaas = new JButton("De helaasheid der dingen");
        buttonHelaas.setMargin(new Insets(5, 0, 5, 0));
        buttonHelaas.addActionListener(bl);
        buttonACO = new JButton("A Clockwork Orange");
        buttonACO.setMargin(new Insets(5, 0, 5, 0));
        buttonACO.addActionListener(bl);

        showSubContainer.add(buttonSherlock, gbc);
        showSubContainer.add(buttonBB, gbc);
        showSubContainer.add(buttonFargo, gbc);
        showSubContainer.add(buttonTLOB, gbc);
        showSubContainer.add(buttonPF, gbc);
        showSubContainer.add(buttonPruim, gbc);
        showSubContainer.add(buttonRD, gbc);
        showSubContainer.add(buttonGBU, gbc);
        showSubContainer.add(buttonAWD, gbc);
        showSubContainer.add(buttonOber, gbc);
        showSubContainer.add(buttonUntergang, gbc);
        showSubContainer.add(buttonHelaas, gbc);
        showSubContainer.add(buttonACO, gbc);

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

    private class ButtonListener implements ActionListener   {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Determine the source of the action performed
            if (e.getSource() == buttonSherlock)    {
                information = new JLabel("Sherlock Holmes", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonSherlock.setEnabled(false);
            } else if (e.getSource() == buttonBB)   {
                information.setText("Breaking Bad");// = new JLabel("Breaking Bad", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonBB.setEnabled(false);
            } else if (e.getSource() == buttonFargo)    {
                information = new JLabel("Fargo", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonFargo.setEnabled(false);
            } else if ((e.getSource() == buttonTLOB)) {
                information = new JLabel("The Life Of Brian", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonTLOB.setEnabled(false);
            } else if (e.getSource() == buttonPF)   {
                information = new JLabel("Pulp Fiction", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonPF.setEnabled(false);
            } else if (e.getSource() == buttonPruim)    {
                information = new JLabel("Vieze porno", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonPruim.setEnabled(false);
            } else if (e.getSource() == buttonRD)   {
                information = new JLabel("Resevoir Dogs", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonRD.setEnabled(false);
            } else if (e.getSource() == buttonGBU)  {
                information = new JLabel("The Good, The Bad, The Ugly", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonGBU.setEnabled(false);
            } else if (e.getSource() == buttonAWD)  {
                information = new JLabel("Dracula", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonAWD.setEnabled(false);
            } else if (e.getSource() == buttonOber) {
                information = new JLabel("Ober", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonOber.setEnabled(false);
            } else if (e.getSource() == buttonUntergang)    {
                information = new JLabel("Der Untergang", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonUntergang.setEnabled(false);
            } else if (e.getSource() == buttonHelaas)   {
                information = new JLabel("De Helaasheid der dingen", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonHelaas.setEnabled(false);
            } else if (e.getSource() == buttonACO)  {
                information = new JLabel("A Clockwork Orange", JLabel.CENTER);
                setAllButtonsEnabled();
                buttonACO.setEnabled(false);
            }
        }

        private void setAllButtonsEnabled()  {
            buttonSherlock.setEnabled(true);
            buttonBB.setEnabled(true);
            buttonFargo.setEnabled(true);
            buttonTLOB.setEnabled(true);
            buttonPF.setEnabled(true);
            buttonPruim.setEnabled(true);
            buttonRD.setEnabled(true);
            buttonGBU.setEnabled(true);
            buttonAWD.setEnabled(true);
            buttonOber.setEnabled(true);
            buttonUntergang.setEnabled(true);
            buttonHelaas.setEnabled(true);
            buttonACO.setEnabled(true);
        }
    }
}