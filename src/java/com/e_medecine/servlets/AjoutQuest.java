/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.servlets;

import com.e_medecine.beans.PatientModel;
import com.e_medecine.beans.QuestionModel;
import com.e_medecine.entities.Patient;
import com.e_medecine.entities.Question;
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
public class AjoutQuest extends HttpServlet {

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
            out.println("<title>Servlet AjoutQuest</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutQuest at " + request.getContextPath() + "</h1>");
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
        QuestionModel qm = new QuestionModel();
        HttpSession ss = request.getSession();
        Patient p = (Patient) ss.getAttribute("patient");
        String cat = request.getParameter("cat");
        String quest = request.getParameter("quest");
        String id = request.getParameter("id");
        if(id == null){
        Question qs = new Question();
        qs.setCategorie(cat);
        qs.setQuestion(quest);
        qs.setIdPat(p.getIdPat());
        PatientModel pm = new PatientModel();
        if(p.getAge() == null && p.getPoid() == null)
        {
            int taille = Integer.parseInt(request.getParameter("taille"));
        int poid = Integer.parseInt(request.getParameter("poid"));
            p.setAge(taille);
        p.setPoid(poid);
        pm.modifierPatient(p);
        }
        qm.creerQuestion(qs);
        String suc = "Question ajoutée avec sucéée !";
        request.setAttribute("suc", suc);
        this.getServletContext().getRequestDispatcher("/mesQuest.jsp").forward(request, response);
                }
        else{
            int idq = Integer.parseInt(id);
            Question q = qm.trouverQuestion(idq);
        q.setCategorie(cat);
        q.setQuestion(quest);
        qm.modiferQuestion(q);
        String mod ="Question modifiée avec sucée !";
        request.setAttribute("mod", mod);
        this.getServletContext().getRequestDispatcher("/mesQuest.jsp").forward(request, response);
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
