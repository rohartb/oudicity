package Oudicity;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class PlateauGraphique extends JComponent {
    OudiCity o;
    Plateau p;
    private boolean deplace = false, fin = false;
    Points deplacer;
    int N;

    Image herbe, pavillon,hlm, building, industrie, ferme, commerce,
          route, bar, cinema, parc, restaurant, stade, zoo, commissariat,
          decheterie, ecole, hopital, hotel, pompier;

    
    private float width, height;
    float xM, xCase;

    PlateauGraphique(OudiCity o){
        this.o = o;
        p = new Plateau(o);
        N = p.getTaille();
        herbe = this.getToolkit().getImage("Image/herbe.png");
        pavillon = this.getToolkit().getImage("Image/maison.png");
        hlm = this.getToolkit().getImage("Image/hlm.png");
        building = this.getToolkit().getImage("Image/building.png");
        industrie = this.getToolkit().getImage("Image/industrie.png");
        ferme = this.getToolkit().getImage("Image/ferme.png");
        commerce = this.getToolkit().getImage("Image/commerce.png");
        route = this.getToolkit().getImage("Image/route.png");
        bar = this.getToolkit().getImage("Image/bar.png");
        cinema = this.getToolkit().getImage("Image/cinema.png");
        parc = this.getToolkit().getImage("Image/parc.png");
        restaurant = this.getToolkit().getImage("Image/restaurant.png");
        stade = this.getToolkit().getImage("Image/stade.png");
        zoo = this.getToolkit().getImage("Image/zoo.png");
        commissariat = this.getToolkit().getImage("Image/commissariat.png");
        decheterie = this.getToolkit().getImage("Image/decheterie.png");
        ecole = this.getToolkit().getImage("Image/ecole.png");
        hopital = this.getToolkit().getImage("Image/hopital.png");
        hotel = this.getToolkit().getImage("Image/hotel.png");
        pompier = this.getToolkit().getImage("Image/pompier.png");

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

    public boolean getDeplace(){
        return deplace;
    }

    public boolean getFin(){
        return fin;
    }

    public void setDeplace(boolean b){
        this.deplace = b;
    }

    public void setFin(boolean b){
        this.fin = b;
    }

    @Override
     public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        width = getSize().width;
        height = getSize().height;
        xCase = (width)/N;

        drawable.setPaint(new Color(153,204,102));
        drawable.fillRect(0, 0,(int)width,(int)height);
        drawable.setPaint(Color.black);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (this.p.plateau[i][j].getType().equals("herbe")){
                    drawable.setPaint(new Color(153,204,102));
                    drawable.draw(new Rectangle2D.Float(i*(width/N), j*(height/N),
                           width/N, height/N));
                }

                //paint pour les logements
                else if(this.p.plateau[i][j].getType().equals("pavillon")){
                    drawable.drawImage(pavillon,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("HLM")){
                    drawable.drawImage(hlm,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("building")){
                    drawable.drawImage(building,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }


                // paint pour les batiments argents
                else if(this.p.plateau[i][j].getType().equals("industrie")){
                    drawable.drawImage(industrie,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("ferme")){
                    drawable.drawImage(ferme,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("commerce")){
                    drawable.drawImage(commerce,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }

                // paint pour les infrastructures
                else if(this.p.plateau[i][j].getType().equals("route")){
                    drawable.setPaint(new Color(51,51,51));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }


                // paint pour les loisirs
                else if(this.p.plateau[i][j].getType().equals("bar")){
                    drawable.drawImage(bar,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("cinema")){
                    drawable.drawImage(cinema,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("parc")){
                    drawable.drawImage(parc,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("restaurant")){
                    drawable.drawImage(restaurant,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("stade")){
                    drawable.drawImage(stade,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("zoo")){
                    drawable.drawImage(zoo,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }


                // paint pour les services publiques
                else if(this.p.plateau[i][j].getType().equals("commissariat")){
                    drawable.setPaint(new Color(0,0,204));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("decheterie")){
                    drawable.setPaint(new Color(51,153,0));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("ecole")){
                    drawable.setPaint(new Color(255,204,153));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("hopital")){
                    drawable.drawImage(hopital,(int)(i*(width/N)),
                            (int) (j*(height/N)),(int)width/N,
                            (int)height/N, null);
                }else if(this.p.plateau[i][j].getType().equals("hoteldeville")){
                    drawable.setPaint(new Color(153,51,204));
                    drawable.fillRect((int)(i*(width/N)),(int) (j*(height/N)), (int)width/N,
                                     (int)height/N);
                }else if(this.p.plateau[i][j].getType().equals("pompier")){
                    drawable.setPaint(new Color(255,0,0));
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

        if(deplace == true){
            drawable.setPaint(new Color(255,0,0));
            drawable.drawRect((int)(deplacer.getX()*(width/N)),
                    (int) (deplacer.getY()*(height/N)), (int)width/N,
                    (int)height/N);
            deplace = false;
        }
    }
}  
