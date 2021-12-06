/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.PatientChDAO;
import com.e_medecine.entities.PatientCh;
import java.util.List;

/**
 *
 * @author mou
 */
public class PatientChModel {
    //Création d'un objet de classe association de ant ch
    public void creerPatientCh(PatientCh pc){
        PatientChDAO pd = new PatientChDAO();
        pd.ajouterPatientCh(pc);
    }
    //Lister les associations suivant l'id du patient
     public List<PatientCh> listerPatientCh(int idPat){
    PatientChDAO pd = new PatientChDAO();
    List<PatientCh> pc = pd.listerPatientCh(idPat);
    return pc;
    }
}
