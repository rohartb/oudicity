package Batiments;

import Oudicity.*;

public class HLM extends Logement {
    
    public HLM(OudiCity o){
        super(o);
        this.coutEntretien=100;
        this.prixAchat=1000;
        this.prixDestr=500;
        this.taille=1;
        this.type="HLM";
        this.persBat="habitant";
        this.groupe="logement";
        this.nb_habitant_MAX=10;
        this.nb_habitant=0;
    }
    
}
