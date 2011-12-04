
import java.awt.event.*;


class EcouteurDeGraphique implements MouseListener, MouseMotionListener{
    OudiCity o;

    public EcouteurDeGraphique(OudiCity o){
        this.o = o;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click" + o.f.getClick());
        if(o.f.getClick()){
            Points p;
            p = o.f.pg.p.Case(e.getX(), e.getY());
            o.f.pg.p.nouveauBatiment(p, "logement");
            o.f.pg.p.afficher();
            o.f.pg.repaint();
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

    }
}
