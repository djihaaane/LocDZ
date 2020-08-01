package sample;

public class Employe extends Personne {
      String mat;


    public Employe(String nom, String prenom, String adresse, Ndate dateDeNaissance, String lieuNaissanceC, String mat) {
        super(nom, prenom, adresse, dateDeNaissance, lieuNaissanceC);
        this.mat = mat;
    }
}
