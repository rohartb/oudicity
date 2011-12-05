package Oudicity;

import Batiments.Batiment;
import java.util.*;

public class Ville extends Observable implements Observer{
    Temps t;
    Plateau p;
    OudiCity s;
    int jourDebut = 2;
    
    String nomVille;
    String nomMaire;
    int nbHabitant;
    int argent;
    int indiceAttraction;
    
    int annee = 1970;
    int mois = 1;
    int jour = 1;
    int jourAtt = 0;
    
    Ville(Temps t){
        this.t = t;
    }
    
    Ville(){
    }
    
    Ville(String v, String m, OudiCity o){
        nomVille = v;
        nomMaire = m;
        this.s = o;
        this.p = o.f.pg.getPlateau();
        argent = 20000;
        nbHabitant = 0;
        indiceAttraction = 50;
        o.t.c.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = new Calendrier();
        if(o.getClass()==c.getClass()){
            c = (Calendrier) o;
            
            // On chnage de jour
            if(jour < c.jour ){
                if(c.jour > jourDebut && jourAtt == 2){
                    // Augmenter le nombre d'habitant si il ya des palces 
                    //dans des logements
                    if(s.f.pg.p.h.logementLibre()){
                        if(indiceAttraction >= 50){
                            nbHabitant += p.h.augmentetHabitant();
                            p.e.AugmenterEmploye();
                            p.e.afficherEmployer();
                            setChanged();
                            notifyObservers();
                        }
                    }
                    jourAtt = 0;
                 } else {
                    jourAtt++;
                 }
            }
             if(c.mois > mois){
                 mois = c.mois;
                 jour = 1;
             }
             
             if(c.annee > annee){
                 System.out.println("Bonne année");
                 payerImpot();
                 annee = c.annee;
                 mois = 1;
                 jour = 1;
             }
        }
    }

    public void payerImpot(){
        Impot impot = new Impot(s);
        int imp = 0;
        imp = impot.preleverImpot();
        if(argent-imp < 0){
            System.out.println("Attention tu es en négatif");
        }
    }
    
    public void payerBatiment(Points pt){
        argent -= p.r.coutBatiment(pt);
        setChanged();
        notifyObservers();
    }
    
    public void rembourserBatiment(Points pt){
        argent += p.r.remboursementBatiment(pt);
        setChanged();
        notifyObservers();
    }
}
