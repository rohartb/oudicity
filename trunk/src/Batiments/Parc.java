package Batiments;

import Oudicity.*;

public class Parc extends Loisir{
    
    public Parc(OudiCity o){
        super(o);
        this.type="parc";
        this.persBat="aucun";
        this.prixAchat=10;
        this.prixDestr=5;
        this.coutEntretien=10;
        this.taille=1;
        this.attraction=12;             
    }
}
