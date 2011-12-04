package Batiments;

public class Hopital extends ServicePublic{
    public Hopital(){
        this.setCoutEntretien(10);
        this.setNb_employe_MAX(20);
        this.setNb_employe(0);        
        this.setPrixAchat(10);
        this.setPrixDestr(5);
        this.setTaille(1);
        this.setType("hopital");
        this.setZoneInfluence(12);            
    }
}
