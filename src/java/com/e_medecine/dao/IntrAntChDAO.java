/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.AntecedentChirurgical;
import com.e_medecine.entities.PatientCh;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrAntChDAO {
    //Ajout d'un AntCh
    void ajouterAntCh(AntecedentChirurgical ac);
    //Extraction d'un antCh suivant l'id
    List<AntecedentChirurgical> listerAntCh(int idch);
}
