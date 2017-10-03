import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
* Cette classe sert a voir si une case est survole ou non, cliquee ou non...
* @version 1.0
* @author Solene Ramis et Vincent Charpentier-Porte
*/

public class Sauver{

	private Case[][] tabcase;
/**
* Constructeur
*/
	public Sauver(Case[][] tabcase0){
		this.tabcase=tabcase0;

	}

 /**
  *  Permet à l'utilisateur de choisir le nom et l'emplacement du fichier à sauvegarder.
  */
 public void choixfichier(){

  JFileChooser fileChooser = new JFileChooser();

  FileNameExtensionFilter filter = new FileNameExtensionFilter("File grille","gri");
  fileChooser.setFileFilter(filter);

  File workingDirectory = new File(System.getProperty("user.dir"));
  fileChooser.setCurrentDirectory(workingDirectory);
  JPanel panneau = new JPanel();
  int valeur_de_retour = fileChooser.showOpenDialog(panneau);
  if(valeur_de_retour == JFileChooser.APPROVE_OPTION) {
    sauv(fileChooser.getSelectedFile().getName());
  }

}


/**
  * Ecris dans le fichier de sauvegarde les donnees de la grille.
  *@param Le nom du fichier de sauvegarde.
  */

public void sauv(String name) {
  
  int val[] = new int[9];
  Case[][] valfini= new Case[9][9];

  int actuVal=0;
  int v=0;

  try{
    FileOutputStream fichier = new FileOutputStream(name);
    DataOutputStream flux = new DataOutputStream(fichier);

    try{


      for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){

          actuVal=this.tabcase[i][j].recup_valeur();
          v=(v*10)-actuVal;

          
        }
        flux.writeInt(-v);
        v=0;
        actuVal=0;
      }
      flux.close();
    }catch(IOException e){
      System.out.println("Lecture fichier imposible");
    }
  }catch(FileNotFoundException e){
    System.out.println("Fichier non trouvé");
  }

  
}



}