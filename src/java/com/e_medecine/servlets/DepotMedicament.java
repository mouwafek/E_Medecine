/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.servlets;

import com.e_medecine.beans.MedicamentModel;
import com.e_medecine.entities.Medicament;
import com.e_medecine.entities.Patient;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author mou
 */
@MultipartConfig
public class DepotMedicament extends HttpServlet {
    // database connection settings

    private String dbURL = "jdbc:mysql://localhost:3306/medec";
    private String dbUser = "root";
    private String dbPass = "";

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
            out.println("<title>Servlet DepotMedicament</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DepotMedicament at " + request.getContextPath() + "</h1>");
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
        HttpSession ss = request.getSession();
        Patient p = (Patient) ss.getAttribute("patient");
        String nom = request.getParameter("nom");
        String forme = request.getParameter("forme");
        String classe = request.getParameter("classe");
        String jour;
        String mois;
        String an;
        String dateval = request.getParameter("dateval");
        jour = dateval.substring(8, 10);
        mois = dateval.substring(5, 7);
        an = dateval.substring(0, 4);
        dateval = jour + "/" + mois + "/" + an;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datev = null;
        Date newdatesys = null;
        try {
            datev = formatter.parse(dateval);
        } catch (ParseException ex) {
            Logger.getLogger(DepotMedicament.class.getName()).log(Level.SEVERE, null, ex);
        }
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String Datesys = format.format(date);
        try {
            newdatesys = formatter.parse(Datesys);
        } catch (ParseException ex) {
            Logger.getLogger(DepotMedicament.class.getName()).log(Level.SEVERE, null, ex);
        }
        int qt = Integer.parseInt(request.getParameter("qt"));
        String id = request.getParameter("id");
        if (id == null) {
            if (datev.equals(newdatesys) || datev.before(newdatesys)) {
                request.setAttribute("erreur", "Vérifier la date de validité !");
                this.getServletContext().getRequestDispatcher("/poserMed.jsp").forward(request, response);
            } else {

                InputStream inputStream = null; // input stream of the upload file
                // obtains the upload file part in this multipart request
                Part filePart = request.getPart("ph");
                if (filePart != null) {
                    // prints out some information for debugging
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    // obtains input stream of the upload file
                    inputStream = filePart.getInputStream();
                }
                Connection conn = null; // connection to the database
                String message = null;  // message will be sent back to client
                try {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                    // constructs SQL statement
                    String sql = "INSERT INTO medicament (NOM_MED,FORME_MED,CLASSE_THERP,PHOTO_MED,QUANTITE,id_pat) values (?,?,?,?,?,?)";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, nom);
                    statement.setString(2, forme);
                    statement.setString(3, classe);
                    statement.setInt(5, qt);
                    statement.setInt(6, p.getIdPat());
                    if (inputStream != null) {
                        // fetches input stream of the upload file for the blob column
                        statement.setBlob(4, inputStream);
                    }
                    // sends the statement to the database server
                    int row = statement.executeUpdate();
                    if (row > 0) {
                        MedicamentModel mm = new MedicamentModel();
                        Medicament m = mm.listerMedicament2(p.getIdPat(), nom, forme).get(0);
                        m.setDateValidite(datev);
                        mm.modiferMedicament(m);
                        message = "Médicament déposé avec succée !";
                    }
                } catch (SQLException ex) {
                    message = "ERROR: " + ex.getMessage();
                    ex.printStackTrace();
                } finally {
                    if (conn != null) {
                        // closes the database connection
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                    // sets the message in request scope
                    request.setAttribute("Message", message);

                    // forwards to the message page
                    getServletContext().getRequestDispatcher("/mesMed.jsp").forward(request, response);
                }
            }
        } else {
            int idq = Integer.parseInt(id);
            MedicamentModel mm = new MedicamentModel();
            Medicament m = new Medicament();
            if (datev.equals(newdatesys) || datev.before(newdatesys)) {
                m = mm.trouverMedicament(idq);
                request.setAttribute("m", m);
                request.setAttribute("erreur", "Vérifier la date de validité !");
                this.getServletContext().getRequestDispatcher("/poserMed.jsp").forward(request, response);
            } else {

                InputStream inputStream = null; // input stream of the upload file
                // obtains the upload file part in this multipart request
                Part filePart = request.getPart("ph");
                if (filePart != null) {
                    // prints out some information for debugging
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    // obtains input stream of the upload file
                    inputStream = filePart.getInputStream();
                }
                Connection conn = null; // connection to the database
                String message = null;  // message will be sent back to client
                try {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                    // constructs SQL statement
                    String sql = "UPDATE medicament set NOM_MED =?, FORME_MED = ?,CLASSE_THERP = ?, PHOTO_MED = ?, QUANTITE = ? where id_med='"+idq+"' and id_pat='"+p.getIdPat()+"'";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, nom);
                    statement.setString(2, forme);
                    statement.setString(3, classe);
                    statement.setInt(5, qt);
                    if (inputStream != null) {
                        // fetches input stream of the upload file for the blob column
                        statement.setBlob(4, inputStream);
                    }
                    // sends the statement to the database server
                    int row = statement.executeUpdate();
                    if (row > 0) {
                        m = mm.listerMedicament2(p.getIdPat(), nom, forme).get(0);
                        m.setDateValidite(datev);
                        mm.modiferMedicament(m);
                        message = "Médicament modifié avec succée !";
                    }
                } catch (SQLException ex) {
                    message = "ERROR: " + ex.getMessage();
                    ex.printStackTrace();
                } finally {
                    if (conn != null) {
                        // closes the database connection
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                    // sets the message in request scope
                    request.setAttribute("Message", message);

                    // forwards to the message page
                    getServletContext().getRequestDispatcher("/mesMed.jsp").forward(request, response);
                }
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
