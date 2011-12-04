
import java.awt.event.*;


class EcouteurDePopup implements ActionListener{
    OudiCity o;

    public EcouteurDePopup(OudiCity o) {
        this.o = o;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1")){
            o.f.barreL.popup.setVisible(false);
        }
        
    }

}
