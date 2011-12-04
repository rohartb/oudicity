package Oudicity;

import java.awt.event.*;

class EcouteurPageAccueil implements ActionListener{
    OudiCity o;

    public EcouteurPageAccueil(OudiCity s) {
        this.o =s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("nouveau")){
        o.f.init_partie();
    }else if(e.getActionCommand().equals("quitter")){
        System.exit(0);
    }
  }
}
