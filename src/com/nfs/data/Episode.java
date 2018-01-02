package com.nfs.data;

import com.nfs.connections.DatabaseConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Episode {

    //declarations
    private DatabaseConnection dbc = new DatabaseConnection();
    private List<String> episodes;


    //Get all the episodes that belong to a serie
    public List<String> getEpisodes(String showName)    {
        episodes = new ArrayList<>();

        //Setting up the query
        String query =  "SELECT Titel\n" +
                        "FROM Episode\n" +
                        "WHERE SerieID = (\n" +
                        "   \t  \t       SELECT SerieID\n" +
                        "   \t  \t       FROM Serie\n" +
                        "   \t  \t       WHERE Titel = '" + showName + "');";
        ResultSet rs = dbc.getData(query);

        try {
            while (rs.next()) {
                episodes.add(rs.getString("Titel"));
            }

        } catch (Exception e)   {
            e.printStackTrace();
        }

        return episodes;
    }
}
