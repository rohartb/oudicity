package Batiments;

import Oudicity.*;
import java.util.*;

public class Commerce extends BatimentArgent implements Observer{
    private int stock_nourriture;
    private int stock_bien;
    
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
        this.stock_bien=0;
        this.stock_nourriture=0;
        
        s.t.c.addObserver(this);
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
    

    
    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = new Calendrier();
        if(o.getClass()==c.getClass()){
            c = (Calendrier) o;
            if(jour != c.jour){
                jour = c.jour;
                if(jour > jourDebut){
                    if(this.stock_bien < 100){
                        int a = s.getFenetre().getGraphique().getPlateau().getSC().augmenterStockBien(100);
                        if(a!=0){
                            //System.out.println("!pas de bien disponible pour commerce!");
                        }
                        else{
                           // System.out.println("assez de bien disponible pour commerce!");
                        }
                        //System.out.println("stock bien"+this.stock_bien);
                        //System.out.println("a"+a);
                        this.stock_bien += 100-a;
                        //System.out.println("sb"+this.stock_bien);
                        
                        
                    }
                    if(this.stock_nourriture<100){
                        int a = s.getFenetre().getGraphique().getPlateau().getSC().augmenterStockNourriture(200);
                        if(a!=0){
                           // System.out.println("!pas de nourriture disponible pour commerce!");
                        }
                        else{
                            //System.out.println("assez de nourriture disponible pour commerce!");
                        }
                        this.stock_nourriture += 200-a;
                        //System.out.println(this.stock_nourriture);
                    }
                }
            }
        }
    }
}
