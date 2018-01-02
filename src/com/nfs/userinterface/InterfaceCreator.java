package com.nfs.userinterface;

import com.nfs.appdetails.AppDetails;
import com.nfs.appdetails.TimeKeeper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class InterfaceCreator {
    //Declarations

    //Information
    private JPanel informationPanel =  new JPanel(new BorderLayout());

    //Users
    private String[] userArray = new String[] {"Sander", "Robin", "Jac"};
    private JComboBox<String> profileDropdown = new JComboBox<>(userArray);
    private JLabel greeting = new JLabel(new TimeKeeper().greeting() + " " + getSelectedIem(), JLabel.CENTER);

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

    public JPanel createStartupInformation()    {

        JLabel information = new JLabel(new TimeKeeper().greeting(), JLabel.CENTER);

        //Label Make-up
        information.setFont(new Font("Arial", Font.BOLD, 36));
        information.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        informationPanel.add(information, BorderLayout.CENTER);

        //Return Label
        return informationPanel;
    }

    public JPanel createProfileDropdown()    {

        //Creating the pane to add the dropdown and greeting
        JPanel profileContainer = new JPanel(new BorderLayout());

        //Setting up the dropdown. UserArray is a placeholder
        this.profileDropdown.setSelectedIndex(0);

        //Adding the Listener to the dropdown
        this.profileDropdown.addItemListener(new ItemListener());

        //Creating a sub-container for better alignment
        JPanel subContainer = new JPanel(new BorderLayout());
        subContainer.setBorder(new EmptyBorder(20, 20, 20, 20));

        //Adding the components to the containers
        subContainer.add(this.greeting);
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

    public JPanel createProfielGegevens()  {
        JLabel hello = new JLabel("profielgegevens", JLabel.CENTER);
        JPanel helloPanel = new JPanel(new BorderLayout());
        helloPanel.add(hello, BorderLayout.NORTH);
        return helloPanel;
    }

    public JPanel createMovieButtons()  {
        JLabel hello = new JLabel("moviebuttons", JLabel.CENTER);
        JPanel helloPanel = new JPanel(new BorderLayout());
        helloPanel.add(hello, BorderLayout.NORTH);
        return helloPanel;
    }

    public JPanel createFilmButtons()  {
        JLabel hello = new JLabel("filmbuttons", JLabel.CENTER);
        JPanel helloPanel = new JPanel(new BorderLayout());
        helloPanel.add(hello, BorderLayout.NORTH);
        return helloPanel;
    }


    //SUBCLASSES
    //ButtonListener class
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Determine the source of the action performed
            if (e.getSource() == profielGegevens)    {
                pressButton(profielGegevens);
                replacePane(createProfielGegevens());

            } else if (e.getSource() == films)   {
                pressButton(films);
                replacePane(createFilmButtons());

            } else if (e.getSource() == series)    {
                pressButton(series);
                replacePane(createMovieButtons());

            }
        }

        private void setAllButtonsEnabled()  {
            profielGegevens.setEnabled(true);
            films.setEnabled(true);
            series.setEnabled(true);
        }

        private void pressButton(JButton button)    {
            setAllButtonsEnabled();
            button.setEnabled(false);
        }

        private void replacePane(Component component)   {
            informationPanel.removeAll();
            informationPanel.add(component, BorderLayout.CENTER);
            informationPanel.updateUI();
        }
    }

    //ItemListener class
    class ItemListener implements java.awt.event.ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            //Changes text of label greeting when profile is changed
            greeting.setText(new TimeKeeper().greeting() + " " + getSelectedIem());

        }
    }
}
