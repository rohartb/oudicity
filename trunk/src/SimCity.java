import javax.swing.*;

public class SimCity{
    String nomVille;
    AireDeJeu aire;
    PlateauGraphique plateauGraph;
   
    public static void main(String[] args){
        SimCity simCity = new SimCity();
    }

    public SimCity(){
        aire = new AireDeJeu("lala");
        plateauGraph = new PlateauGraphique(aire);
        SwingUtilities.invokeLater(new Fenetre(this));
    }
}
