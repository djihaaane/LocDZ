package sample;

import java.util.Date;

public class Reservation {
    static int NumRes;
    Ndate dateDebut;
    int duree;
    String matricule;
    String NPremis;

    public Reservation(Ndate dateDebut, int duree, String matricule, String NPremis) {
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.matricule = matricule;
        this.NPremis = NPremis;
    }
}
