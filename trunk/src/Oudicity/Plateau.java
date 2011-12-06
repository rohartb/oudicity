package Oudicity;
import Batiments.*;

public final class Plateau {
    OudiCity o;
    private int N = 40;
    Habitant h;
    Ressources r;
    Employe e;
    StockCommerce sc;
    Circulation c;
    
    Batiment batiment;
    Batiment plateau[][];
    
    public Plateau(OudiCity o){
        this.o = o;
        init_plateau();
        this.h = new Habitant(this,o);
        this.r = new Ressources(this);
        this.e = new Employe(this,o);
        this.sc = new StockCommerce(this);
        this.c = new Circulation(this);
    }

    public int getTaille(){
        return N;
    }
    
    public Batiment[][] getTab(){
        return plateau;
    }
    
    public StockCommerce getSC(){
        return sc;
    }
    
    void init_plateau() {
        plateau = new Batiment[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                plateau[i][j] = new Batiment(o){};
            }
        }
    }
    
    public Points cases(int x, int y){
            Points p;
            int xc = 0, yc = 0;
            xc = x/((o.f.pg.getWidth())/N);
            yc = y/(o.f.pg.getHeight()/N);
            p = new Points(xc, yc);
            return p;
    }

    public void destroy(Points p){
        if (this.plateau[p.getX()][p.getY()].getGroupe().equals("logement")){
            
        }else if (this.plateau[p.getX()][p.getY()].getGroupe().
                equals("batimentargent")){

        }else if (this.plateau[p.getX()][p.getY()].getGroupe().
                equals("loisir")){

        }else if (this.plateau[p.getX()][p.getY()].getGroupe().
                equals("infrastructure")){

        }
        nouveauBatiment(p, "herbe");
    }


    public void nouveauBatiment(Points p, String type){
        
        if(type.equals("herbe")){
            plateau[p.getX()][p.getY()] = new Batiment(o) {};
        }
        //nouveaux logements
        if(type.equals("pavillon")){
            plateau[p.getX()][p.getY()] = new Pavillon(o);
        }
        if(type.equals("hlm")){
            plateau[p.getX()][p.getY()] = new HLM(o);
        }
        if(type.equals("building")){
            plateau[p.getX()][p.getY()] = new Building(o);
        }

        //nouveaux batiments argent
        if(type.equals("industrie")){
            plateau[p.getX()][p.getY()] = new Industrie(o);
        }
        if(type.equals("ferme")){
            plateau[p.getX()][p.getY()] = new Ferme(o);
        }
        if(type.equals("commerce")){
            plateau[p.getX()][p.getY()] = new Commerce(o) {};
        }

        //nouvelles infrastructures
        if(type.equals("route")){
            plateau[p.getX()][p.getY()] = new Route(o);
        }

        //nouveaux loisirs
        if(type.equals("bar")){
            plateau[p.getX()][p.getY()] = new Bar(o) {};
        }
        if(type.equals("cinema")){
            plateau[p.getX()][p.getY()] = new Cinema(o) {};
        }
        if(type.equals("parc")){
            plateau[p.getX()][p.getY()] = new Parc(o) {};
        }
        if(type.equals("restaurant")){
            plateau[p.getX()][p.getY()] = new Restaurant(o) {};
        }
        if(type.equals("stade")){
            plateau[p.getX()][p.getY()] = new Stade(o) {};
        }
        if(type.equals("zoo")){
            plateau[p.getX()][p.getY()] = new Zoo(o) {};
        }

        //nouveaux services publiques
        if(type.equals("commissariat")){
            plateau[p.getX()][p.getY()] = new Commissariat(o) {};
        }
        if(type.equals("decheterie")){
            plateau[p.getX()][p.getY()] = new Decheterie(o) {};
        }
        if(type.equals("ecole")){
            plateau[p.getX()][p.getY()] = new Ecole(o) {};
        }
        if(type.equals("hopital")){
            plateau[p.getX()][p.getY()] = new Hopital(o) {};
        }
        if(type.equals("hotel")){
            plateau[p.getX()][p.getY()] = new HotelDeVille(o) {};
        }
        if(type.equals("pompier")){
            plateau[p.getX()][p.getY()] = new Pompier(o) {};
        }
        
    }
    
    public void destructionBatiment(Points p, String type){
        
        if(type.equals("pavillon")){
            plateau[p.getX()][p.getY()] = new Pavillon(o);
        }
        if(type.equals("industrie")){
            plateau[p.getX()][p.getY()] = new Industrie(o);
        }
        if(type.equals("herbe")){
            plateau[p.getX()][p.getY()] = new Batiment(o) {};
        }
        if(type.equals("ferme")){
            plateau[p.getX()][p.getY()] = new Ferme(o);
        }
        if(type.equals("route")){
            plateau[p.getX()][p.getY()] = new Route(o);
        }
        
    }

    public void afficher(){
        for (int a=0; a<N; a++){
            for (int b=0; b<N; b++){
                System.out.println(plateau[a][b].getType());
            }
        }
    }
}
