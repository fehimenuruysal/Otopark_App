package com.example.msi.otopark.Activity;

public class UserAracGiris {

    private String plaka;
    private String girissaati;

    public UserAracGiris(String plaka, String girissaati) {
        this.plaka = plaka;
        this.girissaati = girissaati;
    }

    public UserAracGiris(){

    }


    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getGirissaati() {
        return girissaati;
    }

    public void setGirissaati(String girissaati) {
        this.girissaati = girissaati;
    }
}
