package Batiments;

import Oudicity.*;

public class Pavillon extends Logement {
    public Pavillon(OudiCity o){
        super(o);
        this.coutEntretien=50;
        this.prixAchat=500;
        this.prixDestr=250;
        this.taille=1;
        this.type="pavillon";
        this.persBat="habitant";
        this.groupe="logement";
        this.nb_habitant_MAX=10;
        this.nb_habitant=0;
    }
    
}
