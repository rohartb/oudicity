package Oudicity;


import java.awt.event.*;

class EcouteurDeBarreLateral implements ActionListener{
    
    OudiCity o;
    int xSouris, ySouris, xcase, ycase;

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
        }else{
            o.f.setNomBat("herbe");
        }
    }
       
}