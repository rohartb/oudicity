package Oudicity;

import javax.swing.*;

public class OudiCity{
    Ville v;
    public Temps t;
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
        f = new Fenetre(this);
        SwingUtilities.invokeLater(f);
    }
    
}
