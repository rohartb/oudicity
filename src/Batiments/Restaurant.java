package Batiments;

import Oudicity.*;

public class Restaurant extends Loisir {
    
    public Restaurant(OudiCity o){
        super(o);
         this.type="restaurant";
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
