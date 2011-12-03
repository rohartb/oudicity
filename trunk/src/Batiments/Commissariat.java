package Batiments;

public class Commissariat extends ServicePublic{
    public Commissariat(){
        this.setCoutEntretien(10);
        this.setNb_employe(0);
        this.setNb_employe_MAX(10);                
        this.setPrixAchat(10);
        this.setPrixDestr(5);
        this.setTaille(1);
        this.setType("commissariat");
        this.setZoneInfluence(12);    
    }
}
