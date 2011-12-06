package Oudicity;

import Batiments.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;



public class BarreLaterale extends JPanel implements Observer {
    OudiCity o;
    Temps t;
    Ville v;
    PlateauGraphique pg;
    
    // panels 
    JPanel info;
    JPanel batiments;
    JPanel conseils;
    JPanel conseil = new JPanel();
    
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
    JButton bBar;
    JButton bCine;
    JButton bParc;
    JButton bResto;
    JButton bStade;
    JButton bZoo;

    //boutons pour les infrastructures
    JButton bInfra;
    JButton bRoute;

    //boutons pour les services publiques
    JButton bPublique;
    JButton bCommissariat;
    JButton bDecheterie;
    JButton bEcole;
    JButton bHopital;
    JButton bHotelDeVille;
    JButton bPompier;

    //boutons pour la destruction et le déplacement
    JButton bDestroy;
    JButton bDeplace;

    //Différents popup
    JPopupMenu popupLog = new JPopupMenu("Logements");
    JPopupMenu popupBatArg= new JPopupMenu("Batiments Argent");
    JPopupMenu popupInfra= new JPopupMenu("Infrastructure");
    JPopupMenu popupLoisir= new JPopupMenu("Loisir");
    JPopupMenu popupPublique = new JPopupMenu("Publique");
    
   
    int annee = 1970;
    int jour = 1;
    int mois = 1;
    int nbHabitant = 0;
    int argent = 20000;   
    
    public BarreLaterale(OudiCity o){
        this.o =o;
        v = o.v;
        pg = o.f.pg;
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
        
        argentl = new JLabel("OudiZ");
        argentl.setAlignmentX(CENTER_ALIGNMENT);
        
        argenta = new JLabel("20000 Ƶ");
        argenta.setAlignmentX(CENTER_ALIGNMENT);
       
        info.add(nomMaire);
        info.add(maire);
        info.add(hab);
        info.add(nbHab);
        info.add(datel);
        info.add(date); 
        info.add(argentl);
        info.add(argenta); 
        
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
        bLog = new JButton(new ImageIcon("Image/maisonSF.png"));
        bLog.setPreferredSize(new Dimension(30,30));
        bLog.addActionListener(new EcouteurDeBarreLateral(o));
        bLog.setActionCommand("logement");

        bPavillon = new JButton(new ImageIcon("Image/pavillon.png"));
        bPavillon.addActionListener(new EcouteurDePopup(o));
        bPavillon.setActionCommand("pavillon");


        bHLM = new JButton(new ImageIcon("Image/immeu ble.png"));
        bHLM.addActionListener(new EcouteurDePopup(o));
        bHLM.setActionCommand("HLM");

        bBuilding = new JButton(new ImageIcon("Image/build ing.png"));
        bBuilding.addActionListener(new EcouteurDePopup(o));
        bBuilding.setActionCommand("building");

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

        bBar = new JButton("Bar");
        bBar.addActionListener(new EcouteurDePopup(o));
        bBar.setActionCommand("bar");

        bCine = new JButton("Cinema");
        bCine.addActionListener(new EcouteurDePopup(o));
        bCine.setActionCommand("cinema");

        bParc = new JButton("Parc");
        bParc.addActionListener(new EcouteurDePopup(o));
        bParc.setActionCommand("parc");

        bResto = new JButton("Restaurant");
        bResto.addActionListener(new EcouteurDePopup(o));
        bResto.setActionCommand("restaurant");

        bStade = new JButton("Stade");
        bStade.addActionListener(new EcouteurDePopup(o));
        bStade.setActionCommand("stade");

        bZoo = new JButton("Zoo");
        bZoo.addActionListener(new EcouteurDePopup(o));
        bZoo.setActionCommand("zoo");

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

        //////////////////////////////////////////////////
        //                                              //
        //      Bouton et Popup pour les services       //
        //                  Publiques                   //
        //////////////////////////////////////////////////
        bPublique = new JButton("Publique");
        bPublique.addActionListener(new EcouteurDeBarreLateral(o));
        bPublique.setActionCommand("publique");
        

        bCommissariat = new JButton("Commissariat");
        bCommissariat.addActionListener(new EcouteurDePopup(o));
        bCommissariat.setActionCommand("commissariat");

        bDecheterie = new JButton("Decheterie");
        bDecheterie.addActionListener(new EcouteurDePopup(o));
        bDecheterie.setActionCommand("decheterie");

        bEcole = new JButton("Ecole");
        bEcole.addActionListener(new EcouteurDePopup(o));
        bEcole.setActionCommand("ecole");

        bHopital = new JButton(new ImageIcon("Image/hopitalSF.png"));
        bHopital.addActionListener(new EcouteurDePopup(o));
        bHopital.setActionCommand("hopital");

        bHotelDeVille = new JButton("Hotel de Ville");
        bHotelDeVille.addActionListener(new EcouteurDePopup(o));
        bHotelDeVille.setActionCommand("hotel");

        bPompier = new JButton("Pompier");
        bPompier.addActionListener(new EcouteurDePopup(o));
        bPompier.setActionCommand("pompier");

        //////////////////////////////////////////////////
        //                                              //
        //          Bouton pour la destruction          //
        //                                              //
        //////////////////////////////////////////////////
        bDestroy = new JButton(new ImageIcon("Image/bulldozer.png"));
        bDestroy.addActionListener(new EcouteurDeBarreLateral(o));
        bDestroy.setActionCommand("destroy");

        bDeplace = new JButton(new ImageIcon("Image/b ulldozer.png"));
        bDeplace.addActionListener(new EcouteurDeBarreLateral(o));
        bDeplace.setActionCommand("deplace");

        

        
        batiments.add(bLog);
        batiments.add(bBatimentArgent);
        batiments.add(bLoisir);
        batiments.add(bInfra);
        batiments.add(bPublique);
        batiments.add(bDestroy);
        batiments.add(bDeplace);

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

        popupLoisir.setLayout(new GridLayout(2,3));
        popupLoisir.add(bBar);
        popupLoisir.add(bCine);
        popupLoisir.add(bParc);
        popupLoisir.add(bResto);
        popupLoisir.add(bStade);
        popupLoisir.add(bZoo);

        popupPublique.setLayout(new GridLayout(2,3));
        popupPublique.add(bCommissariat);
        popupPublique.add(bDecheterie);
        popupPublique.add(bEcole);
        popupPublique.add(bHopital);
        popupPublique.add(bHotelDeVille);
        popupPublique.add(bPompier);

        
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
            if(argent != ville.argent ){
                argent = ville.argent;
                argenta.setText(argent + " Ƶ");
            }
        }
    }

    //Initialisation de la barre des conseils
    void initConseil(Points points){
        this.remove(conseils);
        this.remove(conseil);
        conseil = new JPanel();
        conseil.setBackground(new Color(255,153,51));
        conseil.setPreferredSize(new Dimension(200,200));
        String scourant = pg.getPlateau().plateau[points.getX()][points.getY()]
                .getGroupe();
        String nbs= "", inter;
        int nb = 0, cout = 0;
        if (scourant.equals("logement")){
            nbs = "Nombre Habitants = ";
            Logement log = (Logement)o.f.pg.getPlateau().
                    plateau[points.getX()][points.getY()];
            nb = log.getNb_habitant();
            cout = log.getPrixDestr();

        }else if (scourant.equals("batimentargent")){
            nbs = "Nombre d'Employés = ";
            BatimentArgent arg = (BatimentArgent) o.f.pg.getPlateau().
                    plateau[points.getX()][points.getY()];
            nb = arg.getNb_employe();
            cout = arg.getPrixDestr();

        }else if (scourant.equals("infrastructure")){
            nbs = "";
            Infrastructure infra = (Infrastructure) o.f.pg.getPlateau().
                    plateau[points.getX()][points.getY()];
            nb = -1;
            cout = infra.getPrixDestr();

        }

        JLabel snb = new JLabel(nbs);
        snb.setAlignmentX(LEFT_ALIGNMENT);

        if(nb >= 0){
            inter = ""+nb;
        }else{
            inter = "";
        }
        JLabel nbPers = new JLabel("");
        nbPers.setAlignmentX(RIGHT_ALIGNMENT);

        JLabel sCout = new JLabel("Coût de destruction");
        sCout.setAlignmentX(LEFT_ALIGNMENT);

        JLabel Cout = new JLabel(""+cout);
        Cout.setAlignmentX(RIGHT_ALIGNMENT);

        conseil.add(snb);
        conseil.add(nbPers);
        conseil.add(sCout);
        conseil.add(Cout);

        this.add(conseil,BorderLayout.SOUTH);
    }

    public void reInit(){
        this.remove(conseil);
        conseils = new JPanel();
        conseils.setBackground(new Color(255,153,51));
        conseils.setPreferredSize(new Dimension(200,200));
        this.add(conseils, BorderLayout.SOUTH);
    }
    
}
