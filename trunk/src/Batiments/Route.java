package Batiments;

import Oudicity.*;

public class Route extends Infrastructure{
    
    public Route(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.prixAchat=10;
        this.prixDestr=5;
        this.taille=1;
        this.type="route";
        this.persBat="aucun";
        this.groupe="infrastructure";
        this.nb_employe_MAX=0; 
        this.nb_employe=0;             
    }         
}
