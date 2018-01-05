package com.nfs.Login;



import com.nfs.connections.DatabaseConnection;

import javax.swing.*;
import java.sql.ResultSet;

public class Login {
    static String userName;
    DatabaseConnection con = new DatabaseConnection();


    public static boolean Login(JTextField username,JPasswordField password){

        try{
        String sql = "SELECT UserName, pin FROM AdminLogin WHERE UserName = '"+ username.getText() + "' AND pin = '" + password.getText()+ "';";
        System.out.println(sql);
        DatabaseConnection con = new DatabaseConnection();
        ResultSet rs = con.getData(sql);




        if(rs.next()){
            System.out.println("Login succesvol");

            return true;
        };
        System.out.println("Login mislukt");
        return false;
    }catch (Exception e){
        e.printStackTrace();
    }
    return false;
    }


}
