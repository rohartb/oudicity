
import java.awt.*;
import java.awt.event.*;

class EcouteurDeBarreLateral implements ActionListener,
                                         MouseListener,
                                  MouseMotionListener {
    
    PlateauGraphique graphe;
    int xSouris, ySouris, xcase, ycase;
    int click = 0;
    String nom;

    public EcouteurDeBarreLateral(PlateauGraphique g){
        graphe = g;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("logement")){
            nom = "logement";
            click++;
        }else if (e.getActionCommand().equals("industrie")){
            click = 0;

        }else if (e.getActionCommand().equals("commerce")){

        }else if (e.getActionCommand().equals("ferme")){

        }else if (e.getActionCommand().equals("route")){
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        xSouris = e.getX();
        ySouris = e.getY();
        if(xSouris >= 200){
            xSouris -= 200;
            if(click > 1){
               Point p = graphe.Case(xSouris, ySouris);
              graphe.nouveauBatiment(p, nom);
              graphe.repaint();
            }
        }
        click ++;

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(xSouris != e.getX() || ySouris != e.getY()){
            xSouris = e.getX();
            ySouris = e.getY();
        }
    }

}