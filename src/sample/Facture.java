package sample;

public class Facture
{   static int NumFac;
    DocPriseCahrge d;
    double prixTotale;

    public Facture(DocPriseCahrge d, double prixTotale) {
        this.d = d;
        this.prixTotale = prixTotale;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "d=" + d +
                ", prixTotale=" + prixTotale +
                '}';
    }
}
