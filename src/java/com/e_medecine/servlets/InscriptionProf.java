/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.servlets;

import com.e_medecine.beans.CabinetModel;
import com.e_medecine.beans.HoraireModel;
import com.e_medecine.beans.ProfessionnelSanteModel;
import com.e_medecine.beans.SpecialiteModel;
import com.e_medecine.entities.Cabinet;
import com.e_medecine.entities.Horaire;
import com.e_medecine.entities.ProfessionnelSante;
import com.e_medecine.entities.Specialite;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author mou
 */
@MultipartConfig
public class InscriptionProf extends HttpServlet {

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
            out.println("<title>Servlet InscriptionProf</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InscriptionProf at " + request.getContextPath() + "</h1>");
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

        //Réception d'infos pers
        String nom = request.getParameter("nom");
        String pren = request.getParameter("pren");
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        String jour;
        String mois;
        String an;
        String dnais = request.getParameter("dnais");
        jour = dnais.substring(8, 10);
        mois = dnais.substring(5, 7);
        an = dnais.substring(0, 4);
        dnais = jour + "/" + mois + "/" + an;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datenais = null;
        try {
            datenais = formatter.parse(dnais);
        } catch (ParseException ex) {
            Logger.getLogger(InscriptionProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        String genre = request.getParameter("genre");
        String adrsph = request.getParameter("adrsph");
        int tel = Integer.parseInt(request.getParameter("tel"));
        String spec = request.getParameter("spec");
        String dip = request.getParameter("dip");
        String vdom = request.getParameter("vdom");

        SpecialiteModel sm = new SpecialiteModel();
        List<Specialite> ls = sm.listerSpecialite1(spec);
        Specialite s = ls.get(0);
        ProfessionnelSanteModel psm = new ProfessionnelSanteModel();
        ProfessionnelSante ps = new ProfessionnelSante();
        //Réception d'infos cabinet
        String gov = request.getParameter("gouv");
        String del = request.getParameter("del");
        String adcab = request.getParameter("adcab");
        int telf = Integer.parseInt(request.getParameter("telf"));
        String desc = request.getParameter("desc");
        float prix = Float.parseFloat(request.getParameter("prix"));
        String cb = request.getParameter("cb");

        CabinetModel cm = new CabinetModel();
        Cabinet c = new Cabinet();

        c.setGouvernorat(gov);
        c.setDelegation(del);
        c.setAdresseCab(adcab);
        c.setTelFixe(telf);
        c.setDescriptionCab(desc);
        c.setPrixVisite(prix);
        if (cb.equals("Oui")) {
            c.setPaimentCarteB(Boolean.TRUE);
        } else {
            c.setPaimentCarteB(Boolean.FALSE);
        }

        //Récupération de l'horaire de lundi
        String displundi = request.getParameter("dispLundi");
        //Récupération de l'horaire de mardi
        String dispMardi = request.getParameter("dispMardi");
       
        //Récupération de l'horaire de mercredi
        String dispMercredi = request.getParameter("dispMercredi");
       
        //Récupération de l'horaire de jeudi
        String dispJeudi = request.getParameter("dispJeudi");
        
        //Récupération de l'horaire de vendredi
        String dispVendredi = request.getParameter("dispVendredi");
        
        //Récupération de l'horaire de samedi
        String dispSamedi = request.getParameter("dispSamedi");
        
        //Récupération de l'horaire de dimanche
        String dispDimanche = request.getParameter("dispDimanche");
        
        List existCab = cm.existeCabinet(telf);

        List existProf = psm.existProfessionnelSante(ps.getEmailProf());
            Horaire lundi = new Horaire();
            Horaire mardi = new Horaire();
            Horaire mercredi = new Horaire();
            Horaire jeudi = new Horaire();
            Horaire vendredi = new Horaire();
            Horaire samedi = new Horaire();
            Horaire dimanche = new Horaire();
            HoraireModel hm = new HoraireModel();
        if (existCab.isEmpty()) {
            
            //Faire les test naicessaire
             if (existProf.isEmpty()) {
                //psm.creerPs(ps);
                InputStream inputStream = null; // input stream of the upload file
                // obtains the upload file part in this multipart request
                Part filePart = request.getPart("ident");
                if (filePart != null) {
                    // prints out some information for debugging
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    // obtains input stream of the upload file
                    inputStream = filePart.getInputStream();
                }
                Connection conn = null; // connection to the database
                try {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                    //Inserstion dans la base
                    String sql = "INSERT INTO professionnel_sante (NOM_PROF, PRENOM_PROF, PASSWORD_PROF, ADRESSE_PROF, EMAIL_PROF, TEL_MOB, GENRE_PROF, DIPLOME, PHOTO_IDENTITE, id_spec) values(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, nom);
                    statement.setString(2, pren);
                    statement.setString(3, pass);
                    statement.setString(4, adrsph);
                    statement.setString(5, mail);
                    statement.setInt(6, tel);
                    statement.setString(7, genre);
                    statement.setString(8, dip);
                    statement.setInt(10, s.getIdSpec());
                    if (inputStream != null) {
                        // fetches input stream of the upload file for the blob column
                        statement.setBlob(9, inputStream);
                        statement.executeUpdate();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InscriptionProf.class.getName()).log(Level.SEVERE, null, ex);
                }
                ps = psm.existProfessionnelSante(mail).get(0);
                ps.setDateNaisProf(datenais);
                if (vdom.equals("Oui")) {
                    ps.setVisiteADomicile(Boolean.TRUE);
                } else {

                    ps.setVisiteADomicile(Boolean.FALSE);
                }
                psm.modifierPs(ps);
                c.setIdProf(psm.existProfessionnelSante(mail).get(0).getIdProf());
                cm.creerCabinet(c);
                //Faire les sets et création seulement des horaire ouverts
                if(displundi.equals("Ouvert")){
                lundi.setIdCab(c.getIdCab());
                lundi.setJour("lundi");
                hm.creerHoraire(lundi);}
                
                if(dispMardi.equals("Ouvert")){
                mardi.setIdCab(c.getIdCab());
                mardi.setJour("mardi");
                hm.creerHoraire(mardi);}
                
                if(dispMercredi.equals("Ouvert")){
                mercredi.setIdCab(c.getIdCab());
                mercredi.setJour("mercredi");
                hm.creerHoraire(mercredi);}
                
                if(dispJeudi.equals("Ouvert")){
                jeudi.setIdCab(c.getIdCab());
                jeudi.setJour("jeudi");
                hm.creerHoraire(jeudi);}
                
                if(dispVendredi.equals("Ouvert")){
                vendredi.setIdCab(c.getIdCab());
                vendredi.setJour("vendredi");
                hm.creerHoraire(vendredi);}
                
                if(dispSamedi.equals("Ouvert")){
                samedi.setIdCab(c.getIdCab());
                samedi.setJour("samedi");
                hm.creerHoraire(samedi);}
                
                if(dispDimanche.equals("Ouvert")){
                dimanche.setIdCab(c.getIdCab());
                dimanche.setJour("dimanche");
                hm.creerHoraire(dimanche);}
                
                String suc = "Vous êtes inscris avec succé !";
                request.setAttribute("suc", suc);
                this.getServletContext().getRequestDispatcher("/loginDocteur.jsp").forward(request, response);
            } else {
                String message = "Il éxiste déja un professionnels de santé avec cette adresse email !";
                request.setAttribute("m", message);
                this.getServletContext().getRequestDispatcher("/inscriptionDocteur.jsp").forward(request, response);
            }
        } else {
            String message = "Il éxiste déja un cabinet ayant ce numéro de téléphone fixe !";
            request.setAttribute("cab", message);
            this.getServletContext().getRequestDispatcher("/inscriptionDocteur.jsp").forward(request, response);
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
