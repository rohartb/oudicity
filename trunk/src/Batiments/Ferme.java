package Batiments;

import Oudicity.*;
import java.util.*;

public class Ferme extends BatimentArgent implements Observer{
    private int subvention;
    private int subvention_MAX;
    private int production;
    private int stock_nourriture;
    private int stock_nourriture_MAX;
    OudiCity o;

    
    int annee = 1970;
    int mois = 1;
    int jour = 1;
    int jourDebut = 3;
    
    public Ferme(OudiCity o){
        super(o);
        this.o = o;
        this.coutEntretien=50;
        this.nb_employe_MAX=10;
        this.nb_employe=0;          
        this.prixAchat=500;
        this.prixDestr=250;     
        this.taille=1;
        this.type="ferme";
        this.persBat="employe";
        this.groupe="batimentargent";        
        this.stock_nourriture=0;
        this.subvention=100;
        this.subvention_MAX=300;
        this.production=0;
        this.stock_nourriture_MAX=4000;  
        
        o.t.c.addObserver(this);
    }

    /*GETTERS*/
    public int getSubvention() {
        return subvention;
    }
    
    public int getProduction() {
        return production;
    }

    public int getStock_nourriture() {
        return stock_nourriture;
    }
    
    public int getStock_nourriture_MAX() {
        return stock_nourriture_MAX;
    }

    /*SETTERS*/
    public void setSubvention(int subvention) {
        this.subvention += subvention;
        this.production=(this.subvention/5)*this.getNb_employe();
    }
    
    public void setStock_nourriture(int stock_nourriture) {
        if(this.stock_nourriture+stock_nourriture<this.stock_nourriture_MAX){
            this.stock_nourriture += stock_nourriture;
        }
        else{
            this.stock_nourriture = this.stock_nourriture_MAX;          
        }
    }
    
    @Override
    public void setNb_employe(int nb_e) {
        this.nb_employe += nb_e;
        this.production=(this.subvention/5)*this.nb_employe;
    }

    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = new Calendrier();
        if(o.getClass()==c.getClass()){
            c = (Calendrier) o;
            
            if(jour != c.jour){
                jour = c.jour;
                if(jour > jourDebut){
                    if(nb_employe > 0 && subvention >0){
                        if(this.stock_nourriture+this.production<this.stock_nourriture_MAX){
                            this.stock_nourriture += this.production;
                        }
                        else{
                            this.stock_nourriture=this.stock_nourriture_MAX;
                        }
                    }
                }
            }
        }
    }
    public void augmenterSubvention(){
        if(this.subvention+10<=this.subvention_MAX){
            setSubvention(10);
            o.getFenetre().getBarreL().changeSub(this.subvention);
        }        
    }
    
    public void diminuerSubvention(){
        if(this.subvention-10>=0){
            setSubvention(-10);
             o.getFenetre().getBarreL().changeSub(this.subvention);
        }       
    }
}
