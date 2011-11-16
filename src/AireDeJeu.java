class AireDeJeu {
    String nomVille;
    static final int LARGEUR = 100;
    static final int HAUTEUR = 100;
    int plateau[][];
    
    AireDeJeu(String n){
        nomVille = n;
    }
    
    void init(){
        plateau = new int[LARGEUR][HAUTEUR];
    }
}
