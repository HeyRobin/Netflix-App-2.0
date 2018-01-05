package com.nfs.Login;



import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;


public class LoginScherm {
    public String username;
    public String password;
    static JPanel panel;
    static JFrame frame;


    public static void buildUI() {

        Image icon = new BufferedImage(32, 32, 3);

        frame = new JFrame("Login");

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();   //maakt een paneel, en voegt deze toe aan het frame.
        frame.add(panel);
        placeComponents();
        frame.setVisible(true);
        frame.setIconImage(icon);


    }

    public static void placeComponents() {

        Border border = new LineBorder(new Color(127), 15, true);



        panel.setBorder(border);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(30, 50, 80, 25);
        panel.add(userLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 80, 80, 25);
        panel.add(passwordLabel);

        JTextField userField = new JTextField("");
        userField.setBounds(130, 50, 180, 25);
        panel.add(userField);

        JPasswordField passwordField = new JPasswordField("");
        passwordField.setBounds(130, 80, 80, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(30, 110, 80, 25);
        loginButton.addActionListener(new LoginListener(userField,passwordField));
        panel.add(loginButton);



    }

    public static void setInvisible(){
        frame.setVisible(false);

    }

}

