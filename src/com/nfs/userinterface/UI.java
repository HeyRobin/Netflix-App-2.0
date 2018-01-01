package com.nfs.userinterface;

import com.nfs.databasefetcher.DatabaseFetcher;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;

public class UI implements Runnable {

    // Initializing different classes
    private TimeKeeper timeKeeper = new TimeKeeper();
    private InterfaceCreator ifc = new InterfaceCreator();
    private final Border grey = BorderFactory.createLineBorder(Color.lightGray);

    // Creating JFrame which acts as main container.
    private JFrame frame;
    private Container pane;

    private JComboBox usersDropdown;

    //Creating the greeting label
    private JLabel greeting;

    //Creating JLabel variable for the right menu to display data
    private JLabel information = new JLabel("");

    //Buttons for the shows
//    private JButton btnSHER, btnBREA, btnFARG, btnTLOB, btnPULP, btnPRUI, btnDOGS;
//    private JButton btnGOOD, btnDRAC, btnOBER, btnUNTE, btnHELA, btnACLO;

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

        //Adds Menubar to frame
        this.frame.setJMenuBar(ifc.createTopMenuBar());

        //Creates an Pane to place components in
        this.pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        //Right interface
        pane.add(ifc.createStartupInformation(), BorderLayout.CENTER);

        //left interface
        JPanel userContainer = new JPanel(new BorderLayout());

        //profile selector
        userContainer.add(ifc.createProfileDropdown(), BorderLayout.NORTH);


        //Adding the profile selector and Greeting.
        usersDropdown = ifc.createProfileDropdown();

        greeting = new JLabel(timeKeeper.greeting() + " " + ifc.getSelectedIem(), JLabel.CENTER);
        greeting.setFont(new Font("Arial", Font.PLAIN, 18));

        //Creating an ActionListener
        class ItemListener implements java.awt.event.ItemListener {

            @Override
            public void itemStateChanged(ItemEvent e) {

                //Changes text of label greeting when profile is changed
                greeting.setText(timeKeeper.greeting() + " " + usersDropdown.getSelectedItem());

            }
        }

        ItemListener il = new ItemListener();
        usersDropdown.addItemListener(il);

        // UserDetails Menu
        JPanel userSubContainer = new JPanel(new BorderLayout());
        userSubContainer.setBorder(new EmptyBorder(20, 20, 20, 20));

        userSubContainer.add(greeting);

        userContainer.add(userSubContainer, BorderLayout.SOUTH);
        userContainer.add(usersDropdown, BorderLayout.NORTH);


        //Adds components to the left side of the UI
        JPanel westContainer = new JPanel(new BorderLayout());
        westContainer.setBorder(grey);
        westContainer.add(userContainer, BorderLayout.NORTH);
        westContainer.add(ifc.createButtons(), BorderLayout.SOUTH);

        //Add the left side to the UI
        pane.add(westContainer, BorderLayout.WEST);

        //Add credits to the bottom of the UI
        pane.add(ifc.createCredits(), BorderLayout.SOUTH);
    }

    //    private class ButtonListener implements ActionListener   {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            //Determine the source of the action performed
//            if (e.getSource() == btnSHER)    {
//
//                //Placeholder
//                information.setText("Sherlock Holmes");
//
//                //First enable previous disabled button, then disable current button
//                setAllButtonsEnabled();
//                btnSHER.setEnabled(false);
//
//                //Get data from database
//                //information.setText(dbf.getInformationAboutShow("Sherlock"));
//
//            } else if (e.getSource() == btnBREA)   {
//                information.setText("Breaking Bad");
//                setAllButtonsEnabled();
//                btnBREA.setEnabled(false);
//
//            } else if (e.getSource() == btnFARG)    {
//                information.setText("Fargo");
//                setAllButtonsEnabled();
//                btnFARG.setEnabled(false);
//                //information.setText(dbf.getInformationAboutShow("Fargo"));
//
//            } else if ((e.getSource() == btnTLOB)) {
//                information.setText("The Life Of Brian");
//                setAllButtonsEnabled();
//                btnTLOB.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("The Life Of Brian"));
//
//            } else if (e.getSource() == btnPULP)   {
//                information.setText("Pulp Fiction");
//                setAllButtonsEnabled();
//                btnPULP.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("Pulp Fiction"));
//
//            } else if (e.getSource() == btnPRUI)    {
//                information.setText("Pruimenbloem");
//                setAllButtonsEnabled();
//                btnPRUI.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("Pruimenbloem"));
//
//            } else if (e.getSource() == btnDOGS)   {
//                information.setText("Resevoir Dogs");
//                setAllButtonsEnabled();
//                btnDOGS.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("Resevoir Dogs"));
//
//            } else if (e.getSource() == btnGOOD)  {
//                information.setText("The Good, The Bad, The Ugly");
//                setAllButtonsEnabled();
//                btnGOOD.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("The Good, The Bad, The Ugly"));
//
//            } else if (e.getSource() == btnDRAC)  {
//                information.setText("Dracula");
//                setAllButtonsEnabled();
//                btnDRAC.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("Dracula"));
//
//            } else if (e.getSource() == btnOBER) {
//                information.setText("Ober");
//                setAllButtonsEnabled();
//                btnOBER.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("Ober"));
//
//            } else if (e.getSource() == btnUNTE)    {
//                information.setText("Der Untergang");
//                setAllButtonsEnabled();
//                btnUNTE.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("Der Untergang"));
//
//            } else if (e.getSource() == btnHELA)   {
//                information.setText("De Helaasheid Der Dingen");
//                setAllButtonsEnabled();
//                btnHELA.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("De Helaasheid Der Dingen"));
//
//            } else if (e.getSource() == btnACLO)  {
//                information.setText("A Clockwork Orange");
//                setAllButtonsEnabled();
//                btnACLO.setEnabled(false);
//                //information.setText(dbf.getInformationAboutFilm("A Clockwork Orange"));
//            }
//        }
//
//        private void setAllButtonsEnabled()  {
//
//            //Sets all the buttons to enabled
//            btnSHER.setEnabled(true);
//            btnBREA.setEnabled(true);
//            btnFARG.setEnabled(true);
//            btnTLOB.setEnabled(true);
//            btnPULP.setEnabled(true);
//            btnPRUI.setEnabled(true);
//            btnDOGS.setEnabled(true);
//            btnGOOD.setEnabled(true);
//            btnDRAC.setEnabled(true);
//            btnOBER.setEnabled(true);
//            btnUNTE.setEnabled(true);
//            btnHELA.setEnabled(true);
//            btnACLO.setEnabled(true);
//        }
//    }


}