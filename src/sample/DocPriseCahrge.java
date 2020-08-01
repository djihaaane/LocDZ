package sample;

import java.util.Date;

public class DocPriseCahrge {
    int NumContrat;
    static int  NumDoc;
    double kilométragedebut;
    Ndate dateDebutR;
    int duree;
    double kilométragefin;

    public double calculerPrixLocation(Vehicule v)
    {
        return (v.prixKM*(this.kilométragefin-this.kilométragedebut)+v.prixJournalier*duree);
    }

    @Override
    public String toString() {
        return "DocPriseCahrge{" +
                "NumContrat=" + NumContrat +
                ", kilométragedebut=" + kilométragedebut +
                ", dateDebutR=" + dateDebutR +
                ", duree=" + duree +
                ", kilométragefin=" + kilométragefin +
                '}';
    }
}
