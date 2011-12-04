package Batiments;

public abstract class BatimentArgent extends Batiment {
       private int ressource;
       private int nb_employe;
       private int nb_employe_MAX;
       private int besoin;
       private boolean augmenter_employe;

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
    
    public int getBesoin() {
        return besoin;
    }
    
    public boolean getAugmenter_employe() {
        return augmenter_employe;
    }
    
    /*SETTERS*/
   /* public void setRessource(int ressource) {
        this.ressource = ressource;
    }*/
    //ressource calculée en fontion des besoins
    //   ->modification seulement dans set_besoin

    public void setNb_employe(int nb_employe) {
        this.nb_employe = nb_employe;
        if(this.nb_employe==this.nb_employe_MAX){
            this.augmenter_employe=false;
        }
        else{
            this.augmenter_employe=true;
        }
    }
    
    public void setNb_employe_MAX(int nb_employe_MAX) {
        this.nb_employe_MAX = nb_employe_MAX;
    }
    
    public void setBesoin(int besoin) {
        this.besoin = besoin;
        this.ressource= besoin/10;
    }
    
    /*public void setAugmenter_employe(boolean augmenter_employe) {
        this.augmenter_employe = augmenter_employe;
    }*/
    //augmenter_employe calculé en fontion des employés
    //   ->modification seulement dans set_nb_employe
}
