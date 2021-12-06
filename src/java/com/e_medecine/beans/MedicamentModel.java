/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.MedicamentDAO;
import com.e_medecine.entities.Medicament;
import java.util.List;

/**
 *
 * @author mou
 */
public class MedicamentModel {
    //Donner la liste des médicament déposés suivant l'id 
    //du patient
    public List<Medicament> listerMedicament(int idPat){
    MedicamentDAO qd = new MedicamentDAO();
    List<Medicament> ml = qd.listerMedicament(idPat);
    return ml;
    }
    //Extraire un seul médicament suivant l'id du patient
    // le nom et la forme pharmaceutique
    public List<Medicament> listerMedicament2(int idPat, String nom, String forme){
    MedicamentDAO qd = new MedicamentDAO();
    List<Medicament> ml = qd.listerMedicament2(idPat,nom,forme);
    return ml;
    }
    //Modifier un médicament
     public void modiferMedicament(Medicament m){
    MedicamentDAO qd = new MedicamentDAO();
    qd.modifierMedicament(m);
    }
     //Supprimer un médicament suivant l'id
    public void supprimerMedicament(int id_med){
    MedicamentDAO md = new MedicamentDAO();
    md.deleteMedicament(id_med);
    }
    //Extraire un médicament suivant l'id
    public Medicament trouverMedicament(int id_med){
     MedicamentDAO md = new MedicamentDAO();
     return md.trouverMedicament(id_med);
     }
}
