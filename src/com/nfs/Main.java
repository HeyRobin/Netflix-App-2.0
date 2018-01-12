package com.nfs;

import com.nfs.connections.DatabaseConnection;
import com.nfs.connections.DatabaseFetcher;

import com.nfs.userinterface.UI;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
   //     DatabaseFetcher con = new DatabaseFetcher();
    //    ArrayList<String[]> result = con.getDataReturnArrayList("SELECT SubscriberID FROM Subscriber");

     //   for (String[] subResult: result
      //       ) {
      //      System.out.println(subResult[0]);

      //  }



        UI ui = new UI();
        ui.run();
    }
}



