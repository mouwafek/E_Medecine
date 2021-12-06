/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Maladie;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class MaladieDAO implements IntrMaladieDAO{
 SessionFactory sf =  HibernateUtil.getSessionFactory();
 //Ajouter malaldie
    @Override
    public void ajouterMaladie(Maladie m) {
    Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(m);
        t.commit();
        ss.close();
    }
    //Trouver suivant l'id
    @Override
    public List<Maladie> listerMaladie(int ID_M) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Maladie where ID_M='"+ID_M+"'");
        List<Maladie> maladie = query.list();
        session.close();
        return maladie;    
    }   
}
