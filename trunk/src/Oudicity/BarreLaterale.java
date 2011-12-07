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
    JPanel south;
    JPanel conseils;
    JPanel infoBat;

    //Tous les composants servant à l'affichage des conseils
    JLabel subvention;
    JPanel sub;
    JButton moins;
    JButton plus;
    EcouteurDeBarreLateral ec;
    JLabel labSub = new JLabel();
    int cons = 0;
    JLabel cons1 = new JLabel("");
    JLabel cons2 = new JLabel("");
    JLabel cons3 = new JLabel("");
    JLabel cons4 = new JLabel("");
     
    
    // Panel affichage
    JPanel maire;
    JPanel hab;
    JPanel datel;
    JPanel argentl;
    
    // Jlabel du panel info
    JLabel nomMaire;
    JLabel nbHab;   
    JLabel date;   
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
        info.setPreferredSize(new Dimension(200,250));
        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        
        // Ajout des Labels
        
       
        nomMaire = new JLabel(v.nomMaire);
        nomMaire.setAlignmentX(CENTER_ALIGNMENT);
        nomMaire.setFont(new Font("lala",Font.TYPE1_FONT,15));
        
        maire = new JPanel();
        maire.setBorder(BorderFactory.createTitledBorder("Maire"));
        maire.setBackground(new Color(153,204,255));
        maire.add(nomMaire);	
        
        nbHab = new JLabel("0");
        nbHab.setAlignmentX(CENTER_ALIGNMENT);
        nbHab.setFont(new Font("lala",Font.TYPE1_FONT,15));
        
        hab = new JPanel();
        hab.setBorder(BorderFactory.createTitledBorder("Nombre d'habitant"));
        hab.setBackground(new Color(153,204,255));
        hab.add(nbHab);
        

        date = new JLabel("1/1/1970");
        date.setAlignmentX(CENTER_ALIGNMENT);
        date.setFont(new Font("lala",Font.TYPE1_FONT,15));
        
        datel = new JPanel();
        datel.setBorder(BorderFactory.createTitledBorder("Date"));
        datel.setBackground(new Color(153,204,255));
        datel.add(date);
        
        argenta = new JLabel("20000 Ƶ");
        argenta.setAlignmentX(CENTER_ALIGNMENT);
        argenta.setFont(new Font("lala",Font.TYPE1_FONT,15));
        
        argentl = new JPanel();
        argentl.setBorder(BorderFactory.createTitledBorder("Budget"));
        argentl.setBackground(new Color(153,204,255));
        argentl.add(argenta);
       
        info.add(maire);
        info.add(hab);
        info.add(datel); 
        info.add(argentl);
        
        //Panel des batiments
        batiments = new JPanel();
        batiments.setBackground(new Color(153,204,255));
        batiments.setPreferredSize(new Dimension(100,100));

        
        //Ajout des bouton qui symbolisent les batiments
        //////////////////////////////////////////////////
        //                                              //
        //      Bouton et Popup pour les logements      //
        //                                              //
        //////////////////////////////////////////////////
        bLog = new JButton("Logement");
        bLog.setPreferredSize(new Dimension(150,30));
        bLog.addActionListener(new EcouteurDeBarreLateral(o));
        bLog.setActionCommand("logement");

        bPavillon = new JButton(new ImageIcon("Image/maison.png"));
        bPavillon.addActionListener(new EcouteurDePopup(o));
        bPavillon.setActionCommand("pavillon");
        bPavillon.setToolTipText("Pavillon");

        bHLM = new JButton(new ImageIcon("Image/hlm.png"));
        bHLM.addActionListener(new EcouteurDePopup(o));
        bHLM.setActionCommand("HLM");
        bHLM.setToolTipText("HLM");

        bBuilding = new JButton(new ImageIcon("Image/building.png"));
        bBuilding.addActionListener(new EcouteurDePopup(o));
        bBuilding.setActionCommand("building");
        bBuilding.setToolTipText("Building");

        //////////////////////////////////////////////////
        //                                              //
        //      Bouton et Popup pour les batiments      //
        //                    argent                    //
        //////////////////////////////////////////////////
        
        bBatimentArgent = new JButton("Entreprise");
        bBatimentArgent.setPreferredSize(new Dimension(150,30));
        bBatimentArgent.addActionListener(new EcouteurDeBarreLateral(o));
        bBatimentArgent.setActionCommand("BatimentArgent");

        bIndus = new JButton(new ImageIcon("Image/industrie.png"));
        bIndus.addActionListener(new EcouteurDePopup(o));
        bIndus.setActionCommand("industrie");
        bIndus.setToolTipText("industrie");
        
        bCommerce = new JButton(new ImageIcon("Image/commerce.png"));
        bCommerce.addActionListener(new EcouteurDePopup(o));
        bCommerce.setActionCommand("commerce");
        bCommerce.setToolTipText("Commerce");

        bFerme = new JButton(new ImageIcon("Image/ferme.png"));
        bFerme.addActionListener(new EcouteurDePopup(o));
        bFerme.setActionCommand("ferme");
        bFerme.setToolTipText("Ferme");

        //////////////////////////////////////////////////
        //                                              //
        //      Bouton et Popup pour les Loisirs        //
        //                                              //
        //////////////////////////////////////////////////
        bLoisir = new JButton("Loisir");
        bLoisir.addActionListener(new EcouteurDeBarreLateral(o));
        bLoisir.setPreferredSize(new Dimension(150,30));
        bLoisir.setActionCommand("loisir");

        bBar = new JButton(new ImageIcon("Image/bar.png"));
        bBar.addActionListener(new EcouteurDePopup(o));
        bBar.setActionCommand("bar");
        bBar.setToolTipText("pavillon");

        bCine = new JButton(new ImageIcon("Image/cinema.png"));
        bCine.addActionListener(new EcouteurDePopup(o));
        bCine.setActionCommand("cinema");
        bCine.setToolTipText("pavillon");

        bParc = new JButton(new ImageIcon("Image/parc.png"));
        bParc.addActionListener(new EcouteurDePopup(o));
        bParc.setActionCommand("parc");
        bParc.setToolTipText("pavillon");

        bResto = new JButton(new ImageIcon("Image/restaurent.png"));
        bResto.addActionListener(new EcouteurDePopup(o));
        bResto.setActionCommand("restaurant");
        bResto.setToolTipText("pavillon");

        bStade = new JButton(new ImageIcon("Image/stade.png"));
        bStade.addActionListener(new EcouteurDePopup(o));
        bStade.setActionCommand("stade");
        bStade.setToolTipText("pavillon");

        bZoo = new JButton(new ImageIcon("Image/zoo.png"));
        bZoo.addActionListener(new EcouteurDePopup(o));
        bZoo.setActionCommand("zoo");
        bZoo.setToolTipText("pavillon");

        //////////////////////////////////////////////////
        //                                              //
        //   Bouton et Popup pour les infrastrcutures   //
        //                                              //
        //////////////////////////////////////////////////
        bInfra = new JButton("Infrastructure");
        bInfra.addActionListener(new EcouteurDeBarreLateral(o));
        bInfra.setPreferredSize(new Dimension(150,30));
        bInfra.setActionCommand("infra");

        bRoute = new JButton(new ImageIcon("Image/route.png"));
        bRoute.addActionListener(new EcouteurDePopup(o));
        bRoute.setActionCommand("route");
        
        bDestroy = new JButton(new ImageIcon("Image/bulldozer.png"));
        bDestroy.addActionListener(new EcouteurDePopup(o));
        bDestroy.setActionCommand("destroy");
        
        bDeplace = new JButton(new ImageIcon("Image/grue.png"));
        bDeplace.addActionListener(new EcouteurDePopup(o));
        bDeplace.setActionCommand("deplace");

        //////////////////////////////////////////////////
        //                                              //
        //      Bouton et Popup pour les services       //
        //                  Publiques                   //
        //////////////////////////////////////////////////
        bPublique = new JButton("Service Publique");
        bPublique.setPreferredSize(new Dimension(150,30));
        bPublique.addActionListener(new EcouteurDeBarreLateral(o));
        bPublique.setActionCommand("publique");
        

        bCommissariat = new JButton(new ImageIcon("Image/police.png"));
        bCommissariat.addActionListener(new EcouteurDePopup(o));
        bCommissariat.setActionCommand("commissariat");

        bDecheterie = new JButton(new ImageIcon("Image/decheterie.png"));
        bDecheterie.addActionListener(new EcouteurDePopup(o));
        bDecheterie.setActionCommand("decheterie");

        bEcole = new JButton(new ImageIcon("Image/ecole.png"));
        bEcole.addActionListener(new EcouteurDePopup(o));
        bEcole.setActionCommand("ecole");

        bHopital = new JButton(new ImageIcon("Image/hopital.png"));
        bHopital.addActionListener(new EcouteurDePopup(o));
        bHopital.setActionCommand("hopital");

        bHotelDeVille = new JButton(new ImageIcon("Image/hoteldeville.png"));
        bHotelDeVille.addActionListener(new EcouteurDePopup(o));
        bHotelDeVille.setActionCommand("hotel");

        bPompier = new JButton(new ImageIcon("Image/pompier.png"));
        bPompier.addActionListener(new EcouteurDePopup(o));
        bPompier.setActionCommand("pompier");

        
        batiments.add(bLog);
        batiments.add(bBatimentArgent);
        batiments.add(bLoisir);
        batiments.add(bInfra);
        batiments.add(bPublique);
        
        popupLog.setLayout(new GridLayout(1,3));
        popupLog.add(bPavillon);
        popupLog.add(bHLM);
        popupLog.add(bBuilding);

        popupBatArg.setLayout(new GridLayout(1,3));
        popupBatArg.add(bIndus);
        popupBatArg.add(bFerme);
        popupBatArg.add(bCommerce);

        popupInfra.setLayout(new GridLayout(1,3));
        popupInfra.add(bRoute);
        popupInfra.add(bDestroy);
        popupInfra.add(bDeplace);

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
        conseils = new JPanel(new GridLayout(4,1));
        conseils.setBorder(BorderFactory.createTitledBorder("Conseils"));
        conseils.setBackground(new Color(153,204,255));
        conseils.setPreferredSize(new Dimension(200,200));

        //Panel des infos sur les batiments
        infoBat = new JPanel();
        infoBat.setBorder(BorderFactory.createTitledBorder("Information bâtiment"));
        infoBat.setBackground(new Color(153,204,255));
        infoBat.setPreferredSize(new Dimension(200,200));

        south = new JPanel(new BorderLayout());
        south.add(conseils, BorderLayout.NORTH);
        south.add(infoBat, BorderLayout.SOUTH);
        
        
        this.add(info,BorderLayout.NORTH);
        this.add(batiments,BorderLayout.CENTER);
        this.add(south,BorderLayout.SOUTH);
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
        south.remove(infoBat);
        infoBat = new JPanel(new GridLayout(4,1));
        infoBat.setBorder(BorderFactory.createTitledBorder("Information bâtiment"));
        infoBat.setBackground(new Color(153,204,255));
        infoBat.setPreferredSize(new Dimension(200,200));
        String scourant = pg.getPlateau().plateau[points.getX()][points.getY()]
                .getGroupe();
        String nbs= "";
        int nb = 0, cout = 0;
        sub = new JPanel(new GridLayout(1,4));

        if (scourant.equals("logement")){
            Logement log = (Logement)o.f.pg.getPlateau().
                    plateau[points.getX()][points.getY()];
            nb = log.getNb_habitant();
            cout = log.getPrixDestr();
            nbs = "Nombre Habitants = "+nb;            
        }else if (scourant.equals("batimentargent")){
            BatimentArgent arg = (BatimentArgent) o.f.pg.getPlateau().
                    plateau[points.getX()][points.getY()];
            if(!arg.getType().equals("commerce")){
               labSub = new JLabel("Subventions");
                moins = new JButton("-");
                ec = new EcouteurDeBarreLateral(o);
                moins.addActionListener(ec);
                moins.setActionCommand("moins");
                plus = new JButton("+");
                plus.addActionListener(ec);
                plus.setActionCommand("plus");
                ec.p = points;
                
                if (arg.getType().equals("industrie")){
                    Industrie ind = (Industrie) arg;
                    subvention = new JLabel(""+ind.getSubvention());
                }else if (arg.getType().equals("ferme")){
                    Ferme fer = (Ferme) arg;
                    subvention = new JLabel("  "+fer.getSubvention());
                    
                }
                sub.add(moins);
                sub.add(subvention);
                sub.add(plus);
                sub.setBackground(new Color(153,204,255));
            }
            nb = arg.getNb_employe();
            cout = arg.getPrixDestr();
            nbs = "Nombre d'Employés = "+nb;
        }else if (scourant.equals("infrastructure")){
            nbs = "";
            Infrastructure infra = (Infrastructure) o.f.pg.getPlateau().
                    plateau[points.getX()][points.getY()];
            nb = -1;
            cout = infra.getPrixDestr();

        }

        
        if(nb >= 0){
            JLabel snb = new JLabel(nbs);
            snb.setAlignmentX(LEFT_ALIGNMENT);
            infoBat.add(snb);
        }

        JLabel sCout = new JLabel("Coût de destruction = "+cout);
        sCout.setAlignmentX(LEFT_ALIGNMENT);
      
        
        infoBat.add(sCout);
        infoBat.add(labSub);
        infoBat.add(sub);

        south.add(infoBat,BorderLayout.SOUTH);
    }

    public void reInit(){
        south.remove(infoBat);
        infoBat = new JPanel();
        infoBat.setBorder(BorderFactory.createTitledBorder("Information bâtiment"));
        infoBat.setBackground(new Color(153,204,255));
        infoBat.setPreferredSize(new Dimension(200,200));
        south.add(infoBat, BorderLayout.SOUTH);
    }

    public void changeSub(int n){
        sub.remove(subvention);
        sub.remove(plus);
        subvention = new JLabel("  "+n);
        plus = new JButton("+");
        plus.addActionListener(ec);
        plus.setActionCommand("plus");
        sub.add(subvention);
        sub.add(plus);
    }

    public void afficheConseil(String s){
        if(s.equals(cons1.getText())||s.equals(cons2.getText())||
                s.equals(cons3.getText())||s.equals(cons4.getText())){

        }else {
            if (cons == 0){
                cons1 = new JLabel(s);
                conseils.add(cons1);
            }else if(cons == 1){
                cons2 = new JLabel(s);
                conseils.add(cons2);
            }else if(cons == 2){
                cons3 = new JLabel(s);
                conseils.add(cons3);
            }else if(cons == 3){
                cons4 = new JLabel(s);
                conseils.add(cons4);
            }else{
                conseils.remove(cons1);
                cons1 = new JLabel();
                cons1 = cons2;
                conseils.remove(cons2);
                cons2 = new JLabel();
                cons2 = cons3;
                conseils.remove(cons3);
                cons3 = new JLabel();
                cons3 = cons4;
                conseils.remove(cons4);
                cons4 = new JLabel(s);
                conseils.add(cons1);
                conseils.add(cons2);
                conseils.add(cons3);
                conseils.add(cons4);
                cons = 3;
            }
            cons++;
        }
        
    }
    
}
