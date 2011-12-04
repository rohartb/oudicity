package Batiments;

public class HLM extends Logement {
    public HLM(){
       this.setCoutEntretien(10);
       this.setPrixAchat(10);
       this.setPrixDestr(5);
       this.setTaille(1);
       this.setType("HLM");
       this.setNb_habitant_MAX(50);
       this.setNb_habitant(0);
    }
    
}
