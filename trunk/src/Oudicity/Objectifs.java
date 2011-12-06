package Oudicity;

public class Objectifs {
    private Ville v;
    Objectifs(Ville v){
        this.v = v;
    }
    
    public int obj_maire_attracrif(){
        int score = 0;
        if(v.nbHabitant>=10000){
            score += 8;
        }
        /*TODO attraction 
         * if(attraction moyenne > 70/100){
         *  score += 8;
         * }        
         */
        if((v.p.e.nb_EmployTot/v.nbHabitant)*100<10){
            score += 8;
        }
        return score;
    }
    
    public int obj_maire_riche(){
        int i,j;
        int score = 0;
        int nb_i=0;
        int nb_f=0;
        
        //verification de l'argent
        if(v.argent>=70000){
            score += 8;
        }
        
        //compte les industries
        for(i=0; i<v.p.plateau.length;i++){
            for(j=0;j<v.p.plateau.length;j++){
                if(v.p.plateau[i][j].getType().equals("industrie")){
                    nb_i++;
                }
            }
        }
        //verification industries
        if(nb_i>24){
            score += 8;
        }
        
        //compte les fermes
        for(i=0; i<v.p.plateau.length;i++){
            for(j=0;j<v.p.plateau.length;j++){
                if(v.p.plateau[i][j].getType().equals("ferme")){
                    nb_f++;
                }
            }
        }
        //verification ferme
        if(nb_f>18){
            score += 8;
        }
        return score;
    }
    
    public int obj_maire_cool(){
        int score = 0;
        int i,j;
        int nb_zoo=0;
        int nb_stade=0;
        int nb_cine=0;
        int nb_resto=0;
        int nb_parc=0;
        int nb_bar=0;
        
        //compte les zoo
        for(i=0; i<v.p.plateau.length;i++){
            for(j=0;j<v.p.plateau.length;j++){
                if(v.p.plateau[i][j].getType().equals("zoo")){
                    nb_zoo++;
                }
            }
        }
        if(nb_zoo>=3){
            score += 12; 
        }
        
        //compte les stades
        for(i=0; i<v.p.plateau.length;i++){
            for(j=0;j<v.p.plateau.length;j++){
                if(v.p.plateau[i][j].getType().equals("stade")){
                    nb_stade++;
                }
            }
        }
        if(nb_stade>=1){
            score += 9;
        }
        
        //compte le cinemas
        for(i=0; i<v.p.plateau.length;i++){
            for(j=0;j<v.p.plateau.length;j++){
                if(v.p.plateau[i][j].getType().equals("cinema")){
                    nb_cine++;
                }
            }
        }
        if(nb_cine>=7){
            score += 8;
        }
        
        //compte les restaurants
        for(i=0; i<v.p.plateau.length;i++){
            for(j=0;j<v.p.plateau.length;j++){
                if(v.p.plateau[i][j].getType().equals("restaurant")){
                    nb_resto++;
                }
            }
        }
        if(nb_resto>=7){
            score += 8;
        }
        
        //compte les parcs
        for(i=0; i<v.p.plateau.length;i++){
            for(j=0;j<v.p.plateau.length;j++){
                if(v.p.plateau[i][j].getType().equals("parc")){
                    nb_parc++;
                }
            }
        }
        if(nb_parc>=13){
            score += 8;
        }
        
        //compte les bars
        for(i=0; i<v.p.plateau.length;i++){
            for(j=0;j<v.p.plateau.length;j++){
                if(v.p.plateau[i][j].getType().equals("bar")){
                    nb_bar++;
                }
            }
        }
        if(nb_bar>=5){
            score += 7;
        }
        
        return score;
    }
}
