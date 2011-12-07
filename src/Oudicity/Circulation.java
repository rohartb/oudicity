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
        Chemin ch = new Chemin(p);
        LinkedList<Points> pchemin = new LinkedList<Points>();
        
        reseauRoutier[x][y] = 1;
        ch = mettreAJour(new Points(pt.getX(), pt.getY()));
        ch.pc.add(new Points( pt.getX(), pt.getY()));

        if(x >0 && (reseauRoutier[x-1][y] == 1 
                || reseauRoutier[x-1][y] == 2)){
            reseauRoutier[x-1][y] = 2;
            reseauRoutier[x][y] = 2;
            pchemin.add(new Points(y,x-1));
        }
        if(x < p.getTaille()-1 && (reseauRoutier[x+1][y] == 1 
                || reseauRoutier[x+1][y] == 2)){
            reseauRoutier[x+1][y] = 2;
            reseauRoutier[x][y] = 2;
            pchemin.add(new Points(y,x+1));
        }
        if(y > 0 &&(reseauRoutier[x][y-1] == 1 
                    || reseauRoutier[x][y-1] == 2)){
            reseauRoutier[x][y-1] = 2;
            reseauRoutier[x][y] = 2;
            pchemin.add(new Points(y-1,x));
        }
        if( y < p.getTaille()-1 && (reseauRoutier[x][y+1] == 1 
            || reseauRoutier[x][y+1] == 2)){
            reseauRoutier[x][y+1] = 2;
            reseauRoutier[x][y] = 2;
            pchemin.add(new Points(y+1,x));
        }
        
        if(reseauRoutier[x][y] == 1){
            lc.add(ch);
            System.out.println("liste points " + ch.pc.size());
            System.out.println("liste com " + ch.batCom.size());
            System.out.println("liste hab " + ch.batHab.size());
            System.out.println("liste ferm " + ch.batFerm.size());
            System.out.println("liste ind " + ch.batInd.size());
            System.out.println("liste loi " + ch.batLoi.size());
            System.out.println("liste servicpu " + ch.batSerPu.size());
            System.out.println("nbemploy " + ch.nbEmploy);
            System.out.println("nbemax " + ch.nbEmployMax);
            System.out.println("nbhab " + ch.nbHabi);
            
        } else {
            Chemin li = new Chemin(p);
            li = fusionner(ch,pchemin);
            lc.add(li);
            System.out.println("liste points " + li.pc.size());
            System.out.println("liste com " + li.batCom.size());
            System.out.println("liste hab " + li.batHab.size());
            System.out.println("liste ferm " + li.batFerm.size());
            System.out.println("liste ind " + li.batInd.size());
            System.out.println("liste loi " + li.batLoi.size());
            System.out.println("liste servicpu " + li.batSerPu.size());
            System.out.println("nbemploy " + li.nbEmploy);
            System.out.println("nbemax " + li.nbEmployMax);
            System.out.println("nbhab " + li.nbHabi);
        }
    }
    
    public void afficher(){
        for (int a=0; a<p.getTaille(); a++){
            for (int b=0; b<p.getTaille(); b++){
                System.out.print("" + reseauRoutier[a][b] + " ");
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
                cheminf.pc.add(ch1.pc.get(i));
            }
        }
        for(int i=0;i<ch2.pc.size();i++){
            if(ch2.pc.size()>0){
                cheminf.pc.add(ch2.pc.get(i));
            }
        }
        
        cheminf.nbEmploy = ch1.nbEmploy + ch2.nbEmploy;
        cheminf.nbHabi = ch1.nbHabi + ch2.nbHabi;
        cheminf.nbEmployMax = ch1.nbEmployMax + ch2.nbEmployMax;
        
        return cheminf;
    }

    private Chemin mettreAJour(Points pet) {
        Points pt;
        Batiment a;
        Chemin ch = new Chemin(p);
        int x;
        int y;
        
        x = pet.getX();
        y = pet.getY();

            if(x >0 && (!p.plateau[x-1][y].getGroupe().equals("infrastructure")
                    || !p.plateau[x-1][y].getGroupe().equals("batiment"))){
                a = p.plateau[x-1][y];
                if(a.getGroupe().equals("batimentargent")){
                    System.out.println("batArgent");
                    BatimentArgent b = (BatimentArgent) p.plateau[x-1][y];
                    if(b.getType().equals("commerce")){
                        ch.batCom.add(new Points(x-1,y));
                        System.out.println("commmerc");
                    } else {
                        if(b.getType().equals("industrie")){
                            ch.batInd.add(new Points(x-1,y));
                            System.out.println("indus");
                        } else {
                            ch.batFerm.add(new Points(x-1,y));
                            System.out.println("ferme");
                        }
                    }
                    
                }
                else if(a.getGroupe().equals("loisir")){
                    ch.batLoi.add(new Points(x-1,y));
                }
                else if(a.getGroupe().equals("servicepublic")){
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
                    BatimentArgent b = (BatimentArgent) p.plateau[x+1][y];
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
                else if(a.getGroupe().equals("servicepublic")){
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
                else if(a.getGroupe().equals("servicepublic")){
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
                else if(a.getGroupe().equals("servicepublic")){
                    ch.batSerPu.add(new Points(x,y+1));
                } else {
                    if(a.getGroupe().equals("logement")){
                        ch.batHab.add(new Points(x,y+1));
                    }
                }
            }
        
        ch.nbHabi = calculerHab(ch);
        ch.nbEmploy = calulerEmploy(ch);
        ch.nbEmployMax = calulerEmployMax(ch);
        
        return ch;
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
    
    private int calulerEmployMax(Chemin ch) {
        int n = 0;
        Points pop = null;
        
        if(ch.batCom != null){
            for(int i=0; i<ch.batCom.size(); i++){
                pop = ch.batCom.get(i);
                Commerce batman = (Commerce) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe_MAX();   
            }
        }
        
        if(ch.batInd != null){
            for(int i=0; i<ch.batInd.size(); i++){
                pop = ch.batInd.get(i);
                Industrie batman = (Industrie) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe_MAX();   
            }
        }
        
        if(ch.batFerm != null){
            for(int i=0; i<ch.batFerm.size(); i++){
                pop = ch.batFerm.get(i);
                Ferme batman = (Ferme) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe_MAX();   
            }
        }
        
        if(ch.batLoi != null){
            for(int i=0; i<ch.batLoi.size(); i++){
                pop = ch.batLoi.get(i);
                Loisir batman = (Loisir) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe_MAX();   
            }
        }
        
        if(ch.batSerPu != null){
            for(int i=0; i<ch.batSerPu.size(); i++){
                pop = ch.batSerPu.get(i);
                ServicePublic batman = (ServicePublic) p.plateau[pop.getX()][pop.getY()];
                n += batman.getNb_employe_MAX();   
            }
        }
    return n;
    }

   public Chemin trouverChemin(Points lol) {
        Chemin chemf = new Chemin(p);

        for(int i=0;i<lc.size();i++){
            chemf = lc.get(i);
            for(int j=0;j<chemf.pc.size();j++){
                if(chemf.pc.get(j).getX() == lol.getX() && chemf.pc.get(j).getY() == lol.getY()){
                    return chemf;
                }
            }
        }
        return chemf;
    }

    public LinkedList<Points> routeACote(Points pt) {
        LinkedList<Points> led = new LinkedList<Points>();
        LinkedList<Points> ledFinal = new LinkedList<Points>();
        int x  = pt.getX();
        int y = pt.getY();
        Points pf;

        if(x >0 && p.plateau[x-1][y].getType().equals("route")){
            pf = new Points(x-1,y);
            led.add(pf);
        }
        if(x < p.getTaille()-1 && p.plateau[x+1][y].getType().equals("route")){
            pf = new Points(x+1,y);
            led.add(pf);
        }
        if(y > 0 && p.plateau[x][y-1].getType().equals("route")){
            led.add(new Points(x,y-1));
        }
        if( y < p.getTaille()-1 && p.plateau[x][y+1].getType().equals("route")){
            led.add(new Points(y+1,x));
        }

        if(led.size() == 1){
            ledFinal.add(led.get(0));
        }
        
        if(led.size()==2){
            Points p1 = led.get(0);
            Points p2 = led.get(1);

            ledFinal.add(p1);
            if(!memeChem(p1,p2)){
                ledFinal.add(p2);
            }
        } else {
            if(led.size() == 3){
                Points p1 = led.get(0);
                Points p2 = led.get(1);
                Points p3 = led.get(2);

                ledFinal.add(p1);
                if(!memeChem(p1,p2)){
                    ledFinal.add(p2);
                }
                if(!memeChem(p1,p3) && !memeChem(p2,p3)){
                     ledFinal.add(p3);
                }
            } else {
                if(led.size() == 4){
                    Points po1 = led.get(0);
                    Points po2 = led.get(1);
                    Points po3 = led.get(2);
                    Points po4 = led.get(3);

                    ledFinal.add(po1);
                    if(!memeChem(po1,po2)){
                        ledFinal.add(po2);
                    }
                    if(!memeChem(po1,po3) && !memeChem(po2,po3)){
                        ledFinal.add(po3);
                    }
                    if(!memeChem(po1,po4) && !memeChem(po2,po4) &&
                                !memeChem(po3,po4)){
                        ledFinal.add(po4);
                    }
                }
            }
        }

        return ledFinal;
    }

    public boolean memeChem(Points p1, Points p2) {
        boolean estDansMemChemin = false;
        Chemin chom;
        boolean estEgalP1 = false;
        boolean estEgalP2 = false;
        Points lala;

        for(int i=0;i<lc.size();i++){
            chom = lc.get(i);
            for(int j=0;j<chom.pc.size();j++){
                lala = chom.pc.get(j);
                if(lala.getX() == p1.getX() && lala.getY() == p1.getY()){
                    estEgalP1 = true;
                }
                if(lala.getX() == p2.getX() && lala.getY() == p2.getY()){
                    estEgalP2 = true;
                }
            }
            if(estEgalP1 && estEgalP2){
                estDansMemChemin = true;
            } else {
                estEgalP1 = false;
                estEgalP2 = false;
            }
        }

        return estDansMemChemin;
    }

    void supprimerRoute(Points pt) {
        int x = pt.getY();
        int y = pt.getX();
        Chemin che = new Chemin(p);
        LinkedList<Points> lip = new LinkedList<Points>();
        
        che = trouverChemin(pt);
        
        if(che.pc.size() == 1){
            supprimerChemin(pt);
            System.out.println("taille liste chemin " + lc.size());
        }
        
        if(x >0 && reseauRoutier[x-1][y] == 0){
            lip.add(new Points(y,x-1));
        }
        if(x < p.getTaille()-1 && reseauRoutier[x+1][y] == 0){ 
            lip.add(new Points(y,x+1));
        }
        if(y > 0 && reseauRoutier[x][y-1] == 0){
            lip.add(new Points(y-1,x));
        }
        if( y < p.getTaille()-1 && reseauRoutier[x][y+1] == 0){
            lip.add(new Points(y+1,x));
        }
        
        if((x==0 && y==0) || (x==p.getTaille()-1 && y==p.getTaille()-1)){
            if(lip.size()==1){
                //fin de chemin
                supprimerFinChemin(lip,pt);
            } else {
                //chemin scindé
                scinderChemin(pt);
            }
        } else {
            if(x==0 || y==0 || x==p.getTaille()-1 || y==p.getTaille()-1){
                if(lip.size() == 2){
                    //fin de chemin
                    supprimerFinChemin(lip,pt);
                } else {
                    //chemin scindé
                    scinderChemin(pt);
                }
            } else {
                if(lip.size() == 1){
                    //fin du chemin
                    supprimerFinChemin(lip,pt);
                } else {
                    // chemin scindé 
                    scinderChemin(pt);
                }
            }
        }
        reseauRoutier[pt.getY()][pt.getX()] = 0;
    
    }
    
    public void supprimerChemin(Points pt) {
        Chemin chemf = new Chemin(p);

        for(int i=0;i<lc.size();i++){
            chemf = lc.get(i);
            for(int j=0;j<chemf.pc.size();j++){
                if(chemf.pc.get(j).getX() == pt.getX() && chemf.pc.get(j).getY() == pt.getY()){
                    lc.remove(i);
                }
            }
        }
    }

    private void supprimerFinChemin(LinkedList<Points> lip, Points pt) {
        Points pete;
        Points pwin;
        Batiment batt;
        Chemin cheminee = trouverChemin(pt);
        
        for(int i = 0;i<lip.size();i++){
            pete = lip.get(i);
            batt = p.plateau[pete.getX()][pete.getY()];
            if(batt.getGroupe().equals("batimentargent")){
                    BatimentArgent b = (BatimentArgent) p.plateau[pete.getX()][pete.getY()];
                    if(b.getType().equals("commerce")){
                        pwin = supprimerBatListe(cheminee.batCom,pete);
                        cheminee.nbEmploy -= pwin.getX();
                        cheminee.nbEmployMax -= pwin.getY();
                    } else {
                        if(b.getType().equals("industrie")){
                            pwin = supprimerBatListe(cheminee.batInd,pete);
                            cheminee.nbEmploy -= pwin.getX();
                            cheminee.nbEmployMax -= pwin.getY();
                        } else {
                            pwin = supprimerBatListe(cheminee.batFerm,pete);
                            cheminee.nbEmploy -= pwin.getX();
                            cheminee.nbEmployMax -= pwin.getY();
                        }
                    }
                    
                }
                else if(batt.getGroupe().equals("loisir")){
                    pwin = supprimerBatListe(cheminee.batLoi,pete);
                    cheminee.nbEmploy -= pwin.getX();
                    cheminee.nbEmployMax -= pwin.getY();
                }
                else if(batt.getGroupe().equals("servicepublic")){
                    pwin = supprimerBatListe(cheminee.batSerPu,pete);
                    cheminee.nbEmploy -= pwin.getX();
                    cheminee.nbEmployMax -= pwin.getY();
                } else {
                    if(batt.getGroupe().equals("logement")){
                        pwin = supprimerBatListe(cheminee.batHab,pete);
                        cheminee.nbHabi -= pwin.getX();
                    }
                
                }
        }

    }

    private void scinderChemin(Points pt) {
        Chemin koala;
        Points panda;
        
        // je recupere le chemin ou la route va etre coupée
        koala = trouverChemin(pt);
        // je supprime le chemin de ma liste de chemin
        supprimerChemin(pt);
        //je parours mon tableau reseau et je supprime tout les points de ce chemin
        for(int i=0; i<koala.pc.size(); i++){
            panda = koala.pc.get(i);
            if(pt.getX() == panda.getX() && pt.getY() == panda.getY()){
                koala.pc.remove(i);
                System.out.println("taille liste" + koala.pc.size());
            } else {
                reseauRoutier[panda.getY()][panda.getX()] = 0;
            }
        }
        afficher();
        // On reactualise tout les points du chemin
        for(int i=0; i<koala.pc.size(); i++){
            panda = koala.pc.get(i);
            System.out.println("panda x et y " + panda.getX() + panda.getY());
            actualiserReseauRoutier(panda);
        }
    }

    private Points supprimerBatListe(LinkedList<Points> batList, Points pwinPwin) {
        Points pNombre = null;
        Points poing;
        Batiment blatte;
        
        for(int i=0;i<batList.size();i++){
            poing = batList.get(i);
            if(poing.getX()== pwinPwin.getX() && poing.getY() == pwinPwin.getX()){
                blatte = p.plateau[poing.getX()][poing.getY()]; 
                if(blatte.getGroupe().equals("batimentargent")){
                    BatimentArgent bobet = (BatimentArgent) p.plateau[poing.getX()][poing.getX()];
                    pNombre = new Points(bobet.getNb_employe(),bobet.getNb_employe_MAX());
                    batList.remove(i);
                }
                else if(blatte.getGroupe().equals("loisir")){
                    Loisir bobet = (Loisir) p.plateau[poing.getX()][poing.getX()];
                    pNombre = new Points(bobet.getNb_employe(),bobet.getNb_employe_MAX());
                    batList.remove(i);
                }
                else if(blatte.getGroupe().equals("servicepublic")){
                    ServicePublic bobet = (ServicePublic) p.plateau[poing.getX()][poing.getX()];
                    pNombre = new Points(bobet.getNb_employe(),bobet.getNb_employe_MAX());
                    batList.remove(i);
                } else {
                    if(blatte.getGroupe().equals("logement")){
                        Logement bobet = (Logement) p.plateau[poing.getX()][poing.getX()];
                        pNombre = new Points(bobet.getNb_habitant(),0);
                        batList.remove(i);
                    }
                }
            }
        }
        return pNombre;
    }
}