import java.awt.*;
import javax.swing.*;


/**
 * La classe Menu est utilisee pour afficher la fenetre du
 * demarrage du jeu.
 * 
 * @version 3.0
 * @author Solene Ramis et Vincent Charpentier-Porte
 */

public class Menu extends JComponent {
   /**
    *Creation de la fenetre. 
   */
    public static void main (String[] args) {
       
        JFrame fenetreMenu = new JFrame();
        fenetreMenu.setSize(600,600);
        fenetreMenu.setLocation(0, 0);
        fenetreMenu.setDefaultCloseOperation(fenetreMenu.EXIT_ON_CLOSE);
        Obsmenu obs =new Obsmenu(new Case[9][9], fenetreMenu);


    // Affichage du Titre.

        
        JLabel titre = new JLabel(new ImageIcon("sudoku.gif"));
        
        titre.setPreferredSize(new Dimension(300, 96));        
        titre.setHorizontalAlignment(JLabel.CENTER);        
        fenetreMenu.add(titre, BorderLayout.NORTH);

     
    // Creation des boutons.

        JPanel panneau = new JPanel();
        
        JButton btn1 = new JButton("RÉSOUDRE MANUELLEMENT");
          btn1.addActionListener(obs);
          panneau.add(btn1);
          btn1.setPreferredSize(new Dimension(330, 96));

        
         JButton btn2 = new JButton("RÉSOUDRE AUTOMATIQUEMENT");
          btn2.addActionListener(obs);
          panneau.add(btn2);      
          btn2.setPreferredSize(new Dimension(330, 96));
        fenetreMenu.add(panneau, BorderLayout.CENTER);


    // Affichage de l'image.

        JPanel panneau1 = new JPanel();
        JLabel image = new JLabel(new ImageIcon("image.png"));
        image.setPreferredSize(new Dimension(250, 260));
        image.setHorizontalAlignment(JLabel.CENTER);
        panneau1.add(image);
        fenetreMenu.add(panneau1, BorderLayout.SOUTH);


    // On montre le résultat.
        fenetreMenu.setVisible(true);

    }
}