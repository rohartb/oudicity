package Batiments;

public class Logement extends Batiment{
   protected int nb_habitant;
   protected int nb_habitant_MAX;
   
   public Logement(){
       
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
    
    /*SETTERS*/
    public void setNb_habitant(int nb_habitant) {
        this.nb_habitant += nb_habitant;
    }
    
    /*public void setNb_habitant_MAX(int nb_habitant_MAX) {
        this.nb_habitant_MAX = nb_habitant_MAX;
    }*/
    
}