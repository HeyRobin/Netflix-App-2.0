package com.nfs.userinterface;

import com.nfs.data.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.nfs.data.currentUser;
public class ProfileSettingsPanel extends JPanel {
    private int subScriberID;
    private int profielID;

    public ProfileSettingsPanel(int subScriberID, int profileID){



        this.subScriberID = subScriberID;
        this.profielID = profileID;

        Profile profile = new Profile(subScriberID, profileID);
        super.setBorder(BorderFactory.createEmptyBorder(10,30,10,10));

        super.setLayout(new BorderLayout());
        JLabel titel = new JLabel("Profiel Gegevens: " + profile.getProfileName());
        titel.setFont(new Font("Serif", Font.PLAIN, 30));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        topPanel.add(titel, BorderLayout.NORTH);

        JLabel content = new JLabel("<html><br/> <br/>Account: " + profile.getSubScriberName() + " (Account Nummer: " + profile.getSubScriberID() + ")<br/>" +
                                                "Profiel: " + profile.getProfileName() + " (Profiel nummer " + profile.getProfileID() + ") <br/>" +
                                                "Geboorte Datum: " + profile.getDateOfBirth() + "<br/>" +
                                                "<br/>" );
        topPanel.add(content,BorderLayout.CENTER);



        JButton changeValues = new JButton("Profiel wijzigen");
        changeValues.setHorizontalAlignment(SwingConstants.LEFT);
        changeValues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeProfile changeProfile = new ChangeProfile(profile.getSubScriberID(),profile.getProfileID());
            }
        });

        topPanel.add(changeValues, BorderLayout.SOUTH);

        super.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        super.add(bottomPanel, BorderLayout.SOUTH);






    }
}
