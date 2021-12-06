/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.entities.Patient;
import com.e_medecine.dao.PatientDAO;
import java.util.List;

/**
 *
 * @author mou
 */
public class PatientModel {
    //Cétaion d'un patient
    public void creerPatient(Patient p){
        PatientDAO pd = new PatientDAO();
        pd.creerPatient(p);
    }
    
    //Extraire les patient suivant l'email
    public List<Patient> existPatient(String email){
    PatientDAO pd = new PatientDAO();
    List<Patient> exist = pd.existPatient(email);
    return exist;
    }
    
    //Extraire un patient suivant l'id
    public Patient trouverPatient(int id_pat){
        PatientDAO pd = new PatientDAO();
        Patient pat = pd.trouverPatient(id_pat);
        return pat;
    }
    //Extraire un patient suivant l'email et le mot de passe
    public List<Patient> loginPatient(String email, String pass){
    PatientDAO p = new PatientDAO();
    List<Patient> list = p.loginPatient(email, pass);
    return list;
    }
    //Modifier un patient
    public void modifierPatient(Patient p){
    PatientDAO pd = new PatientDAO();
    pd.modifierPatient(p);
    }
}
