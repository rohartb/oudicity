package Batiments;

public abstract class BatimentArgent extends Batiment {
       private int ressource;
       private int nb_employe;    

    /*GETTERS*/
    public int getNb_employe() {
        return nb_employe;
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
}
