package Batiments;

public class Ferme extends BatimentArgent{
    private int besoin;
    private int production;
    private int ressource_nourriture;
    public Ferme(){
        this.setCoutEntretien(10);
        this.setNb_employe_MAX(10);
        this.setNb_employe(0);        
        this.setPrixAchat(10);
        this.setPrixDestr(5);
        this.besoin=100;
        this.production=(this.besoin/10)*this.getNb_employe();
        this.ressource_nourriture=0;
        this.setTaille(1);
        this.setType("ferme");
    }

    /*GETTERS*/
    public int getBesoin() {
        return besoin;
    }
    
    public int getProduction() {
        return production;
    }

    public int getRessource_nourriture() {
        return ressource_nourriture;
    }

    public void setBesoin(int besoin) {
        this.besoin = besoin;
        this.production=(this.besoin/10)*this.getNb_employe();
    }
    
    public void setRessource_nourriture(int ressource_nourriture) {
        this.ressource_nourriture += ressource_nourriture;
    }  
    
}
