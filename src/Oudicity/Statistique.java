

package Oudicity;

import java.awt.*;
import javax.swing.*;



class Statistique extends JFrame{
    OudiCity o;

    public Statistique(OudiCity o){
        this.o = o;
    }

    public void AfficherStats() throws InterruptedException{
        JFrame f = new JFrame("Statistiques");
        JPanel nbHabitants, pourcentage, attraction, argent, nbLoisirs,
                nbPubliques;
        JPanel panelGauche, panelDroit, panel;

        panel = new JPanel(new GridLayout(1,2));

        panelGauche = new JPanel();
        panelGauche.setLayout(new BoxLayout(panelGauche,BoxLayout.Y_AXIS));
        panelDroit = new JPanel();
        panelDroit.setLayout(new BoxLayout(panelDroit,BoxLayout.Y_AXIS));


       
        nbHabitants = new JPanel();
        nbHabitants.setBackground(Color.WHITE);
        JLabel habitants = new JLabel(""+o.v.nbHabitant);
        nbHabitants.setBorder(BorderFactory.createTitledBorder("Nombre d'habitants"));
        nbHabitants.add(habitants);

        argent = new JPanel();
        argent.setBackground(Color.WHITE);
        JLabel arg = new JLabel(""+o.v.argent+" Ƶ");
        argent.setBorder(BorderFactory.createTitledBorder("Argent"));
        argent.add(arg);

        int attract = 0;
        attraction = new JPanel();
        attraction.setBackground(Color.WHITE);
        JLabel att = new JLabel(""+attract);
        attraction.setBorder(BorderFactory.createTitledBorder("Attraction"));
        attraction.add(att);
        
        int loisir = this.chercheLoisirs();
        nbLoisirs = new JPanel();
        nbLoisirs.setBackground(Color.WHITE);
        JLabel loi = new JLabel(""+loisir);
        nbLoisirs.setBorder(BorderFactory.createTitledBorder("Loisirs"));
        nbLoisirs.add(loi);

        int service = cherchePubliques();
        nbPubliques = new JPanel();
        nbPubliques.setBackground(Color.WHITE);
        JLabel publiques = new JLabel(""+service);
        nbPubliques.setBorder(BorderFactory.createTitledBorder("Services Publiques"));
        nbPubliques.add(publiques);

        int chomeur = chercheChomeurs();
        pourcentage = new JPanel();
        pourcentage.setBackground(Color.WHITE);
        JLabel chom = new JLabel(""+chomeur+"%");
        pourcentage.setBorder(BorderFactory.createTitledBorder("Pourcentage de chômeurs"));
        pourcentage.add(chom);
        


        panelGauche.add(nbHabitants);
        panelGauche.add(argent);
        panelGauche.add(nbLoisirs);

        panelDroit.add(pourcentage);
        panelDroit.add(attraction);
        panelDroit.add(nbPubliques);

        panel.add(panelGauche);
        panel.add(panelDroit);
        
        f.add(panel);
        f.setDefaultCloseOperation(f.HIDE_ON_CLOSE);
        f.setSize(500, 400);
        f.setVisible(true);

    }

    private int chercheLoisirs() {
        int nb = 0;

        for(int i=0; i<o.f.pg.p.getTaille(); i++){
             for(int j=0; j<o.f.pg.p.getTaille(); j++){
                 if(o.f.pg.p.plateau[i][j].getGroupe().equals("loisir")){
                     nb++;
                 }
             }
        }
        return nb;
    }

    private int cherchePubliques() {
        int nb = 0;

        for(int i=0; i<o.f.pg.p.getTaille(); i++){
             for(int j=0; j<o.f.pg.p.getTaille(); j++){
                 if(o.f.pg.p.plateau[i][j].getGroupe().equals("servicepublic")){
                     nb++;
                 }
             }
        }
        return nb;
    }

    private int chercheChomeurs() {
        int hab = o.v.nbHabitant;
        int employe = o.v.p.e.nbTotEmploy();
        int nb;
        if (hab == 0){
            nb = 1;
        }else{
            nb = (hab - employe)/hab;
        }
        return nb*100;
    }


}
