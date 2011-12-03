package Batiments;

public class Logement extends Batiment{
   private int nb_habitant;
   public Logement(){
       this.setCoutEntretien(10);
       this.nb_habitant=0;
       this.setPrixAchat(10);
       this.setPrixDestr(5);
       this.setTaille(1);
       this.setType("logement");  
   }

    public int getNb_habitant() {
        return nb_habitant;
    }

    public void setNb_habitant(int nb_habitant) {
        this.nb_habitant = nb_habitant;
    }
   
   
}
