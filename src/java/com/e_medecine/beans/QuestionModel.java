/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.QuestionDAO;
import com.e_medecine.entities.Question;
import java.util.List;

/**
 *
 * @author mou
 */
public class QuestionModel {
    //Création d'un question
    public void creerQuestion(Question q){
        QuestionDAO qd = new QuestionDAO();
        qd.ajouterQuestion(q);
    }
    //Suppression d'un question
    public void supprimerQuestion(int id_q){
    QuestionDAO qd = new QuestionDAO();
    qd.deleteQuestion(id_q);
    }
    //Modification d'un question
    public void modiferQuestion(Question q){
    QuestionDAO qd = new QuestionDAO();
    qd.modifierQuestion(q);
    }
    //Extraire la liste des questions suivant l'id du patient
     public List<Question> listerQuestion(int idPat){
    QuestionDAO qd = new QuestionDAO();
    List<Question> ql = qd.listerQuestion(idPat);
    return ql;
    }
      //Extraire la liste des questions suivant l'id du patient
     public List<Question> listerQuestionCat(String cat){
    QuestionDAO qd = new QuestionDAO();
    List<Question> ql = qd.listerQuestionCat(cat);
    return ql;
    }
     //Trouver un question suivant l'id
     public Question trouverQuestion(int id_q){
     QuestionDAO qd = new QuestionDAO();
     return qd.trouverQuestion(id_q);
     }
}
