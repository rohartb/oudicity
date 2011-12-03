
package Batiments;

public abstract class Loisir extends Batiment{
    private int attraction;
    private int nb_employe;

    /*GETTERS*/
    public int getAttraction() {
        return attraction;
    }

    public int getNb_employe() {
        return nb_employe;
    }

    /*SETTERS*/
    public void setAttraction(int attraction) {
        this.attraction = attraction;
    }

    public void setNb_employe(int nb_employe) {
        this.nb_employe = nb_employe;
    }
    
    
    
    
}
