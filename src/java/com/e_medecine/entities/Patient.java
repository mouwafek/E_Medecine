package com.e_medecine.entities;
// Generated 10 avr. 2020 06:38:05 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Patient generated by hbm2java
 */
public class Patient  implements java.io.Serializable {


     private Integer idPat;
     private int idAv;
     private String nomPat;
     private String prenomPat;
     private String loginPat;
     private String passwordPat;
     private Date dateNaisPat;
     private String adressePat;
     private String emailPat;
     private Integer telMobPat;
     private Integer age;
     private String genrePat;
     private Integer poid;
     private String groupeSanguin;
     private String travail;

    public Patient() {
    }

	
    public Patient(int idAv) {
        this.idAv = idAv;
    }
    public Patient(int idAv, String nomPat, String prenomPat, String loginPat, String passwordPat, Date dateNaisPat, String adressePat, String emailPat, Integer telMobPat, Integer age, String genrePat, Integer poid, String groupeSanguin, String travail) {
       this.idAv = idAv;
       this.nomPat = nomPat;
       this.prenomPat = prenomPat;
       this.loginPat = loginPat;
       this.passwordPat = passwordPat;
       this.dateNaisPat = dateNaisPat;
       this.adressePat = adressePat;
       this.emailPat = emailPat;
       this.telMobPat = telMobPat;
       this.age = age;
       this.genrePat = genrePat;
       this.poid = poid;
       this.groupeSanguin = groupeSanguin;
       this.travail = travail;
    }
   
    public Integer getIdPat() {
        return this.idPat;
    }
    
    public void setIdPat(Integer idPat) {
        this.idPat = idPat;
    }
    public int getIdAv() {
        return this.idAv;
    }
    
    public void setIdAv(int idAv) {
        this.idAv = idAv;
    }
    
    public String getNomPat() {
        return this.nomPat;
    }
    
    public void setNomPat(String nomPat) {
        this.nomPat = nomPat;
    }
    public String getPrenomPat() {
        return this.prenomPat;
    }
    
    public void setPrenomPat(String prenomPat) {
        this.prenomPat = prenomPat;
    }
    public String getLoginPat() {
        return this.loginPat;
    }
    
    public void setLoginPat(String loginPat) {
        this.loginPat = loginPat;
    }
    public String getPasswordPat() {
        return this.passwordPat;
    }
    
    public void setPasswordPat(String passwordPat) {
        this.passwordPat = passwordPat;
    }
    public Date getDateNaisPat() {
        return this.dateNaisPat;
    }
    
    public void setDateNaisPat(Date dateNaisPat) {
        this.dateNaisPat = dateNaisPat;
    }
    public String getAdressePat() {
        return this.adressePat;
    }
    
    public void setAdressePat(String adressePat) {
        this.adressePat = adressePat;
    }
    public String getEmailPat() {
        return this.emailPat;
    }
    
    public void setEmailPat(String emailPat) {
        this.emailPat = emailPat;
    }
    public Integer getTelMobPat() {
        return this.telMobPat;
    }
    
    public void setTelMobPat(Integer telMobPat) {
        this.telMobPat = telMobPat;
    }
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getGenrePat() {
        return this.genrePat;
    }
    
    public void setGenrePat(String genrePat) {
        this.genrePat = genrePat;
    }
    public Integer getPoid() {
        return this.poid;
    }
    
    public void setPoid(Integer poid) {
        this.poid = poid;
    }
    public String getGroupeSanguin() {
        return this.groupeSanguin;
    }
    
    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }
    public String getTravail() {
        return this.travail;
    }
    
    public void setTravail(String travail) {
        this.travail = travail;
    }




}


