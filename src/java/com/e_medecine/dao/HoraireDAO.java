/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Horaire;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class HoraireDAO implements IntrHoraireDAO{
    SessionFactory sf = HibernateUtil.getSessionFactory();
    //Création horaire
    @Override
    public void creerHoraire(Horaire h) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(h);
        t.commit();
        ss.close();
    }

    @Override
    public List<Horaire> listerHoraire(int id_cab) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Horaire where id_cab='"+id_cab+"'");
        List<Horaire> lh = query.list();
        session.close();
        return lh;
    }
    
}
