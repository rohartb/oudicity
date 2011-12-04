import Batiments.Batiment;
import java.util.*;

public class Ville extends Observable implements Observer{
    Temps t;
    Plateau p;
    OudiCity s;
    int jourDebut = 2;
    
    int indiceA[][];
    String nomVille;
    String nomMaire;
    int nbHabitant;
    int argent;
    int indiceAttraction = 50;
    
    int annee = 1970;
    int mois = 1;
    int jour = 1;
    int jourAtt = 0;
    
    Ville(Temps t){
        this.t = t;
    }
    
    Ville(){
    }
    
    Ville(String v, String m, OudiCity s){
        nomVille = v;
        nomMaire = m;
        this.s = s;
        this.p = s.f.pg.p;
        argent = 20000;
        nbHabitant = 0;
        indiceAttraction = 50;
        s.t.c.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = new Calendrier();
        if(o.getClass()==c.getClass()){
            c = (Calendrier) o;
            if(jour != c.jour ){
                jour = c.jour;
                
                if(c.jour > jourDebut && jourAtt == 2){
                    // Augmenter le nombre d'habitant si il ya des palces 
                    //dans des logements
                    if(s.f.pg.p.h.logementLibre()){
                        if(indiceAttraction >= 50){
                            nbHabitant += p.h.augmentetHabitant();
                            setChanged();
                            notifyObservers();
                        }
                    }
                    jourAtt = 0;
                } else {
                    jourAtt++;
                }  
            }
        }
    }
    
    public void initTab(int t[][]){
        //for(int i=0;i<t.length;i++){
        //    for(int j;j<)
        //}
    }
}
