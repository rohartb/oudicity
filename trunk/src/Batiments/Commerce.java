package Batiments;

import Oudicity.*;

public class Commerce extends BatimentArgent /*implements Observer*/{
    private int reserv_nourriture;
    private int reserv_bien;
    
    int annee = 1970;
    int mois = 1;
    int jour = 1;
    int jourDebut = 3;
    
    public Commerce(OudiCity s){
        super(s);
        this.coutEntretien=50;
        this.nb_employe_MAX=15;
        this.nb_employe=0;          
        this.prixAchat=500;
        this.prixDestr=250;     
        this.taille=1;
        this.type="commerce";
        this.persBat="employe";
        this.groupe="batimentargent";        
        this.reserv_bien=0;
        this.reserv_nourriture=0;
        
        //s.t.c.addObserver(this);
    }

    /*GETTERS*/
    public int getReserv_bien() {
        return reserv_bien;
    }

    public int getReserv_nourriture() {
        return reserv_nourriture;
    }

    /*SETTERS*/
    public void setReserv_nourriture(int nourriture) {
        this.reserv_nourriture += nourriture;
    }

    public void setReserv_bien(int bien) {
        this.reserv_bien += bien;
    }
    

    
    /*@Override
    public void update(Observable o, Object arg) {
        Calendrier c = new Calendrier();
        if(this.nb_employe>0){
            if(o.getClass()==c.getClass()){
                c = (Calendrier) o;
                if(jour != c.jour){
                    jour = c.jour;
                    if(jour > jourDebut){
                        if(this.reserv_bien < 50){
                            int a = s.getFenetre().getGraphique().getPlateau().getSC().augmenterReservBien(100);
                            if(a!=0 && this.reserv_nourriture==0){
                                s.getFenetre().getBarreL().afficheConseil("Manque d'industries (ou de subvention)");
                                //System.out.println("Certains commerces n'ont plus de bien dans leur reserve!");
                                //System.out.println("  ->faire plus d'industries, ou augmenter leur subvention!");
                            }
                            this.reserv_bien += 100-a;
                        }
                        if(this.reserv_nourriture<100){
                            int a = s.getFenetre().getGraphique().getPlateau().getSC().augmenterReservNourriture(200);
                            if(a!=0 && this.reserv_nourriture==0){
                                s.getFenetre().getBarreL().afficheConseil("Manque de fermes (ou de subvention)");
                               //System.out.println("Certains commerces n'ont plus de nourriture dans leur reserve!");
                               //System.out.println("  ->faire plus de fermes, ou augmenter leur subvention!");
                            }
                            this.reserv_nourriture += 200-a;
                        }
                    }
                }
            }
        }
    }*/
}
