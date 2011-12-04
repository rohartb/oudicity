import Batiments.*;
import java.util.*;

public class Habitant {
    Plateau p;
    
    public Habitant(Plateau p){
        this.p = p;
    }
    
    public LinkedList<Points> plateauContientLogementLibre(){
        LinkedList<Points> l = new LinkedList<Points>();
        int b;
        
        Logement log;
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getType().equals("pavillon")){
                    log = (Logement) p.plateau[i][j];
                    b = log.getAugmenter_habitant();
                    if( b > 0){
                        l.add(new Points(i,j));
                    }
                }
            }
        }
        return l;
    }
    
    boolean logementLibre(){
        boolean estLibre = false;
        LinkedList<Points> l = plateauContientLogementLibre();
        
        if(l.size() != 0){
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
       
        LinkedList<Points> l = plateauContientLogementLibre();
        i = rand.nextInt(l.size());
        pt = l.get(i);
        log = (Logement) p.plateau[pt.getX()][pt.getY()];
        nbMax = log.getAugmenter_habitant();
        
        if(nbMax <5){
            nb = nbMax;
            log.setNb_habitant(nb);
        } else {
            r = rand.nextInt(nbMax);
            while(r == 0){
                r = rand.nextInt(nbMax);
            }
            nb = r;
            log.setNb_habitant(r);
        }
        p.plateau[pt.getX()][pt.getY()] = (Batiment) log;
        return nb;
    }
}
