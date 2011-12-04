package Batiments;

public class Industrie extends BatimentArgent{
    private int besoin;
    private int production;
    private int bien;
    public Industrie(){
        this.setCoutEntretien(10);
        this.setNb_employe_MAX(20);
        this.setNb_employe(0);                
        this.setPrixAchat(10);
        this.setPrixDestr(5);
        this.setTaille(1);
        this.setType("industrie");
        this.besoin=100; 
        this.bien=this.besoin/10;
    }

    public int getBesoin() {
        return besoin;
    }

    public int getBien() {
        return bien;
    }

    public void setBesoin(int besoin) {
        this.besoin = besoin;
        this.bien = besoin/10;
    }
    
}
