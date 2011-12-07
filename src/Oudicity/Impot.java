package Oudicity;
import Batiments.*;
import java.util.*;


public class Impot{
    int annee;
    OudiCity o;
    
    public Impot(OudiCity o){
        annee =1970;
        this.o = o;
    }
    


    public int preleverImpot() {
       int n = 2*o.v.nbHabitant;
       return n;
    }

    public int preleverTaxes() {
       int taxe=0;
       LinkedList<Batiment> bat = new LinkedList<Batiment>();
       for(int i=0; i<o.f.pg.p.getTaille(); i++){
           for(int j=0; j<o.f.pg.p.getTaille(); j++){
               if(o.f.pg.p.plateau[i][j].getGroupe().equals("batimentargent")
                  || o.f.pg.p.plateau[i][j].getGroupe().equals("servicepublic")
                  || o.f.pg.p.plateau[i][j].getGroupe().equals("loisir")){
                   
                   bat.add(o.f.pg.p.plateau[i][j]);
               }
           }
       }

       Batiment batiment;
       Iterator iterator = bat.iterator();

       while(iterator.hasNext()){
           batiment = (Batiment) iterator.next();
           taxe += batiment.getCoutEntretien();
       }

       return taxe;
    }
    
}
