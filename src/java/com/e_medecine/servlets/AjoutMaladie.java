/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e_medecine.servlets;

import com.e_medecine.beans.MaldieModel;
import com.e_medecine.beans.PatientMmodel;
import com.e_medecine.dao.MaladieDAO;
import com.e_medecine.dao.PatientMDAO;
import com.e_medecine.entities.Maladie;
import com.e_medecine.entities.Patient;
import com.e_medecine.entities.PatientM;
import com.e_medecine.entities.PatientMId;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class AjoutMaladie extends HttpServlet {

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
            out.println("<title>Servlet AjoutMaladie</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutMaladie at " + request.getContextPath() + "</h1>");
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
        //Récupération des infos de maladie
        String type = request.getParameter("typem");
        String nom = request.getParameter("nom");
        String autre = request.getParameter("autre");
        String trt = request.getParameter("trtm");
        String art = request.getParameter("arrT");
        //Création des variable pour récupérer le jour mois et an
        String jour;
        String mois;
        String an;
        // Récupération du Date de début de maladie
        String datedeb = request.getParameter("datedmal");
        //Extraction du jour mois et an
        jour = datedeb.substring(8, 10);
        mois = datedeb.substring(5, 7);
        an = datedeb.substring(0, 4);
        //Ordonner la date
        datedeb = jour + "/" + mois + "/" + an;
        //Convertion du date du String au type Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datedebut = null;
        Date newdatesys = null;
        try {
            datedebut = formatter.parse(datedeb);
        } catch (ParseException ex) {
            Logger.getLogger(AjoutMaladie.class.getName()).log(Level.SEVERE, null, ex);
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
        // Récupération du Date de fin de maladie
        String jourf;
        String moisf;
        String anf;
        String datefin = request.getParameter("datefmal");
        Date dfin = null;
        //Si le patient a entré la date de fin
        if (!datefin.isEmpty()) {
            //  on l'a récupère
            jourf = datefin.substring(8, 10);
            moisf = datefin.substring(5, 7);
            anf = datefin.substring(0, 4);
            datefin = jourf + "/" + moisf + "/" + anf;

            try {
                dfin = formatter.parse(datefin);
            } catch (ParseException ex) {
                Logger.getLogger(AjoutMaladie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Création de l'objet maladie
        Maladie m = new Maladie();
        //Création du model maladie
        MaldieModel mm = new MaldieModel();
        //Création d'objet d'association
        PatientM pm = new PatientM();
        //Création du model d'association
        PatientMmodel pmm = new PatientMmodel();
        //Création d'objet contenant les clé primaires
        PatientMId pmid = new PatientMId();
        //Récupération du patient dans la session
        HttpSession ss = request.getSession();
        Patient p = (Patient) ss.getAttribute("patient");
        //Si la maladie est avant ou égale à la date du système
        if (newdatesys.after(datedebut) || newdatesys.equals(datedebut)) {
            //Selon le type de maladie à chaque fois on fait les tests
            switch (type) {
                //Cas de malaldie chronique
                case "Maladie chronique":
                    //Si le patient choisit autre dans la section nom
                    //et remplit le champ "Autre"
                    if (!autre.isEmpty() && nom.equals("Autre")) {
                        //Si la date de fin est vide
                        if (dfin == null) {
                            //On ajoute le type et le nom
                            m.setTypeM(type);
                            m.setNomM(autre);
                            //On créer la maladie
                            mm.creerMaladie(m);
                            //Ajout des id du maladie et patient
                            //dans l'objet contenant les id qui est 
                            //un atrribut de la classe association
                            /*Ajout des valeurs à la classe association*/
                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            //S'il y a arret de travail on met true
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } 
                            //Si non on met false
                            else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            //Création du patient maladie
                            pmm.creerPatientM(pm);
                            //Message de succée d'ajout
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } 
                        //S'il y a la date de fin et après la db
                        //On créer la maladie
                        else if (dfin.after(datedebut)) {
                            m.setTypeM(type);
                            m.setNomM(autre);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pm.setDateFM(dfin);
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                        //Si la date de fin est avant ou égale la date de début
                        //on affiche un message d'erreur
                        else {
                            String df = "La date de fin de maladie ne peut être pas égale ou avant la date de début !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } 
                    //Le champ "Autre" est remplit et nom != autre 
                    else if (!autre.isEmpty() && !nom.equals("Autre")) {
                        String chronique = "Vous avez déja choisi le nom de maladie !! ";
                        request.setAttribute("chronique", chronique);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } 
                    //Le champ "Autre" est vide et le nom = autre
                    else if (nom.equals("Autre") && autre.isEmpty()) {
                        String autr = "Veuiller écrire le nom de la maladie dans le champ 'Autre'";
                        request.setAttribute("autr", autr);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } else if (nom.substring(nom.length() - 11).equals("(chronique)") && autre.isEmpty()) {
                        if (dfin == null) {
                            m.setTypeM(type);
                            m.setNomM(nom);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else if (dfin.after(datedebut)) {
                            m.setTypeM(type);
                            m.setNomM(nom);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pm.setDateFM(dfin);
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut être pas égale ou avant la date de début !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } else if (!nom.substring(nom.length() - 11).equals("(chronique)") && autre.isEmpty()) {
                        String convien = "Le type et le nom de maladie ne conviennent pas !!!";
                        request.setAttribute("convien", convien);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    }

                    break;
                case "Maladie psychiatrique":
                    if (!autre.isEmpty() && nom.equals("Autre")) {
                        if (dfin == null) {
                            m.setTypeM(type);
                            m.setNomM(autre);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else if (dfin.after(datedebut)) {
                            m.setTypeM(type);
                            m.setNomM(autre);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pm.setDateFM(dfin);
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut être pas égale ou avant la date de début !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } //Le champ "Autre" est remplit et nom != autre 
                    else if (!autre.isEmpty() && !nom.equals("Autre")) {
                        String chronique = "Vous avez déja choisi le nom de maladie !! ";
                        request.setAttribute("chronique", chronique);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } else if (nom.equals("Autre") && autre.isEmpty()) {
                        String autr = "Veuiller écrire le nom de la maladie dans le champ 'Autre'";
                        request.setAttribute("autr", autr);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } else if (nom.substring(nom.length() - 15).equals("(psychiatrique)") && autre.isEmpty()) {
                        if (dfin == null) {
                            m.setTypeM(type);
                            m.setNomM(nom);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else if (dfin.after(datedebut)) {
                            m.setTypeM(type);
                            m.setNomM(nom);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pm.setDateFM(dfin);
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut être pas égale ou avant la date de début !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } else if (!nom.substring(nom.length() - 15).equals("(psychiatrique)") && autre.isEmpty()) {
                        String convien = "Le type et le nom de maladie ne conviennent pas !!!";
                        request.setAttribute("convien", convien);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    }
                    break;
                case "Traumatisme":
                    if (!autre.isEmpty() && nom.equals("Autre")) {
                        if (dfin == null) {
                            m.setTypeM(type);
                            m.setNomM(autre);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else if (dfin.after(datedebut)) {
                            m.setTypeM(type);
                            m.setNomM(autre);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pm.setDateFM(dfin);
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut être pas égale ou avant la date de début !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } //Le champ "Autre" est remplit et nom != autre 
                    else if (!autre.isEmpty() && !nom.equals("Autre")) {
                        String chronique = "Vous avez déja choisi le nom de maladie !! ";
                        request.setAttribute("chronique", chronique);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } else if (nom.equals("Autre") && autre.isEmpty()) {
                        String autr = "Veuiller écrire le nom de la maladie dans le champ 'Autre'";
                        request.setAttribute("autr", autr);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } else if (nom.substring(nom.length() - 13).equals("(traumatique)") && autre.isEmpty()) {
                        if (dfin == null) {
                            m.setTypeM(type);
                            m.setNomM(nom);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else if (dfin.after(datedebut)) {
                            m.setTypeM(type);
                            m.setNomM(nom);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pm.setDateFM(dfin);
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut être pas égale ou avant la date de début !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } else if (!nom.substring(nom.length() - 13).equals("(traumatique)") && autre.isEmpty()) {
                        String convien = "Le type et le nom de maladie ne conviennent pas !!!";
                        request.setAttribute("convien", convien);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    }
                    break;
                case "Temporaire":
                    if (nom.equals("Autre") && !autre.isEmpty()) {
                        if (dfin == null) {
                            String dfinull = "Vous avez indiqué que la maladie est temporaire ! Merci d'ajouter la date de fin";
                            request.setAttribute("dfinull", dfinull);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else if (dfin.after(datedebut)) {
                            m.setTypeM(type);
                            m.setNomM(nom);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pm.setDateFM(dfin);
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut être pas égale ou avant la date de début !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } else if (!nom.equals("Autre") && autre.isEmpty()) {
                        if (dfin == null) {
                            String dfinull = "Vous avez indiqué que la maladie est temporaire ! Merci d'ajouter la date de fin";
                            request.setAttribute("dfinull", dfinull);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else if (dfin.after(datedebut)) {
                            m.setTypeM(type);
                            m.setNomM(nom);
                            mm.creerMaladie(m);

                            pmid.setIdM(m.getIdM());
                            pmid.setIdPat(p.getIdPat());
                            pm.setId(pmid);
                            pm.setDateDM(datedebut);
                            pm.setTraitement(trt);
                            if (art.equals("Oui")) {
                                pm.setArretTrav(Boolean.TRUE);
                            } else {
                                pm.setArretTrav(Boolean.FALSE);
                            }
                            pm.setDateFM(dfin);
                            pmm.creerPatientM(pm);
                            String malsuc = "Maladie ajoutée avec succée !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut être pas égale ou avant la date de début !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } else if (!nom.equals("Autre") && !autre.isEmpty()) {
                        String chronique = "Vous avez déja choisi le nom de maladie !! ";
                        request.setAttribute("chronique", chronique);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } else if (nom.equals("Autre") && autre.isEmpty()) {
                        String autr = "Veuiller écrire le nom de la maladie dans le champ 'Autre'";
                        request.setAttribute("autr", autr);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    }
                default:
                    out.println("choisir type");
            }
        } else {
            String mal = "Vérifier la date de début de maladie !!!";
            request.setAttribute("mal", mal);
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
