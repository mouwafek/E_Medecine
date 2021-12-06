/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.servlets;

import com.e_medecine.entities.Patient;
import com.e_medecine.beans.PatientModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mou
 */
public class InscriptionPatient extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InscriptionPatient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InscriptionPatient at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Récupération des données
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("email");
        String pass = request.getParameter("password");
        int tel = Integer.parseInt(request.getParameter("tel"));
        String genre = request.getParameter("genre");
        String jour;
        String mois;
        String an;
        String daten = request.getParameter("datenais");
        jour = daten.substring(8, 10);
        mois = daten.substring(5, 7);
        an = daten.substring(0, 4);
        daten = jour + "/" + mois + "/" + an;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datenais = null;
        try {
            datenais = formatter.parse(daten);
        } catch (ParseException ex) {
            Logger.getLogger(InscriptionPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        PatientModel patm = new PatientModel();
        Patient pat = new Patient();
        //Affectation des info au patient
        pat.setNomPat(nom);
        pat.setPrenomPat(prenom);
        pat.setDateNaisPat(datenais);
        pat.setEmailPat(mail);
        pat.setPasswordPat(pass);
        pat.setTelMobPat(tel);
        pat.setGenrePat(genre);
        //éviter la répétition d'inscription avec le meme email
        List existance = patm.existPatient(pat.getEmailPat());
        
        if (existance.isEmpty()){
            patm.creerPatient(pat);
            String succe = "vous êtes inscris avec succé !";
            request.setAttribute("s", succe);
            this.getServletContext().getRequestDispatcher("/loginPatient.jsp").forward(request, response);
        }
        else {
            String message = "Il éxiste déja un patient avec cette adresse email !";
            request.setAttribute("m", message);
            this.getServletContext().getRequestDispatcher("/inscriptionPatient.jsp").forward(request, response);
        } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
