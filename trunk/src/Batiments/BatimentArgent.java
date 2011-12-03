package Batiments;

public abstract class BatimentArgent extends Batiment {
       private int ressource;
       private int nb_employe;
       private int nb_employe_MAX;    

    /*GETTERS*/
    public int getNb_employe() {
        return nb_employe;
    }
    
    public int getNb_employe_MAX() {
        return nb_employe_MAX;
    }

    public int getRessource() {
        return ressource;
    }
    
    /*SETTERS*/
    public void setRessource(int ressource) {
        this.ressource = ressource;
    }    

    public void setNb_employe(int nb_employe) {
        this.nb_employe = nb_employe;
    }
    
    public void setNb_employe_MAX(int nb_employe_MAX) {
        this.nb_employe_MAX = nb_employe_MAX;
    }
}
