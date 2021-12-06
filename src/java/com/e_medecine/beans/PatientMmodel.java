/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.PatientMDAO;
import com.e_medecine.entities.PatientM;
import java.util.List;

/**
 *
 * @author mou
 */
public class PatientMmodel {
    //Creationd d'une maladie
    public void creerPatientM(PatientM pm){
        PatientMDAO pmd = new PatientMDAO();
        pmd.ajouterPatientM(pm);
    }
    //Liste des maladies suivant l'id du patient
    public List<PatientM> listerPatientM(int idPat){
    PatientMDAO pmd = new PatientMDAO();
    List<PatientM> pml = pmd.listerPatientM(idPat);
    return pml;
    }
}
