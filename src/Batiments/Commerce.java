package Batiments;

public class Commerce extends BatimentArgent{
    private int stock_nourriture;
    private int stock_bien;
    public Commerce(){
        this.setCoutEntretien(10);
        this.setNb_employe_MAX(10);
        this.setNb_employe(0);          
        this.setPrixAchat(10);
        this.setPrixDestr(5);     
        this.setTaille(1);
        this.setType("commmerce");
        this.stock_bien=0;
        this.stock_nourriture=0;              
    }

    /*GETTERS*/
    public int getStock_bien() {
        return stock_bien;
    }

    public int getStock_nourriture() {
        return stock_nourriture;
    }

    /*SETTERS*/
    public void setStock_nourriture(int stock_nourriture) {
        this.stock_nourriture = stock_nourriture;
    }

    public void setStock_bien(int stock_autre) {
        this.stock_bien = stock_autre;
    }
    
}
