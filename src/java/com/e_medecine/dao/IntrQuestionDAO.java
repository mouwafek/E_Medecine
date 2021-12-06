/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Question;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrQuestionDAO {
    //Ajouter
    void ajouterQuestion(Question p);
    //Lister suivant l'id du patient
    List<Question> listerQuestion(int idPat);
    //Lister suivant catégorie
    List<Question> listerQuestionCat(String cat);
    //Modifier
    void modifierQuestion(Question q);
    //Supprimer
    void deleteQuestion(int id);
    //Trouver suivant l'id
    Question trouverQuestion(int id_q);
}
