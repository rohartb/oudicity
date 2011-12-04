package Batiments;

public class Ferme extends BatimentArgent{
    private int besoin;
    private int production;
    private int ressource_nourriture;
    public Ferme(){
        this.coutEntretien=10;
        this.nb_employe_MAX=10;
        this.nb_employe=0;          
        this.prixAchat=10;
        this.prixDestr=5;     
        this.taille=1;
        this.type="commmerce";
        this.ressource_nourriture=0;
        this.besoin=100;
        this.production=0;
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
    
    @Override
    public void setNb_employe(int nb_e) {
        this.nb_employe += nb_e;
        this.production=(this.besoin/10)*this.nb_employe;
    }
    
}
