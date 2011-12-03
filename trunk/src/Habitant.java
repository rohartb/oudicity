import Batiments.*;
import java.awt.*;
import java.util.*;

public class Habitant {
    int annee = 1970;
    int jour = 1;
    Ville v;
    PlateauGraphique p;
    
    Habitant(Ville v, PlateauGraphique p){
        this.v = v;
        this.p = p;
    }

    int augmentetHabitant(int id){
        int nb = 0;
        Points pt;
        int idMax = 0;
        Points logementCool;
        Logement log;
        LinkedList<Points> l = null;
        
        l = p.plateauContient("logement");
        if(l != null){
            for(int i=0;i<l.size();i++){
                pt = l.get(i);
                log = (Logement) p.plateau[pt.getX()][pt.getY()];
                if(log.getNb_habitant()!= log.getNb_habitant_MAX()){
                    //v.indiceA[pt.getX()][pt.getY()]
                }
            }
        }
        return nb;
    }
    
}
