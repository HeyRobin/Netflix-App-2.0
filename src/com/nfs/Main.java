package com.nfs;
import com.nfs.data .currentUser;

import com.nfs.connections.DatabaseConnection;
import com.nfs.connections.DatabaseFetcher;

import com.nfs.userinterface.MovieStatisticsPanel;
import com.nfs.userinterface.UI;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        currentUser.setCurrentSubscriber(5285824);
        currentUser.setCurrentProfile(100005);


   //     DatabaseFetcher con = new DatabaseFetcher();
    //    ArrayList<String[]> result = con.getDataReturnArrayList("SELECT SubscriberID FROM Subscriber");

     //   for (String[] subResult: result
      //       ) {
      //      System.out.println(subResult[0]);

      //  }

        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.add(new MovieStatisticsPanel(1010));
        frame.setVisible(true);

        UI ui = new UI();
        ui.run();
    }
}



