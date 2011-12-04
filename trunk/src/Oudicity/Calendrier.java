package Oudicity;
import java.util.Observable;

public class Calendrier extends Observable{
    public int jour;
    public int mois;
    public int annee;
    
    public Calendrier(){
        jour = 1;
        mois = 1;
        annee = 1970;
    }

    void augmenterJour() {
        if(jour == 31){
            jour = 1;
            augmenterMois();
        } else {  
            jour++;
        }
        setChanged();
        notifyObservers(this);
    }

    private void augmenterMois() {
        if(mois == 12){
            mois = 1;
            annee++;
        } else {
            mois++;
        }
        setChanged();
        notifyObservers(this);
    }
        
    public String afficherDate(){
        return jour+"/"+mois+"/"+annee;
    }

    void waitTime(int v) throws InterruptedException {
        if (v == 1){
            Thread.sleep(2000);
        }
    }
       
}
