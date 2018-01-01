package com.nfs.userinterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class InterfaceCreator {
    //Declarations

    //Users
    private String[] userArray = new String[] {"Sander", "Robin", "Jac"};
    private JComboBox<String> profileDropdown = new JComboBox<>(userArray);

    //Buttons
    private JButton profielGegevens;
    private JButton films;
    private JButton series;


    //Methods
    public JPanel createMoviePanel(String title, String genre, String Language, int age, int duration)    {

        //Assigning the parameters
        JLabel givenTitle = new JLabel(title);
        JLabel givenGenre = new JLabel(genre);
        JLabel givenLanguage = new JLabel(Language);
        JLabel givenAge = new JLabel(""+age+"+");
        JLabel givenDuration = new JLabel(""+duration+" min");

        //Setting up the new panel
        JPanel newPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        newPanel.add(givenTitle, gbc);

        gbc.gridheight = 2;



        return newPanel;
    }

    public JMenuBar createTopMenuBar()  {

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

    public JLabel createStartupInformation()    {

        //Declaration
        JLabel information = new JLabel(new TimeKeeper().greeting(), JLabel.CENTER);

        //Label Make-up
        information.setFont(new Font("Arial", Font.BOLD, 36));
        information.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        //Return Label
        return information;
    }

    public JPanel createProfileDropdown()    {

        //Creating the pane to add the dropdown and greeting
        JPanel profileContainer = new JPanel(new BorderLayout());

        //Setting up the dropdown. UserArray is a placeholder
        this.profileDropdown.setSelectedIndex(0);

        //Creating the greeting JLabel
        JLabel greeting = new JLabel(new TimeKeeper().greeting() + " " + getSelectedIem(), JLabel.CENTER);

        //ItemListener class
        class ItemListener implements java.awt.event.ItemListener {

            @Override
            public void itemStateChanged(ItemEvent e) {

                //Changes text of label greeting when profile is changed
                greeting.setText(new TimeKeeper().greeting() + " " + getSelectedIem());

            }
        }

        //Adding the Listener to the dropdown
        this.profileDropdown.addItemListener(new ItemListener());


        //Creating a subcontainer for better alignment
        JPanel subContainer = new JPanel(new BorderLayout());
        subContainer.setBorder(new EmptyBorder(20, 20, 20, 20));

        //Adding the components to the containers
        subContainer.add(greeting);
        profileContainer.add(profileDropdown, BorderLayout.NORTH);
        profileContainer.add(subContainer, BorderLayout.SOUTH);

        return profileContainer;
    }

    private String getSelectedIem() {
        return userArray[profileDropdown.getSelectedIndex()];
    }

    public JPanel createButtons()  {

        //Setting up the panel
        JPanel buttons = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Setting up the buttons
        ButtonListener bl = new ButtonListener();

        profielGegevens = new JButton("Profiel Gegevens");
        profielGegevens.addActionListener(bl);
        profielGegevens.setMargin(new Insets(5, 0, 5, 0));

        films = new JButton("Films");
        films.addActionListener(bl);
        films.setMargin(new Insets(5, 0, 5, 0));

        series = new JButton("Series");
        series.addActionListener(bl);
        series.setMargin(new Insets(5, 0, 5, 0));

        //Adding the buttons to the panel
        buttons.add(profielGegevens, c);
        buttons.add(films, c);
        buttons.add(series, c);

        return buttons;
    }

    public JPanel createCredits()   {

        //Create panel for labels
        JPanel creditsPanel = new JPanel(new BorderLayout());
        creditsPanel.setBorder(new EmptyBorder(3, 10, 3, 10));

        //Create Labels with information
        JLabel creditsAppVersion = new JLabel("Netflix Statistix versie " + new AppDetails().getVersion(), JLabel.LEFT);
        JLabel credits = new JLabel("Informatica 2017 - Klas E - " + new AppDetails().getAuthors(), JLabel.RIGHT);

        //Add labels to the container
        creditsPanel.add(creditsAppVersion, BorderLayout.WEST);
        creditsPanel.add(credits, BorderLayout.EAST);

        return creditsPanel;
    }


    //subclasses

    //ButtonListener class
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Determine the source of the action performed
            if (e.getSource() == profielGegevens)    {

                //Press button
                setAllButtonsEnabled();
                profielGegevens.setEnabled(false);

            } else if (e.getSource() == films)   {

                setAllButtonsEnabled();
                films.setEnabled(false);

            } else if (e.getSource() == series)    {

                setAllButtonsEnabled();
                series.setEnabled(false);
            }
        }

        private void setAllButtonsEnabled()  {

            //Sets all the buttons to enabled
            profielGegevens.setEnabled(true);
            films.setEnabled(true);
            series.setEnabled(true);
        }
    }
}
