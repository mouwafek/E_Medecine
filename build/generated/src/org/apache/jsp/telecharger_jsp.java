package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.e_medecine.entities.Allergie;
import com.e_medecine.entities.PatientAl;
import com.e_medecine.beans.AllergieModel;
import com.e_medecine.beans.PatientAlModel;
import com.e_medecine.entities.AntecedentChirurgical;
import com.e_medecine.entities.PatientCh;
import com.e_medecine.beans.AntChModel;
import com.e_medecine.beans.PatientChModel;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import com.e_medecine.beans.MaldieModel;
import com.e_medecine.entities.Maladie;
import com.e_medecine.entities.PatientM;
import java.util.List;
import com.e_medecine.beans.PatientMmodel;
import com.e_medecine.entities.Patient;

public final class telecharger_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Consulter Profil</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"icon\" href=\"img/Logo.png\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background: #8e9eab;  /* fallback for old browsers */\n");
      out.write("          background: -webkit-linear-gradient(to bottom, #eef2f3, #8e9eab);  /* Chrome 10-25, Safari 5.1-6 */\n");
      out.write("          background: linear-gradient(to bottom, #eef2f3, #8e9eab); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n");
      out.write("          \">\n");
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
      out.write("        <main>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div style=\"\">\n");
      out.write("                    <div>\n");
      out.write("                        <p style=\"margin-top: 30px;margin-left: 50px;\">\n");
      out.write("                            <strong>E-Medecine</strong>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div style=\"text-align: center;width:auto;height: 250px;margin-right:100px;margin-left: 100px;margin-bottom: 30px;\n");
      out.write("                         margin-top: 60px;background: #136a8a;  /* fallback for old browsers */\n");
      out.write("                         background: -webkit-linear-gradient(to bottom, #267871, #136a8a);  /* Chrome 10-25, Safari 5.1-6 */\n");
      out.write("                         background: linear-gradient(to bottom, #267871, #136a8a); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n");
      out.write("                         border-radius: 100px;\">\n");
      out.write("                        <h1 style=\"color: white;padding-top: 90px;\">Mon profil médical</h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div style=\"text-align: center;padding-top: 50px;padding-left: 20px;padding-right: 20px;margin-bottom: 50px;\">\n");
      out.write("                    <em><h3>Afin de profiter au maximum de votre visite médicale, prenez le temps de noter vos maladies et de\n");
      out.write("faire l’inventaire de vos médicaments et de vos allergies. Ces renseignements aideront les professionnels de santé\n");
      out.write("que vous consulterez à poser le bon diagnostic et à vous traiter efficacement.</h3></em>\n");
      out.write("                </div> \n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <div style=\"text-align: center;\">\n");
      out.write("                    <h2 style=\"margin-bottom: 20px;\">Informations personnelles</h2>\n");
      out.write("                    <div class=\"table-responsive text-nowrap\">\n");
      out.write("\n");
      out.write("                        <table class=\"table\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\">Nom</th>\n");
      out.write("                                    <th scope=\"col\">Prénom</th>\n");
      out.write("                                    <th scope=\"col\">Age</th>\n");
      out.write("                                    <th scope=\"col\">Poid</th>\n");
      out.write("                                    <th scope=\"col\">Taille</th>\n");
      out.write("                                    <th scope=\"col\">Groupe sanguin</th>\n");
      out.write("                                    <th scope=\"col\">Travail</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print(p.getNomPat());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(p.getPrenomPat());
      out.write("</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                            int a = Integer.parseInt(p.getDateNaisPat().toString().substring(0, 4));
                                            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                            Date date = new Date();
                                            int as = Integer.parseInt(format.format(date).substring(6));
                                            int age = as - a;
                                            out.println(age);
                                        
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>");
      out.print(p.getPoid() + " Kg");
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(p.getAge() + " cm");
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(p.getGroupeSanguin());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(p.getTravail());
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                                <hr>\n");
      out.write("                    <h2 style=\"margin-bottom: 20px;\">Antécédents personnels de maladies</h2>\n");
      out.write("                    <div class=\"table-responsive text-nowrap\">\n");
      out.write("\n");
      out.write("                        <table class=\"table\">\n");
      out.write("                            ");

                                PatientMmodel pmm = new PatientMmodel();
                                MaldieModel mm = new MaldieModel();
                                List<PatientM> pml = pmm.listerPatientM(p.getIdPat());
                                if (pml.isEmpty()) {
                                    out.println("Pas de maladies");
                                } else {
                            
      out.write("\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\">Type</th>\n");
      out.write("                                    <th scope=\"col\">Maladie</th>\n");
      out.write("                                    <th scope=\"col\">Age de début</th>\n");
      out.write("                                    <th scope=\"col\">Date de début</th>\n");
      out.write("                                    <th scope=\"col\">Date de fin</th>\n");
      out.write("                                    <th scope=\"col\">Traitement</th>\n");
      out.write("                                    <th scope=\"col\">Arrêt au travail</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
for (int i = 0; i < pml.size(); i++) {
                                    PatientM pm = pml.get(i);
                                    int id_m = pm.getId().getIdM();
                                    Maladie m = mm.listerMaladie(id_m).get(0);
                            
      out.write("\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print(m.getTypeM());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(m.getNomM());
      out.write("</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                            out.println(age);
                                        
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>");
      out.print(pm.getDateDM());
      out.write("</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                            if (pm.getDateFM() == null) {
                                                out.println("....");
                                            } else {
                                                out.println(pm.getDateFM());
                                            }
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>");
      out.print(pm.getTraitement());
      out.write("</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                            if (pm.getArretTrav() == Boolean.TRUE) {
                                                out.println("Oui");
                                            } else {
                                                out.println("Non");
                                            }
                                        
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                            <hr>\n");
      out.write("                    <h2 style=\"margin-bottom: 20px;\">Chirurgies</h2>\n");
      out.write("                    <div class=\"table-responsive text-nowrap\">\n");
      out.write("\n");
      out.write("                        <table class=\"table\">\n");
      out.write("                            ");

                                PatientChModel pcm = new PatientChModel();
                                AntChModel acm = new AntChModel();
                                List<PatientCh> pch = pcm.listerPatientCh(p.getIdPat());
                                if (pch.isEmpty()) {
                                    out.println("Pas de chirurgies");
                                } else {
                            
      out.write("\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\">Chirurgie</th>\n");
      out.write("                                    <th scope=\"col\">Raison</th>\n");
      out.write("                                    <th scope=\"col\">Date</th>\n");
      out.write("                                    <th scope=\"col\">Hôpital</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
for (int i = 0; i < pch.size(); i++) {
                                    PatientCh pc = pch.get(i);
                                    int id_ch = pc.getId().getIdCh();
                                    AntecedentChirurgical ac = acm.listerAntCh(id_ch).get(0);
                            
      out.write("\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print(ac.getNomOp());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(pc.getRaison());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(pc.getDateOp());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(pc.getLocal());
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                            <hr>\n");
      out.write("                    <h2 style=\"margin-bottom: 20px;\">Liste des allergies</h2>\n");
      out.write("                    <div class=\"table-responsive text-nowrap\">\n");
      out.write("\n");
      out.write("                        <table class=\"table\">\n");
      out.write("                            ");

                                PatientAlModel plm = new PatientAlModel();
                                AllergieModel alm = new AllergieModel();
                                List<PatientAl> pal = plm.listerPatientAl(p.getIdPat());
                                if (pal.isEmpty()) {
                                    out.println("Pas d'allergies");
                                } else {
                            
      out.write("\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\">Médicament ou produit</th>\n");
      out.write("                                    <th scope=\"col\">Date de début</th>\n");
      out.write("                                    <th scope=\"col\">Type de réaction</th>\n");
      out.write("                                    <th scope=\"col\">Etat de réaction</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
for (int i = 0; i < pal.size(); i++) {
                                    PatientAl pl = pal.get(i);
                                    int id_al = pl.getId().getIdAl();
                                    Allergie al = alm.listerAllergie(id_al).get(0);
                            
      out.write("\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print(al.getProduitAl());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(pl.getDateDAl());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(pl.getTypeReact());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(pl.getEtatReact());
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                            <hr>\n");
      out.write("                            <h2>Informations supplémentaires</h2>\n");
      out.write("                            <div>\n");
      out.write("                                <h3>Habitudes de vie</h3>\n");
      out.write("                                Tabac : <select>\n");
      out.write("                                    <option>Rien</option>\n");
      out.write("                                    <option>Cigarette</option>\n");
      out.write("                                </select>\n");
      out.write("                                <br>\n");
      out.write("                                Act ph  :<select>\n");
      out.write("                                    <option></option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div style=\"text-align: center;margin-bottom: 30px;margin-top: 30px;\">\n");
      out.write("                <button type=\"button\" id=\"print\" class=\"btn btn-danger\">Télécharger</button>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"js/javascript.js\" ></script>\n");
      out.write("        <script src=\"js/jquery.js\" ></script>\n");
      out.write("        <script src=\"js/printThis.js\" ></script>\n");
      out.write("        <script>\n");
      out.write("            $('#print').click(function () {\n");
      out.write("                $('.container').printThis();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        ");
            } else
                this.getServletContext().getRequestDispatcher("/loginPatient.jsp").forward(request, response);
        
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
