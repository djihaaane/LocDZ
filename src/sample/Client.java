package sample;
import java.util.ArrayList;
import java.util.Date;
public class Client extends Personne {

    String NPermis;

    public Client(String nom, String prenom, String adresse, Ndate dateDeNaissance, String lieuNaissanceC, String NPermis) {
        super(nom, prenom, adresse, dateDeNaissance, lieuNaissanceC);
        this.NPermis = NPermis;
    }

    public void AjouterClient(ArrayList<Client> list, String nom, String prenom, String adresse, String NPermis, Ndate dateDeNaissance,String lieuNaissance)
    {

        list.add(new Client(nom, prenom, adresse, dateDeNaissance, lieuNaissanceC,NPermis ));
    }

}
