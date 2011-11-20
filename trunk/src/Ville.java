import Batiments.Batiment;
import java.util.*;

public class Ville extends Observable{
    Temps t;
    
    Batiment plateau[][];
    
    String nomVille;
    String nomMaire;
    int nbHabitant;
    int argent;
    int indiceAttraction;
    
    Ville(String v, String m, Temps t){
        nomVille = v;
        nomMaire = m;
        argent = 20000;
        nbHabitant = 0;
        indiceAttraction = 50;
    }
    
}
