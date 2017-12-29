package com.nfs.userinterface;

import com.nfs.databasefetcher.DatabaseFetcher;

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
    private JButton btnSHER;
    private JButton btnBREA;
    private JButton btnFARG;
    private JButton btnTLOB;
    private JButton btnPULP;
    private JButton btnPRUI;
    private JButton btnDOGS;
    private JButton btnGOOD;
    private JButton btnDRAC;
    private JButton btnOBER;
    private JButton btnUNTE;
    private JButton btnHELA;
    private JButton btnACLO;

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

        topMenuBar.add(accountMenu);

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
        btnSHER = new JButton("Sherlock");
        btnSHER.setMargin(new Insets(5, 0, 5, 0));
        btnSHER.addActionListener(bl);
        btnBREA = new JButton("Breaking Bad");
        btnBREA.setMargin(new Insets(5, 0, 5, 0));
        btnBREA.addActionListener(bl);
        btnFARG = new JButton("Fargo");
        btnFARG.setMargin(new Insets(5, 0, 5, 0));
        btnFARG.addActionListener(bl);

        //FILMS
        btnTLOB = new JButton("The Life Of Brian");
        btnTLOB.setMargin(new Insets(5, 0, 5, 0));
        btnTLOB.addActionListener(bl);
        btnPULP = new JButton("Pulp Fiction");
        btnPULP.setMargin(new Insets(5, 0, 5, 0));
        btnPULP.addActionListener(bl);
        btnPRUI = new JButton("Pruimenbloesem");
        btnPRUI.setMargin(new Insets(5, 0, 5, 0));
        btnPRUI.addActionListener(bl);
        btnDOGS = new JButton("Reservoir Dogs");
        btnDOGS.setMargin(new Insets(5, 0, 5, 0));
        btnDOGS.addActionListener(bl);
        btnGOOD = new JButton("The Good, the Bad and the Ugly");
        btnGOOD.setMargin(new Insets(5, 0, 5, 0));
        btnGOOD.addActionListener(bl);
        btnDRAC = new JButton("Andy Warhol's Dracula");
        btnDRAC.setMargin(new Insets(5, 0, 5, 0));
        btnDRAC.addActionListener(bl);
        btnOBER = new JButton("Ober");
        btnOBER.setMargin(new Insets(5, 0, 5, 0));
        btnOBER.addActionListener(bl);
        btnUNTE = new JButton("Der Untergang");
        btnUNTE.setMargin(new Insets(5, 0, 5, 0));
        btnUNTE.addActionListener(bl);
        btnHELA = new JButton("De helaasheid der dingen");
        btnHELA.setMargin(new Insets(5, 0, 5, 0));
        btnHELA.addActionListener(bl);
        btnACLO = new JButton("A Clockwork Orange");
        btnACLO.setMargin(new Insets(5, 0, 5, 0));
        btnACLO.addActionListener(bl);

        showSubContainer.add(btnSHER, gbc);
        showSubContainer.add(btnBREA, gbc);
        showSubContainer.add(btnFARG, gbc);
        showSubContainer.add(btnTLOB, gbc);
        showSubContainer.add(btnPULP, gbc);
        showSubContainer.add(btnPRUI, gbc);
        showSubContainer.add(btnDOGS, gbc);
        showSubContainer.add(btnGOOD, gbc);
        showSubContainer.add(btnDRAC, gbc);
        showSubContainer.add(btnOBER, gbc);
        showSubContainer.add(btnUNTE, gbc);
        showSubContainer.add(btnHELA, gbc);
        showSubContainer.add(btnACLO, gbc);

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
            if (e.getSource() == btnSHER)    {

                //Placeholder
                information.setText("Sherlock Holmes");

                //First enable previous disabled button, then disable current button
                setAllButtonsEnabled();
                btnSHER.setEnabled(false);

                //Get data from database
                information.setText(dbf.getInformationAboutShow("Sherlock"));

            } else if (e.getSource() == btnBREA)   {
                information.setText("Breaking Bad");
                setAllButtonsEnabled();
                btnBREA.setEnabled(false);
                information.setText(dbf.getInformationAboutShow("Breaking Bad"));

            } else if (e.getSource() == btnFARG)    {
                information.setText("Fargo");
                setAllButtonsEnabled();
                btnFARG.setEnabled(false);
                information.setText(dbf.getInformationAboutShow("Fargo"));

            } else if ((e.getSource() == btnTLOB)) {
                information.setText("The Life Of Brian");
                setAllButtonsEnabled();
                btnTLOB.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("The Life Of Brian"));

            } else if (e.getSource() == btnPULP)   {
                information.setText("Pulp Fiction");
                setAllButtonsEnabled();
                btnPULP.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("Pulp Fiction"));

            } else if (e.getSource() == btnPRUI)    {
                information.setText("Pruimenbloem");
                setAllButtonsEnabled();
                btnPRUI.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("Pruimenbloem"));

            } else if (e.getSource() == btnDOGS)   {
                information.setText("Resevoir Dogs");
                setAllButtonsEnabled();
                btnDOGS.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("Resevoir Dogs"));

            } else if (e.getSource() == btnGOOD)  {
                information.setText("The Good, The Bad, The Ugly");
                setAllButtonsEnabled();
                btnGOOD.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("The Good, The Bad, The Ugly"));

            } else if (e.getSource() == btnDRAC)  {
                information.setText("Dracula");
                setAllButtonsEnabled();
                btnDRAC.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("Dracula"));

            } else if (e.getSource() == btnOBER) {
                information.setText("Ober");
                setAllButtonsEnabled();
                btnOBER.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("Ober"));

            } else if (e.getSource() == btnUNTE)    {
                information.setText("Der Untergang");
                setAllButtonsEnabled();
                btnUNTE.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("Der Untergang"));

            } else if (e.getSource() == btnHELA)   {
                information.setText("De Helaasheid Der Dingen");
                setAllButtonsEnabled();
                btnHELA.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("De Helaasheid Der Dingen"));

            } else if (e.getSource() == btnACLO)  {
                information.setText("A Clockwork Orange");
                setAllButtonsEnabled();
                btnACLO.setEnabled(false);
                information.setText(dbf.getInformationAboutFilm("A Clockwork Orange"));
            }
        }

        private void setAllButtonsEnabled()  {

            //Sets all the buttons to enabled
            btnSHER.setEnabled(true);
            btnBREA.setEnabled(true);
            btnFARG.setEnabled(true);
            btnTLOB.setEnabled(true);
            btnPULP.setEnabled(true);
            btnPRUI.setEnabled(true);
            btnDOGS.setEnabled(true);
            btnGOOD.setEnabled(true);
            btnDRAC.setEnabled(true);
            btnOBER.setEnabled(true);
            btnUNTE.setEnabled(true);
            btnHELA.setEnabled(true);
            btnACLO.setEnabled(true);
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