package Batiments;

import Oudicity.*;

public abstract class ServicePublic extends Batiment {
    protected int zoneInfluence;
    protected int nb_employe;
    protected int nb_employe_MAX;
    
    public ServicePublic(OudiCity o){
        super(o);
    }

    /*GETTERS*/
    public int getNb_employe() {
        return nb_employe;
    }

    public int getZoneInfluence() {
        return zoneInfluence;
    }
    
    public int getNb_employe_MAX() {
        return nb_employe_MAX;
    }
    
    public int getAugmenter_employe() {
        return nb_employe_MAX-nb_employe;
    }
    
    /*SETTERS*/

    public void setNb_employe(int nb_employe) {
        this.nb_employe += nb_employe;
    }

    /*public void setZoneInfluence(int zoneInfluence) {
        this.zoneInfluence = zoneInfluence;
    }*/
    
    /*public void setNb_employe_MAX(int nb_employe_MAX) {
        this.nb_employe_MAX = nb_employe_MAX;
    }*/
}
