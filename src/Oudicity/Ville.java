package Oudicity;

import Batiments.*;
import java.util.*;
import java.util.LinkedList;

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
    Impot i;
    
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
        i = new Impot(s);
        o.t.c.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = new Calendrier();
        if(o.getClass()==c.getClass()){
            c = (Calendrier) o;

            Chemin ch = new Chemin(p);
            // On change de jour
            if(jour != c.jour ){
                jour = c.jour;
                if((c.annee==1970 && c.mois>2) || c.annee>1970){
                    int consomme = p.h.consommer();

                    argent += (nbHabitant-consomme)/5;

                    if(consomme>0){
                        s.f.barreL.afficheConseil("Manque de commerces");
                        //System.out.println("Les habitants n'ont pas assez de bien");
                        //System.out.println("  ->ajouter des commerces");
                    }  
                    int nou = p.h.nourrir();

                    argent += (nbHabitant-(nou/2))/5;
                    
                    if(nou>0){
                        s.f.barreL.afficheConseil("Manque de commerces");
                        //System.out.println("La population a faim!")
                        //System.out.println("  ->ajouter des commerces");
                    }
                }
                if(c.jour != jourDebut && jourAtt == 2){
                    // Augmenter le nombre d'habitant si il ya des places 
                    //dans des logements
                    if(s.f.pg.p.h.logementLibre()){
                        if(indiceAttraction >= 50){
                            nbHabitant += p.h.augmentetHabitant();
                        }
                    }
                    for(int i=0;i<p.c.lc.size();i++){
                        System.out.println("ville");
                        p.e.AugmenterEmploye(p.c.lc.get(i));
                        setChanged();
                        notifyObservers();
                    }
                    if(c.annee != 1970){
                        calculer_attraction();                        
                    }
                    
                    jourAtt = 0;
                } else {
                    jourAtt++;
                }
            }
            if(c.mois != mois){
                mois = c.mois;
                jour = 1;
                int cout_entretien=0;
                for(int i=0; i<p.getTaille();i++){
                    for(int j=0; j<p.getTaille();j++){
                        if(!p.plateau[i][j].getType().equals("herbe")){
                            cout_entretien += p.plateau[i][j].getCoutEntretien();
                        }
                    }
                }
                argent -= cout_entretien;
                i.preleverTaxes();
            }
            if(c.annee != annee){
                System.out.println("Bonne année");
                payerImpot();
                annee = c.annee;
                mois = 1;
                jour = 1;
            }
        }
        setChanged();
        notifyObservers();
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

    private void calculer_attraction() {
        LinkedList<Points> loisir = new LinkedList<Points>();
        LinkedList<Points> hab = new LinkedList<Points>();
        Logement log;
        Loisir loi;
        Points pt1;
        Points pt2;
        int taille1;
        int taille2;
        int k=0;
        int w=0;
        for(int j=0;j<p.c.lc.size();j++){
            loisir =  p.c.lc.get(j).batLoi;
            hab = p.c.lc.get(j).batHab;
            taille1 = hab.size();
            taille2 = loisir.size();
            while(k<taille1){
                pt1 = hab.get(k);
                log = (Logement) p.plateau[pt1.getX()][pt1.getY()];
                log.setAttirance(0);
                while(w<taille2){
                    pt2 = loisir.get(w);
                    loi = (Loisir) p.plateau[pt1.getX()][pt1.getY()];
                    log.setAttirance(log.getAttirance()+loi.getAttraction()); 
                }
            }
        }
    }
}
