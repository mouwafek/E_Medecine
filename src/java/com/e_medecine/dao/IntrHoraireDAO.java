/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Horaire;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrHoraireDAO {
    //Créer horaire
    void creerHoraire(Horaire h);
    //Lister les horaire d'un professionnle de santé selon l'id du cabinet
    List<Horaire> listerHoraire(int id_cab);
}
