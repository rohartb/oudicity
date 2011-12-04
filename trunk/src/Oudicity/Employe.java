package Oudicity;

public class Employe {
    int nb_EmployTot = 0;
    int nb_maxEmpl = 0;
    Plateau p;
    
    public Employe(Plateau p){
        this.p = p;
    }
    
    int nbTotEmploy(){
        int n = 0;
        
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getPersBat().equals("employe")){
                    if(p.plateau[i][j].getPersBat().equals("B"))
                }
            }
        }
        return n;
    }
    
    int nbTotEmployMax(){
        int n = 0;
        
        
        return n;
    }
}
