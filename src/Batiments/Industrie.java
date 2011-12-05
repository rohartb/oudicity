package Batiments;

import Oudicity.*;
import java.util.*;

public class Industrie extends BatimentArgent implements Observer{
    private int subvention;
    private int production;
    private int stock_bien;
    private int stock_bien_MAX;
    
    int annee = 1970;
    int mois = 1;
    int jour = 1;
    int jourDebut = 3;
    
    public Industrie(OudiCity o){
        super(o);
        this.coutEntretien=150;
        this.nb_employe_MAX=70;
        this.nb_employe=0;          
        this.prixAchat=1500;
        this.prixDestr=750;     
        this.taille=1;
        this.type="industrie";
        this.persBat="employe";
        this.groupe="batimentargent";
        this.stock_bien=0;
        this.subvention=200;
        this.production=0;
        this.stock_bien_MAX=2000;        
        
        o.t.c.addObserver(this);
    }
    
    /*GETTERS*/
    public int getSubvention() {
        return subvention;
    }

    public int getStock_Bien() {
        return stock_bien;
    }
    
    public int getStock_Bien_MAX() {
        return stock_bien_MAX;
    }
    
    public int getProduction() {
        return production;
    }

    /*SETTERS*/
    public void setSubvention(int besoin) {
        this.subvention = besoin;
        this.production = (besoin/40)*this.getNb_employe();
    }
    
    public void setStock_Bien(int stock_bien){
        if(this.stock_bien+stock_bien<this.stock_bien_MAX){
            this.stock_bien += stock_bien;
        }
        else{
            this.stock_bien=this.stock_bien_MAX;
        }
    }
    
    @Override
    public void setNb_employe(int nb_e) {
        this.nb_employe += nb_e;
        this.production=(this.subvention/40)*this.nb_employe;
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
                        if(this.stock_bien+this.production<this.stock_bien_MAX){
                            this.stock_bien += this.production;
                        }
                        else{
                            this.stock_bien=this.stock_bien_MAX;
                        }
                    }
                }
            }
        }
    }
    
}
