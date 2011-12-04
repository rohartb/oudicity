package Batiments;
import Oudicity.*;

public abstract class  Batiment {
    OudiCity o;
    
    protected String type;
    protected String persBat;
    protected int taille;
    protected int coutEntretien;
    protected int prixAchat;
    protected int prixDestr;

    public Batiment(OudiCity o){
        this.o =o;
        this.type="herbe";  
        this.persBat ="aucun";
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
    
    public String getPersBat() {
        return persBat;
    }
    
    /*SETTERS*/
    public void setType(String type){
        this.type=type;
    }

                
}
