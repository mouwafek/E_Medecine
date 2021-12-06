/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Patient;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class PatientDAO implements IntrPatientDAO{
    
    SessionFactory sf = HibernateUtil.getSessionFactory();
    //Création
    @Override
    public void creerPatient(Patient p) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(p);
        t.commit();
        ss.close();
    }
    
    @Override
    // Vérifie si cette adrs email existe dans la base ou non
    public List<Patient> existPatient(String email){
    Session ss = sf.openSession();
    Query q = ss.createQuery("From Patient where email_pat='"+email+"'");
    List<Patient> exist = q.list();
    ss.close();
    return exist;
    }
    // Recherche du patient ayant l'email et mdp entrés
    @Override
    public List<Patient> loginPatient(String email, String pass) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Patient where email_pat='"+email+"' and password_pat='"+pass+"'");
        List<Patient> patient = query.list();
        session.close();
        return patient;
    }
    //Trouver un patient selon l'id
    @Override
    public Patient trouverPatient(int id_pat) {
        Session session = sf.openSession();
        Patient pat = (Patient) session.get(Patient.class, id_pat);
         session.close();
         return pat;
    }
    //Modifier patient
    @Override
    public void modifierPatient(Patient p) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.update(p);
        t.commit();
        session.close();
    }
}
