package Batiments;

public class Pavillon extends Logement {
    public Pavillon(){
       this.setCoutEntretien(10);
       this.setPrixAchat(10);
       this.setPrixDestr(5);
       this.setTaille(1);
       this.setType("pavillon");
       this.setNb_habitant_MAX(10);
       this.setNb_habitant(0);
    }
    
}
