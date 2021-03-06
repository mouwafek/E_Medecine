package com.e_medecine.entities;
// Generated 10 avr. 2020 06:38:05 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * PatientAl generated by hbm2java
 */
public class PatientAl  implements java.io.Serializable {


     private PatientAlId id;
     private Date dateDAl;
     private String typeReact;
     private String etatReact;

    public PatientAl() {
    }

	
    public PatientAl(PatientAlId id) {
        this.id = id;
    }
    public PatientAl(PatientAlId id, Date dateDAl, String typeReact, String etatReact) {
       this.id = id;
       this.dateDAl = dateDAl;
       this.typeReact = typeReact;
       this.etatReact = etatReact;
    }
   
    public PatientAlId getId() {
        return this.id;
    }
    
    public void setId(PatientAlId id) {
        this.id = id;
    }
    public Date getDateDAl() {
        return this.dateDAl;
    }
    
    public void setDateDAl(Date dateDAl) {
        this.dateDAl = dateDAl;
    }
    public String getTypeReact() {
        return this.typeReact;
    }
    
    public void setTypeReact(String typeReact) {
        this.typeReact = typeReact;
    }
    public String getEtatReact() {
        return this.etatReact;
    }
    
    public void setEtatReact(String etatReact) {
        this.etatReact = etatReact;
    }




}


