package com.nfs.userinterface;

import com.nfs.connections.DatabaseConnection;
import com.nfs.data.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ChangeProfile extends JFrame {
    private int subScriberId;
    private int profielId;

    public ChangeProfile(int subScriberId, int profileID){


        this.subScriberId = subScriberId;
        this.profielId = profileID;


        Profile profile = new Profile(subScriberId,profileID);

        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        super.setLocationRelativeTo(null);

        super.setMinimumSize(new Dimension(250,100));
        super.setSize(new Dimension(250,100));
        super.setResizable(false);



        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(2,0));
        ;
        JLabel nameLabel =  new JLabel("Nieuwe naam: ");
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        westPanel.add(nameLabel);

        JLabel dobLabel = new JLabel("Nieuwe Geboortedatum: ");
        dobLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        westPanel.add(dobLabel);


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,2));


        JTextField name = new JTextField();
        name.setText(profile.getProfileName());
        centerPanel.add(name);

        JTextField dateOfBirth = new JTextField();
        dateOfBirth.setText(profile.getDateOfBirth());
        dateOfBirth.setSize(20,5);
        centerPanel.add(dateOfBirth);





        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(0,4));


        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());



        JButton cancel = new JButton("Annuleren");

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

        southPanel.add(cancel,BorderLayout.WEST);

        JButton changeProfileValues = new JButton("Aanpassen");
        changeProfileValues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeValues(name.getText(),dateOfBirth.getText());
            }
        });


        southPanel.add(changeProfileValues, BorderLayout.EAST);

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);
        panel.add(westPanel, BorderLayout.WEST);

        super.add(panel);

        super.pack();
        super.setVisible(true);



    }

    public void close(){
        super.setVisible(false);
        super.removeAll();

    }

    public void changeValues(String newName, String newDateOfBirth){


        DatabaseConnection con = new DatabaseConnection();




        if(checkName(newName) && checkDateOfBirth(newDateOfBirth)) {
            con.runSQL("UPDATE UserProfile SET ProfileName = '" + newName + "', DateOfBirth = '" + newDateOfBirth + "' WHERE SubscriberID = '" + this.subScriberId + "' AND ProfileID = '" + this.profielId + "';");

            close();
            JOptionPane.showMessageDialog(null, "Aanpassing succesvol.");

        }



    }

    public boolean checkName(String name){
        if (name.getClass() != String.class){
            JOptionPane.showMessageDialog(null, "Error in name");
            return false;
        }

        if (name.equals("")){
            JOptionPane.showMessageDialog(null,"Naam kan niet leeg zijn.");
            return false;
        }

        if (name.length() < 4){
            JOptionPane.showMessageDialog(null,"Naam moet minimaal 5 characters bevatten.");
            return false;
        }

        if (name.length() > 30){
            JOptionPane.showMessageDialog(null, "Naam is te lang!");
            return false;
        }


        return true;

    }

    public boolean checkDateOfBirthExt(String text) {
        if (text == null || !text.matches("\\d{4}-[01]\\d-[0-3]\\d"))
            return false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        try {
            df.parse(text);
            return true;
        } catch (ParseException ex) {
            return false;
        }

    }
    public boolean checkDateOfBirth(String dateOfBirth){
        if (checkDateOfBirthExt(dateOfBirth)){
            return true;
        }
        JOptionPane.showMessageDialog(null, "Geboortedatum niet in het juiste format.");
        return false;

    }

}
