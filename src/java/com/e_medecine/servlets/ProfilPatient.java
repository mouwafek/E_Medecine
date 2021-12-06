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
public class ProfilPatient extends HttpServlet {

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
            out.println("<title>Servlet ProfilPatient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfilPatient at " + request.getContextPath() + "</h1>");
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
        String mail = request.getParameter("mail");
        String npwd = request.getParameter("pwd");
        String adrs = request.getParameter("adrs");
        String apwd = request.getParameter("pwdact");
        HttpSession ss = request.getSession();
        PatientModel pm = new PatientModel();
        Patient p = (Patient) ss.getAttribute("patient");
        List test = pm.loginPatient(p.getEmailPat(), apwd);
        
        if(test.isEmpty()){
        String message = "Mot de passe incorretce !";
        request.setAttribute("m", message);
        this.getServletContext().getRequestDispatcher("/profilPatient.jsp").forward(request, response);
        }
        else{
            if(!mail.isEmpty()){
            p.setEmailPat(mail);
            }
            if(!npwd.isEmpty()){
            p.setPasswordPat(npwd);
            }
            if(!adrs.isEmpty()){
            p.setAdressePat(adrs);
            }
            pm.modifierPatient(p);
            String message = "Données changées avec succée !";
            request.setAttribute("m", message);
            this.getServletContext().getRequestDispatcher("/profilPatient.jsp").forward(request, response);
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
