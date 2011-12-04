import javax.swing.*;

public class OudiCity{
    Ville v;
    Temps t;
    Thread thTemps;
    Fenetre f;
    
    String nomVille = "grenoble" ;
    String nomMaire = "josé";
   
    public static void main(String[] args){
        OudiCity oudiCity = new OudiCity();
    }

    public OudiCity(){
        t = new Temps(1);
        thTemps = new Thread(t);
        SwingUtilities.invokeLater(new Fenetre(this));
    }
    
    public void initVille(){
        thTemps.start();
        v = new Ville(nomVille,nomMaire,this);
    }
}
