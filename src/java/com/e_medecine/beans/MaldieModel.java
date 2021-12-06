/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.MaladieDAO;
import com.e_medecine.entities.Maladie;
import java.util.List;

/**
 *
 * @author mou
 */
public class MaldieModel {
    //Création d'une maladie
    public void creerMaladie(Maladie m){
        MaladieDAO md = new MaladieDAO();
        md.ajouterMaladie(m);
    }
    //Extraire une maladie suivant l'id
    public List<Maladie> listerMaladie(int ID_M){
    MaladieDAO ad = new MaladieDAO();
    List<Maladie> ml = ad.listerMaladie(ID_M);
    return ml;
    }
}
