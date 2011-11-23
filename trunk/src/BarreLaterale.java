import java.util.*;
import javax.swing.*;


public class BarreLaterale extends JPanel implements Observer {
    Ville ville;
    Temps t;
    JLabel nomMaire;
    JLabel nbHab;
    JLabel date;
    JButton boutonL = new JButton("Logement");
   
    int annee = 1970;
    int jour = 1;
    int mois = 1;
    int nbHabitant = 0;
    int argent = 20000;
    
    public BarreLaterale(Ville v,Temps t){
        ville = v;
        this.t = t;
        t.c.addObserver(this);
        ville.addObserver(this);
    }
  
    
    @Override
    public void update(Observable o, Object arg) {
        Ville v = new Ville();
        Calendrier c = new Calendrier();
        
        if(o.getClass() == c.getClass()){
            c = (Calendrier) o;
            if(jour != c.jour){
                jour = c.jour;
                date.setText(c.afficherDate());
            }
        } else {
            v  = (Ville) o;
            if(nbHabitant != v.nbHabitant){
                nbHabitant = v.nbHabitant;
                nbHab.setText("" + nbHabitant);
            }
        }
    }
    
}
