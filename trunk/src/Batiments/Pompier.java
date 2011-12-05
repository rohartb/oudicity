package Batiments;

import Oudicity.*;

public class Pompier extends ServicePublic{
    public Pompier(OudiCity o){
        super(o);
        this.coutEntretien=70;
        this.nb_employe_MAX=15;
        this.nb_employe=0;
        this.prixAchat=700;
        this.prixDestr=350;
        this.taille=1;
        this.type="pompier";
        this.persBat="employe";
        this.groupe="servicepublic";
        this.zoneInfluence=10;       
    }
}
