package Batiments;

import Oudicity.*;

public class Commerce extends BatimentArgent{
    private int stock_nourriture;
    private int stock_bien;
    
    public Commerce(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.nb_employe_MAX=10;
        this.nb_employe=0;          
        this.prixAchat=10;
        this.prixDestr=5;     
        this.taille=1;
        this.type="commmerce";
        this.stock_bien=0;
        this.stock_nourriture=0;              
    }

    /*GETTERS*/
    public int getStock_bien() {
        return stock_bien;
    }

    public int getStock_nourriture() {
        return stock_nourriture;
    }

    /*SETTERS*/
    public void setStock_nourriture(int stock_nourriture) {
        this.stock_nourriture += stock_nourriture;
    }

    public void setStock_bien(int stock_bien) {
        this.stock_bien += stock_bien;
    }
    
}
