/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.CabinetDAO;
import com.e_medecine.entities.Cabinet;
import java.util.List;

/**
 *
 * @author mou
 */
public class CabinetModel {
    //Création d'une cabinet
    public void creerCabinet (Cabinet c){
    CabinetDAO cd = new CabinetDAO();
    cd.creerCabinet(c);
    }
    //  Recherche d'une cabinet suivant le num de telephone
    public List<Cabinet> existeCabinet(int tel){
    CabinetDAO cd = new CabinetDAO();
    List<Cabinet> lc = cd.existeCabinet(tel);
    return lc;
    }
     //  Recherche d'une cabinet suivant l'id du professionnle de santé
    public List<Cabinet> existeCabinet1(int id_prof){
    CabinetDAO cd = new CabinetDAO();
    List<Cabinet> lc = cd.existeCabinet1(id_prof);
    return lc;
    }
}
