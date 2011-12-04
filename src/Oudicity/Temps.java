package Oudicity;

public class Temps implements Runnable {
    int vitesse;
    public Calendrier c = new Calendrier();
    
    public Temps(int v){
        vitesse = v;
    }
        
    @Override
    public void run(){ 
        while(true){
            if(vitesse == 1){
                try {
                    c.waitTime(vitesse);
                    c.augmenterJour();
                }catch(InterruptedException e){
                    System.out.println("interrupted exception : "+e.getMessage());
                } 
            }
        }
    }
}
