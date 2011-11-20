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
    OudiCity oudi;

    public EcouteurDeBouton(Fenetre f, OudiCity s) {
        fenetre = f;
        oudi = s;
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("nouveau")) {
        PlateauGraphique dessin = new PlateauGraphique(oudi.aire);
        fenetre.removeAll();
        fenetre.add(dessin);
        fenetre.add(oudi.plateauGraph);
        dessin.setVisible(true);
    }else if(e.getActionCommand().equals("quitter")){
        System.exit(0);
    }
  }
}
