/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.servlets;

import com.e_medecine.beans.ProfessionnelSanteModel;
import com.e_medecine.entities.ProfessionnelSante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mou
 */
public class LoginDocteur extends HttpServlet {

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
            out.println("<title>Servlet LoginDocteur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginDocteur at " + request.getContextPath() + "</h1>");
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
        String email_prof = request.getParameter("email");
        String pwd = request.getParameter("pass");
        // Recherche du professionnel de santé ayant l'email et mdp entrés
        ProfessionnelSanteModel pm = new ProfessionnelSanteModel();
        List<ProfessionnelSante> list = pm.existProfessionnelSante1(email_prof, pwd);
        
        if (list.isEmpty()/*c-d-r pas de patient avec ces données*/) 
        {
            String message = "Vérifier vos données";
            request.setAttribute("m", message);
            this.getServletContext().getRequestDispatcher("/loginDocteur.jsp").forward(request, response);
        } else {
            ProfessionnelSante prof = new ProfessionnelSante();
            prof = list.get(0);
            HttpSession ss = request.getSession();
            ss.setAttribute("prof", prof);
            this.getServletContext().getRequestDispatcher("/espaceDocteur.jsp").forward(request, response);
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
