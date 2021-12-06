/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.dao;

import com.e_medecine.entities.Medicament;
import java.util.List;

/**
 *
 * @author mou
 */
public interface IntrMedicamentDAO {
    //Lister les médicaments suivant l'id du patient
    List<Medicament> listerMedicament(int idPat);
    //Extraire le médicament suivant des paramètres nom  id patient et forme
    List<Medicament> listerMedicament2(int idPat,String nom, String forme);
    //Modifier médcament 
    void modifierMedicament(Medicament m);
    //Supprimer médicament
    void deleteMedicament(int id);
    //Trouver médicament suivant l'id
    Medicament trouverMedicament(int id_med);
}
