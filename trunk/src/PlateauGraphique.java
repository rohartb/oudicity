import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class PlateauGraphique extends JComponent {
    Ville ville;
    int N=60;

    PlateauGraphique(Ville v){
        this.ville = v;
    }

     public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        int width = getSize().width;
        int height = getSize().height;
        float xM = (width*20)/100;
        float xCase = (width-xM)/N;
       

        drawable.setPaint(Color.white);
        drawable.fillRect((int) xM, 0, width, height);
        drawable.setPaint(Color.black);

        for(int i=0; i<=N; i++){
            drawable.draw(new Line2D.Float(i*xCase+xM, 0, i*xCase+xM, height));
            drawable.draw(new Line2D.Float(xM, i*(height/N), width, i*(height/N)));
        }

    }
}
    
 