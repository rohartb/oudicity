package Batiments;

public class Cinema extends Loisir {
    public Cinema(){
        this.setType("cinema");
        this.setPrixAchat(10);
        this.setPrixDestr(5);
        this.setCoutEntretien(10);
        this.setTaille(1);
        this.setAttraction(12);
        this.setNb_employe(0);
        this.setNb_employe_MAX(12);                
    }
}
