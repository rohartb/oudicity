
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bastien
 */
class EcouteurDeBarreLateral implements ActionListener{
    Image maison, immeuble, mairie, hopital;
    PlateauGraphique graphe;

    public EcouteurDeBarreLateral(PlateauGraphique g){
        graphe = g;
        //maison = graphe.getToolkit().getImage("Image/maison.jpg");
        //immeuble = graphe.getToolkit().getImage("Image/immeuble.gif");
        //mairie = graphe.getToolkit().getImage("Image/mairie.png");
        //hopital = graphe.getToolkit().getImage("Image/hopital.jpg");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
