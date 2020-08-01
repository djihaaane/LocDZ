package sample;

public class Ndate {
    int jour;
    int mois;
    int annee;

    Ndate() {
        this.jour = 0;
        this.mois = 0;
        this.annee = 0;
    }

    Ndate(int j, int m, int a) {
        this.jour = j;
        this.mois = m;
        this.annee = a;
    }

    public void modifierDate(int j, int m, int a) {
        this.jour = j;
        this.mois = m;
        this.annee = a;
    }

    public String toString() {
        return this.jour + "/" + this.mois + "/" + this.annee;
    }

    boolean comparerDates(Ndate d) {
        return this.jour == d.jour && this.mois == d.mois && this.annee == d.annee;
    }
}