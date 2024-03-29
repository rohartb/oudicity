
package Batiments;

import Oudicity.*;

public abstract class Loisir extends Batiment{
    protected int attraction;
    protected int nb_employe;
    protected int nb_employe_MAX;

    public Loisir(OudiCity o){
        super(o);
    }
    
    /*GETTERS*/
    public int getAttraction() {
        return attraction;
    }

    public int getNb_employe() {
        return nb_employe;
    }
    
    public int getNb_employe_MAX() {
        return nb_employe_MAX;
    }
    
    public int getAugmenter_employe() {
        return nb_employe_MAX-nb_employe;
    }

    /*SETTERS*/
    /*public void setAttraction(int attraction) {
        this.attraction = attraction;
    }*/

    public void setNb_employe(int nb_employe) {
        this.nb_employe += nb_employe;
    }
    
    /*public void setNb_employe_MAX(int nb_employe_MAX) {
        this.nb_employe_MAX = nb_employe_MAX;
    }*/
    
    
}
