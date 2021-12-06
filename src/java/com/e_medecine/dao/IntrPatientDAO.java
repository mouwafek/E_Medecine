/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Allergie;
import com.e_medecine.entities.Patient;
import com.e_medecine.entities.PatientAl;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrPatientDAO {
    //Création du patient
    void creerPatient(Patient p);
    //Trouver patient suivant l'email
    List<Patient> existPatient(String email);
    //Trouver suivant l'id
    Patient trouverPatient(int id_pat);
    //Trouver suivant l'email et le mot de passe
    List<Patient> loginPatient(String email, String pass);
    //modifier 
    void modifierPatient(Patient p);
    
}
