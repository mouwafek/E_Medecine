/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.PatientAlDAO;
import com.e_medecine.entities.PatientAl;
import java.util.List;

/**
 *
 * @author mou
 */
public class PatientAlModel {
    //Création d'un objet de classe association d'allergie
     public void creerPatientAl(PatientAl pl){
        PatientAlDAO pd = new PatientAlDAO();
        pd.ajouterPatientAl(pl);
    }
     //Lister les associations suivant l'id du patient
     public List<PatientAl> listerPatientAl(int idPat){
    PatientAlDAO pd = new PatientAlDAO();
    List<PatientAl> pl = pd.listerPatientAl(idPat);
    return pl;
    }
}
