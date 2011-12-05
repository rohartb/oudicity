package Batiments;

import Oudicity.*;

public class Stade extends Loisir{
    public Stade(OudiCity o){
        super(o);
         this.type="stade";
         this.persBat="employe";
         this.groupe="loisir";
         this.prixAchat=2000;
         this.prixDestr=1000;
         this.coutEntretien=200;
         this.taille=1;
         this.attraction=200;
         this.nb_employe_MAX=15;           
         this.nb_employe=0; 
    }
}
