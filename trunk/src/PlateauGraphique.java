import java.awt.*;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import javax.swing.*;
import Batiments.*;

public class PlateauGraphique extends JComponent {
    OudiCity o;
    Plateau p;
    int N;
    
    private int width, height;
    float xM, xCase;

    PlateauGraphique(OudiCity o){
        this.o = o;
        p = new Plateau(o);
        N = p.getTaille();
    }

    @Override
     public void paintComponent(Graphics g) {
        Graphics2D drawable;
        drawable = (Graphics2D) g;
        Image image = herbe;

        width = getSize().width;
        height = getSize().height;
        xCase = (width)/N;
       

        drawable.setPaint(Color.white);
        drawable.fillRect((int) 0, 0, width, height);
        drawable.setPaint(Color.black);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(plateau[i][j] == null){
                    image = herbe;
                }else{
                    String type = plateau[i][j].getType();
                    if(type.equals("logement")){
                        image = maison;
                        System.out.println("maison");
                    }
                }
                //System.out.println("vrinr" +image);
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
            xc = x/((width-200)/N);
            yc = y/(height/N);
            p = new Point(xc, yc);
            return p;
    }
    
    public void nouveauBatiment(Point p, String type){
        
        if(type.equals("logement")){
            plateau[(int)p.getX()][(int)p.getY()] = new Logement();
        }
    }

    boolean plateauContient(String string) {
        boolean estDansPlateau = false;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(plateau[i][j].getType().equals(string)){
                    estDansPlateau = true;
                }
            }
        }
        return estDansPlateau;
    }
    
    LinkedList<Points> plateauListes(String string) {
        LinkedList<Points> l = null;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(plateau[i][j].getType().equals(string)){
                    l.add(new Points(i,j));
                }
            }
        }
        return l;
    }
}  
