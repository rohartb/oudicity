import Batiments.*;
import java.util.*;

public class Habitant {
    Plateau p;
    
    public Habitant(Plateau p){
        this.p = p;
    }
    
    public Points [] plateauContientLogementLibre(){
        Points tab[] = new Points[p.getTaille()];
        int idTab = 0;
        int b;
        
        Logement log;
        
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getType().equals("logement")){
                    log = (Logement) p.plateau[i][j];
                    b = log.getAugmenter_habitant();
                    if( b != 0){
                        tab[i] = new Points(i,j);
                    }
                }
            }
        }
        return tab;
    }
    
    boolean logementLibre(){
        boolean estLibre = false;
        Points t[] = plateauContientLogementLibre();
        
        if(t[0] != null){
            estLibre = true;
        }
        return estLibre;
    }
    
    int augmentetHabitant(){
        Random rand = new Random();
        int nb = 0;
        int i;
        int r;
        int nbMax;
        Points pt;
        Logement log;
       
        Points t[] = plateauContientLogementLibre();
        i = rand.nextInt(t.length);
        pt = t[i];
        log = (Logement) p.plateau[pt.getX()][pt.getY()];
        nbMax = log.getAugmenter_habitant();
        
        if(nbMax <5){
            nb = nbMax;
            log.setNb_habitant(nbMax+nb);
        } else {
            r = rand.nextInt(nbMax);
            nb = r;
            log.setNb_habitant(nbMax + r);
        }
        p.plateau[pt.getX()][pt.getY()] = (Batiment) log;
        return nb;
    }
}
