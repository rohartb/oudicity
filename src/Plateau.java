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
    
}
