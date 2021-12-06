/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Cabinet;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class CabinetDAO implements IntrCabinetDAO{
    SessionFactory sf =  HibernateUtil.getSessionFactory();
    //Création d'une cabinet
    @Override
    public void creerCabinet(Cabinet c) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(c);
        t.commit();
        ss.close();
    }
//  Recherche d'une cabinet suivant le num de telephone
    @Override
    public List<Cabinet> existeCabinet(int tel) {
        Session ss = sf.openSession();
    Query q = ss.createQuery("From Cabinet where tel_fixe='"+tel+"'");
    List<Cabinet> exist = q.list();
    ss.close();
    return exist;
    }

    @Override
    public List<Cabinet> existeCabinet1(int ID_PROF) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Cabinet where ID_PROF='"+ID_PROF+"'");
        List<Cabinet> lc = query.list();
        session.close();
        return lc;
    }
    
}
