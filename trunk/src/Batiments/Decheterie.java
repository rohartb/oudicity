package Batiments;

import Oudicity.*;

public class Decheterie extends ServicePublic{
    Decheterie(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.nb_employe_MAX=10;
        this.nb_employe=0;
        this.prixAchat=10;
        this.prixDestr=5;
        this.taille=1;
        this.type="decheterie";
        this.persBat="employe";
        this.groupe="servicepublic";        
        this.zoneInfluence=50;
    }
    
}
