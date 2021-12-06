/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Medicament;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class MedicamentDAO implements IntrMedicamentDAO{
       SessionFactory sf =  HibernateUtil.getSessionFactory();
    //Liste des médicaments
   public List<Medicament> listerMed() {
        Session session = sf.openSession();
        Query query = session.createQuery("From Medicament");
        List<Medicament> m = query.list();
        session.close();
        return m;
   }
   //Trouver un médicament suivant l'id patient le nom et la forme
   @Override
    public List<Medicament> listerMedicament2(int idPat, String nom, String forme) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Medicament where id_pat='"+idPat+"' and nom_med='"+nom+"' and forme_med='"+forme+"'");
        List<Medicament> ml = query.list();
        session.close();
        return ml;
    }
    //Liste des médicaments suivant l'id patient
    @Override
    public List<Medicament> listerMedicament(int idPat) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Medicament where id_pat='"+idPat+"'");
        List<Medicament> ml = query.list();
        session.close();
        return ml;
    }
    //Modifier med
    @Override
    public void modifierMedicament(Medicament m) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.update(m);
        t.commit();
        session.close(); 
    }
    //Suppression
    @Override
    public void deleteMedicament(int id_med) {
        Session session  = sf.openSession();
        Medicament m  = (Medicament) session.get(Medicament.class, id_med);
        if(m!=null){
        Transaction t = session.beginTransaction();
        session.delete(m);
        t.commit();
        }
    }
    //Trouver selon l'id
    @Override
    public Medicament trouverMedicament(int id_med) {
         Session session = sf.openSession();
        Medicament m = (Medicament) session.get(Medicament.class, id_med);
         session.close();
         return m;
    }

}
