import Batiments.*;
import java.util.*;

public class Habitant {
    int annee = 1970;
    int jour = 1;
    Ville v;
    PlateauGraphique p;
    Random rand = new Random();
    
    Habitant(Ville v, PlateauGraphique p){
        this.v = v;
        this.p = p;
    }

    int augmentetHabitant(int id){
        int nb = 0;
        Points pt;
        Points lf = null;
        Logement log;
        int nbLog;
        int nbMaxlog;
        int i;
        LinkedList<Points> l;
        
        if(p.plateauContient("logement")){
            l = p.plateauListes("logement");
            while(l != null && lf == null){
                i = rand.nextInt(12000%l.size());
                pt = l.remove(i); 
                log = (Logement) p.plateau[pt.getX()][pt.getY()];
                if(log.getNb_habitant()!= log.getNb_habitant_MAX()){
                    lf = new Points(pt.getX(),pt.getY());
                }
            }
        }
         
        if(lf != null){
            log = (Logement) p.plateau[lf.getX()][lf.getY()];
            nbLog = log.getNb_habitant();
            nbMaxlog = log.getNb_habitant_MAX();
            int a = nbLog - nbMaxlog;
            if(a<5){
                nb = a;
                log.setNb_habitant(a+nbLog);
            } else {  
                i = rand.nextInt(12000%a);
                log.setNb_habitant(a+i);
            }
        }
        return nb;
    }
    
}
