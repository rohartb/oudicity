package Batiments;

public class Ferme extends BatimentArgent{
    public Ferme(){
        this.setCoutEntretien(10);
        this.setNb_employe_MAX(10);
        this.setNb_employe(0);        
        this.setPrixAchat(10);
        this.setPrixDestr(5);
        this.setBesoin(100);         
        this.setTaille(1);
        this.setType("ferme");
    }
}
