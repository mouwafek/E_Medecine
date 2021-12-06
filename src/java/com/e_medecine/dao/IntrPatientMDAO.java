/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.PatientM;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrPatientMDAO {
    //Ajout
     void ajouterPatientM(PatientM pm);
     //Trouver suivant l'id du patient
    List<PatientM> listerPatientM(int idPat);
}
