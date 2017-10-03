import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
* Cette classe sert a voir si une case est survole ou non, cliquee ou non...
* @version 2.0
* @author Solene Ramis et Vincent Charpentier-Porte
*/

public class  Lecture{

  private Case[][] tabcase;

/**
* Constructeur
*/
  public Lecture(Case [][] tabcase0) {
    this.tabcase=tabcase0;

  }

  /**
  *  Permet à l'utilisateur de choisir un fichier à ouvrir.
  */
  public void choixfichier(){

        JFileChooser fichier = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("File grille","gri");
        fichier.setFileFilter(filter);

        File workingDirectory = new File(System.getProperty("user.dir"));
        fichier.setCurrentDirectory(workingDirectory);
        JPanel panneau = new JPanel();
        int valeur_de_retour = fichier.showOpenDialog(panneau);
        if(valeur_de_retour == JFileChooser.APPROVE_OPTION) {
            lec(fichier.getSelectedFile().getName());
        }
    }
  /**
  * Permet au programme de lire le fichier puis de l'ouvrir.
  */
  public void lec(String name) {
    
    int valeur[] = new int[9];
    int valeur_en_fin[][]= new int[9][9];

    int valeur_actuelle=0;

    try{
      FileInputStream fichier = new FileInputStream(name);
      DataInputStream flux = new DataInputStream(fichier);

      try{
        for(int i=0; i<9; i++){
          valeur[i]=flux.readInt();
        }
        flux.close();
      }catch(IOException e){
        System.out.println("Lecture fichier impossible");
      }
    }catch(FileNotFoundException e){
      System.out.println("Fichier non trouvé");
    }

    for(int i=0; i<9; i++){
      for(int j=8; j>=0; j--){
        valeur_actuelle=valeur[i];

        valeur_actuelle=valeur_actuelle%10;
        valeur[i]=(valeur[i]-valeur_actuelle)/10;

        valeur_en_fin[i][j]=valeur_actuelle;
        this.tabcase[i][j].enr_valeur(valeur_actuelle);
      }
      valeur_actuelle=0;
    }

    for(int i=0; i<9; i++){
      for(int j=0; j<9; j++){
        System.out.print(valeur_en_fin[i][j]);
      }
      System.out.println(" ");
    }
  }
}