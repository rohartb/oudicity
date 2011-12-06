

package Oudicity;

import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;


class EcouteurMenu implements ActionListener{
    OudiCity o;

    public EcouteurMenu(OudiCity s) {
        this.o = s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("nouveau")){

            
        }else if(e.getActionCommand().equals("stats")){
            Statistique s = new Statistique(o);
            try {
                s.AfficherStats();
            } catch (InterruptedException ex) {
                Logger.getLogger(EcouteurMenu.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }else if(e.getActionCommand().equals("quitter")){
            System.exit(0);
        }
    }

}
