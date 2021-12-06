/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Allergie;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class AllergieDAO implements IntrAllergieDAO{
    SessionFactory sf =  HibernateUtil.getSessionFactory();
    //Ajout d'une allergie à la base
    @Override
    public void ajouterAllergie(Allergie a) {
    Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(a);
        t.commit();
        ss.close();
    }
        //Extraire une allergie suivant l'id entré en paramétre 
    @Override
    public List<Allergie> listerAllergie(int idal) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Allergie where id_al='"+idal+"'");
        List<Allergie> allergie = query.list();
        session.close();
        return allergie;    
    }

}
