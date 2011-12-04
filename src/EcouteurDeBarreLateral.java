import java.awt.event.*;

class EcouteurDeBarreLateral implements ActionListener{
    
    OudiCity o;
    int xSouris, ySouris, xcase, ycase;

    public EcouteurDeBarreLateral(OudiCity o){
        this.o = o;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("logement")){
            if(o.f.getClick() == false){
                o.f.setClick(true);
                o.f.setNomBat("logement");
            }else{
                 o.f.setClick(false);
            }
        }else if (e.getActionCommand().equals("industrie")){
             if(o.f.getClick() == false){
                o.f.setClick(true);
                o.f.setNomBat("industrie");
            }else{
                 o.f.setClick(false);
            }
        }else if (e.getActionCommand().equals("commerce")){

        }else if (e.getActionCommand().equals("ferme")){

        }else if (e.getActionCommand().equals("route")){
            
        }
    }
}