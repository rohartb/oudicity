import java.awt.*;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import javax.swing.*;
import Batiments.Batiment;
import Batiments.Logement;

public class PlateauGraphique extends JComponent {
    Ville ville;
    Batiment batiment;
    Batiment plateau[][];
    Graphics2D drawable;
    Image maison, immeuble, mairie, hopital, courant, herbe;
    private int N=4, width, height;
    float xM, xCase;

    PlateauGraphique(Ville v){
        this.ville = v;
        maison = this.getToolkit().getImage("Image/maison.gif");
        immeuble = this.getToolkit().getImage("Image/immeuble.gif");
        mairie = this.getToolkit().getImage("Image/mairie.gif");
        hopital = this.getToolkit().getImage("Image/hospital.gif");
        herbe = this.getToolkit().getImage("Image/herbe.gif");

        plateau = new Batiment[N][N];
        /*for(int euh=0; euh<N; euh++){
            for(int e=0; e<N; e++){
                plateau[euh][e]= new Batiment() {};
                plateau[euh][e].setType("herbe");
            }
        }*/
    }

    public int getTailleTableau(){
        return N;
    }

    @Override
     public void paintComponent(Graphics g) {

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

    LinkedList<Points> plateauContient(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}  
