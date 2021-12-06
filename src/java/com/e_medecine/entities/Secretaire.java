package com.e_medecine.entities;
// Generated 10 avr. 2020 06:38:05 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Secretaire generated by hbm2java
 */
public class Secretaire  implements java.io.Serializable {


     private Integer idSec;
     private String nomSec;
     private String prenomSec;
     private String loginSec;
     private String passwordSec;
     private Date dateNaisSec;
     private String adresseSec;
     private String emailSec;
     private Integer telMobSec;
     private Boolean etatSec;

    public Secretaire() {
    }

    public Secretaire(String nomSec, String prenomSec, String loginSec, String passwordSec, Date dateNaisSec, String adresseSec, String emailSec, Integer telMobSec, Boolean etatSec) {
       this.nomSec = nomSec;
       this.prenomSec = prenomSec;
       this.loginSec = loginSec;
       this.passwordSec = passwordSec;
       this.dateNaisSec = dateNaisSec;
       this.adresseSec = adresseSec;
       this.emailSec = emailSec;
       this.telMobSec = telMobSec;
       this.etatSec = etatSec;
    }
   
    public Integer getIdSec() {
        return this.idSec;
    }
    
    public void setIdSec(Integer idSec) {
        this.idSec = idSec;
    }
    public String getNomSec() {
        return this.nomSec;
    }
    
    public void setNomSec(String nomSec) {
        this.nomSec = nomSec;
    }
    public String getPrenomSec() {
        return this.prenomSec;
    }
    
    public void setPrenomSec(String prenomSec) {
        this.prenomSec = prenomSec;
    }
    public String getLoginSec() {
        return this.loginSec;
    }
    
    public void setLoginSec(String loginSec) {
        this.loginSec = loginSec;
    }
    public String getPasswordSec() {
        return this.passwordSec;
    }
    
    public void setPasswordSec(String passwordSec) {
        this.passwordSec = passwordSec;
    }
    public Date getDateNaisSec() {
        return this.dateNaisSec;
    }
    
    public void setDateNaisSec(Date dateNaisSec) {
        this.dateNaisSec = dateNaisSec;
    }
    public String getAdresseSec() {
        return this.adresseSec;
    }
    
    public void setAdresseSec(String adresseSec) {
        this.adresseSec = adresseSec;
    }
    public String getEmailSec() {
        return this.emailSec;
    }
    
    public void setEmailSec(String emailSec) {
        this.emailSec = emailSec;
    }
    public Integer getTelMobSec() {
        return this.telMobSec;
    }
    
    public void setTelMobSec(Integer telMobSec) {
        this.telMobSec = telMobSec;
    }
    public Boolean getEtatSec() {
        return this.etatSec;
    }
    
    public void setEtatSec(Boolean etatSec) {
        this.etatSec = etatSec;
    }




}


