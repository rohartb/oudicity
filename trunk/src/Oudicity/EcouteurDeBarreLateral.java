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
        o.f.pg.fin = false;
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
        }else if (e.getActionCommand().equals("destroy")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("destroy")){
                o.f.setClick(true);
                o.f.setNomBat("destroy");
            }else{
                 o.f.setClick(false);
            }
        }else if (e.getActionCommand().equals("deplace")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("deplace")){
                o.f.setClick(true);
                o.f.setNomBat("deplace");
            }else{
                 o.f.setClick(false);
            }
        }else{
            o.f.setNomBat("herbe");
        }
    }
       
}