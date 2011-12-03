import java.awt.*;
import java.util.*;
import javax.swing.*;


public class BarreLaterale extends JPanel implements Observer {
    Ville ville;
    Temps t;
    PlateauGraphique p;
    
    // panels 
    JPanel info;
    JPanel batiments;
    JPanel conseils;
    
    // Jlabel du panel info
    JLabel nomMaire;
    JLabel maire;
    JLabel nbHab;
    JLabel hab;
    JLabel datel;
    JLabel date;
    
    // Boutons du panel batiments
    JButton bLog;
    JButton bCommerce;
    JButton bIndus;
    JButton bFerme;
    JButton bLoisir;
    JButton bRoute;
    
   
    int annee = 1970;
    int jour = 1;
    int mois = 1;
    int nbHabitant = 0;
    int argent = 20000;   
    
    public BarreLaterale(Ville v,Temps t,PlateauGraphique p){
        ville = v;
        this.t = t;
        this.p = p;
        t.c.addObserver(this);
        ville.addObserver(this);
        
        
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200,700));
        this.setLayout(new BorderLayout());
        
        //Panel au NORD contenant les informations
        info = new JPanel();
        info.setBackground(new Color(153,204,255));
        info.setPreferredSize(new Dimension(200,150));
        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        
        // Ajout des Labels
        nomMaire = new JLabel("Maire");
        nomMaire.setAlignmentX(CENTER_ALIGNMENT);
        nomMaire.setFont(new Font("lala",Font.TYPE1_FONT,20));
        
        maire = new JLabel(ville.nomMaire);
        maire.setAlignmentX(CENTER_ALIGNMENT);
        maire.setFont(new Font("lala",Font.TYPE1_FONT,15));
        
        hab = new JLabel("Nombre Habitants");
        hab.setAlignmentX(CENTER_ALIGNMENT);
        
        nbHab = new JLabel("0");
        nbHab.setAlignmentX(CENTER_ALIGNMENT);
        
        datel = new JLabel("Date");
        datel.setAlignmentX(CENTER_ALIGNMENT);
        
        date = new JLabel("1/1/1970");
        date.setAlignmentX(CENTER_ALIGNMENT);
       
        info.add(nomMaire);
        info.add(maire);
        info.add(hab);
        info.add(nbHab);
        info.add(datel);
        info.add(date); 
        
        //Panel des batiments
        batiments = new JPanel();
        batiments.setLayout(new GridLayout(3,2));
        batiments.setBackground(new Color(204,255,102));
        batiments.setPreferredSize(new Dimension(100,200));
        
        //Ajout des bouton qui symbolisent les batiments 
        bLog = new JButton(new ImageIcon("Image/maison.png"));
        bLog.setPreferredSize(new Dimension(30,30));
        bLog.addActionListener(new EcouteurDeBarreLateral(p));
        bLog.addMouseListener(new EcouteurDeBarreLateral(p));
        bLog.addMouseMotionListener(new EcouteurDeBarreLateral(p));
        bLog.setActionCommand("logement");
        
        bIndus = new JButton(new ImageIcon("Image/usine.png"));
        bIndus.addActionListener(new EcouteurDeBarreLateral(p));
        bIndus.addMouseListener(new EcouteurDeBarreLateral(p));
        bIndus.addMouseMotionListener(new EcouteurDeBarreLateral(p));
        bIndus.setActionCommand("industrie");
        
        bCommerce = new JButton(new ImageIcon("Image/commerce.png"));
        bCommerce.addActionListener(new EcouteurDeBarreLateral(p));
        bCommerce.addMouseListener(new EcouteurDeBarreLateral(p));
        bCommerce.addMouseMotionListener(new EcouteurDeBarreLateral(p));
        bCommerce.setActionCommand("commerce");
        
        bLoisir = new JButton(new ImageIcon("Image/loisir.png"));
        bLoisir.addActionListener(new EcouteurDeBarreLateral(p));
        bLoisir.addMouseListener(new EcouteurDeBarreLateral(p));
        bLoisir.addMouseMotionListener(new EcouteurDeBarreLateral(p));
        bLoisir.setActionCommand("loisir");
        
        bFerme = new JButton(new ImageIcon("Image/ferme.png"));
        bFerme.addActionListener(new EcouteurDeBarreLateral(p));
        bFerme.addMouseListener(new EcouteurDeBarreLateral(p));
        bFerme.addMouseMotionListener(new EcouteurDeBarreLateral(p));
        bFerme.setActionCommand("ferme");
        
        bRoute = new JButton(new ImageIcon("Image/route.png"));
        bRoute.addActionListener(new EcouteurDeBarreLateral(p));
        bRoute.addMouseListener(new EcouteurDeBarreLateral(p));
        bRoute.addMouseMotionListener(new EcouteurDeBarreLateral(p));
        bRoute.setActionCommand("route");
        
        batiments.add(bLog);
        batiments.add(bIndus);
        batiments.add(bCommerce);
        batiments.add(bLoisir);
        batiments.add(bFerme);
        batiments.add(bRoute);
        
        //Panel des conseils
        conseils = new JPanel();
        conseils.setBackground(new Color(255,153,51));
        conseils.setPreferredSize(new Dimension(200,200));
        
        this.add(info,BorderLayout.NORTH);
        this.add(batiments,BorderLayout.CENTER);
        this.add(conseils,BorderLayout.SOUTH);
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
