package Batiments;

public abstract class ServicePublic extends Batiment {
    private int zoneInfluence;
    private int nb_employe;

    /*GETTERS*/
    public int getNb_employe() {
        return nb_employe;
    }

    public int getZoneInfluence() {
        return zoneInfluence;
    }
    
    /*SETTERS*/

    public void setNb_employe(int nb_employe) {
        this.nb_employe = nb_employe;
    }

    public void setZoneInfluence(int zoneInfluence) {
        this.zoneInfluence = zoneInfluence;
    }   
}
