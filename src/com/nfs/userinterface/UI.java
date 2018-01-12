package com.nfs.userinterface;

import com.nfs.appdetails.AppDetails;
import com.nfs.data.Profile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UI implements Runnable {

    // DDeclarations
    private InterfaceCreator ifc = new InterfaceCreator();
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

        //Adds Menubar to frame
        this.frame.setJMenuBar(Interface.createTopMenuBar());

        //Creates an Pane to place components in
        container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        //Right interface
        container.add(ifc.createStartupInformation(), BorderLayout.CENTER);

        //Creates the container for the left side of the UI
        JPanel westContainer = new JPanel(new BorderLayout());
        westContainer.setBorder(grey());
        westContainer.setPreferredSize(new Dimension(200, 600));

        //Add components to the left side of the UI
        westContainer.add(ifc.createDropdownsAndGreeting(), BorderLayout.NORTH);
        westContainer.add(ifc.createButtons(), BorderLayout.SOUTH);

        //Add the left side to the UI
        container.add(westContainer, BorderLayout.WEST);

        //Add credits to the bottom of the UI
        container.add(ifc.createCredits(), BorderLayout.SOUTH);
    }

 //   public void setContainer(JPanel container) {

    //    this.container.add(container);
  //  }

    public Border grey()   {
        return BorderFactory.createLineBorder(Color.gray);
    }
}

