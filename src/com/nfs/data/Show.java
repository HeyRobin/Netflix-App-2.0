package com.nfs.data;

import com.nfs.connections.DatabaseConnection;

import javax.swing.*;
import java.awt.*;


public class Show {

    //declarations
    private DatabaseConnection dbc = new DatabaseConnection();
    private Episode episode = new Episode();


    //get the information about a show
    public JPanel getInformationAboutShow(String showName)    {

        //declarations
        JPanel newPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 30;

        JTextArea textField = new JTextArea();
        textField.setEditable(false);
        textField.setText("vnfnkfdnv");

        JTextArea textField2 = new JTextArea();
        textField2.setEditable(false);
        textField2.setText("bvjkdnvbfdk");

        newPanel.add(textField, gbc);
        newPanel.add(textField2, gbc);


        return newPanel;
    }


}
