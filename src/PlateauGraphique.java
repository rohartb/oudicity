import java.awt.*;
import javax.swing.*;

public class PlateauGraphique extends JComponent {
    AireDeJeu aire;
    
    public PlateauGraphique(AireDeJeu a){
        aire = a;
    }
 
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        
    }
}
