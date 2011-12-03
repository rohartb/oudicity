import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class PlateauGraphique extends JComponent {
    Ville ville;
    Graphics2D drawable;
    int N=4, width, height;
    float xM, xCase;

    PlateauGraphique(Ville v){
        this.ville = v;
    }

    @Override
     public void paintComponent(Graphics g) {
        drawable = (Graphics2D) g;
        Image image = this.getToolkit().getImage("Image/herbe.gif");

        width = getSize().width;
        height = getSize().height;
        xCase = (width)/N;
       

        drawable.setPaint(Color.white);
        drawable.fillRect((int) 0, 0, width, height);
        drawable.setPaint(Color.black);

        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                drawable.drawImage(image,i*(width/N), j*(height/N),width/N,
                        height/N, null);
            }
        }
        for(int i=0; i<=N; i++){
            drawable.draw(new Line2D.Float(i*xCase, 0, i*xCase, height));
            drawable.draw(new Line2D.Float(0, i*(height/N), width,
                    i*(height/N)));
        }
    }

    public Point Case(int x, int y){
            Point p;
            int xc = 0, yc = 0;
                while((xc*(width/N))<=x){
                    xc++;
                }
                while(yc*(height/N)<=y){
                    yc++;
                }
            p = new Point(xc, yc);
            return p;
    }
}
    
 
