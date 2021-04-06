package com.example.msi.otopark.Activity;

public class User {
    private String ad;
    private String soyad;
    private String plaka;
    private String eposta;
    private String telefon;
    private String aracmodel;
    private String aracmarka;

    public User(String ad, String soyad, String plaka, String eposta, String telefon, String aracmodel, String aracmarka) {
        this.ad = ad;
        this.soyad = soyad;
        this.plaka = plaka;
        this.eposta = eposta;
        this.telefon = telefon;
        this.aracmodel = aracmodel;
        this.aracmarka = aracmarka;
    }
    public User(){



    }
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAracmodel() {
        return aracmodel;
    }

    public void setAracmodel(String aracmodel) {
        this.aracmodel = aracmodel;
    }

    public String getAracmarka() {
        return aracmarka;
    }

    public void setAracmarka(String aracmarka) {
        this.aracmarka = aracmarka;
    }
}

