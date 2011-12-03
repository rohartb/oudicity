
import java.awt.*;
import java.awt.event.*;

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
        if(e.getActionCommand().equals("logement")){
            courant = maison;
            nom = "logement";
            click = true;
        }else if (e.getActionCommand().equals("industrie")){
            click = false;

        }else if (e.getActionCommand().equals("commerce")){

        }else if (e.getActionCommand().equals("ferme")){

        }else if (e.getActionCommand().equals("route")){
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        xSouris = e.getX();
        ySouris = e.getY();
        System.out.println("clic  "+click);
        if(click == true){
            Point p = graphe.Case(xSouris, ySouris);
            System.out.println("click : "+xcase + "  "+ ycase);
            graphe.drawable.drawImage(maison,200, 200, 100, 100 ,
                    null);
            graphe.repaint();
        }
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