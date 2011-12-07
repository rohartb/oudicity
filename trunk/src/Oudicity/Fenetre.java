package Oudicity;


import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame implements Runnable{
    OudiCity s;
    PlateauGraphique pg;
    EcouteurDeGraphique souris;
    private boolean click = false;
    private String nomBat= "";
    
    // Panel page d'accueil
    JPanel accueil;
    JPanel panelBouton;
    BarreLaterale barreL;
    JPanel aireDeJeu;
    JMenuBar bar;
    JMenu menu;
    JMenuItem nouv;
    JMenuItem statistique;
    JMenuItem quit;
    
    JLabel bienvenue;
   
    JButton nouveau;
    JButton continuer;
    JButton quitter;
    
    public Fenetre (OudiCity s){
        this.s = s;
    }

    public PlateauGraphique getGraphique(){
        return pg;
    }

    public BarreLaterale getBarreL(){
        return barreL;
    }

    public boolean getClick(){
        return click;
    }

    public void setClick(boolean b){
        click = b;
    }
    
    public String getNomBat(){
        return nomBat;
    }

    public void setNomBat(String s){
        nomBat = s;
    }
    
    @Override
    public void run() {
        try {
            if (System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty ("apple.laf.useScreenMenuBar","true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Test");
            } else {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch(Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }
        
        //////////////////////////////////////
        //          Page d'accueil          //
        //////////////////////////////////////
        
        accueil = new JPanel(new GridLayout(2,1));

        accueil.setSize(1000,800);
        accueil.setBackground(Color.white); 

        bienvenue = new JLabel(new ImageIcon("Image/Bienvenue.png"));
        
        // Boutons de l'ecran d'accueil
        panelBouton = new JPanel();
        panelBouton.setBackground(Color.WHITE);
        
        // Nouvelle Partie
        nouveau = new JButton("nouvelle partie");
        nouveau.setAlignmentX(CENTER_ALIGNMENT);
        nouveau.setPreferredSize(new Dimension(200,50));
        nouveau.addActionListener(new EcouteurPageAccueil(s));
        nouveau.setActionCommand("nouveau");
        
        // Continuer Partie
        continuer = new JButton("continuer partie");
        continuer.setAlignmentX(CENTER_ALIGNMENT);

        // Quitter Partie
        quitter = new JButton("quitter");
        quitter.setAlignmentX(CENTER_ALIGNMENT);
        quitter.setPreferredSize(new Dimension(200,50));
        quitter.addActionListener(new EcouteurPageAccueil(s));
        quitter.setActionCommand("quitter");

        // Ajout des boutons au panel
        panelBouton.add(nouveau);
        panelBouton.add(quitter);
        
        accueil.add(bienvenue);
        accueil.add(panelBouton);
        accueil.setVisible(true);
        
        this.add(accueil);
 
        this.setTitle("OudiCity");
        
        
        //Fenetre du jeu
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void init_partie(){
        souris = new EcouteurDeGraphique(s);

        pg = new PlateauGraphique(s);
        pg.addMouseListener(souris);
        pg.addMouseMotionListener(souris);
        s.v = new Ville(s.nomVille,s.nomMaire,s);
        s.thTemps.start();
        barreL = new BarreLaterale(s);
        barreL.setPreferredSize(new Dimension(200,800));
        bar = new JMenuBar();
        menu = new JMenu("Fichier");
        nouv = new JMenuItem("Nouveau");
        nouv.addActionListener(new EcouteurMenu(s));
        nouv.setActionCommand("nouveau");
        statistique = new JMenuItem("Statistiques");
        statistique.addActionListener(new EcouteurMenu(s));
        statistique.setActionCommand("stats");
        quit = new JMenuItem("Quitter");
        quit.addActionListener(new EcouteurMenu(s));
        quit.setActionCommand("quitter");

        bar.add(menu);
        menu.add(nouv);
        menu.add(statistique);
        menu.add(quit);

        this.accueil.setVisible(false);
        this.setLayout(new BorderLayout());
        this.add(bar, BorderLayout.NORTH);
        this.add(barreL, BorderLayout.WEST);
        this.add(pg, BorderLayout.CENTER);
        
        this.validate();
        this.pg.setVisible(true);
    }
}
