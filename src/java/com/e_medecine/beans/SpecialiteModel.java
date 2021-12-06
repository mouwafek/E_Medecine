/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.SpecialiteDAO;
import com.e_medecine.entities.Specialite;
import java.util.List;

/**
 *
 * @author mou
 */
public class SpecialiteModel {
    //Création d'une spécialité
    public void creerSpecialite(Specialite s){
        SpecialiteDAO sd = new SpecialiteDAO();
        sd.ajouterSpectialite(s);
    }
    //Lister toutes les specialités
    public List<Specialite> listerSpecialite(){
    SpecialiteDAO sd = new SpecialiteDAO();
    List<Specialite> ls = sd.listerSpecialite();
    return ls;
    }
    //Lister une specialité suivant nom
    public List<Specialite> listerSpecialite1(String nom){
    SpecialiteDAO sd = new SpecialiteDAO();
    List<Specialite> ls = sd.listerSpecialite1(nom);
    return ls;
    }
    //Extraire une specialite suivant l'id
    public Specialite trouverSpecialite(int id_spec){
        SpecialiteDAO sd = new SpecialiteDAO();
        Specialite s = sd.trouverSpecialite(id_spec);
        return s;
    }
}
