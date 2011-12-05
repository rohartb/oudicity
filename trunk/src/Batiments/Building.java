package Batiments;
import Oudicity.*;

public class Building extends Logement {
    
    public Building(OudiCity o){
       super(o);
       this.coutEntretien=150;
       this.prixAchat=1500;
       this.prixDestr=750;
       this.taille=1;
       this.type="building";
       this.persBat="habitant";
       this.groupe="logement";       
       this.nb_habitant_MAX=100;
       this.nb_habitant=0;
    }
    
}
