import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

/**
 * La classe Menu est utilisee pour afficher la fenetre du
 * demarrage du jeu.
 * 
 * @version 1.0
 * @author Solene Ramis et Vincent Charpentier-Porte
 */

public class Bloc{

	private Case[][] tabCase;
	private Case caseActu;

/**
 * Constructeur
 * 
 * @param Tableau complet des cases.
 * @param case selectionee.
 */
	public Bloc (Case[][] tab, Case cas){
		this.tabCase=tab;
		this.caseActu=cas;
	}
    /**
    * Découpe la grille générale en 9 blocs de 9 cases.
    */
	protected void decoupageBlocs(){
           int[][] tableau = new int[9][9];

           for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                tableau[i][j]=this.tabCase[i][j].recup_valeur();
            }
        }
        int[][] grp = new int[3][3];

        int bloc=0; 

        for (int i = 0; i < tableau.length; i = i+3){           

            for (int j = 0; j < tableau[i].length; j = j+3){

                bloc=(i + (j / 3));

                System.out.println("Groupe: "+bloc);

                int ligneGrp=0;

                for (int k = i; k < (i + 3); k++){

                    int colGrp=0;

                    for (int l = j; l < (j + 3); l++){

                        grp[ligneGrp][colGrp] = tableau[k][l];
                        System.out.format("[%-1s][%-1s] : %-3s ", ligneGrp, colGrp, grp[ligneGrp][colGrp++]);


                    }

                    ligneGrp++;

                    System.out.println();

                }
            }
        }
        verif_bloc(grp);
    

}
    /**
    * Renvoie faux si deux cases sont égales dans le même groupe.
    * @param Groupe de 9 cases
    * @return Boolean : false si deux cases ont la meme valeur dans le même groupe.
    */
	public boolean verif_bloc(int[][] grp){

		for(int i=0; i<3;i++){
			for (int j=0; j<3; j++){

				for(int c=0; c<3;c++){
					for (int d=0; d<3; d++){
						if (grp[i][j]==grp[c][d]){

							return(false);}
						else {return (true);}
						


					}

				}
			}
		}
		return(false);
	}
}
