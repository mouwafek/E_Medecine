/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Allergie;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrAllergieDAO {
    //Ajout d'allergie
     void ajouterAllergie(Allergie a);
     //Trouver allergie suivant l'id
     List<Allergie> listerAllergie(int idal);
}
