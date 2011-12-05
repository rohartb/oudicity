package Batiments;
import Oudicity.*;

public abstract class  Batiment {
    OudiCity s;
    
    protected String type;
    protected String persBat;
    protected String groupe;
    protected int taille;
    protected int coutEntretien;
    protected int prixAchat;
    protected int prixDestr;
    protected boolean acces_route;

    public Batiment(OudiCity s){
        this.s = s;
        this.type="herbe";  
        this.persBat ="aucun";
        this.groupe = "batiment";
        this.acces_route=false;
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
    
    public String getGroupe(){
        return groupe;
    }
    
    /*SETTERS*/
    public void setType(String type){
        this.type=type;
    }

                
}
