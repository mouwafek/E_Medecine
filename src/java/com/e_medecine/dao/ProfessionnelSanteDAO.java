/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.ProfessionnelSante;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class ProfessionnelSanteDAO implements IntrProfessionnelSanteDAO {

    SessionFactory sf = HibernateUtil.getSessionFactory();
    //Création
    @Override
    public void creerPs(ProfessionnelSante ps) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(ps);
        t.commit();
        ss.close();
    }
    //Modifier
    @Override
    public void modifierPs(ProfessionnelSante ps) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.update(ps);
        t.commit();
        session.close();
    }
    //Trouver suivant l'id
    @Override
    public List<ProfessionnelSante> listerPs(int ID_PROF) {
        Session session = sf.openSession();
        Query query = session.createQuery("From ProfessionnelSante where ID_PROF ='" + ID_PROF + "'");
        List<ProfessionnelSante> ps = query.list();
        session.close();
        return ps;
    }
    //Lister tous
    @Override
    public List<ProfessionnelSante> listerPs2() {
        Session session = sf.openSession();
        Query query = session.createQuery("From ProfessionnelSante");
        List<ProfessionnelSante> ps = query.list();
        session.close();
        return ps;
    }
        //Trouver suivant email
    @Override
    public List<ProfessionnelSante> existProfessionnelSante(String email) {
        Session ss = sf.openSession();
        Query q = ss.createQuery("From ProfessionnelSante where email_prof='" + email + "'");
        List<ProfessionnelSante> exist = q.list();
        ss.close();
        return exist;
    }

    @Override
    public List<ProfessionnelSante> existProfessionnelSante1(String email, String pwd) {
         Session session = sf.openSession();
        Query query = session.createQuery("From ProfessionnelSante where email_prof='"+email+"' and password_prof='"+pwd+"'");
        List<ProfessionnelSante> ProfessionnelSante = query.list();
        session.close();
        return ProfessionnelSante;
    }
}
