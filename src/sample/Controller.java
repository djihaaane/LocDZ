package sample;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static javafx.collections.FXCollections.observableArrayList;
import static javafx.fxml.FXMLLoader.load;

public class Controller {

    public static HashMap<String,String> map_user = new HashMap<String,String>();
    public static HashMap<String, Reservation> map_res = new HashMap<>();
    public static ArrayList array_typeV = new ArrayList();
    public static ArrayList array_client = new ArrayList();
    public static ArrayList array_veh = new ArrayList();

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField user;
    @FXML
    private Label LOGIN;
    @FXML
    private JFXTextField tv;

    @FXML
    private JFXTextArea aff;

    @FXML
    private JFXButton rchrch;

    @FXML
    private JFXDatePicker db;

    @FXML
    private JFXDatePicker dn;

    @FXML
    private JFXDatePicker df;

    @FXML
    private JFXTextField mv;

    @FXML
    private JFXTextField nonc;

    @FXML
    private JFXTextField prenomc;

    @FXML
    private JFXTextField ln;

    @FXML
    private JFXTextField np;

    @FXML
    private JFXTextField adr;

    @FXML
    private JFXTextField tyv;
    @FXML
    private JFXTextField dl;
    @FXML
    private JFXTextField mrv;
    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField pasword;
    @FXML
    private JFXTextField kild;

    @FXML
    private JFXDatePicker dater;
    @FXML
    private JFXTextField kilf;

    @FXML
    private JFXDatePicker daterf;

    @FXML
    private JFXTextArea textarea;
    @FXML
    private JFXComboBox<String> combo = new JFXComboBox<>();


    public void typeCombo(ActionEvent event)
    {
        combo.setItems(observableArrayList(array_typeV));

    }

    public Ndate convertirDatePicker(JFXDatePicker dn){

        String dd =dn.getValue().toString();
        String[] tab = dd.split("-");
        int jour= Integer.valueOf(tab[0]);
        int mois= Integer.valueOf(tab[1]);
        int annee= Integer.valueOf(tab[2]);


        Ndate nda = new Ndate(jour,mois,annee);

        return nda;

    }
    @FXML
    void Login(ActionEvent event) throws IOException {
        map_user.put("djihane", "harouni");
        map_user.put("faycal", "faycal");
        array_typeV.add("Camion");
        array_typeV.add("Minibus");
        array_typeV.add("Voiture de tourisme");
        array_typeV.add("Porte_voiture");
        array_veh.add(new Vehicule("12345", "werty", "wertyu", 2009, "Camion"));
        array_veh.add(new Vehicule("12366", "rty", "wertyu", 2004, "Camion"));

      // array_client.add(new Client("khedache", "katia", "bouira", "9999", new Ndate(3,5,1999)));
   //    array_client.add(new Client("khedache", "yacine", "bouira", "9499", new Ndate(6,5,2000)));
   //    array_client.add(new Client("Harouni", "Mahi", "staouli", "94923", new Ndate(22,2,2002)));
            if(map_user.containsKey(user.getText()))

                if (map_user.get(user.getText()).equals(password.getText()))
                {
                    LOGIN.setText("Login Success");
                   // System.out.println(map_user.get(user.getText()));
                    Stage primaryStage = new Stage();
                    Parent root = load(getClass().getResource("/sample/Menu.fxml"));
                    Scene scene = new Scene(root, 600, 500);
                    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
                else
                {
                    LOGIN.setText("Login failed");
                }

            }

    public void ajouterRes(ActionEvent event) throws IOException {

        Stage primaryStage = new Stage();
        Parent root = load(getClass().getResource("/sample/AjouterRes.fxml"));
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void ajouterUtilisateurInt(ActionEvent event) throws IOException {

        Stage primaryStage = new Stage();
        Parent root = load(getClass().getResource("/sample/AjouterUtilisateur.fxml"));
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    void AjouterUtilisateur(ActionEvent event)
    {
        map_user.put(username.getText(), pasword.getText());

    }

    public Boolean existeClient(ArrayList array_client,String nP)
    {
      for(int i=0;i<array_client.size();i++)
      {
          if(((Client)array_client.get(i)).NPermis.equals(nP))
              return true;
      }
      return false;
    }
 public int  vehiculeDisponible(ArrayList array_veh,String type,String modele,String marque)
 { for(int i=0;i<array_veh.size();i++)
     {
         if(((Vehicule)array_veh.get(i)).type.equals(type) && ((Vehicule)array_veh.get(i)).modele.equals(modele) && ((Vehicule)array_veh.get(i)).marque.equals(marque))
         {
             return i;
         }
     }
     return -1;
 }
    public void etablirDocPriseCharge(ActionEvent event) throws IOException
    {
        if(vehiculeDisponible(array_veh, tyv.getText(), mv.getText(), mrv.getText())!=-1)
        {
            Reservation res = new Reservation(convertirDatePicker(dn), Integer.parseInt(dl.getText()),(((Vehicule)array_veh.get(vehiculeDisponible(array_veh, tyv.getText(), mv.getText(), mrv.getText()))).matricule),np.getText());
            ((Vehicule) array_veh.get(vehiculeDisponible(array_veh, tyv.getText(), mv.getText(), mrv.getText()))).diponible=false;
        }
        else
        {
            System.out.println("Vehicule Non Disponible");
           /* Stage primaryStage = new Stage();
            Parent root = load(getClass().getResource("/sample/NonDisponible.fxml"));
            Scene scene = new Scene(root, 600, 500);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();*/
        }
        if(!existeClient(array_client, np.getText()))
        {
            array_client.add(new Client(nonc.getText(), prenomc.getText(), adr.getText(), convertirDatePicker(dn), ln.getText(), np.getText()));
        }
        Stage primaryStage = new Stage();
        Parent root = load(getClass().getResource("/sample/AfficherContrat.fxml"));
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void etablirFacture() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = load(getClass().getResource("/sample/EtablirFacture.fxml"));
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void affficherFacture(Facture f)
    {
    textarea.setText(f.toString());
    }

    public void consulter(ActionEvent event) throws IOException {

        Stage primaryStage = new Stage();
        Parent root = load(getClass().getResource("/sample/Catalogue.fxml"));
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    void rechercher(ActionEvent event)
    {
        array_veh.add(new Vehicule("12345", "werty", "wertyu", 2009, "Camion"));
        array_veh.add(new Vehicule("12366", "rty", "wertyu", 2004, "Camion"));
        array_veh.add(new Vehicule("15566", "rty", "weu", 2019, "Minibus"));
        array_veh.add(new Vehicule("12366", "rty", "wertyu", 2004, "porte_voiture"));
        array_veh.add(new Vehicule("123000", "rty", "wertyu", 2012, "voiture de tourisme"));
     if(tv.getText()!=null) {
         for (int i = 0; i < array_veh.size(); i++) {
             if (tv.getText().equals(((Vehicule)array_veh.get(i)).type)){
                 aff.appendText(array_veh.get(i).toString()+"\n");

             }

         }

     }
  if(tv.getText().equals(""))
  {
      for (int i = 0; i < array_veh.size(); i++) {
          aff.appendText(array_veh.get(i).toString()+"\n");

      }
  }
         }


}
