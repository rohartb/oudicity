package Oudicity;
import Batiments.*;
import java.util.*;

public final class Circulation {
    Plateau p;
    Batiment t[][];
    int reseauRoutier[][];
    LinkedList <Chemin> lc = new LinkedList<Chemin>();
    
    public Circulation(Plateau p){
        this.p = p;
        t = p.plateau;
        reseauRoutier = new int[p.getTaille()][p.getTaille()];
        init_tab(reseauRoutier);
    }
    
    
    public void init_tab(int tab[][]){
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                tab[i][j] = 0;
            }
        }
    }
    
    public void actualiserReseauRoutier(Points pt){
        int x = pt.getX();
        int y = pt.getY();
        
        reseauRoutier[x][y] = 1;
        
        if(x >0 && (reseauRoutier[x-1][y] == 1 
                || reseauRoutier[x-1][y] == 2)){
            reseauRoutier[x-1][y] = 2;
            reseauRoutier[x][y] = 2;
        }
        if(x < p.getTaille()-1 && (reseauRoutier[x+1][y] == 1 
                || reseauRoutier[x+1][y] == 2)){
            reseauRoutier[x+1][y] = 2;
            reseauRoutier[x][y] = 2;
        }
        if(y > 0 &&(reseauRoutier[x][y-1] == 1 
                    || reseauRoutier[x][y-1] == 2)){
            reseauRoutier[x][y-1] = 2;
            reseauRoutier[x][y] = 2;
        }
        if( y < p.getTaille()-1 && (reseauRoutier[x][y+1] == 1 
            || reseauRoutier[x][y+1] == 2)){
            reseauRoutier[x][y+1] = 2;
            reseauRoutier[x][y] = 2;
        }
        
        
        // On a juste une seule route
        if(reseauRoutier[x][y] == 1){
            System.out.println("un chemin seul");
            Chemin ch = new Chemin(p);
            ch.pc.add(pt);
            mettreAJour(ch);
            lc.add(ch);
        }
    }
    
    public void afficher(){
        for (int a=0; a<p.getTaille(); a++){
            for (int b=0; b<p.getTaille(); b++){
                System.out.print("" + reseauRoutier[b][a] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private void mettreAJour(Chemin ch) {
        Points pt;
        Batiment b;
        int x;
        int y;
        
        for(int i =0; i<ch.pc.size(); i++){
            pt = ch.pc.get(i);
            x = pt.getX();
            y = pt.getY();
            Batiment a = p.plateau[x][y];
           /* 
            if(x >0 && (p.plateau[x-1][y].getGroupe().equals("logement")
                || p.plateau[x-1][y].getGroupe().equals("industrie")
                || p.plateau[x-1][y].getGroupe().equals("batimentargent"))){
                
                if(a.getGroupe().equals("batimentargent")){
                    BatimentArgent b = (BatimentArgent) p.plateau[pt.getX()][pt.getY()];
                    b.setNb_employe(1);
                }
                else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("loisir")){
                    Loisir b = (Loisir) p.plateau[pt.getX()][pt.getY()];
                    b.setNb_employe(1);
                }
                else if(p.plateau[pt.getX()][pt.getY()].getGroupe().equals("servicepublic")){
                    ServicePublic b = (ServicePublic) p.plateau[pt.getX()][pt.getY()];
                    b.setNb_employe(1);
                }  
            }
            if(x < p.getTaille()-1 && (reseauRoutier[x+1][y] == 1 
                || reseauRoutier[x+1][y] == 2)){
            reseauRoutier[x+1][y] = 2;
            reseauRoutier[x][y] = 2;
            }
            if(y > 0 &&(reseauRoutier[x][y-1] == 1 
                    || reseauRoutier[x][y-1] == 2)){
            reseauRoutier[x][y-1] = 2;
            reseauRoutier[x][y] = 2;
            }
            if( y < p.getTaille()-1 && (reseauRoutier[x][y+1] == 1 
            || reseauRoutier[x][y+1] == 2)){
            reseauRoutier[x][y+1] = 2;
            reseauRoutier[x][y] = 2;
            }
        */
        }
    }
}
