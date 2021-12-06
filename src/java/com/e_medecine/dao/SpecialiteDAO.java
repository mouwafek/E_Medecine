/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Specialite;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class SpecialiteDAO implements IntrSpecialiteDAO{
    SessionFactory sf = HibernateUtil.getSessionFactory();
    //Ajout spécialité
    @Override
    public void ajouterSpectialite(Specialite s) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(s);
        t.commit();
        ss.close();  
    }
    //Lister spécialités
    @Override
    public List<Specialite> listerSpecialite() {
        Session ss = sf.openSession();
        Query query = ss.createQuery("From Specialite");
        List<Specialite> ls = query.list();
        ss.close();
        return ls;
    }

    @Override
    public List<Specialite> listerSpecialite1(String nom) {
        Session ss = sf.openSession();
        Query query = ss.createQuery("From Specialite where nom_spec='"+nom+"'");
        List<Specialite> ls = (List<Specialite>) query.list();
        ss.close();
        return ls;
    }

    @Override
    public Specialite trouverSpecialite(int id_spec) {
        Session session = sf.openSession();
        Specialite s = (Specialite) session.get(Specialite.class, id_spec);
         session.close();
         return s;
    }
    
}
