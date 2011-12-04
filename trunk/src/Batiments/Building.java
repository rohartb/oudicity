package Batiments;
public class Building extends Logement {
    public Building(){
       this.setCoutEntretien(10);
       this.setPrixAchat(10);
       this.setPrixDestr(5);
       this.setTaille(1);
       this.setType("building");
       this.setNb_habitant_MAX(100);
       this.setNb_habitant(0);
    }
    
}
