import Batiments.Batiment;
import java.util.*;

public class Ville extends Observable implements Observer{
    Temps t;
    
    int annee = 1970;
    int mois = 1;
    int jour = 1;
    
    Ville(Temps t){
        this.t = t;
    }
    
    Ville (){
        
    }
    
    String nomVille;
    String nomMaire;
    int nbHabitant;
    int argent;
    int indiceAttraction;
    
    Ville(String v, String m, Temps t){
        nomVille = v;
        nomMaire = m;
        argent = 20000;
        nbHabitant = 0;
        indiceAttraction = 50;
        t.c.addObserver(this);
    }
    
    Habitant h = new Habitant(indiceAttraction,nbHabitant);

    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = new Calendrier();
        if(o.getClass()==c.getClass()){
            c = (Calendrier) o;
            if(jour != c.jour){
                jour = c.jour;
                nbHabitant=h.augmentetHabitant(indiceAttraction);
                setChanged();
                notifyObservers();
            }
        }
    }
}
