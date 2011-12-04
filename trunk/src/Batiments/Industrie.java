package Batiments;

import Oudicity.*;

public class Industrie extends BatimentArgent{
    private int besoin;
    private int production;
    private int bien;
    
    public Industrie(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.nb_employe_MAX=10;
        this.nb_employe=0;          
        this.prixAchat=10;
        this.prixDestr=5;     
        this.taille=1;
        this.type="commmerce";
        this.bien=0;
        this.besoin=100;
        this.production=0;
    }
    
    /*GETTERS*/
    public int getBesoin() {
        return besoin;
    }

    public int getBien() {
        return bien;
    }
    
    public int getProduction() {
        return production;
    }

    /*SETTERS*/
    public void setBesoin(int besoin) {
        this.besoin = besoin;
        this.production = (besoin/10)*this.getNb_employe();
    }
    
    public void setBien(int bien){
        this.bien += bien;
    }
    
    @Override
    public void setNb_employe(int nb_e) {
        this.nb_employe += nb_e;
        this.production=(this.besoin/10)*this.nb_employe;
    }
    
}
