package Batiments;

import Oudicity.*;

public class Pompier extends ServicePublic{
    public Pompier(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.nb_employe_MAX=10;
        this.nb_employe=0;
        this.prixAchat=10;
        this.prixDestr=5;
        this.taille=1;
        this.type="pompier";
        this.zoneInfluence=50;       
    }
}
