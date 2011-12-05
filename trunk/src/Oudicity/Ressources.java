package Oudicity;

public class Ressources {
    Plateau p;
    
    public Ressources(Plateau p){
        this.p = p;
    }
    
    public boolean mangerHab(){
        boolean aManger = false;
        
        return aManger;
    }
    
    public int coutBatiment(Points pt){
        return p.plateau[pt.getX()][pt.getY()].getPrixAchat();
    }
}
