import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

/**
* Cette classe sert a voir si une case est survole ou non, cliquee ou non...
* @version 2.0
* @author Solene Ramis et Vincent Charpentier-Porte
*/


public class Souris implements MouseListener{


    private Case tabcas0;
    private int i;
    private int j;
    private boolean b = false;
    private int c;
    private int k;
    private Case[][] tableau;

    /**
        * Constructeur
    */

    public Souris(Case tabcas1, int i0, int j0,Case[][] tableau0){

        this.tabcas0=tabcas1;
        this.i=i0;
        this.j=j0;
        this.tableau=tableau0;


    }   
        /**
        * La méthode MouseCLicked est invoquee lorsque le bouton de la souris
        * a été clique (presse et relache) sur un composant.
        */
        public void mouseClicked(MouseEvent evenement ){                                 

            Case actu = new Case(0,0,0);

            if (!b){


               
                k=this.tabcas0.recup_valeur();
                k++;
                this.tabcas0.enr_valeur(k);

                for(int i=0; i<9;i++){
                    for (int j=0; j<9; j++){
                        if(evenement.getSource()==this.tableau[i][j]){
                            actu=this.tableau[i][j];
                        }
                    }
                }
                Verif verification = new Verif(this.tableau,actu);
                verification.test();





            } 

        }
/** 
*La methode mouseEntered est invoquee lorsque la souris entre dans un composant.
*/
public void mouseEntered(MouseEvent evenement){                         
    if (!b){
        this.tabcas0.setBackground(Color.CYAN);
    }
}
/**
*  La methode mouseExited est invoquee lorsque la souris sort d'un composant.
*/
public void mouseExited(MouseEvent evenement) {                                 

    if (!b){
        this.tabcas0.setBackground(Color.WHITE);
    }


}      

public void mousePressed(MouseEvent evenement){                 // un bouton appuyé

}                      

public void mouseReleased(MouseEvent evenement){                // un bouton relâché

}                      

}


