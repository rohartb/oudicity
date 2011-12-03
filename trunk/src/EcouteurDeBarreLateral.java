
import java.awt.*;
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
    
    Image maison, immeuble, mairie, hopital, courant;
    PlateauGraphique graphe;
    int xSouris, ySouris, xcase, ycase;
    boolean click = false;
    String nom;

    public EcouteurDeBarreLateral(PlateauGraphique g){
        graphe = g;
        maison = graphe.getToolkit().getImage("Image/maison.gif");
        immeuble = graphe.getToolkit().getImage("Image/immeuble.gif");
        mairie = graphe.getToolkit().getImage("Image/mairie.gif");
        hopital = graphe.getToolkit().getImage("Image/hospital.gif");
        xcase = (graphe.width/graphe.N);
        ycase = (graphe.height/graphe.N);
    }
    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getActionCommand().equals("logement")){
            courant = maison;
            nom = "logement";
        }else if (e.getActionCommand().equals("industrie")){

        }else if (e.getActionCommand().equals("commerce")){

        }else if (e.getActionCommand().equals("ferme")){

        }else if (e.getActionCommand().equals("route")){
            
        }
        click = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        xSouris = e.getX();
        ySouris = e.getY();
        if(click == true){
            Point p = graphe.Case(xSouris, ySouris);
            //graphe.nouveauBatiment(p, nom);
        }
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
        if(xSouris != e.getX() || ySouris != e.getY()){
            xSouris = e.getX();
            ySouris = e.getY();
        }
        graphe.drawable.drawImage(courant, xSouris, ySouris, xcase, ycase,
                null);
    }

}
