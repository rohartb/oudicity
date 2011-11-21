import java.awt.BorderLayout;
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
    JPanel barreLaterale;

    public EcouteurDeBouton(Fenetre f, OudiCity s, JPanel b) {
        this.fenetre = f;
        this.ville = s.ville;
        this.graphe = new PlateauGraphique(this.ville);
        this.barreLaterale = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("nouveau")) {

        pane.setLayout(new BorderLayout());
        pane.add(barreLaterale, BorderLayout.WEST);
        pane.add(graphe, BorderLayout.CENTER);
        fenetre.setContentPane(pane);
        fenetre.validate();
        
    }else if(e.getActionCommand().equals("quitter")){
        System.exit(0);
    }
  }
}
