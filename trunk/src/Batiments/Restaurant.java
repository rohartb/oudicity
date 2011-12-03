package Batiments;

public class Restaurant extends Loisir {
    public Restaurant(){
        this.setAttraction(50);
        this.setCoutEntretien(10);
        this.setPrixAchat(10);
        this.setPrixDestr(5);    
        this.setTaille(1);
        this.setType("restaurant");
        this.setNb_employe(0);
        this.setNb_employe_MAX(10);                
    }
       
}
