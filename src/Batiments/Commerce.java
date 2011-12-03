package Batiments;

public class Commerce extends BatimentArgent{
        public Commerce(){
            this.setCoutEntretien(10);
            this.setNb_employe(0);
            this.setNb_employe_MAX(10);            
            this.setPrixAchat(10);
            this.setPrixDestr(5);
            //this.setRessource(ressource);    
            this.setTaille(1);
            this.setType("commmerce");            
        }
}
