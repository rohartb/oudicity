import java.awt.*;
import java.util.*;
import javax.swing.*;


public class BarreLaterale extends JPanel implements Observer {
    OudiCity o;
    Temps t;
    Ville v;
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
    JButton bDestroy;
    JPopupMenu popup;
    
   
    int annee = 1970;
    int jour = 1;
    int mois = 1;
    int nbHabitant = 0;
    int argent = 20000;   
    
    public BarreLaterale(OudiCity o){
        this.o =o;
        v = o.v;
        o.t.c.addObserver(this);
        o.v.addObserver(this);
        
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
        
        maire = new JLabel(v.nomMaire);
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
        bLog.addActionListener(new EcouteurDeBarreLateral(o));
        bLog.setActionCommand("logement");
        
        bIndus = new JButton(new ImageIcon("Image/usine.png"));
        bIndus.addActionListener(new EcouteurDeBarreLateral(o));
        bIndus.setActionCommand("industrie");
        
        bCommerce = new JButton(new ImageIcon("Image/commerce.png"));
        bCommerce.addActionListener(new EcouteurDeBarreLateral(o));
        bCommerce.setActionCommand("commerce");
        
        bLoisir = new JButton(new ImageIcon("Image/loisir.png"));
        bLoisir.addActionListener(new EcouteurDeBarreLateral(o));
        bLoisir.setActionCommand("loisir");
        
        bFerme = new JButton(new ImageIcon("Image/ferme.png"));
        bFerme.addActionListener(new EcouteurDeBarreLateral(o));
        bFerme.setActionCommand("ferme");
        
        bRoute = new JButton(new ImageIcon("Image/route.png"));
        bRoute.addActionListener(new EcouteurDeBarreLateral(o));
        bRoute.setActionCommand("route");

        bDestroy = new JButton(new ImageIcon("Image/bulldozer.gif"));
        bDestroy.addActionListener(new EcouteurDeBarreLateral(o));
        bDestroy.setActionCommand("destroy");

        JButton bPop = new JButton(new ImageIcon("Image/maison.png"));
        bPop.addActionListener(new EcouteurDePopup(o));
        bPop.setActionCommand("1");

        JButton bPop2 = new JButton(new ImageIcon("Image/immeuble gif"));
        bPop2.addActionListener(new EcouteurDePopup(o));
        bPop2.setActionCommand("2");

        JButton bPop3 = new JButton(new ImageIcon("Image/ferme.png"));
        bPop3.addActionListener(new EcouteurDePopup(o));
        bPop3.setActionCommand("3");

        popup = new JPopupMenu("Logements");
        
        batiments.add(bLog);
        batiments.add(bIndus);
        batiments.add(bCommerce);
        batiments.add(bLoisir);
        batiments.add(bFerme);
        batiments.add(bRoute);
        batiments.add(bDestroy);
        popup.setLayout(new GridLayout(1,3));
        popup.add(bPop);
        popup.add(bPop2);
        popup.add(bPop3);
        
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
        Ville ville = new Ville();
        Calendrier c = new Calendrier();
        
        if(o.getClass() == c.getClass()){
            c = (Calendrier) o;
            if(jour != c.jour){
                jour = c.jour;
                date.setText(c.afficherDate());
            }
        } else {
            ville  = (Ville) o;
            if(nbHabitant != ville.nbHabitant){
                nbHabitant = ville.nbHabitant;
                nbHab.setText("" + nbHabitant);
            }
        }
    }
    
}
