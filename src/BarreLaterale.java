import java.awt.*;
import java.util.*;
import javax.swing.*;


public class BarreLaterale extends JPanel implements Observer {
    Ville ville;
    Temps t;
    JPanel info;
    JPanel batiments;
    JPanel conseils;
    JLabel nomMaire;
    JLabel nbHab;
    JLabel date;
    JButton boutonL;
   
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
        
        
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200,700));
        this.setLayout(new BorderLayout());
        
        //Panel au NORD contenant les informations
        info = new JPanel();
        info.setBackground(new Color(153,204,255));
        info.setPreferredSize(new Dimension(200,200));
        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        
        // Ajout des Labels
        nomMaire = new JLabel("Maire " + ville.nomMaire);
        nbHab = new JLabel("" +ville.nbHabitant);
        date = new JLabel(t.c.afficherDate());
       
        info.add(nomMaire);
        info.add(nbHab);
        
        boutonL = new JButton("Logement");
        
        //this.add(nomMaire);
        //this.add(nbHab);
        //this.add(date);
        this.add(info,BorderLayout.NORTH);
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
