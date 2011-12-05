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
                }

                //paint pour les logements
                else if(this.p.plateau[i][j].getType().equals("pavillon")){
                    drawable.setPaint(new Color(255,51,51));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("hlm")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("building")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }


                // paint pour les batiments argents
                else if(this.p.plateau[i][j].getType().equals("industrie")){
                    drawable.setPaint(new Color(51,153,153));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("ferme")){
                    drawable.setPaint(new Color(139,69,19));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("commerce")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }

                // paint pour les infrastructures
                else if(this.p.plateau[i][j].getType().equals("route")){
                    drawable.setPaint(new Color(51,51,51));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }


                // paint pour les loisirs
                else if(this.p.plateau[i][j].getType().equals("bar")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("cinema")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("parc")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("restaurant")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("stade")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("zoo")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }


                // paint pour les services publiques
                else if(this.p.plateau[i][j].getType().equals("commissariat")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("decheterie")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("ecole")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("hopital")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("hotel")){
                    drawable.setPaint(new Color(0,0,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("pompier")){
                    drawable.setPaint(new Color(45,112,24));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }
            }
        }

        drawable.setPaint(Color.black);
        for(int i=0; i<=N; i++){
            drawable.draw(new Line2D.Float(i*xCase, 0, i*xCase, height));
            drawable.draw(new Line2D.Float(0, i*(height/N), width,
                    i*(height/N)));
        }
    }
}  
