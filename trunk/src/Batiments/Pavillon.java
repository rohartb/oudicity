package Batiments;

import Oudicity.*;

public class Pavillon extends Logement {
    public Pavillon(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.prixAchat=10;
        this.prixDestr=5;
        this.taille=1;
        this.type="pavillon";
        this.nb_habitant_MAX=10;
        this.nb_habitant=0;
    }
    
}
