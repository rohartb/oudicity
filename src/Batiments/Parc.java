package Batiments;

import Oudicity.*;

public class Parc extends Loisir{
    
    public Parc(OudiCity o){
        super(o);
        this.type="parc";
        this.persBat="aucun";
        this.groupe="loisir";
        this.prixAchat=600;
        this.prixDestr=300;
        this.coutEntretien=60;
        this.taille=1;
        this.attraction=100;             
    }
}
