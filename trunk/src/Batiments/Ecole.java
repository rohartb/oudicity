package Batiments;

public class Ecole extends ServicePublic{
    public Ecole(){
        this.setCoutEntretien(10);
        this.setNb_employe_MAX(10);
        this.setNb_employe(0);
        this.setPrixAchat(10);
        this.setPrixDestr(5);
        this.setTaille(1);
        this.setType("ecole");
        this.setZoneInfluence(50);        
    }
    
}
