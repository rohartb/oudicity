package Oudicity;
import Batiments.*;

public final class Plateau {
    OudiCity o;
    private int N = 10;
    Habitant h;
    Ressources r;
    Employe e;
    
    Batiment batiment;
    Batiment plateau[][];
    
    public Plateau(OudiCity o){
        this.o = o;
        init_plateau();
        this.h = new Habitant(this);
        this.r = new Ressources(this);
        this.e = new Employe(this,o);
    }

    public int getTaille(){
        return N;
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
