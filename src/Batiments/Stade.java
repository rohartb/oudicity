package Batiments;

import Oudicity.*;

public class Stade extends Loisir{
    public Stade(OudiCity o){
        super(o);
         this.type="stade";
         this.prixAchat=10;
         this.prixDestr=5;
         this.coutEntretien=10;
         this.taille=1;
         this.attraction=12;
         this.nb_employe_MAX=10;           
         this.nb_employe=0; 
    }
}
