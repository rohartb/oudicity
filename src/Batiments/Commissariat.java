package Batiments;

import Oudicity.*;

public class Commissariat extends ServicePublic{
    public Commissariat(OudiCity o){
        super(o);
        this.coutEntretien=10;
        this.nb_employe_MAX=10;
        this.nb_employe=0;
        this.prixAchat=10;
        this.prixDestr=5;
        this.taille=1;
        this.type="commissariat";
        this.persBat="employe";
        this.zoneInfluence=50;    
    }
}
