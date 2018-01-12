package com.nfs.connections;

import com.nfs.data.Movie;
import com.nfs.data.Show;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class DatabaseFetcher {

    //Declarations
    private Movie movie;
    private Show show;

    //Constructor
    public DatabaseFetcher()    {
        movie = new Movie();
        show = new Show();
    }

    //Giving the information corresponding to a movie
    //public JPanel getInformationAboutFilm(String movieName) {
     //   return movie.getInformationAboutFilm(movieName);
   // }



    public ArrayList<String[]> getDataReturnArrayList(String query) {    //Returned het resultaat als Arraylist
        try {
            DatabaseConnection con = new DatabaseConnection();

            ResultSet rs = con.getData(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            int amountOfCollumns = rsmd.getColumnCount();
            ArrayList Rows = new ArrayList<String[]>();

            while (rs.next()) {

                String[] row = new String[amountOfCollumns];

                for (int i = 1; i <= amountOfCollumns; i++) {
                    row[i - 1] = rs.getString(i);


                }
                Rows.add(row);
            }

            return Rows;}
            catch (Exception e){
            e.printStackTrace();
            }
            return null;

    }

    public String getDataResultSingleCellAsString(String sql){    //Voert query uit, resultaat MOET 1 cell zijn. Returnt waarde in cell.
        String result = "";
       ArrayList<String[]> resultArray = getDataReturnArrayList(sql);
        for (String[] resultLine: resultArray
             ) { result = resultLine[0];

        }
        return result;
    }


    //Giving the information corresponding to a show
    public JPanel getInformationAboutShow(String serieName)    {
        return show.getInformationAboutShow(serieName); }
}
