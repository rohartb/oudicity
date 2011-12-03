package Batiments;

public class Industrie extends BatimentArgent{
    public Industrie(){
        this.setCoutEntretien(10);
        this.setNb_employe(0);
        this.setNb_employe_MAX(20);                
        this.setPrixAchat(10);
        this.setPrixDestr(5);
        this.setTaille(1);
        this.setType("industrie");    
    }
}
