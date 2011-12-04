import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;

class EcouteurPageAccueil implements ActionListener{
    Fenetre fenetre;
    JPanel pane = new JPanel();
    Ville ville;
    PlateauGraphique graphe;
    BarreLaterale barreL;

    public EcouteurPageAccueil(Fenetre f, OudiCity s, BarreLaterale b) {
        this.fenetre = f;
        this.ville = s.ville;
        this.graphe = new PlateauGraphique(this.ville);
        this.barreL = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("nouveau")){
        //graphe.addMouseListener(new EcouteurDeSouris(graphe));
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
