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
        //Cr??ation des variable pour r??cup??rer le jour mois et an
        String jour;
        String mois;
        String an;
        //R??cup??ration du date 
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
        //R??cup??ration de la date du syst??me et convertion en type
        //Date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = new Date();
        String Datesys = format.format(date);
        try {
            newdatesys = formatter.parse(Datesys);
        } catch (ParseException ex) {
            Logger.getLogger(AjoutAllergie.class.getName()).log(Level.SEVERE, null, ex);
        }
        //R??cup??ration du type de r??action
         String type = request.getParameter("typer");
         //R??cup??ration d'??tat de r??action
        String etat = request.getParameter("etatr");
        //R??cup??ration du produit causant l'allergie
        String prd = request.getParameter("prod");
        //Test sur la date d'allergie : Elle doit etre ??gale ou avant 
        //la date du syst??me
        /*SI OUI*/
        if(newdatesys.after(dateallerg) || newdatesys.equals(dateallerg)){   
            //Cr??ation du model
        AllergieModel am = new AllergieModel();
        //Cr??ation d'objet Allergie
        Allergie a = new Allergie();
        //Affectation des champ prod dans les attribut sp??cifi??
        a.setProduitAl(prd);
        //Cr??ation d'une allergie
        am.creerAllergie(a);
        //R??cup??ration de l'objet patient dans la session
        HttpSession ss = request.getSession();
        Patient p = (Patient) ss.getAttribute("patient");
        //Cr??ation d'un objet contenant les cl?? primaire du patient
        //et d'allergie
        PatientAlId pid = new PatientAlId();
        pid.setIdPat(p.getIdPat());
        pid.setIdAl(a.getIdAl());
        //Cr??ation d'un objet de classe d'assiciation
        PatientAl pl = new PatientAl();
        //Cr??ation du model d'association
        PatientAlModel pam = new PatientAlModel();
        //Affectation des champs dans les attribus sp??cifi??s
        pl.setId(pid);
        pl.setDateDAl(dateallerg);
        pl.setTypeReact(type);
        pl.setEtatReact(etat);
        //Cr??ation d'une association
        pam.creerPatientAl(pl);
        //Cr??ation du message du succ??e
        String succ = "Allergie ajout??e avec succ??e";
        request.setAttribute("s", succ);
        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
        }
        /*SI NON*/
        else{
            //On demande de v??rifier la date ent??e
        String erreur = "V??rifier la date de l'allergie !!! ";
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
