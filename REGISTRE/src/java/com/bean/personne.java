
package com.bean;


public class personne {
    static int IDP ;
    static String NOMP ;
    static String NOMF ;
    
    
    public personne(){
    
    }
    
    public personne( int IDP, String NOMP, String NOMF){
    this.IDP  = IDP;
    this.NOMP = NOMP;
    this.NOMF = NOMF;
    }
    
    public static int getIDPersonne(){
    return IDP;
    }
    
    public static String getNOMPersonne(){
    return NOMP ;
    }
    public static String getNOMFonction(){
    return NOMF ;
    }
   
    public void setIDPersonne(int ID){
    this.IDP = ID; 
    }
    public void setNOMPersonne(String Nom){
    this.NOMP = Nom;
    }
    public void setNOMFonction(String Nom){
    this.NOMF = Nom;
    }
    
    
    
}
