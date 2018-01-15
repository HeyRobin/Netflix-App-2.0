package com.nfs;
import com.nfs.data.CurrentUser;
import com.nfs.userinterface.UI;

public class Main {
    public static void main(String[] args) {

        //init
        CurrentUser.setCurrentSubscriber(1215426);
        CurrentUser.setCurrentProfile(100001);


   //     DatabaseFetcher con = new DatabaseFetcher();
    //    ArrayList<String[]> result = con.getDataReturnArrayList("SELECT SubscriberID FROM Subscriber");

     //   for (String[] subResult: result
      //       ) {
      //      System.out.println(subResult[0]);

      //  }

      //  JFrame frame = new JFrame();
      //  frame.setSize(600,600);
     //   frame.add(new MovieStatisticsPanel(1010));
     //   frame.setVisible(true);

        UI ui = new UI();


        ui.run();


    }
}



