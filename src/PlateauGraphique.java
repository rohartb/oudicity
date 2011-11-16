import java.awt.*;
import javax.swing.*;

public class PlateauGraphique extends JComponent {
    AireDeJeu aire;
    
    PlateauGraphique(AireDeJeu a){
        aire = a;
    }
 
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        
    }
}
