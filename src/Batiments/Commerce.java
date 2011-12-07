package Batiments;

import Oudicity.*;

public class Commerce extends BatimentArgent{
    private int reserv_nourriture;
    private int reserv_bien;
    
    int annee = 1970;
    int mois = 1;
    int jour = 1;
    int jourDebut = 3;
    
    public Commerce(OudiCity s){
        super(s);
        this.coutEntretien=50;
        this.nb_employe_MAX=15;
        this.nb_employe=0;          
        this.prixAchat=500;
        this.prixDestr=250;     
        this.taille=1;
        this.type="commerce";
        this.persBat="employe";
        this.groupe="batimentargent";        
        this.reserv_bien=0;
        this.reserv_nourriture=0;
        
        //s.t.c.addObserver(this);
    }

    /*GETTERS*/
    public int getReserv_bien() {
        return reserv_bien;
    }

    public int getReserv_nourriture() {
        return reserv_nourriture;
    }

    /*SETTERS*/
    public void setReserv_nourriture(int nourriture) {
        this.reserv_nourriture += nourriture;
    }

    public void setReserv_bien(int bien) {
        this.reserv_bien += bien;
    }
}
