package com.nfs.userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.nfs.data.Profile;
import com.nfs.data.Subscriber;
import com.nfs.userinterface.InterfaceCreator;

public class AccountSettingsPanel extends JPanel {
    private int subScriberID;
    private JPanel bottomPanel;
    public AccountSettingsPanel(int subScriberID) {


        super.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10));

        super.setLayout(new BorderLayout());




    }

}

