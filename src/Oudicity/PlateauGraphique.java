package Oudicity;
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class PlateauGraphique extends JComponent {
    OudiCity o;
    Plateau p;
    int N;

    Image courant, herbe, maison;
    
    private float width, height;
    float xM, xCase;

    PlateauGraphique(OudiCity o){
        this.o = o;
        p = new Plateau(o);
        N = p.getTaille();
        herbe = this.getToolkit().getImage("Image/herbe.gif");
        maison = this.getToolkit().getImage("Image/maison.gif");
    }

    public Plateau getPlateau(){
        return p;
    }

    public float getW(){
        return width;
    }

    public float getH(){
        return height;
    }

    @Override
     public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        width = getSize().width;
        height = getSize().height;
        xCase = (width)/N;

        drawable.setPaint(Color.white);
        drawable.fillRect(0, 0,(int)width,(int)height);
        drawable.setPaint(Color.black);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (this.p.plateau[i][j].getType().equals("herbe")){
                    drawable.setPaint(new Color(153,255,51));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                    drawable.setPaint(Color.black);
                }else if(this.p.plateau[i][j].getType().equals("pavillon")){
                    drawable.setPaint(new Color(255,51,51));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                    drawable.setPaint(Color.black);
                }else if(this.p.plateau[i][j].getType().equals("industrie")){
                    drawable.setPaint(new Color(51,153,153));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                    drawable.setPaint(Color.black);
                }else if(this.p.plateau[i][j].getType().equals("ferme")){
                    drawable.setPaint(new Color(139,69,19));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                    drawable.setPaint(Color.black);
                }
                else if(this.p.plateau[i][j].getType().equals("route")){
                    drawable.setPaint(new Color(148,148,148));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
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
