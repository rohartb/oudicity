package Batiments;

import Oudicity.*;

public abstract class Logement extends Batiment{
   protected int nb_habitant;
   protected int nb_habitant_MAX;
   protected int attirance;
   
   public Logement(OudiCity o){
       super(o);
       attirance=500;
   }

   /*GETTERS*/
    public int getNb_habitant() {
        return nb_habitant;
    }
    
    public int getNb_habitant_MAX() {
        return nb_habitant_MAX;
    }
    
    public int getAugmenter_habitant() {
        return nb_habitant_MAX-nb_habitant;
    }
    
    public int getAttirance() {
        return attirance;
    }
    
    /*SETTERS*/
    public void setNb_habitant(int nb_habitant) {
        this.nb_habitant += nb_habitant;
    }
    
    public void setAttirance(int att) {
        this.attirance = att;
    }
    
    /*public void setNb_habitant_MAX(int nb_habitant_MAX) {
        this.nb_habitant_MAX = nb_habitant_MAX;
    }*/
    
}