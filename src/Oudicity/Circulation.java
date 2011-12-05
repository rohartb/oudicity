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
        int y = pt.getX();
        int x = pt.getY();
        LinkedList<Points> pchemin = new LinkedList<Points>();
        
        reseauRoutier[x][y] = 1;
        Chemin ch = new Chemin(p);
        ch.pc.add(new Points(x, y));
        mettreAJour(ch);
        
        
        if(x >0 && (reseauRoutier[x-1][y] == 1 
                || reseauRoutier[x-1][y] == 2)){
            reseauRoutier[x-1][y] = 2;
            reseauRoutier[x][y] = 2;
            pchemin.add(new Points(x-1,y));
        }
        if(x < p.getTaille()-1 && (reseauRoutier[x+1][y] == 1 
                || reseauRoutier[x+1][y] == 2)){
            reseauRoutier[x+1][y] = 2;
            reseauRoutier[x][y] = 2;
            pchemin.add(new Points(x+1,y));
        }
        if(y > 0 &&(reseauRoutier[x][y-1] == 1 
                    || reseauRoutier[x][y-1] == 2)){
            reseauRoutier[x][y-1] = 2;
            reseauRoutier[x][y] = 2;
            pchemin.add(new Points(x,y-1));
        }
        if( y < p.getTaille()-1 && (reseauRoutier[x][y+1] == 1 
            || reseauRoutier[x][y+1] == 2)){
            reseauRoutier[x][y+1] = 2;
            reseauRoutier[x][y] = 2;
            pchemin.add(new Points(x,y+1));
        }
        
        if(reseauRoutier[x][y] == 1){
            lc.add(ch);
            System.out.println(" lc " + lc.size());
            System.out.println("com " + ch.batCom.size());
            System.out.println(" ferm " + ch.batFerm.size());
            System.out.println("hab " + ch.batHab.size());
            System.out.println(" ind " + ch.batInd.size());
            System.out.println(" bat" + ch.batSerPu.size());
        } else {
            Chemin li = new Chemin(p);
            li = fusionner(ch,pchemin);
            lc.add(li);
            System.out.println(" lc " + lc.size());
            System.out.println("com " + li.batCom.size());
            System.out.println(" ferm " + li.batFerm.size());
            System.out.println("hab " + li.batHab.size());
            System.out.println(" ind " + li.batInd.size());
            System.out.println(" bat" + li.batSerPu.size());
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
    
    public Chemin fusionner(Chemin ch,LinkedList<Points> lp){
        LinkedList<Chemin> lchem = new LinkedList<Chemin>();
        Points lala;
        Chemin chem = new Chemin(p);
        
        for(int j=0;j<lp.size();j++){
            lala =lp.get(j);
            for(int i=0;i<lc.size();i++){
                chem = lc.get(i);
                if(contientPoint(lala,chem)){
                    lc.remove(i);
                    lchem.add(chem);
                }
            }
        }
        
        for(int j=0;j<lchem.size();j++){
            ch = ajouter(ch,lchem.get(j));
        }
        
        return ch;
    }
    
    private boolean contientPoint(Points lol, Chemin chem) {
        boolean estDans = false;
        
        for(int j=0;j<chem.pc.size();j++){
            if(chem.pc.get(j).getX() == lol.getX() && chem.pc.get(j).getY() == lol.getY()){
                estDans = true;
            }
        }
        
        return estDans;
    }

    public Chemin ajouter(Chemin ch1, Chemin ch2) {
        Chemin cheminf = new Chemin(p);
        
        //liste batCom
        for(int i=0;i<ch1.batCom.size();i++){
            if(ch1.batCom.size()>0){
                cheminf.batCom.add(ch1.batCom.get(i));
            }
        }
        for(int i=0;i<ch2.batCom.size();i++){
            if(ch2.batCom.size()>0){
                cheminf.batCom.add(ch2.batCom.get(i));
            }
        }
        
        //liste batFerm
        for(int i=0;i<ch1.batFerm.size();i++){
            if(ch1.batFerm.size()>0){
                cheminf.batFerm.add(ch1.batFerm.get(i));
            }
        }
        for(int i=0;i<ch2.batFerm.size();i++){
            if(ch2.batFerm.size()>0){
                cheminf.batFerm.add(ch2.batFerm.get(i));
            }
        }
        
        //liste batHab
        for(int i=0;i<ch1.batHab.size();i++){
            if(ch1.batHab.size()>0){
                cheminf.batHab.add(ch1.batHab.get(i));
            }
        }
        for(int i=0;i<ch2.batHab.size();i++){
            if(ch2.batHab.size()>0){
                cheminf.batHab.add(ch2.batHab.get(i));
            }
        }
        
        //liste batLoi
        for(int i=0;i<ch1.batLoi.size();i++){
            if(ch1.batLoi.size()>0){
                cheminf.batLoi.add(ch1.batLoi.get(i));
            }
        }
        for(int i=0;i<ch2.batLoi.size();i++){
            if(ch2.batLoi.size()>0){
                cheminf.batLoi.add(ch2.batLoi.get(i));
            }
        }
        
        //liste batInd
        for(int i=0;i<ch1.batInd.size();i++){
            if(ch1.batInd.size()>0){
                cheminf.batInd.add(ch1.batInd.get(i));
            }
        }
        for(int i=0;i<ch2.batInd.size();i++){
            if(ch2.batInd.size()>0){
                cheminf.batInd.add(ch2.batInd.get(i));
            }
        }
        
        //liste batSerPu
        for(int i=0;i<ch1.batSerPu.size();i++){
            if(ch1.batSerPu.size()>0){
                cheminf.batSerPu.add(ch1.batSerPu.get(i));
            }
        }
        for(int i=0;i<ch2.batSerPu.size();i++){
            if(ch2.batSerPu.size()>0){
                cheminf.batSerPu.add(ch2.batSerPu.get(i));
            }
        }
        
         //liste pc
        for(int i=0;i<ch1.pc.size();i++){
            if(ch1.pc.size()>0){
                System.out.println("ch1 pc " + ch1.pc.size());
                cheminf.pc.add(ch1.pc.get(i));
            }
        }
        for(int i=0;i<ch2.pc.size();i++){
            if(ch2.pc.size()>0){
                System.out.println("ch2 pc " + ch2.pc.size());
                cheminf.pc.add(ch2.pc.get(i));
            }
        }
        
        cheminf.nbEmploy = ch1.nbEmploy + ch2.nbEmploy;
        cheminf.nbHabi = ch1.nbHabi + ch2.nbHabi;
        
        System.out.println("cheminf pc " + cheminf.pc.size());
        return cheminf;
    }

    private void mettreAJour(Chemin ch) {
        Points pt;
        Batiment a;
        int x;
        int y;
        
        for(int i =0; i<ch.pc.size(); i++){
            pt = ch.pc.get(i);
            x = pt.getX();
            y = pt.getY();
            a = p.plateau[x][y];

            if(x >0 && (!p.plateau[x-1][y].getGroupe().equals("infrastructure")
                    || !p.plateau[x-1][y].getGroupe().equals("batiment"))){
                
                a = p.plateau[x-1][y];
                if(a.getGroupe().equals("batimentargent")){
                    BatimentArgent b = (BatimentArgent) p.plateau[x-1][y];
                    if(b.getType().equals("commerce")){
                    } else {
                        if(b.getType().equals("industrie")){
                            ch.batInd.add(new Points(x-1,y));
                        } else {
                            ch.batFerm.add(new Points(x-1,y));
                        }
                    }
                    
                }
                else if(a.getGroupe().equals("loisir")){
                    ch.batLoi.add(new Points(x-1,y));
                }
                else if(a.getGroupe().equals("servicepublique")){
                    ch.batSerPu.add(new Points(x-1,y));
                } else {
                    if(a.getGroupe().equals("logement")){
                        ch.batHab.add(new Points(x-1,y));
                    }
                }
            }
            if(x <p.getTaille()-1 && (!p.plateau[x+1][y].getGroupe().equals("infrastrucure")
                || !p.plateau[x+1][y].getGroupe().equals("batiment"))){
                
                a = p.plateau[x+1][y];
                if(a.getGroupe().equals("batimentargent")){
                    BatimentArgent b = (BatimentArgent) p.plateau[x-1][y];
                    if(b.getType().equals("commerce")){
                        ch.batCom.add(new Points(x+1,y));
                    } else {
                        if(b.getType().equals("industrie")){
                            ch.batInd.add(new Points(x+1,y));
                        } else {
                            ch.batFerm.add(new Points(x+1,y));
                        }
                    }
                    
                }
                else if(a.getGroupe().equals("loisir")){
                    ch.batLoi.add(new Points(x+1,y));
                }
                else if(a.getGroupe().equals("servicepublique")){
                    ch.batSerPu.add(new Points(x+1,y));
                } else {
                    if(a.getGroupe().equals("logement")){
                        ch.batHab.add(new Points(x+1,y));
                    }
                }
            }
            if(y > 0 && (!p.plateau[x][y-1].getGroupe().equals("infrastructure")
                || !p.plateau[x][y-1].getGroupe().equals("batiment"))){
                
                a = p.plateau[x][y-1];
                if(a.getGroupe().equals("batimentargent")){
                    BatimentArgent b = (BatimentArgent) p.plateau[x][y-1];
                    if(b.getType().equals("commerce")){
                        ch.batCom.add(new Points(x,y-1));
                    } else {
                        if(b.getType().equals("industrie")){
                            ch.batInd.add(new Points(x,y-1));
                        } else {
                            if(a.getGroupe().equals("logement")){
                                ch.batFerm.add(new Points(x,y-1));
                            }
                        }
                    }
                    
                }
                else if(a.getGroupe().equals("loisir")){
                    ch.batLoi.add(new Points(x,y-1));
                }
                else if(a.getGroupe().equals("servicepublique")){
                    ch.batSerPu.add(new Points(x,y-1));
                } else {
                    if(a.getGroupe().equals("logement")){
                        ch.batHab.add(new Points(x,y-1));
                    }
                }
            }
            if( y < p.getTaille()-1 && (!p.plateau[x][y+1].getGroupe().equals("infrastructure")
                || !p.plateau[x][y+1].getGroupe().equals("batiment"))){
                
                a = p.plateau[x][y+1];
                if(a.getGroupe().equals("batimentargent")){
                    BatimentArgent b = (BatimentArgent) p.plateau[x][y+1];
                    if(b.getType().equals("commerce")){
                        ch.batCom.add(new Points(x,y+1));
                    } else {
                        if(b.getType().equals("industrie")){
                            ch.batInd.add(new Points(x,y+1));
                        } else {
                            ch.batFerm.add(new Points(x,y+1));
                        }
                    }
                    
                }
                else if(a.getGroupe().equals("loisir")){
                    ch.batLoi.add(new Points(x,y+1));
                }
                else if(a.getGroupe().equals("servicepublique")){
                    ch.batSerPu.add(new Points(x,y+1));
                } else {
                    if(a.getGroupe().equals("logement")){
                        ch.batHab.add(new Points(x,y+1));
                    }
                }
            }
        }
        
        ch.nbHabi = calculerHab(ch);
        ch.nbEmploy = calulerEmploy(ch);
    }

    private int calculerHab(Chemin ch) {
        int n = 0;
        Points pop = null;
        
        if(ch.batHab != null){
            for(int i=0; i<ch.batHab.size(); i++){
                pop = ch.batHab.get(i);
                Logement loge =  (Logement) p.plateau[pop.getX()][pop.getY()];
                n += loge.getNb_habitant();   
            }
        }
        return n;
    }

    private int calulerEmploy(Chemin ch) {
        int n = 0;
        Points pop = null;
        
        if(ch.batCom != null){
            for(int i=0; i<ch.batCom.size(); i++){
                pop = ch.batCom.get(i);
                Commerce batman = (Commerce) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe();   
            }
        }
        
        if(ch.batInd != null){
            for(int i=0; i<ch.batInd.size(); i++){
                pop = ch.batInd.get(i);
                Industrie batman = (Industrie) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe();   
            }
        }
        
        if(ch.batFerm != null){
            for(int i=0; i<ch.batFerm.size(); i++){
                pop = ch.batFerm.get(i);
                Ferme batman = (Ferme) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe();   
            }
        }
        
        if(ch.batLoi != null){
            for(int i=0; i<ch.batLoi.size(); i++){
                pop = ch.batLoi.get(i);
                Loisir batman = (Loisir) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe();   
            }
        }
        
        if(ch.batSerPu != null){
            for(int i=0; i<ch.batSerPu.size(); i++){
                pop = ch.batSerPu.get(i);
                ServicePublic batman = (ServicePublic) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe();   
            }
        }
    return n;
    }
}