package com.nfs.databasefetcher;

public class TextFormatter {

    ///Formats all the movie details to a simple String
    public String formatterMovie(String title, String genre, String spokenLanguage, int age, int lengthInSeconds)   {
        String output;

        //placing a String within HTML tags make it wrap inside a JLabel
        output  = "<html>"
                + "Titel: " + title + "<br>"
                + "Genre: " + genre + "<br>"
                + "Taal:" + spokenLanguage + "<br>"
                + "Leeftijd: " + age + "<br>"
                + "Duur: " + (lengthInSeconds / 60) / 60 + "<br>"
                + "</html>";

        return output;
    }
}
