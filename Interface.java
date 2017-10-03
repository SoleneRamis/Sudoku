    import java.awt.*;
    import javax.swing.*;

    
    /**
    * Cette classe sert a lancer la grille
    * @version 4.0
    * @author Solene Ramis et Vincent Charpentier-Porte
    */
    
    public class Interface {
    /**
    *Creation de la grille. 
    */
        public static void main (String[] args) {

            int grp=-1;
                    //  Un objet pour servir de fenetre.
            JPanel panneau = new JPanel();
                    // on configure la fenetre.
            JFrame fenetre = new JFrame();
            JPanel pf = new JPanel();
            fenetre.setSize(600,600);
            fenetre.setLocation(0, 0);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // GridLayout avec les deux boucles for permet de diviser la fenetre en 81 cases.
            GridLayout gestionnaire = new GridLayout(9,9);
            GridLayout ca = new GridLayout(1,1);
            Case tabcas[][]=new Case[9][9];

            JPanel panel = new JPanel();
            pf.setLayout(gestionnaire);
            
            
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(j==0){
                        grp++;
                    }else if(j==3){
                        grp++;
                    }else if(j==6){  
                        grp++;
                    }
                    tabcas[i][j]=new Case(i,j,grp);
                    tabcas[i][j].setLayout(ca);
                    tabcas[i][j].setBackground(Color.WHITE);
                    pf.add(tabcas[i][j]);
                    
                }
                if(i<2){
                    grp=-1;
                }else if(i<5){
                    grp=2;
                }else{  
                    grp=5;
                }
            }
            
             for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    
                    Souris s = new Souris(tabcas[i][j],i,j,tabcas);
                    tabcas[i][j].addMouseListener(s);
                    
                }
            }

            JButton btn = new JButton("SAUVEGARDER GRILLE");
            JButton btn1 = new JButton("CHARGER GRILLE");
            Obsmenu obsbutt = new Obsmenu(tabcas,fenetre);

            btn.addActionListener(obsbutt);
            btn1.addActionListener(obsbutt);

            panneau.add(btn);
            panneau.add(btn1);
            fenetre.add(pf);
            fenetre.add(panneau, BorderLayout.SOUTH);
            fenetre.setVisible(true);

            

                       
        }
    }
