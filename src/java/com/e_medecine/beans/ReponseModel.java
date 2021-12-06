/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.ReponseDAO;
import com.e_medecine.entities.Reponse;
import java.util.List;

/**
 *
 * @author mou
 */
public class ReponseModel {
    //Création d'une réponse
     public void creerReponse(Reponse r){
        ReponseDAO rd = new ReponseDAO();
        rd.creerReponse(r);
    }
     //Liste des réponse suivant l'id du question
    public List<Reponse> listerReponse(int id_q){
    ReponseDAO rd = new ReponseDAO();
    List<Reponse> rl = rd.listerReponse(id_q);
    return rl;
    }
}
