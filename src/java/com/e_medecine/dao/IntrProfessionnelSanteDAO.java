/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.ProfessionnelSante;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrProfessionnelSanteDAO {
    //Modifier 
    public void modifierPs(ProfessionnelSante ps);
    //Ajout 
    public void creerPs(ProfessionnelSante ps);
    //Trouver suivant email
    List<ProfessionnelSante> existProfessionnelSante(String email);
    //Trouver suivant email et mot de passe
    List<ProfessionnelSante> existProfessionnelSante1(String email , String pwd);
    //Trouver suivant id
    public List<ProfessionnelSante> listerPs(int ID_PROF);
    //Lister tous
    public List<ProfessionnelSante> listerPs2();
}
