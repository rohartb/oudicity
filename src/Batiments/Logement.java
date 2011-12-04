package Batiments;

public class Logement extends Batiment{
   private int nb_habitant;
   private int nb_habitant_MAX;
   private boolean augmenter_habitant;
   
   public Logement(){
       
   }

   /*GETTERS*/
    public int getNb_habitant() {
        return nb_habitant;
    }
    
    public int getNb_habitant_MAX() {
        return nb_habitant_MAX;
    }
    
    public boolean getAugmenter_habitant() {
        return augmenter_habitant;
    }
    
    /*SETTERS*/
    public void setNb_habitant(int nb_habitant) {
        this.nb_habitant = nb_habitant;
        if(this.nb_habitant==this.nb_habitant_MAX){
            this.augmenter_habitant=false;
        }
        else{
            this.augmenter_habitant=true;
        }
    }
    
    public void setNb_habitant_MAX(int nb_habitant_MAX) {
        this.nb_habitant_MAX = nb_habitant_MAX;
    }
    
    /*public void setAugmenter_habitant(boolean augmenter_habitant) {
        this.augmenter_habitant = augmenter_habitant;
    }*/
    //augmenter_habitant calculé en fontion des hab
    //   ->modification seulement dans set_nb_habitant
}