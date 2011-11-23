import java.util.*;

public class Habitant {
    int annee = 1970;
    int jour = 1;
    int indiceAttirance;
    int nbHab;
    
    Habitant(int i, int n){
        indiceAttirance = i;
        nbHab = n;
    }

    int augmentetHabitant(int indiceAttraction) {
        return nbHab++;
    }
}
