import java.util.*;

public class Habitant implements Observer {
    int annee = 1970;
    int jour = 1;
    int indiceAttirance;
    int nbHab;
    
    Habitant(int i, int n){
        indiceAttirance = i;
        nbHab = n;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = (Calendrier) arg;
        if(annee != c.annee){
            if(jour != c.jour){ 
                nbHab++;
            }
        }
    }
    
}
