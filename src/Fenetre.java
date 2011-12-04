import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame implements Runnable{
    OudiCity s;
    PlateauGraphique pg;
    EcouteurDeGraphique souris;
    private boolean click = false;
    private String nomBat; 
    
    // Panel page d'accueil
    JPanel accueil;
    JPanel panelBouton;
    BarreLaterale barreL;
    JPanel aireDeJeu;
    
    JLabel bienvenue;
   
    JButton nouveau;
    JButton continuer;
    JButton quitter;
    
    public Fenetre (OudiCity s){
        this.s = s;
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
        accueil.setSize(800,700);
        accueil.setBackground(Color.WHITE);

        bienvenue = new JLabel(new ImageIcon("Image/Bienvenue.png"));
        
        // Boutons de l'ecran d'accueil
        panelBouton = new JPanel();
        panelBouton.setBackground(Color.WHITE);
        panelBouton.setLayout(new BoxLayout(panelBouton,BoxLayout.Y_AXIS));
        
        // Nouvelle Partie
        nouveau = new JButton("nouvelle partie");
        nouveau.setAlignmentX(CENTER_ALIGNMENT);
        nouveau.addActionListener(new EcouteurPageAccueil(s));
        nouveau.setActionCommand("nouveau");
        
        // Continuer Partie
        continuer = new JButton("continuer partie");
        continuer.setAlignmentX(CENTER_ALIGNMENT);

        // Quitter Partie
        quitter = new JButton("quitter");
        quitter.setAlignmentX(CENTER_ALIGNMENT);
        quitter.addActionListener(new EcouteurPageAccueil(s));
        quitter.setActionCommand("quitter");

        // Ajout des boutons au panel
        panelBouton.add(nouveau);
        panelBouton.add(continuer);
        panelBouton.add(quitter);
        
        accueil.add(bienvenue);
        accueil.add(panelBouton);
        accueil.setVisible(true);
        
        this.add(accueil);
 
        this.setTitle("OudiCity");
        
        
        //Fenetre du jeu
        this.setSize(800,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void init_partie(){
        System.out.println("init Partie");
        souris = new EcouteurDeGraphique(s);

        pg = new PlateauGraphique(s);
        pg.addMouseListener(souris);
        pg.addMouseMotionListener(souris);
        s.v = new Ville(s.nomVille,s.nomMaire,s);
        s.thTemps.start();
        barreL = new BarreLaterale(s);

        this.accueil.setVisible(false);
        this.setLayout(new BorderLayout());
        this.add(barreL, BorderLayout.WEST);
        this.add(pg, BorderLayout.CENTER);
        
        this.setTitle(s.nomVille);
        this.validate();
        this.pg.setVisible(true);
    }
}
