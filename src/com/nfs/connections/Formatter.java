package com.nfs.connections;

import java.util.ArrayList;

public class Formatter {

    public static void formatArrayListToString(ArrayList<String[]> arrayList){         // BASIC FORMATTER.

        if (arrayList.size() == 0 || arrayList == null){
            System.out.println("Geen resultaten");
        }
        for (int i = 0 ; i < arrayList.size(); i++){

        String[] array = arrayList.get(i);

        for (String string: array){
            System.out.print(string + "  ");
        }
            System.out.println();

        }
        System.out.println();
    }
}
