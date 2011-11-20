import javax.swing.*;

public class OudiCity{
    String nomVille;
    Ville ville;
    PlateauGraphique plateauGraph;
    Temps t;
    Thread thTemps;
   
    public static void main(String[] args){
        OudiCity OudiCity = new OudiCity();
    }

    public OudiCity(){
        t = new Temps(1);
        thTemps = new Thread(t);
        thTemps.start();
        ville = new Ville("lala","margaux",t);
        plateauGraph = new PlateauGraphique(ville);
        SwingUtilities.invokeLater(new Fenetre(this));
    }
}
