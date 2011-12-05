package Oudicity;
import java.awt.event.*;


class EcouteurDeGraphique implements MouseListener, MouseMotionListener{
    OudiCity o;
    String s = "herbe";

    public EcouteurDeGraphique(OudiCity o){
        this.o = o;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Points pt;
        pt = o.f.pg.p.cases(e.getX(), e.getY());
         if((o.f.pg.p.plateau[pt.getX()][pt.getY()].getType().equals("herbe"))){
            if(o.f.getClick()){
                if(o.f.getNomBat().equals("pavillon")){
                    o.f.pg.p.nouveauBatiment(pt, "pavillon");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("industrie")){
                    o.f.pg.p.nouveauBatiment(pt, "industrie");
                }
                if(o.f.getNomBat().equals("ferme")){
                    o.f.pg.p.nouveauBatiment(pt, "ferme");
                }
                if(o.f.getNomBat().equals("route")){
                    o.f.pg.p.nouveauBatiment(pt, "route");
                }
                if(o.f.getNomBat().equals("destroy")){
                    o.f.pg.p.destroy(pt);
                }
                
            }
        }
        if(o.f.getNomBat().equals("herbe")){
            o.f.pg.p.nouveauBatiment(pt, "herbe");
        }
        o.f.pg.repaint();
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
