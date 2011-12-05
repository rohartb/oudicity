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

                //quand on click sur un logement
                if(o.f.getNomBat().equals("pavillon")){
                    o.f.pg.p.nouveauBatiment(pt, "pavillon");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("HLM")){
                    o.f.pg.p.nouveauBatiment(pt, "hlm");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("building")){
                    o.f.pg.p.nouveauBatiment(pt, "building");
                    o.v.payerBatiment(pt);
                }

                //quand on click sur un batiment argent
                if(o.f.getNomBat().equals("industrie")){
                    o.f.pg.p.nouveauBatiment(pt, "industrie");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("ferme")){
                    o.f.pg.p.nouveauBatiment(pt, "ferme");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("commerce")){
                    o.f.pg.p.nouveauBatiment(pt, "commerce");
                    o.v.payerBatiment(pt);
                }

                //quand on click sur une infrastructure
                if(o.f.getNomBat().equals("route")){
                    o.f.pg.p.nouveauBatiment(pt, "route");
                    o.v.payerBatiment(pt);
                    o.f.pg.p.c.actualiserReseauRoutier(pt);
                }
                
                //quand on click sur un loisir
                if(o.f.getNomBat().equals("bar")){
                    o.f.pg.p.nouveauBatiment(pt, "bar");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("cinema")){
                    o.f.pg.p.nouveauBatiment(pt, "cinema");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("parc")){
                    o.f.pg.p.nouveauBatiment(pt, "parc");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("restaurant")){
                    o.f.pg.p.nouveauBatiment(pt, "restaurant");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("stade")){
                    o.f.pg.p.nouveauBatiment(pt, "stade");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("zoo")){
                    o.f.pg.p.nouveauBatiment(pt, "zoo");
                    o.v.payerBatiment(pt);
                }

                //quand on click sur un service publique
                if(o.f.getNomBat().equals("commissariat")){
                    o.f.pg.p.nouveauBatiment(pt, "commissariat");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("decheterie")){
                    o.f.pg.p.nouveauBatiment(pt, "decheterie");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("ecole")){
                    o.f.pg.p.nouveauBatiment(pt, "ecole");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("hopital")){
                    o.f.pg.p.nouveauBatiment(pt, "hopital");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("hotel")){
                    o.f.pg.p.nouveauBatiment(pt, "hotel");
                    o.v.payerBatiment(pt);
                }
                if(o.f.getNomBat().equals("pompier")){
                    o.f.pg.p.nouveauBatiment(pt, "pompier");
                    o.v.payerBatiment(pt);
                }
                
            }
            o.f.barreL.reInit();
        }else{
            if(o.f.getNomBat().equals("destroy")){
                o.v.rembourserBatiment(pt);
                o.f.pg.p.destroy(pt);
            }else{
                o.f.barreL.initConseil(pt);
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
