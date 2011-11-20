import java.util.*;

public class Habitant implements Observer {
    int annee = 1970;
    int indiceAttirance;
    
    Habitant(int i){
        indiceAttirance = i;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = (Calendrier) arg;
        if(annee != c.annee){
            
        }
    }
    
}
