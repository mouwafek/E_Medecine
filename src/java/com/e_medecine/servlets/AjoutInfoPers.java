/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.servlets;

import com.e_medecine.beans.PatientModel;
import com.e_medecine.entities.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mou
 */
public class AjoutInfoPers extends HttpServlet {

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
            out.println("<title>Servlet AjoutInfoPers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutInfoPers at " + request.getContextPath() + "</h1>");
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
        //Récupération du poid et taille, groupe sanguin et travaille
        int poid = Integer.parseInt(request.getParameter("poid"));
        int taille = Integer.parseInt(request.getParameter("taille"));
        String gs = request.getParameter("GS");
        String tr = request.getParameter("trav");
        //Récupération du patient dans la session
        HttpSession ss = request.getSession();
        Patient p = (Patient) ss.getAttribute("patient");
        //Création d'un patient model
        PatientModel pm = new PatientModel();
        //Si le patient n'a pas soécifier le groupe sanguin avant
        if (p.getGroupeSanguin() == null) {
            p.setPoid(poid);
            p.setAge(taille);
            //S'il a choisit un gs du formulaire
            if (!gs.equals("Choisir")) {
                //On affecte la valeur dans champ convenable
                p.setGroupeSanguin(gs);
            }
            //Affectation du travail
            p.setTravail(tr);
            //Appel à la méthode modifier
            pm.modifierPatient(p);
            //Message de succée
            String suc = "Vos information sont mises à jour avec succée ! ";
            request.setAttribute("sinf", suc);
            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
        } 
        //Si le patient a spécifier le groupe sanguin avant
        else if (p.getGroupeSanguin() != null) {
            //Et il n'a pas l'entrer de nouveau
            if (gs.equals("Choisir")) {
                //On ajoute les nouvelles valeurs
                p.setPoid(poid);
                p.setAge(taille);
                p.setTravail(tr);
                //Appel à la Mth modifier
                pm.modifierPatient(p);
                //Message de succée
                String suc = "Vos information sont mises à jour avec succée ! ";
                request.setAttribute("sinf", suc);
                this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
            }
            //S'il entre de nouveau son groupe sanguin
            else {
                //On fait la modification à l'exeption du groupe sanguin
                p.setPoid(poid);
                p.setAge(taille);
                p.setTravail(tr);
                pm.modifierPatient(p);
                String err = "Informations modifiées avec succée !<br> <p style='margin:auto;text-align:center;Background-color: red;'>Attention , vous avez déja spécifier votre groupe sanguin !"
                        + "qui est : " + p.getGroupeSanguin() + "</p>";
                request.setAttribute("erinf", err);
                this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
            }

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
