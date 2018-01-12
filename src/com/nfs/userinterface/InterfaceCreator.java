package com.nfs.userinterface;

import com.nfs.appdetails.AppDetails;
import com.nfs.appdetails.TimeKeeper;
import com.nfs.connections.DatabaseFetcher;
import com.nfs.data.Movie;
import com.nfs.data.MovieButton;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.nfs.data.SerieButton;
import com.nfs.data.currentUser;
import javafx.scene.control.ComboBox;

public class InterfaceCreator {
    //Declarations

    //Information
    private JPanel eastPanel =  new JPanel(new BorderLayout());

    //Buttons
    private JButton statistieken;
    private JButton accountGegevens;
    private JButton profielGegevens;
    private JButton films;
    private JButton series;



    //Methods

    public JPanel createStartupInformation()    {

        JLabel information = new JLabel(new TimeKeeper().greeting(), JLabel.CENTER);

        //Label Make-up
        information.setFont(new Font("Arial", Font.BOLD, 36));
        information.setBorder(BorderFactory.createLineBorder(Color.gray));

        eastPanel.add(information, BorderLayout.CENTER);

        //Return Label
        return eastPanel;
    }

    public JPanel createDropdownsAndGreeting()  {

        JPanel profilePanel = new JPanel(new BorderLayout());
        JComboBox profiledropdown = new ProfileDropdown().createProfileDropdown();
        JLabel profileLabel = new JLabel("Profiel: ");
        profilePanel.add(profiledropdown, BorderLayout.EAST);
        profilePanel.add(profileLabel, BorderLayout.WEST);

        JPanel subscriberPanel = new JPanel(new BorderLayout());
        JLabel subscriberLabel = new JLabel("Account: ");
        JComboBox subscribersdropdown = new SubscriberDropdown().createSubscriberDropdown();
        subscriberPanel.add(subscriberLabel, BorderLayout.WEST);
        subscriberPanel.add(subscribersdropdown, BorderLayout.EAST);



        JPanel dropdownSubpanel = new JPanel(new BorderLayout());
        dropdownSubpanel.add(profiledropdown, BorderLayout.NORTH);
        dropdownSubpanel.add(profiledropdown, BorderLayout.SOUTH);

        JPanel dropdownSubPanel2 = new JPanel(new BorderLayout());
        dropdownSubPanel2.add(subscribersdropdown, BorderLayout.NORTH);
        dropdownSubPanel2.add(subscribersdropdown, BorderLayout.SOUTH);


        JPanel panel = new JPanel(new BorderLayout());
        panel.add(dropdownSubpanel, BorderLayout.SOUTH);
        panel.add(dropdownSubPanel2,BorderLayout.NORTH);


        subscribersdropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

             String selected =(String)subscribersdropdown.getItemAt(subscribersdropdown.getSelectedIndex());
                for (String[] array:currentUser.currentSubs
                     ) {if (selected.equals(array[1])){
                         currentUser.setCurrentSubscriber(Integer.parseInt(array[0]));
                         profiledropdown.updateUI();
                         profilePanel.revalidate();
                         DatabaseFetcher con = new DatabaseFetcher();
                    System.out.println("test");

                        profiledropdown.setSelectedItem(con.getDataResultSingleCellAsString("SELECT TOP 1 ProfileName FROM UserProfile WHERE SubscriberID ='" + currentUser.currentSubscriber + "';"));
                };

                }
            }
        });

        return panel;
    }

    public JPanel createButtons()  {

        //Setting up the panel
        JPanel buttons = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Setting up the buttons
        statistieken = new JButton("Statistieken");
        statistieken.addActionListener(new StatistiekenListener());
        statistieken.setMargin(new Insets(5, 0, 5, 0));

        accountGegevens = new JButton("Accountgegevens");
        accountGegevens.addActionListener(new AccountListener());
        accountGegevens.setMargin(new Insets(5, 0, 5, 0));

        profielGegevens = new JButton("Profile Gegevens");
        profielGegevens.addActionListener(new ProfielButtonListener());
        profielGegevens.setMargin(new Insets(5, 0, 5, 0));

        films = new JButton("Films");
        films.addActionListener(new FilmButtonListener());
        films.setMargin(new Insets(5, 0, 5, 0));

        series = new JButton("Series");
        series.addActionListener(new SerieButtonListener());
        series.setMargin(new Insets(5, 0, 5, 0));

        //Adding the buttons to the panel
        buttons.add(statistieken, c);
        buttons.add(accountGegevens, c);
        buttons.add(profielGegevens, c);
        buttons.add(films, c);
        buttons.add(series, c);

        return buttons;
    }

    public JPanel createCredits()   {

        //Create panel for labels
        JPanel creditsPanel = new JPanel(new BorderLayout());
        creditsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

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

    public JPanel createMovieButtons(){

        DatabaseFetcher con = new DatabaseFetcher();
        ArrayList<String[]> movies = con.getDataReturnArrayList("SELECT MovieID FROM movie;");

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel west = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 25, 10);

        int movieInArray = 0;
        int x = 0;
        int z = 0;

        //width and height of the buttons, Non-scalable
        c.ipady = 55;
        c.ipadx = 65;



     for (int y = 0; y < (movies.size()/3 + 1); y++) {
         for (x = 0; x < 3; x++) {
             c.gridx = x;
             c.gridy = y;
             if (movieInArray == movies.size()) {
                 break;
             }

             MovieButton button = new MovieButton(Integer.parseInt(movies.get(movieInArray)[0]));
             button.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     replacePane(new MovieStatisticsPanel(button.getMovieID()));
                     setAllButtonsEnabled();
                 }

             });

             movieInArray++;
             buttonPanel.add(button, c);
         }

     }



        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        west.add(mainPanel, BorderLayout.WEST);

        return west;
    }

    public JPanel createShowButtons()  {
            DatabaseFetcher con = new DatabaseFetcher();
        ArrayList<String[]> series = con.getDataReturnArrayList("SELECT SerieID FROM Serie;");


        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel west = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 70, 10);



        int serieInArray = 0;
        int x = 0;
        int z = 0;
        //width and height of the buttons, Non-scalable
        c.ipady = 100;
        c.ipadx = 55;



        for (int y = 0; y < (series.size()/3 + 1); y++) {
            for (x = 0; x < 3; x++) {
                c.gridx = x;
                c.gridy = y;
                if (serieInArray == series.size()) {
                    break;
                }

                SerieButton button = new SerieButton(Integer.parseInt(series.get(serieInArray)[0]));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        replacePane(new SerieStatisticsPanel(button.getSerieID()));
                        setAllButtonsEnabled();
                    }

                });

                serieInArray++;
                buttonPanel.add(button, c);
            }

        }



        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        west.add(mainPanel, BorderLayout.WEST);

        return west;
    }


    //SUBCLASSES





    class SerieButtonListener implements  ActionListener    {

        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(series);
            replacePane(createShowButtons());
        }
    }

    class FilmButtonListener implements ActionListener  {

        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(films);
            replacePane(createMovieButtons());
        }
    }




    class ProfielButtonListener implements ActionListener   {
        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(profielGegevens);
            replacePane(createProfielGegevens());
        }
    }

    class StatistiekenListener implements ActionListener    {

        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(statistieken);
            replacePane(new JLabel("Statistieken"));
        }
    }

    class AccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pressButton(accountGegevens);
            replacePane(new JLabel("Acountgegevens"));
        }
    }

    private void setAllButtonsEnabled()  {
        statistieken.setEnabled(true);
        accountGegevens.setEnabled(true);
        profielGegevens.setEnabled(true);
        films.setEnabled(true);
        series.setEnabled(true);
    }

    private void pressButton(JButton button)    {
        setAllButtonsEnabled();
        button.setEnabled(false);
    }

    public void replacePane(Component component)   {
        eastPanel.removeAll();
        eastPanel.add(component, BorderLayout.CENTER);
        eastPanel.updateUI();
    }

}
