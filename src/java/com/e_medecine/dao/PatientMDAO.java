/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.PatientM;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class PatientMDAO implements IntrPatientMDAO{
    SessionFactory sf =  HibernateUtil.getSessionFactory();
    //Ajout
    @Override
    public void ajouterPatientM(PatientM pm) {
    Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(pm);
        t.commit();
        ss.close();
    }
    //Lister suivant l'id patient
    @Override
    public List<PatientM> listerPatientM(int idPat) {
        Session session = sf.openSession();
        Query query = session.createQuery("From PatientM where id_pat='"+idPat+"'");
        List<PatientM> pm = query.list();
        session.close();
        return pm;    
    }
}
