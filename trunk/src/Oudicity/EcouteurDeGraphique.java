package Oudicity;
import java.awt.event.*;


class EcouteurDeGraphique implements MouseListener, MouseMotionListener{
    OudiCity o;
    int x = -1, y = -1;
    Points point = new Points(x,y), p2 = new Points(-1,-1);
    String s = "herbe";

    public EcouteurDeGraphique(OudiCity o){
        this.o = o;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Points p;
        p = o.f.pg.p.cases(e.getX(), e.getY());
        if((o.f.pg.p.plateau[p.getX()][p.getY()].getType().equals("herbe"))){
            if(o.f.getClick()){
                if(o.f.getNomBat().equals("pavillon")){
                    o.f.pg.p.nouveauBatiment(p, "pavillon");
                    o.v.payerBatiment("pavillon");
                }
                if(o.f.getNomBat().equals("industrie")){
                    o.f.pg.p.nouveauBatiment(p, "industrie");
                }
                if(o.f.getNomBat().equals("ferme")){
                    o.f.pg.p.nouveauBatiment(p, "ferme");
                }
                if(o.f.getNomBat().equals("route")){
                    o.f.pg.p.nouveauBatiment(p, "route");
                }
                if(o.f.getNomBat().equals("destroy")){
                    o.f.pg.p.destroy(p);
                }
                
            }
        }
        if(o.f.getNomBat().equals("herbe")){
            o.f.pg.p.nouveauBatiment(p, "herbe");
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
