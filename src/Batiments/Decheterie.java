package Batiments;

import Oudicity.*;

public class Decheterie extends ServicePublic{
    public Decheterie(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.nb_employe_MAX=5;
        this.nb_employe=0;
        this.prixAchat=100;
        this.prixDestr=50;
        this.taille=1;
        this.type="decheterie";
        this.persBat="employe";
        this.groupe="servicepublic";        
        this.zoneInfluence=20;
    }
    
}
