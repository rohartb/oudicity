package Oudicity;

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
    JLabel argentl;
    JLabel argenta;
    
    // Boutons du panel batiments
    //boutton pour les logements
    JButton bLog;
    JButton bPavillon;
    JButton bHLM;
    JButton bBuilding;

    //boutons pour les batiments d'argent
    JButton bBatimentArgent;
    JButton bCommerce;
    JButton bIndus;
    JButton bFerme;

    JButton bLoisir;

    //boutons pour les infrastructures
    JButton bInfra;
    JButton bRoute;

    //boutons pour la destruction
    JButton bDestroy;

    //Différents popup
    JPopupMenu popupLog = new JPopupMenu("Logements");
    JPopupMenu popupBatArg= new JPopupMenu("Batiments Argent");
    JPopupMenu popupInfra= new JPopupMenu("Infrastructure");
    JPopupMenu popupLoisir= new JPopupMenu("Loisir");
    
   
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
        //////////////////////////////////////////////////
        //                                              //
        //      Bouton et Popup pour les logements      //
        //                                              //
        //////////////////////////////////////////////////
        bLog = new JButton(new ImageIcon("Image/maison.png"));
        bLog.setPreferredSize(new Dimension(30,30));
        bLog.addActionListener(new EcouteurDeBarreLateral(o));
        bLog.setActionCommand("logement");

        bPavillon = new JButton(new ImageIcon("Image/maison.png"));
        bPavillon.addActionListener(new EcouteurDePopup(o));
        bPavillon.setActionCommand("pavillon");


        bHLM = new JButton(new ImageIcon("Image/maison.png"));
        bHLM.addActionListener(new EcouteurDePopup(o));
        bHLM.setActionCommand("HLM");

        bBuilding = new JButton(new ImageIcon("Image/maison.png"));
        bBuilding.addActionListener(new EcouteurDePopup(o));
        bBuilding.setActionCommand("Buildings");

        //////////////////////////////////////////////////
        //                                              //
        //      Bouton et Popup pour les batiments      //
        //                    argent                    //
        //////////////////////////////////////////////////
        bBatimentArgent = new JButton(new ImageIcon("Image/usine.png"));
        bBatimentArgent.addActionListener(new EcouteurDeBarreLateral(o));
        bBatimentArgent.setActionCommand("BatimentArgent");

        bIndus = new JButton(new ImageIcon("Image/usine.png"));
        bIndus.addActionListener(new EcouteurDePopup(o));
        bIndus.setActionCommand("industrie");
        
        bCommerce = new JButton(new ImageIcon("Image/commerce.png"));
        bCommerce.addActionListener(new EcouteurDePopup(o));
        bCommerce.setActionCommand("commerce");

        bFerme = new JButton(new ImageIcon("Image/ferme.png"));
        bFerme.addActionListener(new EcouteurDePopup(o));
        bFerme.setActionCommand("ferme");

        //////////////////////////////////////////////////
        //                                              //
        //      Bouton et Popup pour les Loisirs        //
        //                                              //
        //////////////////////////////////////////////////
        bLoisir = new JButton(new ImageIcon("Image/loisir.png"));
        bLoisir.addActionListener(new EcouteurDeBarreLateral(o));
        bLoisir.setActionCommand("loisir");

        //////////////////////////////////////////////////
        //                                              //
        //   Bouton et Popup pour les infrastrcutures   //
        //                                              //
        //////////////////////////////////////////////////
        bInfra = new JButton(new ImageIcon("Image/route.png"));
        bInfra.addActionListener(new EcouteurDeBarreLateral(o));
        bInfra.setActionCommand("infra");

        bRoute = new JButton(new ImageIcon("Image/route.png"));
        bRoute.addActionListener(new EcouteurDePopup(o));
        bRoute.setActionCommand("route");

        bDestroy = new JButton(new ImageIcon("Image/bulldozer.gif"));
        bDestroy.addActionListener(new EcouteurDeBarreLateral(o));
        bDestroy.setActionCommand("destroy");

        

        
        batiments.add(bLog);
        batiments.add(bBatimentArgent);
        batiments.add(bLoisir);
        batiments.add(bInfra);
        batiments.add(bDestroy);

        popupLog.setLayout(new GridLayout(1,3));
        popupLog.add(bPavillon);
        popupLog.add(bHLM);
        popupLog.add(bBuilding);

        popupBatArg.setLayout(new GridLayout(1,3));
        popupBatArg.add(bIndus);
        popupBatArg.add(bFerme);
        popupBatArg.add(bCommerce);

        popupInfra.setLayout(new GridLayout(1,1));
        popupInfra.add(bRoute);
        
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
