package sample;

public class Vehicule {
    String matricule;
    String modele;
    String marque;
    String type;
    Boolean diponible;
    double prixKM;
    double prixJournalier;

    int annee;

    public Vehicule(String matricule, String modele, String marque, int annee,String type) {
        this.matricule = matricule;
        this.modele = modele;
        this.marque = marque;
        this.annee = annee;
        this.type=type;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "matricule='" + matricule + '\'' +
                ", modele='" + modele + '\'' +
                ", marque='" + marque + '\'' +
                ", annee=" + annee +
                '}';
    }
}
