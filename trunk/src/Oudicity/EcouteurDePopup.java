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
        }else  if (e.getActionCommand().equals("HLM")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("HLM")){
                o.f.setClick(true);
                o.f.setNomBat("HLM");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupLog.setVisible(false);
        }else if (e.getActionCommand().equals("building")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("building")){
                o.f.setClick(true);
                o.f.setNomBat("building");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupLog.setVisible(false);

            //Popup des batiments argents
        }else if (e.getActionCommand().equals("industrie")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("industrie")){
                o.f.setClick(true);
                o.f.setNomBat("industrie");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupBatArg.setVisible(false);
        }else if (e.getActionCommand().equals("commerce")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("commerce")){
                o.f.setClick(true);
                o.f.setNomBat("commerce");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupBatArg.setVisible(false);
        }else if (e.getActionCommand().equals("ferme")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("ferme")){
                o.f.setClick(true);
                o.f.setNomBat("ferme");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupBatArg.setVisible(false);


            //Popup des infrastructures
        }else if (e.getActionCommand().equals("route")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("route")){
                o.f.setClick(true);
                o.f.setNomBat("route");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupInfra.setVisible(false);
        }else if (e.getActionCommand().equals("destroy")) {
            if(o.f.getClick() == false || !o.f.getNomBat().equals("destroy")){
                o.f.setClick(true);
                o.f.setNomBat("destroy");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupInfra.setVisible(false);
        }else if (e.getActionCommand().equals("deplace")) {
            if(o.f.getClick() == false || !o.f.getNomBat().equals("deplace")){
                o.f.setClick(true);
                o.f.setNomBat("deplace");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popupInfra.setVisible(false);
        }

            //Popup des loisirs
        else if (e.getActionCommand().equals("bar")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("bar")){
                o.f.setClick(true);
                o.f.setNomBat("bar");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupLoisir.setVisible(false);
        }else if (e.getActionCommand().equals("cinema")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("cinema")){
                o.f.setClick(true);
                o.f.setNomBat("cinema");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupLoisir.setVisible(false);
        }else if (e.getActionCommand().equals("parc")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("parc")){
                o.f.setClick(true);
                o.f.setNomBat("parc");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupLoisir.setVisible(false);
        }else if (e.getActionCommand().equals("restaurant")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("restaurant")){
                o.f.setClick(true);
                o.f.setNomBat("restaurant");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupLoisir.setVisible(false);
        }else if (e.getActionCommand().equals("stade")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("stade")){
                o.f.setClick(true);
                o.f.setNomBat("stade");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupLoisir.setVisible(false);
        }else if (e.getActionCommand().equals("zoo")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("zoo")){
                o.f.setClick(true);
                o.f.setNomBat("zoo");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupLoisir.setVisible(false);

            //Popup des services publiques
        }else if (e.getActionCommand().equals("commissariat")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("commissariat")){
                o.f.setClick(true);
                o.f.setNomBat("commissariat");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupPublique.setVisible(false);
        }else if (e.getActionCommand().equals("decheterie")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("decheterie")){
                o.f.setClick(true);
                o.f.setNomBat("decheterie");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupPublique.setVisible(false);
        }else if (e.getActionCommand().equals("ecole")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("ecole")){
                o.f.setClick(true);
                o.f.setNomBat("ecole");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupPublique.setVisible(false);
        }else if (e.getActionCommand().equals("hopital")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("hopital")){
                o.f.setClick(true);
                o.f.setNomBat("hopital");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupPublique.setVisible(false);
        }else if (e.getActionCommand().equals("hotel")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("hotel")){
                o.f.setClick(true);
                o.f.setNomBat("hotel");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupPublique.setVisible(false);
        }else if (e.getActionCommand().equals("pompier")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("pompier")){
                o.f.setClick(true);
                o.f.setNomBat("pompier");
            }else{
                o.f.setClick(false);
            }
            o.f.barreL.popupPublique.setVisible(false);
        } else {
            o.f.setClick(false);
            o.f.setNomBat("herbe");
        }
        
    }

}
