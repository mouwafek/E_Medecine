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
        //R??cup??ration des infos de maladie
        String type = request.getParameter("typem");
        String nom = request.getParameter("nom");
        String autre = request.getParameter("autre");
        String trt = request.getParameter("trtm");
        String art = request.getParameter("arrT");
        //Cr??ation des variable pour r??cup??rer le jour mois et an
        String jour;
        String mois;
        String an;
        // R??cup??ration du Date de d??but de maladie
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
        // R??cup??ration du Date de fin de maladie
        String jourf;
        String moisf;
        String anf;
        String datefin = request.getParameter("datefmal");
        Date dfin = null;
        //Si le patient a entr?? la date de fin
        if (!datefin.isEmpty()) {
            //  on l'a r??cup??re
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
        //Cr??ation de l'objet maladie
        Maladie m = new Maladie();
        //Cr??ation du model maladie
        MaldieModel mm = new MaldieModel();
        //Cr??ation d'objet d'association
        PatientM pm = new PatientM();
        //Cr??ation du model d'association
        PatientMmodel pmm = new PatientMmodel();
        //Cr??ation d'objet contenant les cl?? primaires
        PatientMId pmid = new PatientMId();
        //R??cup??ration du patient dans la session
        HttpSession ss = request.getSession();
        Patient p = (Patient) ss.getAttribute("patient");
        //Si la maladie est avant ou ??gale ?? la date du syst??me
        if (newdatesys.after(datedebut) || newdatesys.equals(datedebut)) {
            //Selon le type de maladie ?? chaque fois on fait les tests
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
                            //On cr??er la maladie
                            mm.creerMaladie(m);
                            //Ajout des id du maladie et patient
                            //dans l'objet contenant les id qui est 
                            //un atrribut de la classe association
                            /*Ajout des valeurs ?? la classe association*/
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
                            //Cr??ation du patient maladie
                            pmm.creerPatientM(pm);
                            //Message de succ??e d'ajout
                            String malsuc = "Maladie ajout??e avec succ??e !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } 
                        //S'il y a la date de fin et apr??s la db
                        //On cr??er la maladie
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                        //Si la date de fin est avant ou ??gale la date de d??but
                        //on affiche un message d'erreur
                        else {
                            String df = "La date de fin de maladie ne peut ??tre pas ??gale ou avant la date de d??but !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } 
                    //Le champ "Autre" est remplit et nom != autre 
                    else if (!autre.isEmpty() && !nom.equals("Autre")) {
                        String chronique = "Vous avez d??ja choisi le nom de maladie !! ";
                        request.setAttribute("chronique", chronique);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } 
                    //Le champ "Autre" est vide et le nom = autre
                    else if (nom.equals("Autre") && autre.isEmpty()) {
                        String autr = "Veuiller ??crire le nom de la maladie dans le champ 'Autre'";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut ??tre pas ??gale ou avant la date de d??but !";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut ??tre pas ??gale ou avant la date de d??but !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } //Le champ "Autre" est remplit et nom != autre 
                    else if (!autre.isEmpty() && !nom.equals("Autre")) {
                        String chronique = "Vous avez d??ja choisi le nom de maladie !! ";
                        request.setAttribute("chronique", chronique);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } else if (nom.equals("Autre") && autre.isEmpty()) {
                        String autr = "Veuiller ??crire le nom de la maladie dans le champ 'Autre'";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut ??tre pas ??gale ou avant la date de d??but !";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut ??tre pas ??gale ou avant la date de d??but !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } //Le champ "Autre" est remplit et nom != autre 
                    else if (!autre.isEmpty() && !nom.equals("Autre")) {
                        String chronique = "Vous avez d??ja choisi le nom de maladie !! ";
                        request.setAttribute("chronique", chronique);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } else if (nom.equals("Autre") && autre.isEmpty()) {
                        String autr = "Veuiller ??crire le nom de la maladie dans le champ 'Autre'";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut ??tre pas ??gale ou avant la date de d??but !";
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
                            String dfinull = "Vous avez indiqu?? que la maladie est temporaire ! Merci d'ajouter la date de fin";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut ??tre pas ??gale ou avant la date de d??but !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } else if (!nom.equals("Autre") && autre.isEmpty()) {
                        if (dfin == null) {
                            String dfinull = "Vous avez indiqu?? que la maladie est temporaire ! Merci d'ajouter la date de fin";
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
                            String malsuc = "Maladie ajout??e avec succ??e !";
                            request.setAttribute("malsuc", malsuc);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        } else {
                            String df = "La date de fin de maladie ne peut ??tre pas ??gale ou avant la date de d??but !";
                            request.setAttribute("df", df);
                            this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                        }
                    } else if (!nom.equals("Autre") && !autre.isEmpty()) {
                        String chronique = "Vous avez d??ja choisi le nom de maladie !! ";
                        request.setAttribute("chronique", chronique);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    } else if (nom.equals("Autre") && autre.isEmpty()) {
                        String autr = "Veuiller ??crire le nom de la maladie dans le champ 'Autre'";
                        request.setAttribute("autr", autr);
                        this.getServletContext().getRequestDispatcher("/profilMedicalPatient.jsp").forward(request, response);
                    }
                default:
                    out.println("choisir type");
            }
        } else {
            String mal = "V??rifier la date de d??but de maladie !!!";
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
