
import java.awt.event.*;


class EcouteurDeGraphique implements MouseListener, MouseMotionListener{
    OudiCity o;
    int x = 0, y = 0;
    Points point = new Points(x,y);
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
                }
                if(o.f.getNomBat().equals("industrie")){
                    o.f.pg.p.nouveauBatiment(p, "industrie");
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
       /*if (x != e.getX() || y != e.getY()){
            x = e.getX();
            y = e.getY();

            if(o.f.getClick()){
                if(point != o.f.pg.p.Case(x, y)){
                    if(o.f.pg.p.plateau[o.f.pg.p.Case(x, y).getX()]
                            [o.f.pg.p.Case(x, y).getY()].equals("herbe")){
                        o.f.pg.p.nouveauBatiment(point, "herbe");
                        System.out.println();
                        point = o.f.pg.p.Case(x, y);
                        s = o.f.getNomBat();
                        if(o.f.getNomBat().equals("logement")){
                            o.f.pg.p.nouveauBatiment(point, s);
                        }
                    }
                }
            }
        }
        o.f.pg.repaint();*/
    }
}
