package Batiments;
import Oudicity.*;

public class Cinema extends Loisir {
    public Cinema(OudiCity o){
        super(o);
         this.type="cinema";
         this.persBat="employe";
         this.groupe="loisir";         
         this.prixAchat=600;
         this.prixDestr=300;
         this.coutEntretien=60;
         this.taille=1;
         this.attraction=100;
         this.nb_employe_MAX=10;           
         this.nb_employe=0;                 
    }
}
