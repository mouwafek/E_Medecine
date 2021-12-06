/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.PatientCh;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class PatientChDAO implements IntrPatientChDAO{
    SessionFactory sf =  HibernateUtil.getSessionFactory();
    //  création
    @Override
    public void ajouterPatientCh(PatientCh pc) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(pc);
        t.commit();
        ss.close();
    }
    //Lister suivant l'id patient
    @Override
    public List<PatientCh> listerPatientCh(int idPat) {
        Session session = sf.openSession();
        Query query = session.createQuery("From PatientCh where id_pat='"+idPat+"'");
        List<PatientCh> Pc = query.list();
        session.close();
        return Pc;
    }
}
