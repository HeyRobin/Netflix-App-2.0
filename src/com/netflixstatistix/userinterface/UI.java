package com.netflixstatistix.userinterface;

import com.netflixstatistix.connections.DatabaseFetcher;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class UI implements Runnable {

    // Initializing different classes
    private AppDetails appDetails = new AppDetails();
    private TimeKeeper timeKeeper = new TimeKeeper();

    private final Border grey = BorderFactory.createLineBorder(Color.lightGray);

    // Creating JFrame which acts as main container.
    private JFrame frame;

    private JComboBox usersDropdown;

    //Creating the greeting label
    private JLabel greeting;

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

    //Initializes the Database Fetcher
    private DatabaseFetcher dbf = new DatabaseFetcher();

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

        //PlaceHolder. Profiles of Subscription.
        String[] userArray = {"Sander", "Robin", "Jac"};
        usersDropdown = new JComboBox(userArray);
        usersDropdown.setSelectedIndex(0);
        userContainer.add(usersDropdown, BorderLayout.NORTH);

        // UserDetails Menu
        JPanel userSubContainer = new JPanel(new BorderLayout());
        userSubContainer.setBorder(new EmptyBorder(20, 20, 20, 20));

        //Formatting the greetins Label
        greeting = new JLabel(timeKeeper.greeting() + " " + userArray[usersDropdown.getSelectedIndex()], JLabel.CENTER);
        greeting.setFont(new Font("Arial", Font.PLAIN, 18));

        ItemListener il = new ItemListener();
        usersDropdown.addItemListener(il);

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

                //Placeholder
                information.setText("Sherlock Holmes");

                //First enable previous disabled button, then disable current button
                setAllButtonsEnabled();
                buttonSherlock.setEnabled(false);

                //Get data from database
                dbf.getInformationAboutSherlock();

            } else if (e.getSource() == buttonBB)   {
                information.setText("Breaking Bad");
                setAllButtonsEnabled();
                buttonBB.setEnabled(false);
                dbf.getInformationAboutBreakingBad();

            } else if (e.getSource() == buttonFargo)    {
                information.setText("Fargo");
                setAllButtonsEnabled();
                buttonFargo.setEnabled(false);
                dbf.getInformationAboutFargo();

            } else if ((e.getSource() == buttonTLOB)) {
                information.setText("The Life Of Brian");
                setAllButtonsEnabled();
                buttonTLOB.setEnabled(false);
                dbf.getInformationAboutTLOB();

            } else if (e.getSource() == buttonPF)   {
                information.setText("Pupl Fiction");
                setAllButtonsEnabled();
                buttonPF.setEnabled(false);
                dbf.getInformationAboutPF();

            } else if (e.getSource() == buttonPruim)    {
                information.setText("Vieze porno");
                setAllButtonsEnabled();
                buttonPruim.setEnabled(false);
                dbf.getInformationAboutPruim();

            } else if (e.getSource() == buttonRD)   {
                information.setText("Resevoir Dogs");
                setAllButtonsEnabled();
                buttonRD.setEnabled(false);
                dbf.getInformationAboutRD();

            } else if (e.getSource() == buttonGBU)  {
                information.setText("The Good, The Bad, The Ugly");
                setAllButtonsEnabled();
                buttonGBU.setEnabled(false);
                dbf.getInformationAboutGBU();

            } else if (e.getSource() == buttonAWD)  {
                information.setText("Dracula");
                setAllButtonsEnabled();
                buttonAWD.setEnabled(false);
                dbf.getInformationAboutAWD();

            } else if (e.getSource() == buttonOber) {
                information.setText("Ober");
                setAllButtonsEnabled();
                buttonOber.setEnabled(false);
                dbf.getInformationAboutOber();

            } else if (e.getSource() == buttonUntergang)    {
                information.setText("Der Untergang");
                setAllButtonsEnabled();
                buttonUntergang.setEnabled(false);
                dbf.getInformationAboutUntergang();

            } else if (e.getSource() == buttonHelaas)   {
                information.setText("De Helaasheid Der Dingen");
                setAllButtonsEnabled();
                buttonHelaas.setEnabled(false);
                dbf.getInformationAboutHelaas();

            } else if (e.getSource() == buttonACO)  {
                information.setText("A Clockwork Orange");
                setAllButtonsEnabled();
                buttonACO.setEnabled(false);
                dbf.getInformationAboutACO();
            }
        }

        private void setAllButtonsEnabled()  {

            //Sets all the buttons to enabled
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

    private class ItemListener implements java.awt.event.ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            //Changes text of label greeting when profile is changed
            greeting.setText(timeKeeper.greeting() + " " + usersDropdown.getSelectedItem());
        }
    }
}