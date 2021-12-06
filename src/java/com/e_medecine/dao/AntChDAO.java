/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.AntecedentChirurgical;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class AntChDAO implements IntrAntChDAO{
    SessionFactory sf =  HibernateUtil.getSessionFactory();
    //Création d'un antécédent ch
    @Override
    public void ajouterAntCh(AntecedentChirurgical ac) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(ac);
        t.commit();
        ss.close();
    }
 //Extraire l'ant Ch selon l'id entré en paramètes
    @Override
    public List<AntecedentChirurgical> listerAntCh(int idch) {
        Session session = sf.openSession();
        Query query = session.createQuery("From AntecedentChirurgical where id_ch='"+idch+"'");
        List<AntecedentChirurgical> ac = query.list();
        session.close();
        return ac;
    }
    
}
