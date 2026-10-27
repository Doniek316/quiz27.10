package com.example.quiz;

public class Pytanie {
    private long idZdjecia;
    private  String trescPytania;
    private  boolean poprawnaOdpowiedz;
    //tak true, nie false
    private boolean czyPoprawnie;
    //dobra odpowiedz - true, zla - false

    public Pytanie(String trescPytania, boolean poprawnaOdpowiedz, long idZdjecia) {
        this.trescPytania = trescPytania;
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
        this.idZdjecia = idZdjecia;
        czyPoprawnie = false;
    }

    public long getIdZdjecia() {
        return idZdjecia;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public boolean isPoprawnaOdpowiedz() {
        return poprawnaOdpowiedz;
    }

    public boolean isCzyPoprawnie() {
        return czyPoprawnie;
    }

    public void setCzyPoprawnie(boolean czyPoprawnie) {
        this.czyPoprawnie = czyPoprawnie;
    }
}
