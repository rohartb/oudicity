import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class PlateauGraphique extends JComponent {
    OudiCity o;
    Plateau p;
    int N;

    Image courant, herbe, maison;
    
    private int width, height;
    float xM, xCase;

    PlateauGraphique(OudiCity o){
        this.o = o;
        p = new Plateau(o);
        N = p.getTaille();
        herbe = this.getToolkit().getImage("Image/herbe.gif");
        maison = this.getToolkit().getImage("Image/maison.gif");
    }

    @Override
     public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        width = getSize().width;
        height = getSize().height;
        xCase = (width)/N;

        drawable.setPaint(Color.white);
        drawable.fillRect((int) 0, 0, width, height);
        drawable.setPaint(Color.black);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (this.p.plateau[i][j].getType().equals("herbe")){
                    //drawable.drawImage(herbe, i*(width/N), j*(height/N),
                    //                   width/N, height/N, null);
                    drawable.setPaint(new Color(153,255,51));
                    drawable.fillRect(i*(width/N), j*(height/N), width/N,
                                     height/N);
                    drawable.setPaint(Color.black);
                }else if(this.p.plateau[i][j].getType().equals("logement")){
                    //drawable.drawImage(maison, i*(width/N), j*(height/N),
                    //                   width/N, height/N, null);
                    drawable.setPaint(new Color(255,51,51));
                    drawable.fillRect(i*(width/N), j*(height/N), width/N,
                                     height/N);
                    drawable.setPaint(Color.black);
                }else if(this.p.plateau[i][j].getType().equals("industrie")){
                    //drawable.drawImage(maison, i*(width/N), j*(height/N),
                    //                   width/N, height/N, null);
                    drawable.setPaint(new Color(51,153,153));
                    drawable.fillRect(i*(width/N), j*(height/N), width/N,
                                     height/N);
                    drawable.setPaint(Color.black);
                }
            }
        }
        for(int i=0; i<=N; i++){
            drawable.draw(new Line2D.Float(i*xCase, 0, i*xCase, height));
            drawable.draw(new Line2D.Float(0, i*(height/N), width,
                    i*(height/N)));
        }
    }
}  
