/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.PatientAl;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrPatientAlDAO {
    //Ajout
    void ajouterPatientAl(PatientAl pl);
    //trouver suivant l'id du patient
    List<PatientAl> listerPatientAl(int idPat);
}
