
import java.awt.Image;
import java.awt.event.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bastien
 */
class EcouteurDeBarreLateral implements ActionListener,
                                         MouseListener,
                                  MouseMotionListener {
    
    Image maison, immeuble, mairie, hopital;
    PlateauGraphique graphe;

    public EcouteurDeBarreLateral(PlateauGraphique g){
        graphe = g;
        maison = graphe.getToolkit().getImage("Image/maison.gif");
        immeuble = graphe.getToolkit().getImage("Image/immeuble.gif");
        mairie = graphe.getToolkit().getImage("Image/mairie.gif");
        hopital = graphe.getToolkit().getImage("Image/hospital.gif");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int xcase = (graphe.width/graphe.N);
        int ycase = (graphe.height/graphe.N);

        if (e.getActionCommand().equals("logement")){
            //graphe.getGraphics().drawImage(maison,i*(width/N), j*(height/N),width/N,
              //          height/N, null);
        }else if (e.getActionCommand().equals("industrie")){

        }else if (e.getActionCommand().equals("commerce")){

        }else if (e.getActionCommand().equals("ferme")){

        }else if (e.getActionCommand().equals("route")){
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
