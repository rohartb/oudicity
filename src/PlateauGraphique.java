import java.awt.*;
import javax.swing.*;

public class PlateauGraphique extends JComponent {
    AireDeJeu aire;
    int N=60;
    
    PlateauGraphique(AireDeJeu a){
        this.aire = a;
    }
 
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        int width = getSize().width;
        int height = getSize().height;
        int xM = (width*20)/100;
        int xCase = (width-xM)/N;
       

        drawable.setPaint(Color.white);
        drawable.fillRect(xM, 0, width, height);
        drawable.setPaint(Color.black);

        for(int i=0; i<=N; i++){
            drawable.drawLine(i*xCase+xM, 0, i*xCase+xM, height);
            drawable.drawLine(xM, i*(height/N), width, i*(height/N));
        }

    }
}
