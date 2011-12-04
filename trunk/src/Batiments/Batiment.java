package Batiments;

public abstract class  Batiment {

    private String type;
    private int taille;
    private int coutEntretien;
    private int prixAchat;
    private int prixDestr;
    //boolean accesRoute;
    // int nbOccupant;

    public Batiment(){
           this.type="herbe";        
    }
    
    /*SETTERS*/
    public void setCoutEntretien(int coutEntretien) {
        this.coutEntretien = coutEntretien;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public void setPrixDestr(int prixDestr) {
        this.prixDestr = prixDestr;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    /*GETTERS*/
    public int getCoutEntretien() {
        return coutEntretien;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public int getPrixDestr() {
        return prixDestr;
    }

    public int getTaille() {
        return taille;
    }

    public String getType() {
        return type;
    } 
}
