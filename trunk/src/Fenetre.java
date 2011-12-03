import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame implements Runnable{
    OudiCity s;
    JPanel accueil;
    JPanel panelBouton;
    BarreLaterale barreL;
    
    JLabel bienvenue;
    
    JButton nouveau;
    JButton continuer;
    JButton quitter;

    PlateauGraphique plateau;
    EcouteurDeBarreLateral souris;
    
    public Fenetre (OudiCity s){
        this.s = s;
        plateau = new PlateauGraphique(s.ville);
        souris = new EcouteurDeBarreLateral(plateau);
        this.addMouseListener(souris);
        this.addMouseMotionListener(souris);
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

        
        
        ////////////////////////////////////
        //        Barre latérale          //
        ////////////////////////////////////
        
        BarreLaterale barreL = new BarreLaterale(s.ville,s.t,plateau, souris);
        
        
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
        nouveau.addActionListener(new EcouteurDeBouton(this, s, barreL));
        nouveau.setActionCommand("nouveau");
        
        // Continuer Partie
        continuer = new JButton("continuer partie");
        continuer.setAlignmentX(CENTER_ALIGNMENT);

        // Quitter Partie
        quitter = new JButton("quitter");
        quitter.setAlignmentX(CENTER_ALIGNMENT);
        quitter.addActionListener(new EcouteurDeBouton(this, s, barreL));
        quitter.setActionCommand("quitter");

        // Ajout des boutons au panel
        panelBouton.add(nouveau);
        panelBouton.add(continuer);
        panelBouton.add(quitter);
        
        accueil.add(bienvenue);
        accueil.add(panelBouton);
        accueil.setVisible(true);
        
        this.add(accueil);
        this.add(plateau);
 
        this.setTitle("OudiCity");
        
        //Fenetre du jeu
        this.setSize(800,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
