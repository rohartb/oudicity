package Batiments;

import Oudicity.*;

public class Ecole extends ServicePublic{
    public Ecole(OudiCity o){
        super(o);
        this.coutEntretien=60;
        this.nb_employe_MAX=10;
        this.nb_employe=0;
        this.prixAchat=600;
        this.prixDestr=300;
        this.taille=1;
        this.type="ecole";
        this.persBat="employe";
        this.groupe="servicepublic";        
        this.zoneInfluence=10;        
    }
    
}
