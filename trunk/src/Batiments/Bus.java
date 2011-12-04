package Batiments;

import Oudicity.*;

public class Bus extends Infrastructure{
    public Bus(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.prixAchat=10;
        this.prixDestr=5;
        this.taille=1;
        this.type="bus";
        this.persBat="aucun";
        this.groupe="infrastructure";        
        this.nb_employe_MAX=0; 
        this.nb_employe=0;               
    }
}
