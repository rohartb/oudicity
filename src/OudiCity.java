import javax.swing.*;

public class OudiCity{
    String nomVille;
    Ville ville;
    PlateauGraphique plateauGraph;
    Temps t;
    Thread thTemps;
   
    public static void main(String[] args){
        OudiCity oudiCity = new OudiCity();
    }

    public OudiCity(){
        t = new Temps(1);
        thTemps = new Thread(t);
        thTemps.start();
        ville = new Ville("lala","margaux",t);
        SwingUtilities.invokeLater(new Fenetre(this));
    }
}
