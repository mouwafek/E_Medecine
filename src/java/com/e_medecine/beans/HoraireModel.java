/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.HoraireDAO;
import com.e_medecine.entities.Horaire;
import java.util.List;

/**
 *
 * @author mou
 */
public class HoraireModel {
    //Création horaire
    public void creerHoraire(Horaire h){
    HoraireDAO hd = new HoraireDAO();
    hd.creerHoraire(h);
    }
    //  Recherche d'une cabinet suivant l'id du professionnle de santé
    public List<Horaire> listeHoraire(int id_cab){
    HoraireDAO hd = new HoraireDAO();
    List<Horaire> lh = hd.listerHoraire(id_cab);
    return lh;
    }
}
