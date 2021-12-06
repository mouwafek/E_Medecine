/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Question;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mou
 */
public class QuestionDAO implements IntrQuestionDAO {

    SessionFactory sf = HibernateUtil.getSessionFactory();
    //Ajout
    @Override
    public void ajouterQuestion(Question q) {
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        ss.save(q);
        t.commit();
        ss.close();
    }
    //Lister suivant l'id patient
    @Override
    public List<Question> listerQuestion(int idPat) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Question where id_pat='" + idPat + "'");
        List<Question> ql = query.list();
        session.close();
        return ql;
    }
    //Modifier
    @Override
    public void modifierQuestion(Question q) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.update(q);
        t.commit();
        session.close();
    }
    //Supprimer
    @Override
    public void deleteQuestion(int id_q) {
        Session session = sf.openSession();
        Question q = (Question) session.get(Question.class, id_q);
        if (q != null) {
            Transaction t = session.beginTransaction();
            session.delete(q);
            t.commit();
        }
        session.close();
    }
    //Trouver suivant l'id
    @Override
    public Question trouverQuestion(int id_q) {
        Session session = sf.openSession();
        Question q = (Question) session.get(Question.class, id_q);
        session.close();
        return q;
    }

    @Override
    public List<Question> listerQuestionCat(String cat) {
         Session session = sf.openSession();
        Query query = session.createQuery("From Question where categorie='" + cat + "'");
        List<Question> ql = query.list();
        session.close();
        return ql;
    }
}
