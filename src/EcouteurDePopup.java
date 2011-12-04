
import java.awt.event.*;


class EcouteurDePopup implements ActionListener{
    OudiCity o;

    public EcouteurDePopup(OudiCity o) {
        this.o = o;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1")){
            if(o.f.getClick() == false || !o.f.getNomBat().equals("logement")){
                o.f.setClick(true);
                o.f.setNomBat("logement");
            }else{
                 o.f.setClick(false);
            }
            o.f.barreL.popup.setVisible(false);
        }
        
    }

}
