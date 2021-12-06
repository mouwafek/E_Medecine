/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.AllergieDAO;
import com.e_medecine.entities.Allergie;
import java.util.List;

/**
 *
 * @author mou
 */
public class AllergieModel {
    //Création d'une allergie 
    public void creerAllergie(Allergie a){
        AllergieDAO ad = new AllergieDAO();
        ad.ajouterAllergie(a);
    }
    //Extraire une allergie suivant l'id entré en paramétre 
    public List<Allergie> listerAllergie(int idal){
    AllergieDAO ad = new AllergieDAO();
    List<Allergie> al = ad.listerAllergie(idal);
    return al;
    }
}
