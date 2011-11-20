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

        int width = getWidth();
        int height = getHeight();

        drawable.setColor(Color.black);
        drawable.drawRect(0, 0, 300, 300);
    }
}
