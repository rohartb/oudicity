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
    
    public LinkedList<Points> listeContientTravail(LinkedList<Points> li){
        LinkedList<Points> liste = li;
        LinkedList<Points> l = new LinkedList<Points>();
        int nb_travail;
        int taille=liste.size();
        int i=0;
        Points pt;
        while(i<taille){
            pt = liste.get(i);
            if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("batimentargent")){
                BatimentArgent b = (BatimentArgent) p.plateau[pt.getX()][pt.getY()];
                nb_travail = b.getAugmenter_employe();
                if( nb_travail > 0){
                    l.add(new Points(pt.getX(),pt.getY()));
                }
            }
            else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("loisir")){
                Loisir b = (Loisir) p.plateau[pt.getX()][pt.getY()];
                nb_travail = b.getAugmenter_employe();
                if( nb_travail > 0){
                    l.add(new Points(pt.getX(),pt.getY()));
                }
            }
            else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("servicepublic")){
                ServicePublic b = (ServicePublic) p.plateau[pt.getX()][pt.getY()];
                nb_travail = b.getAugmenter_employe();
                if( nb_travail > 0){
                    l.add(new Points(pt.getX(),pt.getY()));
                }
            }
            i++;
        }
        return l;
    }
    
    public LinkedList<Points> listeContientEmploye(LinkedList<Points> li){
        LinkedList<Points> liste = li;
        LinkedList<Points> l= new LinkedList<Points>();
        int nb_employe;
        int taille = liste.size();
        int i =0;
        Points pt;
        
        while(i<taille){
            pt = liste.get(i);
            if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("batimentargent")){
                BatimentArgent b = (BatimentArgent) p.plateau[pt.getX()][pt.getY()];
                nb_employe = b.getNb_employe();
                if( nb_employe > 0){
                    l.add(new Points(pt.getX(),pt.getY()));
                }
            }
            else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("loisir")){
                Loisir b = (Loisir) p.plateau[pt.getX()][pt.getY()];
                nb_employe = b.getNb_employe();
                if( nb_employe > 0){
                    l.add(new Points(pt.getX(),pt.getY()));
                }
            }
            else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("servicepublic")){
                ServicePublic b = (ServicePublic) p.plateau[pt.getX()][pt.getY()];
                nb_employe = b.getNb_employe();
                if( nb_employe > 0){
                    l.add(new Points(pt.getX(),pt.getY()));
                }
            }
            i++;
        }
        return l;
    }
    
    
    
    void AugmenterEmploye(Chemin ch){
        Chemin c = ch;        
        
        LinkedList<Points> commerce =  c.batCom; 
        LinkedList<Points> loisir =  c.batLoi; 
        LinkedList<Points> serPu =  c.batSerPu;
        LinkedList<Points> ind =  c.batInd; 
        LinkedList<Points> ferme =  c.batFerm;
        LinkedList<Points> conca =  listeConcatene(commerce,loisir);
        conca = listeConcatene(conca,serPu);
        conca = listeConcatene(conca,ind);
        conca = listeConcatene(conca,ferme);
        
        
        Random rand = new Random();
        int nb_chomeur = c.nbHabi - c.nbEmploy;
        int nb_travail = c.nbEmployMax - c.nbEmploy;
        int i=0;
        int travail;
        Points pt;   
            
        if(nb_travail != 0 && nb_chomeur!= 0){
            if (nb_travail<nb_chomeur){
                i = rand.nextInt(nb_travail);
            }
            else{
                i = rand.nextInt(nb_chomeur);
            }

            for(int j=0; j<i; j++){
                conca = listeContientTravail(conca);
                if(conca.size()==0){
                    break;
                }
                travail=rand.nextInt(conca.size());
                pt = conca.get(travail);
                if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("batimentargent")){
                    BatimentArgent b = (BatimentArgent) p.plateau[pt.getX()][pt.getY()];
                    b.setNb_employe(1);
                }
                else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("loisir")){
                    Loisir b = (Loisir) p.plateau[pt.getX()][pt.getY()];
                    b.setNb_employe(1);
                }
                else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("servicepublic")){
                    ServicePublic b = (ServicePublic) p.plateau[pt.getX()][pt.getY()];
                    b.setNb_employe(1);
                }
            }
        }
    }
    
    void diminuerEmploye(Chemin ch){
        Chemin c = ch;        
        
        LinkedList<Points> commerce =  c.batCom; 
        LinkedList<Points> loisir =  c.batLoi; 
        LinkedList<Points> serPu =  c.batSerPu;
        LinkedList<Points> ind =  c.batInd; 
        LinkedList<Points> ferme =  c.batFerm;
        LinkedList<Points> conca =  listeConcatene(commerce,loisir);
        conca = listeConcatene(conca,serPu);
        conca = listeConcatene(conca,ind);
        conca = listeConcatene(conca,ferme);
        conca = listeContientEmploye(conca);
        
        Random rand = new Random();
        int i=0;
        Points pt;
        int nb_habitant = c.nbHabi;
        int nb_travailleur = c.nbEmploy;
        int diff = nb_travailleur-nb_habitant;
        int enlever_employe;
        
        if(diff>0){ //plus de travailleur que d'habitant!!
            for(i=0;i<diff;i++){
                conca = listeContientEmploye(conca);
                if(conca.size()==0){
                    break;
                }
                enlever_employe=rand.nextInt(conca.size());
                pt = conca.get(enlever_employe);
                if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("batimentargent")){
                    BatimentArgent b = (BatimentArgent) p.plateau[pt.getX()][pt.getY()];
                    b.setNb_employe(-1);
                }
                else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("loisir")){
                    Loisir b = (Loisir) p.plateau[pt.getX()][pt.getY()];
                    b.setNb_employe(-1);
                }
                else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("servicepublic")){
                    ServicePublic b = (ServicePublic) p.plateau[pt.getX()][pt.getY()];
                    b.setNb_employe(-1);
                }
            }
        }
    }
    
    void afficherEmployer(){
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getGroupe().equals("batimentargent")){
                    BatimentArgent b = (BatimentArgent) p.plateau[i][j];
                    System.out.println(p.plateau[i][j].getType() + b.getNb_employe());
                }
                else if(p.plateau[i][j].getGroupe().equals("loisir")){
                    Loisir b = (Loisir) p.plateau[i][j];
                    System.out.println(p.plateau[i][j].getType() + b.getNb_employe());
                }
                else if(p.plateau[i][j].getGroupe().equals("servicepublic")){
                    ServicePublic b = (ServicePublic) p.plateau[i][j];
                    System.out.println(p.plateau[i][j].getType() + b.getNb_employe());
                }
            }
        }
    }

    //fonction qui concatene 2 listes! 
    private LinkedList<Points> listeConcatene(LinkedList<Points> l1, LinkedList<Points> l2) {
        int i =0;
        int taille = l2.size();
        Points pt;
        while(i<taille){
            pt=l2.get(i);
            l1.add(pt);
            i++;
        }
        return l1;
    }
}