package Batiments;

public class Route extends Infrastructure{
    public Route(){
       this.setCoutEntretien(10);
       this.setPrixAchat(10);
       this.setPrixDestr(5);
       this.setTaille(1);
       this.setType("route");
       this.setNb_employe_MAX(1);  
       this.setNb_employe(0);             
    }         
}
