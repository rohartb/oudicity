package Batiments;

public class Infrastructure extends Batiment{
    private int nb_employe;
    private int nb_employe_MAX;

    /*GETTERS*/
    public int getNb_employe() {
        return nb_employe;
    }
    
    public int getNb_employe_MAX() {
        return nb_employe_MAX;
    }

    /*SETTERS*/
    public void setNb_employe(int nb_employe) {
        this.nb_employe = nb_employe;
    }
    
    public void setNb_employe_MAX(int nb_employe_MAX) {
        this.nb_employe_MAX = nb_employe_MAX;
    }
    
}