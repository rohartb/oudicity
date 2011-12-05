package Oudicity;
import java.awt.event.*;


class EcouteurDePopup implements ActionListener{
    OudiCity o;

    public EcouteurDePopup(OudiCity o) {
        this.o = o;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Popup des logements
        if (e.getActionCommand().equals("pavillon")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("pavillon")){
                o.f.setClick(true);
                o.f.setNomBat("pavillon");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupLog.setVisible(false);
        }
        if (e.getActionCommand().equals("HLM")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("HLM")){
                o.f.setClick(true);
                o.f.setNomBat("HLM");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupLog.setVisible(false);
        }
        if (e.getActionCommand().equals("building")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("building")){
                o.f.setClick(true);
                o.f.setNomBat("building");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupLog.setVisible(false);
        }

        //Popup des batiments d'argent
        if (e.getActionCommand().equals("industrie")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("industrie")){
                o.f.setClick(true);
                o.f.setNomBat("industrie");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupBatArg.setVisible(false);
        }
        if (e.getActionCommand().equals("commerce")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("commerce")){
                o.f.setClick(true);
                o.f.setNomBat("commerce");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupBatArg.setVisible(false);
        }
        if (e.getActionCommand().equals("ferme")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("ferme")){
                o.f.setClick(true);
                o.f.setNomBat("ferme");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupBatArg.setVisible(false);
        }
        if (e.getActionCommand().equals("route")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("route")){
                o.f.setClick(true);
                o.f.setNomBat("route");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupInfra.setVisible(false);
        }
        if(o.f.getClick() == false || !o.f.getNomBat().equals("loisir")){
                o.f.setClick(true);
                o.f.setNomBat("loisir");
        }else{
                o.f.setClick(false);
        }
    }

}
