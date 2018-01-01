package com.nfs.userinterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCreator {

    //Users
    private String[] userArray = new String[] {"Sander", "Robin", "Jac"};
    private JComboBox<String> usersDropdown = new JComboBox<>(userArray);

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

    public JComboBox createProfileDropdown()    {

        usersDropdown.setSelectedIndex(0);

        return usersDropdown;
    }

    public String getSelectedIem() {
        return userArray[usersDropdown.getSelectedIndex()];
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

    //ButtonListener class
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Determine the source of the action performed
            if (e.getSource() == profielGegevens)    {

                //Placeholder
                //information.setText("Sherlock Holmes");

                //First enable previous disabled button, then disable current button
                setAllButtonsEnabled();
                profielGegevens.setEnabled(false);

                //Get data from database
                //information.setText(dbf.getInformationAboutShow("Sherlock"));

            } else if (e.getSource() == films)   {
                //information.setText("Breaking Bad");
                setAllButtonsEnabled();
                films.setEnabled(false);

            } else if (e.getSource() == series)    {
                //information.setText("Fargo");
                setAllButtonsEnabled();
                series.setEnabled(false);
                //information.setText(dbf.getInformationAboutShow("Fargo"));

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
