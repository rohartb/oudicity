
import java.awt.event.*;


class EcouteurDeGraphique implements MouseListener, MouseMotionListener{
    OudiCity o;

    public EcouteurDeGraphique(OudiCity o){
        this.o = o;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Points p;
        p = o.f.pg.p.Case(e.getX(), e.getY());
        if((o.f.pg.p.plateau[p.getX()][p.getY()].getType().equals("herbe"))){
            if(o.f.getClick()){
                if(o.f.getNomBat().equals("logement")){
                    o.f.pg.p.nouveauBatiment(p, "logement");
                }
                if(o.f.getNomBat().equals("industrie")){
                    o.f.pg.p.nouveauBatiment(p, "industrie");
                }
            }else{
                o.f.pg.p.nouveauBatiment(p, "herbe");
            }
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
