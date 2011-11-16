import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame implements Runnable {
    OudiCity s;
    JPanel accueil;
    int plateau[][];
    JLabel bienvenue;
    JButton nouveau;
    
    public Fenetre (OudiCity s){
        this.s = s;
        plateau = s.aire.plateau;
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

        accueil = new JPanel(new GridLayout(2,1));
        accueil.setSize(800,700);
        accueil.setBackground(Color.WHITE);

        bienvenue = new JLabel(new ImageIcon("Image/Bienvenue.png"));
        
       
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        
        nouveau = new JButton("nouvelle partie");
        nouveau.setAlignmentX(CENTER_ALIGNMENT);
        
        JButton continuer = new JButton("continuer partie");
        continuer.setAlignmentX(CENTER_ALIGNMENT);

        JButton quitter = new JButton("quitter");
        quitter.setAlignmentX(CENTER_ALIGNMENT);

        p.add(nouveau);
        p.add(continuer);
        p.add(quitter);
        
        accueil.add(bienvenue);
        //accueil.add(nouveau);
        //accueil.add(continuer);
        //accueil.add(quitter);
        accueil.add(p);
        accueil.setVisible(true);
        
        this.add(accueil);

        this.add(s.plateauGraph);
        
        this.setTitle("SimCity");
        //Fenetre du jeu
        this.setSize(800,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
