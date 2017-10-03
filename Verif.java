import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

/**
* Cette classe va servir a verifier si les contraintes d'unicites sont respectees.
* @version 1.2
* @author Solène Ramis et Vincent Charpentier-Porte
*/

public class Verif{

	private Case[][] tableau;
	private Case casActu;
	
	/**
	* Constructeur.
	* @param tableau de cases.
	* @param appel la case en cours.
	*/
	public Verif(Case[][] tableau0, Case tab){

		this.tableau=tableau0;
		this.casActu=tab;

	}
	/**
	* La méthode "test" verifie les contraintes d'unicites et les conditions de victoire.
	*/
	public void test(){


		affichegrille();


		for(int i=0; i<9;i++){
			for (int j=0; j<9; j++){

				for(int c=0; c<9;c++){
					for (int d=0; d<9; d++){

						if (this.tableau[i][j]!=this.tableau[c][d]
							&&this.tableau[i][j].recup_valeur()!=this.tableau[c][d].recup_valeur()
							&&(i==c&&j!=d||j==d&&i!=c)
							&&this.tableau[i][j].recup_valeur()!=0
							&&this.tableau[c][d].recup_valeur()!=0){

							this.tableau[i][j].setForeground(Color.BLACK);
							this.tableau[i][j].setflag(0);
						}		
					}
				}
			}
		}
		for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(this.casActu.recupgrp()==this.tableau[i][j].recupgrp() 
                    && this.casActu!=this.tableau[i][j]){

                    if(this.casActu.recup_valeur()!=this.tableau[i][j].recup_valeur() 
                        && this.tableau[i][j].recup_valeur()!=0 && this.casActu.recup_valeur()!=0){

                        this.tableau[i][j].setForeground(Color.BLACK);
                    	this.tableau[i][j].setflag(0);
                    }
                }
            }
	    }
	for(int i=0; i<9;i++){
		for (int j=0; j<9; j++){

			for(int c=0; c<9;c++){
				for (int d=0; d<9; d++){

					if (this.tableau[i][j]!=this.tableau[c][d]
						&&this.tableau[i][j].recup_valeur()==this.tableau[c][d].recup_valeur()
						&&(i==c&&j!=d||j==d&&i!=c)
						&&this.tableau[i][j].recup_valeur()!=0
						&&this.tableau[c][d].recup_valeur()!=0) {

						this.tableau[i][j].setForeground(Color.RED);
						this.tableau[i][j].setflag(1);

					}

				}
			}
		}
	}



	for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            if(this.casActu.recupgrp()==this.tableau[i][j].recupgrp() 
                && this.casActu!=this.tableau[i][j]){

                if(this.casActu.recup_valeur()==this.tableau[i][j].recup_valeur() 
                    && this.tableau[i][j].recup_valeur()!=0 && this.casActu.recup_valeur()!=0){

                    this.tableau[i][j].setForeground(Color.RED);
               		this.tableau[i][j].setflag(1);

                }
            }
        }
    }


	 int verificationflag=0;
	 for(int k=0; k<9; k++){
        for(int l=0; l<9; l++){

        	if(this.tableau[k][l].getflag()==false&&this.tableau[k][l].recup_valeur()!=0){
        		verificationflag+=1;
        	}

        }
	 }

	if (verificationflag==81){

		JFrame gain = new JFrame();
		JLabel gagne = new JLabel("FELICITATION, PARTIE GAGNEE!!!!");
		gagne.setHorizontalAlignment(SwingConstants.CENTER);
	    gagne.setVerticalAlignment(SwingConstants.CENTER);
	    Font font = new Font("Arial", Font.BOLD,12);
	    gagne.setFont(font);
		gain.setSize(250,250);
	    gain.setLocation(250, 250);
	    gain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	GridLayout gestionnaire = new GridLayout(2,1);
	   	gain.setLayout(gestionnaire);
	   	gain.add(gagne);
	   	

	   	JButton exit = new JButton("QUITTER");
	   	gain.add(exit);


		Obsmenu obs =new Obsmenu(new Case[9][9], gain);
	   	exit.addActionListener(obs);
	   	gain.setVisible(true);
	}


}



public void affichegrille(){

	System.out.println("");

	System.out.println("");
	int a=0;
	while (a < 9)
	{
		int b = 0;
		while(b < 9)
		{
			System.out.print(this.tableau[a][b].recup_valeur());
			if ((b+1)%3==0)
				System.out.print(" ");
			b++;
		}
		System.out.println("");
		if((a+1)%3==0)System.out.println(" ");
		a++;
	}
	System.out.println("------------------------------");


}

}