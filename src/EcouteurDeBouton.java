import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
    AireDeJeu jeu;
    PlateauGraphique graphe;

    public EcouteurDeBouton(Fenetre f, OudiCity s) {
        this.fenetre = f;
        this.jeu = s.aire;
        this.graphe = new PlateauGraphique(this.jeu);
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("nouveau")) {

        pane.setLayout(new BorderLayout());
        pane.add(graphe, BorderLayout.CENTER);
        fenetre.setContentPane(pane);
        fenetre.validate();
        
    }else if(e.getActionCommand().equals("quitter")){
        System.exit(0);
    }
  }
}
