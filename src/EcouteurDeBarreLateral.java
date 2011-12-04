import java.awt.event.*;

class EcouteurDeBarreLateral implements ActionListener{
    
    OudiCity o;
    int xSouris, ySouris, xcase, ycase;
    String nom;

    public EcouteurDeBarreLateral(OudiCity o){
        this.o = o;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ecouteur latéral");
        if(e.getActionCommand().equals("logement")){
            if(o.f.getClick() == false){
                o.f.setClick(true);
                nom = "logement";
            }else{
                 o.f.setClick(false);
                nom = "herbe";
            }
        }else if (e.getActionCommand().equals("industrie")){

        }else if (e.getActionCommand().equals("commerce")){

        }else if (e.getActionCommand().equals("ferme")){

        }else if (e.getActionCommand().equals("route")){
            
        }
    }
}