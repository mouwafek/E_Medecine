/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Reponse;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrReponseDAO {
    //Lister suivant l'id du question
    public List<Reponse> listerReponse(int id_q);
    //Ajout
    void creerReponse(Reponse r);
}
