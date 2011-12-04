import java.awt.event.*;

class EcouteurDeBarreLateral implements ActionListener{
    
    OudiCity o;
    int xSouris, ySouris, xcase, ycase;
    int click = 0;
    String nom;

    public EcouteurDeBarreLateral(OudiCity o){
        this.o = o;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("logement")){
            nom = "logement";
            click++;
        }else if (e.getActionCommand().equals("industrie")){
            click = 0;

        }else if (e.getActionCommand().equals("commerce")){

        }else if (e.getActionCommand().equals("ferme")){

        }else if (e.getActionCommand().equals("route")){
            
        }
    }
}