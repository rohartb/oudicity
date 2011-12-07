package Oudicity;

import Batiments.Logement;

public final class Satisfaction {
    Plateau p;
    int tabContent[][];
    
    public Satisfaction(Plateau p){
        this.p = p;
        tabContent = new int[p.getTaille()][p.getTaille()];
        init_tab(tabContent);
    }
    
    
    public void init_tab(int tab[][]){
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                tab[i][j] = 0;
            }
        }
    }
    
    public void mettreAJour(){
        
    }

    public int calculContentement(){
        int attirance = 0, nb = 0;

        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if (p.plateau[i][j].getGroupe().equals("logement")){
                    Logement log = (Logement) p.plateau[i][j];
                    attirance +=log.getAttirance();
                    nb ++;
                }
            }
        }
        if(nb == 0){
            attirance = 0;
        } else {
            attirance = attirance/nb;
            if(attirance > 1000){
                attirance = 1000;
            }
        }

        return attirance;
    }
}
