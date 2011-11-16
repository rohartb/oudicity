import javax.swing.*;

public class OudiCity{
    String nomVille;
    AireDeJeu aire;
    PlateauGraphique plateauGraph;
   
    public static void main(String[] args){
        OudiCity OudiCity = new OudiCity();
    }

    public OudiCity(){
        aire = new AireDeJeu("lala");
        plateauGraph = new PlateauGraphique(aire);
        SwingUtilities.invokeLater(new Fenetre(this));
    }
}
