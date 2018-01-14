package com.nfs;
import com.nfs.data .currentUser;
import com.nfs.userinterface.ChangeProfile;
import com.nfs.userinterface.UI;

public class Main {
    public static void main(String[] args) {
        currentUser.setCurrentSubscriber(5602533);
        currentUser.setCurrentProfile(100004);


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



