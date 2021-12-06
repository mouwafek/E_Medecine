/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Reponse;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class ReponseDAO implements IntrReponseDAO{
    SessionFactory sf =  HibernateUtil.getSessionFactory();
    //Lister suivant l'id question
    @Override
    public List<Reponse> listerReponse(int id_q) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Reponse where id_q='"+id_q+"'");
        List<Reponse> Reponse = query.list();
        session.close();
        return Reponse;     
    }
    //Ajout réponse
    @Override
    public void creerReponse(Reponse r) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(r);
        t.commit();
        ss.close();    
    }
    
}
