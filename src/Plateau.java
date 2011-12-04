import Batiments.*;
import java.util.*;

public final class Plateau {
    OudiCity o;
    private int N = 10;
    
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
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                plateau[i][j] = new Batiment(){};
            }
        }
    }
    
    public Points Case(int x, int y){
            Points p;
            int xc = 0, yc = 0;
            xc = x/((o.f.pg.getWidth())/N);
            yc = y/(o.f.pg.getHeight()/N);
            p = new Points(xc, yc);
            return p;
    }
    
    public void nouveauBatiment(Points p, String type){
        
        if(type.equals("logement")){
            plateau[p.getX()][p.getY()] = new Logement();
        }
        if(type.equals("industrie")){
            plateau[p.getX()][p.getY()] = new Industrie();
        }
        if(type.equals("herbe")){
            plateau[p.getX()][p.getY()].setType(type);
        }
        
    }

    public void afficher(){
        for (int a=0; a<N; a++){
            for (int b=0; b<N; b++){
                System.out.println(plateau[a][b].getType());
            }
        }
    }
    
    public Points plateauContientLogementLibre(){
        Points lala = null;
        int nbH;
        int nbHMax;
        Logement log;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(plateau[i][j].getType().equals("logement")){
                    log = (Logement) plateau[i][j];
                    nbH = log.getNb_habitant();
                    nbHMax = log.getNb_habitant_MAX();
                    if(nbH < nbHMax){
                        lala = new Points(i,j);
                    }
                }
            }
        }
        return lala;
    }
    
    int augmentetHabitant(int id){
        Random rand = new Random();
        int nb = 0;
        int i;
        int nbMax;
        Points pt = plateauContientLogementLibre();
        if(pt != null){
            Logement log = (Logement) plateau[pt.getX()][pt.getY()];
            nbMax = log.getNb_habitant_MAX() -log.getNb_habitant();
            if(nbMax <5){
                nb = nbMax;
            } else {
                i = rand.nextInt(nbMax);
                nb = i;
            }
        }
        return nb;
    }
}
