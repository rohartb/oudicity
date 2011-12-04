package Batiments;

import Oudicity.*;

public class Ecole extends ServicePublic{
    public Ecole(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.nb_employe_MAX=10;
        this.nb_employe=0;
        this.prixAchat=10;
        this.prixDestr=5;
        this.taille=1;
        this.type="ecole";
        this.persBat="employe";
        this.zoneInfluence=50;        
    }
    
}
