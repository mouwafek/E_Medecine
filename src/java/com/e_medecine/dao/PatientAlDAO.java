/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.PatientAl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class PatientAlDAO implements IntrPatientAlDAO{
   SessionFactory sf =  HibernateUtil.getSessionFactory();
   //Ajout
    @Override
    public void ajouterPatientAl(PatientAl pl) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(pl);
        t.commit();
        ss.close();
    }
    //Trouver suivant du patient
    @Override
    public List<PatientAl> listerPatientAl(int idPat) {
        Session session = sf.openSession();
        Query query = session.createQuery("From PatientAl where id_pat='"+idPat+"'");
        List<PatientAl> Pl = query.list();
        session.close();
        return Pl;
    }
    
}
