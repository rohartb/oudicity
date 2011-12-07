package Oudicity;

import Batiments.*;
import java.util.*;

public class StockCommerce {
    Plateau p;
    public StockCommerce(Plateau p){
        this.p = p;
    }
    
    public LinkedList<Points> plateauContientFerme(Chemin ch){
        LinkedList<Points> ferme = ch.batFerm;
        LinkedList<Points> l = new LinkedList<Points>();
        for(int i=0; i<ferme.size(); i++){
            Points pt = ferme.get(i);
            Ferme f = (Ferme) p.plateau[pt.getX()][pt.getY()];
            if (f.getStock_nourriture()>0){
                l.add(new Points(pt.getX(),pt.getY()));
            }
        }
        return l;
    }

    public LinkedList<Points> plateauContientIndustrie(Chemin ch){
        LinkedList<Points> ind = ch.batInd;
        LinkedList<Points> l = new LinkedList<Points>();
        for(int i=0; i<ind.size(); i++){
            Points pt = ind.get(i);
            Industrie indus = (Industrie) p.plateau[pt.getX()][pt.getY()];
            if (indus.getStock_Bien()>0){
                l.add(new Points(pt.getX(),pt.getY()));
            }
        }
        return l;
    }

    //retourne b qui est soit nul quand on a réussit à puiser tous les biens
    //dans les industries, soit positive
    public int augmenterReservBien(int a,Chemin ch){//a est ce qu'on veut prendre
        LinkedList<Points> l = plateauContientIndustrie(ch);
        Industrie ind;
        int i =0;
        int b=a;
        Points pt;
        int taille=l.size();
        if(taille==0){
            return b;
        }
        else{
            while(b!=0 && i<taille){
                pt=l.get(i);
                i++;
                ind = (Industrie) p.plateau[pt.getX()][pt.getY()];
                if(ind.getStock_Bien()<b ){                
                    b -= ind.getStock_Bien();
                    ind.setStock_Bien(-ind.getStock_Bien());//on prend tout ce qui reste
                }
                else{
                    ind.setStock_Bien(-b);
                    b=0;        
                }
            }
            return b;
            //b est ce qu'on a pas pu prendre, plus de stock dans les industries
        }
    }
    
    public int augmenterReservNourriture(int a, Chemin ch){//a est ce qu'on veut prendre
        LinkedList<Points> l = plateauContientFerme(ch);
        Ferme f;
        int i =0;
        int b=a;
        Points pt;
        int taille=l.size();
        if(taille==0){
            return b;
        }
        else{
            while(b!=0 && i<taille){
                pt = l.get(i);
                i++;
                 f = (Ferme) p.plateau[pt.getX()][pt.getY()];
                if(f.getStock_nourriture()<b ){                
                    b -= f.getStock_nourriture();
                    f.setStock_nourriture(-f.getStock_nourriture());//on prend tout ce qui reste
                }
                else{
                    f.setStock_nourriture(-b);
                    b=0;        
                }
            }
            return b;
            //b est ce qu'on a pas pu prendre, plus de stock dans les fermes
        }
    } 
}