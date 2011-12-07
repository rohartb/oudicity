package Oudicity;

public final class Satisfaction {
    Plateau p;
    int tabContent[][];
    
    public Satisfaction(Plateau p){
        this.p = p;
        tabContent = new int[p.getTaille()][p.getTaille()];
        init_tab(tabContent);
    }
    
    
    public void init_tab(int tab[][]){
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                tab[i][j] = 0;
            }
        }
    }
    
    public void mettreAJour(){
        
    }
}
