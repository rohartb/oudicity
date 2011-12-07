package Oudicity;
import Batiments.*;
import java.util.*;

public class Habitant {
    Plateau p;
    OudiCity o;
    
    public Habitant(Plateau p, OudiCity o){
        this.p = p;
        this.o = o;
    }
    
    public LinkedList<Points> plateauContientLogementLibre(){
        LinkedList<Points> l = new LinkedList<Points>();
        int b;
        
        Logement log;
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getGroupe().equals("logement")){
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
    
        public LinkedList<Commerce> plateauCommerce(){
        LinkedList<Commerce> l = new LinkedList<Commerce>();
        Commerce c;
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getType().equals("commerce")){
                    c = (Commerce) p.plateau[i][j];
                    l.add(c);
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
        Chemin ch;
       
        LinkedList<Points> l = plateauContientLogementLibre();
        i = rand.nextInt(l.size());
        pt = l.get(i);
        log = (Logement) p.plateau[pt.getX()][pt.getY()];
        nbMax = log.getAugmenter_habitant();
        ch = p.c.trouverChemin(pt);
        
                
        if(nbMax <5){
            nb = nbMax;
            log.setNb_habitant(nb);
            ch.nbHabi+=nb;
        } else {
            r = rand.nextInt(nbMax);
            while(r == 0){
                r = rand.nextInt(nbMax);
            }
            nb = r;
            log.setNb_habitant(r);
            ch.nbHabi+=r;
        }
        p.plateau[pt.getX()][pt.getY()] = (Batiment) log;
        return nb;
    }
    
    public int consommer(){
        int nb = o.v.nbHabitant;
        Commerce c;
        LinkedList<Commerce> l = plateauCommerce();
        int i = 0;
        int taille = l.size();
        if(taille!=0){
            while(i<taille && nb!=0){
                c=l.get(i);
                if(c.getReserv_bien()<nb){
                    nb -= c.getReserv_bien();
                    c.setReserv_bien(-c.getReserv_bien());
                }else{
                    c.setReserv_bien(-nb);
                    nb=0;
                }
                i++;
            }
        }
        return nb;
    }
    
    public int nourrir(){
        int nb = o.v.nbHabitant*2;
        Commerce c;
        LinkedList<Commerce> l = plateauCommerce();
        int i=0;
        int taille = l.size();
        if(taille!=0){
            while(i<taille &&  nb!=0){
                c=l.get(i);
                if(c.getReserv_nourriture()<nb){
                    nb -= c.getReserv_nourriture();
                    c.setReserv_nourriture(-c.getReserv_nourriture());
                }else{
                    c.setReserv_nourriture(-nb);
                    nb=0;
                }
                i++;
            }
        }
        return nb;
    }
}