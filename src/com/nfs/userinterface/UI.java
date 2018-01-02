package com.nfs.userinterface;

import com.nfs.appdetails.AppDetails;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UI implements Runnable {

    // Initializing different classes
    private InterfaceCreator ifc = new InterfaceCreator();
    private final Border grey = BorderFactory.createLineBorder(Color.lightGray);

    // Creating JFrame which acts as main container.
    private JFrame frame;

    //Creating the greeting label

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
        container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        //Right interface
        container.add(ifc.createStartupInformation(), BorderLayout.CENTER);

        //Creates the container for the left side of the UI
        JPanel westContainer = new JPanel(new BorderLayout());
        westContainer.setBorder(grey);

        //Add components to the left side of the UI
        westContainer.add(ifc.createProfileDropdown(), BorderLayout.NORTH);
        westContainer.add(ifc.createButtons(), BorderLayout.SOUTH);

        //Add the left side to the UI
        container.add(westContainer, BorderLayout.WEST);

        //Add credits to the bottom of the UI
        container.add(ifc.createCredits(), BorderLayout.SOUTH);
    }
}