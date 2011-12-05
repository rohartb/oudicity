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
        p = o.f.pg.p.Case(e.getX(), e.getY());
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
            }else{
                o.f.pg.p.nouveauBatiment(p, "herbe");
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
       /*String scourant;
       Points pcourant;
       if (x != e.getX() || y != e.getY()){
           if(e.getX() < o.f.pg.getW() && e.getY() < o.f.pg.getH())
            x = e.getX();
            y = e.getY();

            if(o.f.getClick()){
                pcourant = o.f.pg.p.Case(x, y);
                scourant = o.f.pg.p.plateau[pcourant.getX()]
                            [pcourant.getY()].getType();
                System.out.println("tree");
                if(point != o.f.pg.p.Case(x, y) && point.getX() != -1){
                    System.out.println("rentrer"+point.getX()+"  "+point.getY());
                    o.f.pg.p.nouveauBatiment(point, s);
                    s = o.f.pg.p.plateau[point.getX()]
                            [point.getY()].getType();
                    point = o.f.pg.p.Case(x, y);
                    if(o.f.pg.p.plateau[o.f.pg.p.Case(x, y).getX()]
                            [o.f.pg.p.Case(x, y).getY()].equals("herbe")){
                        if(o.f.getNomBat().equals("pavillon")){
                            o.f.pg.p.nouveauBatiment(point, o.f.getNomBat());
                        }
                    }
                }
                point = pcourant;
                s = scourant;
            }
        }
        o.f.pg.repaint();*/
    }
}
