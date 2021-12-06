/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.beans;

import com.e_medecine.dao.ProfessionnelSanteDAO;
import com.e_medecine.entities.ProfessionnelSante;
import java.util.List;

/**
 *
 * @author mou
 */
public class ProfessionnelSanteModel {
    //Modifier un professionnel de santé
    public void modifierPs(ProfessionnelSante ps){
    ProfessionnelSanteDAO psd = new ProfessionnelSanteDAO();
    psd.modifierPs(ps);
    }
    //Créer un prof de de santé
    public void creerPs(ProfessionnelSante ps){
    ProfessionnelSanteDAO psd = new ProfessionnelSanteDAO();
    psd.creerPs(ps);
    }
    //Extraire le professionnel de santé suivant l'id
    public List<ProfessionnelSante> listerPs(int ID_PROF){
    ProfessionnelSanteDAO psd = new ProfessionnelSanteDAO();
    List<ProfessionnelSante> listps = psd.listerPs(ID_PROF);
    return listps;
    }
    //Lister tous les professionnels de santé 
    public List<ProfessionnelSante> listerPs2(){
    ProfessionnelSanteDAO psd = new ProfessionnelSanteDAO();
    List<ProfessionnelSante> listps = psd.listerPs2();
    return listps;
    }
    //Extraire le professsionnel de santé selon l'email
    public List<ProfessionnelSante> existProfessionnelSante(String email){
    ProfessionnelSanteDAO pd = new ProfessionnelSanteDAO();
    List<ProfessionnelSante> exist = pd.existProfessionnelSante(email);
    return exist;
    }
    //Extraire un professionnel de santé suivant l'email et le mot de passe
    public List<ProfessionnelSante> existProfessionnelSante1(String email, String pass){
    ProfessionnelSanteDAO pd = new ProfessionnelSanteDAO();
    List<ProfessionnelSante> list = pd.existProfessionnelSante1(email, pass);
    return list;
    }
}
