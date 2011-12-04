package Batiments;
import Oudicity.*;

public class Building extends Logement {
    
    public Building(OudiCity o){
       super(o);
       this.coutEntretien=10;
       this.prixAchat=10;
       this.prixDestr=5;
       this.taille=1;
       this.type="building";
       this.nb_habitant_MAX=100;
       this.nb_habitant=0;
    }
    
}
