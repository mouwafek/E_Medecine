/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.servlets;

import com.e_medecine.beans.AllergieModel;
import com.e_medecine.beans.PatientAlModel;
import com.e_medecine.entities.Allergie;
import com.e_medecine.entities.Patient;
import com.e_medecine.entities.PatientAl;
import com.e_medecine.entities.PatientAlId;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mou
 */
public class AjoutAllergie extends HttpServlet {
       
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
            out.println("<title>Servlet AjoutAllergie</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutAllergie at " + request.getContextPath() + "</h1>");
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
        //Création des variable pour récupérer le jour mois et an
        String jour;
        String mois;
        String an;
        //Récupération du date 
        String dateal = request.getParameter("dateall");
        //Extraction du jour mois et an
        jour = dateal.substring(8, 10);
        mois = dateal.substring(5, 7);
        an = dateal.substring(0, 4);
        //Ordonner la date
        dateal = jour + "/" + mois + "/" + an;
        //Convertion du date du String au type Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateallerg = null;
        Date newdatesys = null;
        try {
            dateallerg = formatter.parse(dateal);
        } catch (ParseException ex) {
            Logger.getLogger(AjoutAllergie.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Récupération de la date du système et convertion en type
        //Date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = new Date();
        String Datesys = format.format(date);
        try {
            newdatesys = formatter.parse(Datesys);
        } catch (ParseException ex) {
            Logger.getLogger(AjoutAllergie.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Récupération du type de réaction
         String type = request.getParameter("typer");
         //Récupération d'état de réaction
        String etat = request.getParameter("etatr");
        //Récupération du produit causant l'allergie
        String prd = request.getParameter("prod");
        //Test sur la date d'allergie : Elle doit etre égale ou avant 
        //la date du système
        /*SI OUI*/
        if(newdatesys.after(dateallerg) || newdatesys.equals(dateallerg)){   
            //Création du model
        AllergieModel am = new AllergieModel();
        //Création d'objet Allergie
        Allergie a = new Allergie();
        //Affectation des champ prod dans les attribut spécifié
        a.setProduitAl(prd);
        //Création d'une allergie
        am.creerAllergie(a);
        //Récupération de l'objet patient dans la session
        HttpSession ss = request.getSession();
        Patient p = (Patient) ss.getAttribute("patient");
        //Création d'un objet contenant les clé primaire du patient
        //et d'allergie
        PatientAlId pid = new PatientAlId();
        pid.setIdPat(p.getIdPat());
        pid.setIdAl(a.getIdAl());
        //Création d'un objet de classe d'assiciation
        PatientAl pl = new PatientAl();
        //Création du model d'association
        PatientAlModel pam = new PatientAlModel();
        //Affectation des champs dans les attribus spécifiés
        pl.setId(pid);
        pl.setDateDAl(dateallerg);
        pl.setTypeReact(type);
        pl.setEtatReact(etat);
        //Création d'une association
        pam.creerPatientAl(pl);
        //Création du message du succée
        String succ = "Allergie ajoutée avec succée";
        request.setAttribute("s", succ);
        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
        }
        /*SI NON*/
        else{
            //On demande de vérifier la date entée
        String erreur = "Vérifier la date de l'allergie !!! ";
        request.setAttribute("e", erreur);
        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
        }
    }   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
