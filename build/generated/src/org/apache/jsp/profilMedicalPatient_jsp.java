package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.e_medecine.entities.Medicament;
import com.e_medecine.dao.ProfessionnelSanteDAO;
import com.e_medecine.entities.ProfessionnelSante;
import com.e_medecine.beans.PatientModel;
import com.e_medecine.entities.PatientAl;
import java.util.List;
import com.e_medecine.entities.Allergie;
import java.sql.Statement;
import com.e_medecine.entities.Patient;

public final class profilMedicalPatient_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Profil médical patient</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"icon\" href=\"img/Logo.png\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            //Récupération du  patient dans la session
            if (session.getAttribute("patient") != null) {

                Patient p = (Patient) session.getAttribute("patient");
        
      out.write("\n");
      out.write("        <!--Header-->\n");
      out.write("        <header style=\"z-index: 1000; position: fixed; width: 100%;\">\n");
      out.write("            <nav id=\"navbarmed\" class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.jsp\">\n");
      out.write("                    <img src=\"img/Logo.png\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n");
      out.write("                    <strong>E-Medecine</strong>\n");
      out.write("                </a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("                <div style=\"justify-content: flex-end;\" class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item active\" style=\"color : white; important;\">\n");
      out.write("                            <a class=\"nav-link\" href=\"espacePatient.jsp\">Accueil<span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"professionnelSante.jsp\">Professionnel de santé</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"medicament.jsp\">Médicaments</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"question.jsp\">Questions</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("            <div data-spy=\"scroll\" data-target=\"#navbarmed\" data-offset=\"0\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <main style=\"background: #2980B9;  /* fallback for old browsers */\n");
      out.write("              background: -webkit-linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9);  /* Chrome 10-25, Safari 5.1-6 */\n");
      out.write("              background: linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n");
      out.write("              \">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            ");
 //Réception des msg d'erreur et de succées Block allergie
                String sucal = (String) request.getAttribute("s");
                if (sucal == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(sucal);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 String erral = (String) request.getAttribute("e");
                if (erral == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(erral);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 //Réception des msg d'erreur et de succées Block Antécédents ch
                String ch = (String) request.getAttribute("sch");
                if (ch == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(ch);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 String ech = (String) request.getAttribute("ech");
                if (ech == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(ech);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 //Réception des msg d'erreur et de succées Block Infos Pers
                String sinf = (String) request.getAttribute("sinf");
                if (sinf == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(sinf);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 String erinf = (String) request.getAttribute("erinf");
                if (erinf == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(erinf);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 //Réception des msg d'erreur et de succées Block Maladie
                String malsuc = (String) request.getAttribute("malsuc");
                if (malsuc == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(malsuc);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 String convien = (String) request.getAttribute("convien");
                if (convien == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(convien);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 String df = (String) request.getAttribute("df");
                if (df == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(df);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 String chronique = (String) request.getAttribute("chronique");
                if (chronique == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(chronique);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 String autr = (String) request.getAttribute("autr");
                if (autr == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(autr);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 String mal = (String) request.getAttribute("mal");
                if (mal == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(mal);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            ");
 String dfinull = (String) request.getAttribute("dfinull");
                if (dfinull == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;\">\n");
      out.write("                ");
out.println(dfinull);
                    }
      out.write("\n");
      out.write("            </p>\n");
      out.write("            <div style=\"background: #1f4037;  /* fallback for old browsers */\n");
      out.write("background: -webkit-linear-gradient(to right, #99f2c8, #1f4037);  /* Chrome 10-25, Safari 5.1-6 */\n");
      out.write("background: linear-gradient(to right, #99f2c8, #1f4037); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n");
      out.write(" width: auto;border-radius: 100px;height: 550px;margin-left: 10px;margin-right: 10px;display: list-item; justify-content: center;\">\n");
      out.write("                <div style=\"text-align: center;padding-top: 50px;padding-left: 20px;padding-right: 20px;\">\n");
      out.write("                    <em><h2>Ici vous pouvez ajouter des informations sur votre santé\n");
      out.write("                         pour bien construire votre profil médical\n");
      out.write("                            afin d'aider les professionnels de santé \n");
      out.write("                            à bien comprendre votre situation</h2></em>\n");
      out.write("                </div> \n");
      out.write("                <div style=\"text-align: center;\">\n");
      out.write("                    <img src=\"img/profileMed.jpg\" style=\"width: 350px;height: 200px;-webkit-border-radius:50px;\n");
      out.write("    -moz-border-radius:50px;\n");
      out.write("    border-radius:50px;\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Block Allergie / Antécédent chirurgucal / Maladie-->\n");
      out.write("            <div style=\"margin-bottom: 20px;margin-top: 20px;\">\n");
      out.write("                <article style=\"display: flex; justify-content: center;\">\n");
      out.write("                    <div class=\"card-deck\">\n");
      out.write("                        <!-- Block Allergie -->\n");
      out.write("                        <div class=\"card\" style=\"width: 25rem;background-color: #2BBBAD;\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <form method=\"post\" action=\"/E_Medecine/AjoutAllergie\">\n");
      out.write("                                    <h5 class=\"card-title\">Avez-vous une nouvelle allergie? </h5>\n");
      out.write("                                    Premier date d'allergie : \n");
      out.write("                                    <input style=\"margin-bottom:20px; \" placeholder=\"Date allergie\" type=\"date\" id=\"example\" class=\"form-control\" name=\"dateall\" required=\"\">\n");
      out.write("                                    Type de réaction :\n");
      out.write("                                    <div class=\"input-group mb-3\">\n");
      out.write("                                        <select name=\"typer\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                            <option selected></option>\n");
      out.write("                                            <option>Immédiate</option>\n");
      out.write("                                            <option>Retardée</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    Etat de réaction :\n");
      out.write("                                    <div class=\"input-group mb-3\">\n");
      out.write("                                        <select name=\"etatr\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                            <option selected></option>\n");
      out.write("                                            <option>Grave</option>\n");
      out.write("                                            <option>Normale</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    Médicament ou produit causant l'allergie :\n");
      out.write("                                    <input type=\"text\"  class=\"form-control\" name=\"prod\" required=\"\">\n");
      out.write("                                    <p style=\"text-align: center;\">\n");
      out.write("                                        <input type=\"submit\" value=\"Ajouter\" class=\"btn btn-primary\" style=\"margin-top: 20px;\">\n");
      out.write("                                    </p>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Block info pers -->\n");
      out.write("                        <div class=\"card\" style=\"width: 25rem;background-color: #33b5e5;\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <form method=\"post\" action=\"/E_Medecine/AjoutInfoPers\">\n");
      out.write("                                    <h5 class=\"card-title\">Informations personnelles : </h5>\n");
      out.write("                                    Poid : \n");
      out.write("                                    <input type=\"text\" maxlength=\"3\" style=\"margin-bottom: 20px;\" Value=\"");

                                                                                                            if(p.getPoid() != null){
                                                                                                                out.println(p.getPoid());
                                                                                                                }
                                                                                                                else
                                                                                                                {
                                                                                                                out.println("");
                                                                                                                }
                                                                                                            
      out.write("\" placeholder=\"");

                                                                                                                if(p.getPoid() != null){
                                                                                                                out.println(p.getPoid()+" Kg");
                                                                                                                }
                                                                                                                else
                                                                                                                {
                                                                                                                out.println("Poid en Kg");
                                                                                                                }
                                                                                                                    
      out.write("\"id=\"exampleForm2\" class=\"form-control\" name=\"poid\" required=\"\">\n");
      out.write("                                    Taille : \n");
      out.write("                                    <input type=\"text\" maxlength=\"3\" style=\"margin-bottom: 20px;\" value=\"");

                                                                                                            if(p.getAge() != null){
                                                                                                                out.println(p.getAge());
                                                                                                                }
                                                                                                                else
                                                                                                                {
                                                                                                                out.println("");
                                                                                                                }
                                                                                                            
      out.write("\" placeholder=\"");

                                                                                                                if(p.getAge() != null){
                                                                                                                out.println(p.getAge()+" cm");
                                                                                                                }
                                                                                                                else
                                                                                                                {
                                                                                                                out.println("Taille en cm");
                                                                                                                }
                                                                                                                    
      out.write("\"id=\"exampleForm2\" class=\"form-control\" name=\"taille\" required=\"\">\n");
      out.write("                                    Groupe sanguin :(Attention! vous ne pouvez pas le modifier après!)\n");
      out.write("                                    <div class=\"input-group mb-3\">\n");
      out.write("                                        <select name=\"GS\" class=\"custom-select\" id=\"inputGroupSelect01\" >\n");
      out.write("                                            <option selected>Choisir</option>\n");
      out.write("                                            <option>AB+</option>\n");
      out.write("                                            <option>AB-</option>\n");
      out.write("                                            <option>A+</option>\n");
      out.write("                                            <option>A-</option>\n");
      out.write("                                            <option>B+</option>\n");
      out.write("                                            <option>B-</option>\n");
      out.write("                                            <option>O+</option>\n");
      out.write("                                            <option>O-</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    Que travailler vous ? :\n");
      out.write("                                    <input type=\"text\" id=\"exampleForm2\" class=\"form-control\" name=\"trav\" required=\"\">\n");
      out.write("\n");
      out.write("                                    <p style=\"text-align: center;\">\n");
      out.write("                                        <input type=\"submit\" value=\"Mettre à jour\" class=\"btn btn-primary\" style=\"margin-top: 20px;\">\n");
      out.write("                                    </p>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Antécédent chirurgucal -->\n");
      out.write("                        <div class=\"card\" style=\"width: 25rem;background-color: #2BBBAD;\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <form method=\"post\" action=\"/E_Medecine/AjoutAntCh\">\n");
      out.write("                                    <h5 class=\"card-title\">Vos antécédents  chirurgicaux</h5>\n");
      out.write("                                    Nom de l'opération : \n");
      out.write("                                    <div class=\"input-group mb-3\">\n");
      out.write("                                        <select name=\"nom\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                            <option selected></option>\n");
      out.write("                                            <option>Chirurgie vasculaire </option>\n");
      out.write("                                            <option>Chirurgie digestive</option>\n");
      out.write("                                            <option>Chirurgie infantile</option>\n");
      out.write("                                            <option>Chirurgie plastique ou esthétique</option>\n");
      out.write("                                            <option>Chirurgie maxillo faciale et stomatologie</option>\n");
      out.write("                                            <option>Chirurgie ophtalmologique</option>\n");
      out.write("                                            <option>ORL ou Oto-rhino-laryngologie</option>\n");
      out.write("                                            <option>Chirurgie urologique</option>\n");
      out.write("                                            <option>Autre</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    Date de l'opération : \n");
      out.write("                                    <input placeholder=\"Date allergie\" style=\"margin-bottom: 20px;\" type=\"date\" id=\"example\" class=\"form-control\" name=\"dateop\" required=\"\">\n");
      out.write("                                    Raison :\n");
      out.write("                                    <input type=\"text\" id=\"exampleForm2\" style=\"margin-bottom: 20px;\" class=\"form-control\" name=\"raison\" required=\"\">\n");
      out.write("                                    Nom de l'Hopital/Clinique :\n");
      out.write("                                    <input type=\"text\" id=\"exampleForm2\" class=\"form-control\" name=\"hop\" required=\"\">\n");
      out.write("                                    <p style=\"text-align: center;\">\n");
      out.write("                                        <input type=\"submit\" value=\"Ajouter\" class=\"btn btn-primary\" style=\"margin-top: 20px;\">\n");
      out.write("                                    </p>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("            </div>\n");
      out.write("            <!-- Maladie-->\n");
      out.write("            <div style=\"margin-bottom: 20px;margin-top: 20px;\">\n");
      out.write("                <article style=\"display: flex; justify-content: center;\">\n");
      out.write("                    <div class=\"card-deck\">\n");
      out.write("                        <!-- Maladie -->\n");
      out.write("                        <div class=\"card\" style=\"width: 25rem;background-color: #2BBBAD;\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <form method=\"post\" action=\"/E_Medecine/AjoutMaladie\">\n");
      out.write("                                    <h5 class=\"card-title\">Vous avez une nouvelle maladie ?</h5>\n");
      out.write("                                    Type de maladie : \n");
      out.write("                                    <div class=\"input-group mb-3\">\n");
      out.write("                                        <select id=\"typem\" name=\"typem\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                            <option selected></option>\n");
      out.write("                                            <option>Maladie chronique </option>\n");
      out.write("                                            <option>Maladie psychiatrique</option>\n");
      out.write("                                            <option>Traumatisme</option>\n");
      out.write("                                            <option>Temporaire</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    Nom de maladie : \n");
      out.write("                                    <div class=\"input-group mb-3\">\n");
      out.write("                                        <select id=\"nom\" name=\"nom\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                            <option selected></option>\n");
      out.write("                                            <option>Diabète(chronique)</option>\n");
      out.write("                                            <option>Hypertension artérielle(chronique)</option>\n");
      out.write("                                            <option>Maladie cardiaque(chronique)</option>\n");
      out.write("                                            <option>Asthme(chronique)</option>\n");
      out.write("                                            <option>Hypercholestérolémie(chronique)</option>\n");
      out.write("                                            <option>Arthrite(chronique)</option>\n");
      out.write("                                            <option>Ostéoporose(chronique)</option>\n");
      out.write("                                            <option>Hypothyroïdie(chronique)</option>\n");
      out.write("                                            <option>Maladie génétique(chronique)</option>\n");
      out.write("                                            <option>Maladie psychiatrique(chronique)</option>\n");
      out.write("                                            <option>Cancer(chronique)</option>\n");
      out.write("                                            <option>Maladie neurologique(chronique)</option>\n");
      out.write("                                            <option>Dépression(psychiatrique)</option>\n");
      out.write("                                            <option>Anxiété(psychiatrique)</option>\n");
      out.write("                                            <option>Manie(psychiatrique)</option>\n");
      out.write("                                            <option>Panique(psychiatrique)</option>\n");
      out.write("                                            <option>Hyperactivité(psychiatrique)</option>\n");
      out.write("                                            <option>Bipolarité(psychiatrique)</option>\n");
      out.write("                                            <option>Entorse(traumatique)</option>\n");
      out.write("                                            <option>Fracture(traumatique)</option>\n");
      out.write("                                            <option>Autre</option>\n");
      out.write("                                        </select>\n");
      out.write("                                        <input type=\"text\" placeholder=\"Autre\" name=\"autre\">\n");
      out.write("                                    </div>\n");
      out.write("                                    Date de début de maladie : \n");
      out.write("                                    <input placeholder=\"Date d maladie\" type=\"date\" id=\"example\" class=\"form-control\" name=\"datedmal\" required=\"\">\n");
      out.write("                                    Date de fin de maladie si elle est soignée : \n");
      out.write("                                    <input placeholder=\"Date f maladie\" type=\"date\" id=\"example\" class=\"form-control\" name=\"datefmal\">\n");
      out.write("                                    Traitement : \n");
      out.write("                                    <input type=\"text\" id=\"exampleForm2\" class=\"form-control\" name=\"trtm\" required=\"\">\n");
      out.write("                                    Vous avez arrêté à travailler ?\n");
      out.write("                                    <div class=\"input-group mb-3\">\n");
      out.write("                                        <select name=\"arrT\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                            <option selected></option>\n");
      out.write("                                            <option>Oui</option>\n");
      out.write("                                            <option>Non</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <p style=\"text-align: center;\">\n");
      out.write("                                        <input type=\"submit\" value=\"Ajouter\" class=\"btn btn-primary\" style=\"margin-top: 20px;\">\n");
      out.write("                                    </p>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card\" style=\"width: 25rem;background-color: #33b5e5;\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                    <h5 class=\"card-title\">Consulter votre profil médical</h5>\n");
      out.write("                                    <p>Cliquer ici pour voir et télécharger votre profil médical</p>\n");
      out.write("                                    <p style=\"text-align: center;\">\n");
      out.write("                                        <a href=\"telecharger.jsp\"><button type=\"button\" class=\"btn btn-success\">Mon profil</button></a>\n");
      out.write("                                    </p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("            </div>\n");
      out.write("            <form method=\"post\" action=\"/E_Medecine/UploadImgTest\" enctype=\"multipart/form-data\">\n");
      out.write("\n");
      out.write("                <input type=\"file\" accept=\"image/*\" name=\"PSimg\" required=\"\">\n");
      out.write("                <input type=\"submit\" value=\"Charger\">\n");
      out.write("            </form>\n");
      out.write("            <img src=\"getImage.jsp?id=");
      out.print(3);
      out.write("\" width=\"400px\" height=\"400px\"/>\n");
      out.write("           \n");
      out.write("        </main>\n");
      out.write("            <!-- Footer -->\n");
      out.write("            <footer class=\"page-footer font-small stylish-color-dark pt-4 bg-dark\">\n");
      out.write("\n");
      out.write("                <!-- Footer Links -->\n");
      out.write("                <div class=\"container text-center text-md-left\">\n");
      out.write("\n");
      out.write("                    <!-- Grid row -->\n");
      out.write("                    <div class=\"row\">\n");
      out.write("\n");
      out.write("                        <!-- Grid column -->\n");
      out.write("                        <div class=\"col-md-4 mx-auto\">\n");
      out.write("\n");
      out.write("                            <!-- Content -->\n");
      out.write("                            <h5 class=\"font-weight-bold text-uppercase mt-3 mb-4\" style=\"color:white !important;\">E-Medecine</h5>\n");
      out.write("                            <p style=\"color:white !important;\">Faites vos actes maintenant! \n");
      out.write("                                Bénéficier des meilleures services!</p>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Grid column -->\n");
      out.write("\n");
      out.write("                        <hr class=\"clearfix w-100 d-md-none\">\n");
      out.write("\n");
      out.write("                        <!-- Grid column -->\n");
      out.write("                        <div class=\"col-md-2 mx-auto\">\n");
      out.write("\n");
      out.write("                            <!-- Links -->\n");
      out.write("                            <h5 class=\"font-weight-bold text-uppercase mt-3 mb-4\" style=\"color:white !important;\">Liens</h5>\n");
      out.write("\n");
      out.write("                            <ul class=\"list-unstyled\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"professionnelSante.jsp\">Professionnel de santé</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"medicament.jsp\">Médicaments</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"question.jsp\">Qestions</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"contact.jsp\">Contact</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <!-- Grid column -->\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Grid row -->\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- Footer Links -->\n");
      out.write("\n");
      out.write("                <hr>\n");
      out.write("\n");
      out.write("                <!-- Call to action -->\n");
      out.write("                <ul class=\"list-unstyled list-inline text-center py-2\">\n");
      out.write("                    <li class=\"list-inline-item\">\n");
      out.write("                        <h5 style=\"color:white !important;\" class=\"mb-1\">Enregistrer gratuitement</h5>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"list-inline-item\">\n");
      out.write("                        <a href=\"index.jsp\" class=\"btn btn-danger btn-rounded\">S'inscrire!</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <!-- Call to action -->\n");
      out.write("\n");
      out.write("                <!-- Copyright -->\n");
      out.write("                <div class=\"footer-copyright text-center py-3\" style=\"color:white !important;\">© 2020 Copyright:\n");
      out.write("                    <a href=\"index.jsp\"> E-Medecine.com</a>\n");
      out.write("                </div>\n");
      out.write("                <!-- Copyright -->\n");
      out.write("\n");
      out.write("            </footer>\n");
      out.write("            <!-- Footer -->\n");
      out.write("\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"js/javascript.js\" />\n");
      out.write("            <script src=\"js/jquery.js\" />\n");
      out.write("            ");

                }else
                    this.getServletContext().getRequestDispatcher("/loginPatient.jsp").forward(request, response);
            
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
