package Oudicity;

import Batiments.*;
import java.util.*;

public final class Employe {
    int nb_EmployTot = 0;
    int nb_maxEmpl = 0;
    Plateau p;
    OudiCity o;
    
    public Employe(Plateau p, OudiCity o){
        this.p = p;
        this.o = o;
        nb_EmployTot = nbTotEmploy();
        nb_maxEmpl = nbTotEmployMax();
    }
    
    int nbTotEmploy(){
        int n = 0;
        
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getPersBat().equals("employe")){
                    if(p.plateau[i][j].getGroupe().equals("batimentargent")){
                        BatimentArgent b = (BatimentArgent) p.plateau[i][j];
                        n += b.getNb_employe();
                    }
                    if(p.plateau[i][j].getGroupe().equals("loisir")){
                        Loisir b = (Loisir) p.plateau[i][j];
                        n += b.getNb_employe();
                    }
                    if(p.plateau[i][j].getGroupe().equals("servicepublic")){
                        ServicePublic b = (ServicePublic) p.plateau[i][j];
                        n += b.getNb_employe();
                    }
                }
            }
        }
        return n;
    }
    
    int nbTotEmployMax(){
        int n = 0;
        
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getPersBat().equals("employe")){
                    if(p.plateau[i][j].getGroupe().equals("batimentargent")){
                        BatimentArgent b = (BatimentArgent) p.plateau[i][j];
                        n += b.getNb_employe_MAX();
                    }
                    if(p.plateau[i][j].getGroupe().equals("loisir")){
                        Loisir b = (Loisir) p.plateau[i][j];
                        n += b.getNb_employe_MAX();
                    }
                    if(p.plateau[i][j].getGroupe().equals("servicepublic")){
                        ServicePublic b = (ServicePublic) p.plateau[i][j];
                        n += b.getNb_employe_MAX();
                    }
                }
            }
        }
        return n;
    }
    
    public LinkedList<Points> plateauContientTravail(){
        LinkedList<Points> l = new LinkedList<Points>();
        int nb_travail;
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getPersBat().equals("employe")){
                    if(p.plateau[i][j].getGroupe().equals("batimentargent")){
                        BatimentArgent b = (BatimentArgent) p.plateau[i][j];
                        nb_travail = b.getAugmenter_employe();
                        if( nb_travail > 0){
                            l.add(new Points(i,j));
                        }
                    }
                    else if(p.plateau[i][j].getGroupe().equals("loisir")){
                        Loisir b = (Loisir) p.plateau[i][j];
                        nb_travail = b.getAugmenter_employe();
                        if( nb_travail > 0){
                            l.add(new Points(i,j));
                        }
                    }
                    else if(p.plateau[i][j].getGroupe().equals("servicepublic")){
                        ServicePublic b = (ServicePublic) p.plateau[i][j];
                        nb_travail = b.getAugmenter_employe();
                        if( nb_travail > 0){
                            l.add(new Points(i,j));
                        }
                    }
                }
            }
        }
        return l;
    }
    
    
    
    void AugmenterEmploye(){
        Random rand = new Random();
        LinkedList<Points> l;
        int nb_chomeur= o.v.nbHabitant - nbTotEmploy();
        int i = rand.nextInt(nb_chomeur);
        Points pt;
        
        for(int j=0; j<i; j++){
            l = plateauContientTravail();
            int travail=rand.nextInt(l.size());
            pt = l.get(travail);
            if(p.plateau[i][j].getGroupe().equals("batimentargent")){
                BatimentArgent b = (BatimentArgent) p.plateau[i][j];
                b.setNb_employe(1);
            }
            else if(p.plateau[i][j].getGroupe().equals("loisir")){
                Loisir b = (Loisir) p.plateau[i][j];
                b.setNb_employe(1);
            }
            else if(p.plateau[i][j].getGroupe().equals("servicepublic")){
                ServicePublic b = (ServicePublic) p.plateau[i][j];
                b.setNb_employe(1);
            }    
        }
        
    }
}
