package com.nfs.data;

public class Addres {
    private int huisNummer;
    private String straatNaam;
    private String postCode;

    public Addres(String straatNaam, int huisNummer, String postCode)    {
        this.huisNummer = huisNummer;
        this.straatNaam = straatNaam;
        this.postCode = postCode;
    }

    public int getHuisNummer() {
        return huisNummer;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStraatNaam() {
        return straatNaam;
    }
}

