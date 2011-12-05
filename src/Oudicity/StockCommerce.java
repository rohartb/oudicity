package Oudicity;

import Batiments.*;
import java.util.*;

public class StockCommerce {
    Plateau p;
    public StockCommerce(Plateau p){
        this.p = p;
    }
    
    public LinkedList<Points> plateauContientFerme(){
        LinkedList<Points> l = new LinkedList<Points>();
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getType().equals("ferme")){
                    Ferme f = (Ferme) p.plateau[i][j];
                    if (f.getStock_nourriture()>0){
                        l.add(new Points(i,j));
                    }
                }
            }
        }
        return l;
    }

    public LinkedList<Points> plateauContientIndustrie(){
        LinkedList<Points> l = new LinkedList<Points>();
        for(int i=0; i<p.getTaille(); i++){
            for(int j=0; j<p.getTaille(); j++){
                if(p.plateau[i][j].getType().equals("inductrie")){
                    Industrie ind = (Industrie) p.plateau[i][j];
                    if(ind.getStock_Bien()>0){
                        l.add(new Points(i,j));  
                    }
                }
            }
        }
        return l;
    }
    
    public int augmenterStockBien(int a){//a est ce qu'on veut prendre
        LinkedList<Points> l = plateauContientIndustrie();
        int i =1;
        int b=a;
        Points pt = l.get(i);
        while(b!=0 && pt!=null){
            Industrie ind = (Industrie) p.plateau[pt.getX()][pt.getY()];
            if(ind.getStock_Bien()<b ){                
                b -= ind.getStock_Bien();
                ind.setStock_Bien(-ind.getStock_Bien());//on prend tout ce qui reste
            }
            else{
                ind.setStock_Bien(-b);
                b=0;        
            }
            i++;
            pt = l.get(i);
        }
        return b;
        //b est ce qu'on a pas pu prendre, plus de stock dans les industries
    }
    
    public int augmenterStockNourriture(int a){//a est ce qu'on veut prendre
        LinkedList<Points> l = plateauContientFerme();
        Ferme f;
        int i =1;
        int b=a;
        Points pt = l.get(i);
        while(b!=0 && pt!=null){
             f = (Ferme) p.plateau[pt.getX()][pt.getY()];
            if(f.getStock_nourriture()<b ){                
                b -= f.getStock_nourriture();
                f.setStock_nourriture(-f.getStock_nourriture());//on prend tout ce qui reste
            }
            else{
                f.setStock_nourriture(-b);
                b=0;        
            }
            i++;
            pt = l.get(i);
        }
        return b;
        //b est ce qu'on a pas pu prendre, plus de stock dans les industries
    }
    
    
}
