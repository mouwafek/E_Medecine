/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.AntChDAO;
import com.e_medecine.entities.AntecedentChirurgical;
import java.util.List;

/**
 *
 * @author mou
 */
public class AntChModel {
    //Création d'un antécédent ch
    public void creerAntCh(AntecedentChirurgical ac){
        AntChDAO ad = new AntChDAO();
        ad.ajouterAntCh(ac);
    }
    //Extraire l'ant Ch selon l'id entré en paramètes
    public List<AntecedentChirurgical> listerAntCh(int idch){
    AntChDAO ad = new AntChDAO();
    List<AntecedentChirurgical> ac = ad.listerAntCh(idch);
    return ac;
    }
}
