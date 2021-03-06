/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.servlets;

import com.e_medecine.beans.AntChModel;
import com.e_medecine.beans.PatientChModel;
import com.e_medecine.entities.AntecedentChirurgical;
import com.e_medecine.entities.Patient;
import com.e_medecine.entities.PatientCh;
import com.e_medecine.entities.PatientChId;
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
public class AjoutAntCh extends HttpServlet {

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
            out.println("<title>Servlet AjoutAntCh</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutAntCh at " + request.getContextPath() + "</h1>");
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
        String dateop = request.getParameter("dateop");
        //Extraction du jour mois et an
        jour = dateop.substring(8, 10);
        mois = dateop.substring(5, 7);
        an = dateop.substring(0, 4);
        //Ordonner la date
        dateop = jour + "/" + mois + "/" + an;
        //Convertion du date du String au type Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateoperation = null;
        Date datesys = null;
        try {
            dateoperation = formatter.parse(dateop);
        } catch (ParseException ex) {
            Logger.getLogger(AjoutAntCh.class.getName()).log(Level.SEVERE, null, ex);
        }
        //R??cup??ration de la date du syst??me et convertion en type
        //Date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String Datesys = format.format(date);
        try {
            datesys = formatter.parse(Datesys);
        } catch (ParseException ex) {
            Logger.getLogger(AjoutAllergie.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Test sur la date d'allergie : Elle doit etre ??gale ou avant 
        //la date du syst??me
        /*SI OUI*/
        if (datesys.after(dateoperation) || datesys.equals(dateoperation)) {
            //R??cup??ration du nom d'op
            String nom = request.getParameter("nom");
            //Raison
            String rais = request.getParameter("raison");
            //Nom d'hopital
            String hop = request.getParameter("hop");
            //Cr??ation du model AntCh
            AntChModel acm = new AntChModel();
            //Cr??ation d'objet AntCh
            AntecedentChirurgical ac = new AntecedentChirurgical();
            //Ajouter le nom
            ac.setNomOp(nom);
            //Cr??ation d'un AntCh
            acm.creerAntCh(ac);
            //R??cup??ration de l'objet patient dans la session
            HttpSession ss = request.getSession();
            Patient p = (Patient) ss.getAttribute("patient");
            //Cr??ation d'un objet contenant les cl?? primaire du patient
             //et d'AntCh
            PatientChId pcid = new PatientChId();
            pcid.setIdPat(p.getIdPat());
            pcid.setIdCh(ac.getIdCh());
            //Cr??ation d'un objet de classe d'assiciation
            PatientCh pc = new PatientCh();
            //Cr??ation du model d'association
            PatientChModel pcm = new PatientChModel();
            //Affectation des champs dans les attribus sp??cifi??s
            pc.setId(pcid);
            pc.setDateOp(dateoperation);
            pc.setRaison(rais);
            pc.setLocal(hop);
            //Cr??ation d'une association
            pcm.creerPatientCh(pc);
            //Cr??ation du message de succ??e
            String succ = "Donn??es ajout??es avec succ??e";
            request.setAttribute("sch", succ);
            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
        } 
        /*SI NON*/
        else {
            String erreur = "V??rifier la date de l'op??ration !!! ";
            request.setAttribute("ech", erreur);
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
