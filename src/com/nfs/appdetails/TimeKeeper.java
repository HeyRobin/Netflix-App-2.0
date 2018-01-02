package com.nfs.appdetails;

import java.util.Calendar;

public class TimeKeeper {

       private int getTime() {
           return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
       }

       public String greeting() {
           int hour = getTime();

           if (hour>=0 && hour<=6) {
               return "Goedenavond";
           } else if (hour>=6 && hour<=12){
               return "Goedemorgen";
           } else if (hour>=12 && hour<=16){
               return "Goedemiddag";
           } else if (hour>=21 && hour<=24) {
               return "Goedenavond";
           } else {
               return "Hallo";
           }
       }
}
