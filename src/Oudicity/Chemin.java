package Oudicity;
import java.util.*;

public class Chemin {
    Plateau p;
    
    LinkedList<Points> batHab =  new LinkedList<Points>();
    LinkedList<Points> batCom =  new LinkedList<Points>(); 
    LinkedList<Points> batLoi =  new LinkedList<Points>(); 
    LinkedList<Points> batSerPu =  new LinkedList<Points>();
    LinkedList<Points> batInd =  new LinkedList<Points>(); 
    LinkedList<Points> batFerm =  new LinkedList<Points>(); 
    LinkedList<Points> pc =  new LinkedList<Points>(); 
    int nbBat1;
    int nbBat2;
    
    public Chemin(Plateau p){
        nbBat1 = 0;
        nbBat2 = 0;
    }
}
