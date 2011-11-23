import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bastien
 */
class EcouteurDeBouton implements ActionListener{
    Fenetre fenetre;
    JPanel pane = new JPanel();
    Ville ville;
    PlateauGraphique graphe;
    BarreLaterale barreL;

    public EcouteurDeBouton(Fenetre f, OudiCity s, BarreLaterale b) {
        this.fenetre = f;
        this.ville = s.ville;
        this.graphe = new PlateauGraphique(this.ville);
        this.barreL = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("nouveau")){
        graphe.addMouseListener(new EcouteurDeSouris(graphe));
        pane.setLayout(new BorderLayout());
        pane.add(barreL, BorderLayout.WEST);
        pane.add(graphe, BorderLayout.CENTER);
        fenetre.setContentPane(pane);
        fenetre.validate();
        
    }else if(e.getActionCommand().equals("quitter")){
        System.exit(0);
    }
  }
}
