package com.e_medecine.entities;
// Generated 10 avr. 2020 06:38:05 by Hibernate Tools 4.3.1



/**
 * Question generated by hbm2java
 */
public class Question  implements java.io.Serializable {


     private Integer idQ;
     private int idPat;

    public int getIdPat() {
        return idPat;
    }

    public void setIdPat(int idPat) {
        this.idPat = idPat;
    }
     private String categorie;
     private String question;

    public Question() {
    }

    public Question(String categorie, String question) {
       this.categorie = categorie;
       this.question = question;
    }
   
    public Integer getIdQ() {
        return this.idQ;
    }
    
    public void setIdQ(Integer idQ) {
        this.idQ = idQ;
    }
    
    public String getCategorie() {
        return this.categorie;
    }
    
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }




}


