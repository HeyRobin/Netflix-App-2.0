package com.nfs.login;


import com.nfs.userinterface.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener{
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginListener(JTextField username, JPasswordField password){
        this.usernameField = username;
        this.passwordField = password;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(Login.Login(this.usernameField,this.passwordField)){
            LoginScherm.setInvisible();
            UI ui = new UI();
            ui.run();
        }


    }
}
