package Batiments;

public class Logement extends Batiment{
   private int nb_habitant;
   private int nb_habitant_MAX;
   
   public Logement(){
       this.setCoutEntretien(10);
       this.setPrixAchat(10);
       this.setPrixDestr(5);
       this.setTaille(1);
       this.setType("logement");
       this.nb_habitant=0;
       this.nb_habitant_MAX=20;       
   }

   /*GETTERS*/
    public int getNb_habitant() {
        return nb_habitant;
    }
    
    public int getNb_habitant_MAX() {
        return nb_habitant_MAX;
    }
    
    /*SETTERS*/
    public void setNb_habitant(int nb_habitant) {
        this.nb_habitant = nb_habitant;
    }
    
    public void setNb_habitant_MAX(int nb_habitant_MAX) {
        this.nb_habitant_MAX = nb_habitant_MAX;
    }
   
   
}
