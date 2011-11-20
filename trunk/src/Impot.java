import java.util.*;


public class Impot implements Observer {
    int annee;
    int argent;
    
    Impot(int a){
        argent = a;
        annee =1970;
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
        Calendrier c = (Calendrier) arg;
        if(annee != c.annee){
            preleverImpot();
            annee = c.annee;
        }
        
    }

    private void preleverImpot() {
       //TODO
    }
    
}
