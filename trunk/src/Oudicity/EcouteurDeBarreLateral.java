package Oudicity;


import Batiments.*;
import java.awt.event.*;

class EcouteurDeBarreLateral implements ActionListener{
    Points p;
    OudiCity o;

    public EcouteurDeBarreLateral(OudiCity o){
        this.o = o;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        o.f.pg.setFin(false);
        if(e.getActionCommand().equals("logement")){
            o.f.barreL.popupLog.show(o.f.barreL.bLog, 50, 50);
        }else if (e.getActionCommand().equals("BatimentArgent")){
            o.f.barreL.popupBatArg.show(o.f.barreL.bBatimentArgent, 50, 50);
        }else if (e.getActionCommand().equals("infra")){
            o.f.barreL.popupInfra.show(o.f.barreL.bInfra, 50, 50);
        }else if (e.getActionCommand().equals("loisir")){
            o.f.barreL.popupLoisir.show(o.f.barreL.bLoisir, 50, 50);
        }else if (e.getActionCommand().equals("publique")){
            o.f.barreL.popupPublique.show(o.f.barreL.bPublique, 50, 50);
        }else if (e.getActionCommand().equals("moins")){
            String s = o.f.pg.p.plateau[p.getX()][p.getY()].getType();
            if(s.equals("industrie")){
                Industrie ind = (Industrie) o.f.pg.p.plateau[p.getX()][p.getY()];
                ind.diminuerSubvention();
            }else if(s.equals("ferme")){
                Ferme fer = (Ferme) o.f.pg.p.plateau[p.getX()][p.getY()];
                fer.diminuerSubvention();
            }
        }else if (e.getActionCommand().equals("plus")){
            String s = o.f.pg.p.plateau[p.getX()][p.getY()].getType();
            if(s.equals("industrie")){
                Industrie ind = (Industrie) o.f.pg.p.plateau[p.getX()][p.getY()];
                ind.augmenterSubvention();
            }else if(s.equals("ferme")){
                Ferme fer = (Ferme) o.f.pg.p.plateau[p.getX()][p.getY()];
                fer.augmenterSubvention();
            }
        }else{
            o.f.setNomBat("herbe");
        }
    }
       
}