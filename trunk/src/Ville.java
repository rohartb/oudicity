import Batiments.Batiment;
import java.util.*;

public class Ville extends Observable implements Observer{
    Temps t;
    Plateau p;
    OudiCity o;
    int jourDebut = 2;
    
    int indiceA[][];
    String nomVille;
    String nomMaire;
    int nbHabitant;
    int argent;
    int indiceAttraction;
    
    int annee = 1970;
    int mois = 1;
    int jour = 1;
    
    Ville(Temps t){
        this.t = t;
    }
    
    Ville(){
    }
    
    Ville(String v, String m, OudiCity o){
        nomVille = v;
        nomMaire = m;
        this.o = o;
        this.p = o.f.pg.p;
        argent = 20000;
        nbHabitant = 0;
        indiceAttraction = 50;
        o.t.c.addObserver(this);
    }
    
    Habitant h = new Habitant(o);

    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = new Calendrier();
        if(o.getClass()==c.getClass()){
            c = (Calendrier) o;
            if(jour != c.jour && c.jour > jourDebut){
                jour = c.jour;
                //nbHabitant+=p.augmentetHabitant(indiceAttraction);
                setChanged();
                notifyObservers();
            }
        }
    }
    
    public void initTab(int t[][]){
        //for(int i=0;i<t.length;i++){
        //    for(int j;j<)
        //}
    }
}
