import java.awt.*; 
import javax.swing.*; 
import  java.awt.event.*;

/**
 * La classe Obsmenu est utilisee pour gerer le clic des
 * bouton.
 *  
 * @version 2.0
 * @author Solene Ramis et Vincent Charpentier-Porte
 */

public class Obsmenu extends JFrame implements ActionListener {

    private Case[][] tab;
    private JFrame fe;
   /**
    * Constructeur.
    * @param tableau de toutes les cases.
    * @param passage de la fenetre pour la fermer. 
   */
    public Obsmenu(Case[][] val, JFrame fenetreMenu){
        this.tab=val;
        this.fe=fenetreMenu;
    }

    
    // test implemente l'interface ActionListener

    /**
    * Reaction au clic des boutons.
    */
    public void  actionPerformed(ActionEvent e) {

        String str = e.getActionCommand();

        if (str == "RÉSOUDRE MANUELLEMENT") {
            String[] args = new String[10];
            this.fe.dispose();
            Interface.main(args);
            
        }
        if (str == "RÉSOUDRE AUTOMATIQUEMENT") {
            

        }

        if (str == "CHARGER GRILLE") {
            Lecture file = new Lecture(this.tab);
            file.choixfichier();
        }
        if (str == "SAUVEGARDER GRILLE"){
            Sauver save = new Sauver(this.tab);
            save.choixfichier();

        }
        if (str == "QUITTER"){
            this.fe.dispose();
            

        }
    }
}