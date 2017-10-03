import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;


/**
* Cette classe sert a creer une case
* @version 2.0
* @author Solène Ramis et Vincent Charpentier-Porte
*/

public class Case extends JLabel {
        private int ncas;
        private int ncas0;
        private int valeur;
        private int groupe;
        private boolean drap;

        /**
            * Constructeur.
            * @param i = numero de la ligne de la case.
            * @param j = numero de la colonne de la case. 
            * @param gr = numero du groupe de la case.
        */        
        public Case(int i , int j, int gr){
                this.ncas=i;
                this.ncas0=j;
                this.groupe=gr;
                consCase();
                
                
                
        }

         /**
         * Dessine les bordures de la grille.
         */
        public void consCase(){
                setHorizontalAlignment(SwingConstants.CENTER);
                setVerticalAlignment(SwingConstants.CENTER);
                Font font = new Font("Arial", Font.BOLD,30);
                setFont(font);
                Border bordure = BorderFactory.createLineBorder(Color.BLACK, 1);
                Border epaisdroit = BorderFactory.createMatteBorder(1, 3, 1, 1, Color.BLACK);
                Border epaishaut = BorderFactory.createMatteBorder(3, 1, 1, 1, Color.BLACK);
                Border epaishautdroit = BorderFactory.createMatteBorder(3, 3, 1, 1, Color.BLACK);
                
                if (this.ncas%3==0&&this.ncas0%3!=0){
                        setBorder(epaishaut);
                }
                else if (this.ncas%3!=0&&this.ncas0%3==0){
                        setBorder(epaisdroit);
                }
                else if (this.ncas%3==0&&this.ncas0%3==0){
                        setBorder(epaishautdroit);
                }
                else {
                        setBorder(bordure);
                }
                setOpaque(true);
        }

        // Enregistre la valeur de "actuel" (valeur actuel de la case).
        public void enr_valeur(int actuel){
                this.valeur=actuel;
                setText(this.valeur+"");
                if(this.valeur==10) this.valeur=0;
                if (this.valeur==0) setText(" ");
                




        }

        // Recupere la valeur de la case.
        public int recup_valeur(){
                return this.valeur;

        }

        public int recupgrp(){
                return this.groupe;
        }
        public boolean recup_drap(){
                return this.drap;
        }
        public void setflag(int tst){
                if (tst==1)
                this.drap=true;
                if (tst==0)
                this.drap=false;
        }
        /**
         * Verifie les contraintes d'unicites.
         */
        public boolean getflag(){
                return this.drap;
        }
}





