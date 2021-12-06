/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Cabinet;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrCabinetDAO {
    //Création du cabinet
    void creerCabinet (Cabinet c);
    //Trouver cabinet suivant tel
    List<Cabinet> existeCabinet(int tel);
    //Trouver cabinet suivant id du professionnel
    List<Cabinet> existeCabinet1(int ID_PROF);
}
