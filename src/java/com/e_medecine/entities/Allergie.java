package com.e_medecine.entities;
// Generated 10 avr. 2020 06:38:05 by Hibernate Tools 4.3.1



/**
 * Allergie generated by hbm2java
 */
public class Allergie  implements java.io.Serializable {


     private Integer idAl;
     private String produitAl;

    public Allergie() {
    }

    public Allergie(String produitAl) {
       this.produitAl = produitAl;
    }
   
    public Integer getIdAl() {
        return this.idAl;
    }
    
    public void setIdAl(Integer idAl) {
        this.idAl = idAl;
    }
    public String getProduitAl() {
        return this.produitAl;
    }
    
    public void setProduitAl(String produitAl) {
        this.produitAl = produitAl;
    }




}


