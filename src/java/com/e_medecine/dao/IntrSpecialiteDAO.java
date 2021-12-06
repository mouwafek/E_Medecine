/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Specialite;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrSpecialiteDAO {
    //Ajout
    void ajouterSpectialite(Specialite s);
    //Lister les spécilités
    List<Specialite> listerSpecialite();
    //Donner la spec suivant nom
    List<Specialite> listerSpecialite1(String nom);
    //Donner la spec suivant id
    Specialite trouverSpecialite(int id_spec);
}
