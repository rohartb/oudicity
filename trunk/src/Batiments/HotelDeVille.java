package Batiments;

import Oudicity.*;

public class HotelDeVille extends ServicePublic{
    public HotelDeVille(OudiCity o){
        super(o);
        this.coutEntretien=80;
        this.nb_employe_MAX=12;
        this.nb_employe=0;
        this.prixAchat=800;
        this.prixDestr=400;
        this.taille=1;
        this.type="hoteldeville";
        this.persBat="employe";
        this.groupe="servicepublic";
        this.zoneInfluence=20;        
    }
}
