import Batiments.*;

public final class Plateau {
    OudiCity o;
    private int N = 4;
    
    Batiment batiment;
    Batiment plateau[][];
    
    public Plateau(OudiCity o){
        this.o = o;
        init_plateau();
    }

    public int getTaille(){
        return N;
    }
    
    void init_plateau() {
        plateau = new Batiment[N][N];
    }
    
    public Points Case(int x, int y){
            Points p;
            int xc = 0, yc = 0;
            xc = x/((o.f.pg.getWidth()-200)/N);
            yc = y/(o.f.pg.getHeight()/N);
            p = new Points(xc, yc);
            return p;
    }
    
    public void nouveauBatiment(Points p, String type){
        
        if(type.equals("logement")){
            plateau[p.getX()][p.getY()] = new Logement();
        }
    }  
}
