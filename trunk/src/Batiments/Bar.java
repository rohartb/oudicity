package Batiments;

import Oudicity.*;

public class Bar extends Loisir{
    public Bar(OudiCity o){
        super(o);
         this.type="bar";
         this.persBat="employe";
         this.groupe="loisir";         
         this.prixAchat=300;
         this.prixDestr=150;
         this.coutEntretien=30;
         this.taille=1;
         this.attraction=50;
         this.nb_employe_MAX=5;           
         this.nb_employe=0;       
    }
}
