/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.PatientCh;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrPatientChDAO {
    //Ajout 
     void ajouterPatientCh(PatientCh pc);
     //Trouver suivant l'id du patient
    List<PatientCh> listerPatientCh(int idPat);
}
