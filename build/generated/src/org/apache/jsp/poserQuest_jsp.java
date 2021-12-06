package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.e_medecine.entities.Specialite;
import java.util.List;
import java.util.List;
import com.e_medecine.beans.SpecialiteModel;
import com.e_medecine.entities.Question;
import com.e_medecine.entities.Patient;

public final class poserQuest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Poser des questions</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"icon\" href=\"img/Logo.png\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background: #abbaab;  /* fallback for old browsers */\n");
      out.write("          background: -webkit-linear-gradient(to right, #ffffff, #abbaab);  /* Chrome 10-25, Safari 5.1-6 */\n");
      out.write("          background: linear-gradient(to right, #ffffff, #abbaab); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n");
      out.write("          \">\n");
      out.write("        ");

            //Test d'exixstance de l'objet patient dans la session
            if (session.getAttribute("patient") != null) {
        
      out.write("\n");
      out.write("        ");

            //Récupération de l'objet patient
            Patient p = (Patient) session.getAttribute("patient");
        
      out.write("\n");
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
      out.write("                        <li>\n");
      out.write("                            <a href=\"Rendezvous.jsp\">Rendez-Vous</a>\n");
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
      out.write("        <main>  \n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            ");

                //Récupération et Test d'existance de l'objet question
                //(En cas de modification)
                Question q = (Question) request.getAttribute("q");
                //Pas d'objet question envoyé depuis la servlet modifier ==> Ajout
                if (q == null) {
            
      out.write("\n");
      out.write("            <div style=\"text-align: center;\">\n");
      out.write("                <em><h2>Poser votre ici en spécifiant la catégorie, la question d'une façon détaillée,\n");
      out.write("                        et n'oubliant pas de mentionner votre poid et taille si vous n'avez pas les rempli\n");
      out.write("                        dans la section \"Profil médical\"</h2></em>\n");
      out.write("            </div>\n");
      out.write("            <!--Block d'ajout de question-->\n");
      out.write("            <form method=\"post\" action=\"/E_Medecine/AjoutQuest\">\n");
      out.write("                <article style=\"display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;\">\n");
      out.write("                    <div class=\"card\" style=\"margin-bottom: 25px;width: 40rem;background-color: #83a4d4;\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <p class=\"card-title\">Catégorie :</p>\n");
      out.write("                            <div class=\"input-group mb-3\">\n");
      out.write("                                <select name=\"cat\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                    <option selected></option>\n");
      out.write("                                    ");

                                        SpecialiteModel sm = new SpecialiteModel();
                                        List<Specialite> ls = sm.listerSpecialite();
                                    for(int i = 0;i<ls.size();i++ ){
                                    
      out.write("\n");
      out.write("                                    <option>");
      out.print(ls.get(i).getNomSpec());
      out.write("</option>\n");
      out.write("                                  <!--  <option>Médecine dentaire</option>\n");
      out.write("                                    <option>Médecine esthétique</option>\n");
      out.write("                                    <option>Cardiologie</option>\n");
      out.write("                                    <option>Dermatologie</option>\n");
      out.write("                                    <option>Endocrrinologie - Diabétologie</option>\n");
      out.write("                                    <option>Gynécologie</option>\n");
      out.write("                                    <option>Ophtalmologie</option>\n");
      out.write("                                    <option>Traumatologie</option>\n");
      out.write("                                    <option>Pédiatrie</option>\n");
      out.write("                                    <option>Psychiatrie</option>\n");
      out.write("                                    <option>Sexologie</option>\n");
      out.write("                                    <option>Gastro-entérologue</option>\n");
      out.write("                                    <option>Carcinologie</option>\n");
      out.write("                                    <option>Urologie</option>\n");
      out.write("                                    <option>Autre</option>\n");
      out.write("                                    <option>Hématologie</option>\n");
      out.write("                                    <option>Neurologie</option>\n");
      out.write("                                    <option>Nutrition</option>\n");
      out.write("                                    <option>Rhumatologie</option>\n");
      out.write("                                    <option>Néphrologie</option>\n");
      out.write("                                    <option>Pédopsychiatrie</option>\n");
      out.write("                                    <option>Orthophonie</option>\n");
      out.write("                                    <option>Pneumologie</option>\n");
      out.write("                                    <option>Angiologie</option>\n");
      out.write("                                    <option>Kinésithérapie</option>\n");
      out.write("                                    <option>Podologie</option>-->\n");
      out.write("                                  ");
}
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("\n");
      out.write("                <article style=\"display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;\">\n");
      out.write("                    <div class=\"card\" style=\"margin-bottom: 25px;width: 40rem;height: 20rem;background-color: #2BBBAD;\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <p class=\"card-title\">Question :</p>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <textarea name=\"quest\" style=\"height: 12rem;\"class=\"form-control rounded-0\" id=\"exampleFormControlTextarea2\" rows=\"3\" placeholder=\"Ecrire votre question\" required=\"\"></textarea>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("                <article style=\"display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;\">\n");
      out.write("                    <div class=\"card\" style=\"margin-bottom: 25px;width: 40rem;height: 15rem;background-color: #2BBBAD;\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <p>Taille en cm:</p>\n");
      out.write("                            ");

                                if (p.getAge() == null) {
                            
      out.write("\n");
      out.write("                            <input name=\"taille\" type=\"text\" maxlength=\"3\" class=\"form-control\" placeholder=\"Taille en cm\" required=\"\">\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                            <input name=\"taille\" value=\"");
      out.print(p.getAge());
      out.write("\" type=\"text\" class=\"form-control\" disabled=\"\">\n");
      out.write("                            ");

                    }
      out.write("\n");
      out.write("                            <p style=\"margin-top: 15px;\">Poid en Kg :</p>\n");
      out.write("                            ");

                                if (p.getPoid() == null) {
                            
      out.write("\n");
      out.write("                            <input name=\"poid\" type=\"text\" maxlength=\"3\" class=\"form-control\" placeholder=\"Poid en Kg\" required=\"\">\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                            <input name=\"poid\" value=\"");
      out.print(p.getPoid());
      out.write("\" type=\"text\" class=\"form-control\" disabled=\"\">\n");
      out.write("                            ");

                    }
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("                <article style=\"display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;\">\n");
      out.write("                    <!-- Send button -->\n");
      out.write("                    <button style=\"width: 40rem;margin-bottom: 40px;\" class=\"btn btn-info btn-block\" type=\"submit\">Envoyer</button>\n");
      out.write("                </article>\n");
      out.write("            </form>\n");
      out.write("            ");

            } 
                //S'il existe un objet question envoyé depuis servlet de modification ==> Modification
                else {
            
      out.write("\n");
      out.write("            <!--Meme block avec les données à modifier-->\n");
      out.write("            <div style=\"text-align: center;\">\n");
      out.write("                <em><h2>Vous voulez modifier votre question ?</h2></em>\n");
      out.write("            </div>\n");
      out.write("            <form method=\"post\" action=\"/E_Medecine/AjoutQuest\">\n");
      out.write("                <article style=\"display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;\">\n");
      out.write("                    <div class=\"card\" style=\"margin-bottom: 25px;width: 40rem;background-color: #83a4d4;\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <p class=\"card-title\">Catégorie :</p>\n");
      out.write("                            <input name=\"cat\" list=\"cat\" type=\"text\" value=\"");
      out.print(q.getCategorie());
      out.write("\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("\n");
      out.write("                <article style=\"display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;\">\n");
      out.write("                    <div class=\"card\" style=\"margin-bottom: 25px;width: 40rem;height: 20rem;background-color: #2BBBAD;\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <p class=\"card-title\">Question :</p>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <textarea name=\"quest\" style=\"height: 12rem;\"class=\"form-control rounded-0\" id=\"exampleFormControlTextarea2\" rows=\"3\" required=\"\">");
      out.print(q.getQuestion());
      out.write("</textarea>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("                <article style=\"display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;\">\n");
      out.write("                    <div class=\"card\" style=\"margin-bottom: 25px;width: 40rem;height: 15rem;background-color: #2BBBAD;\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <p>Taille en cm:</p>\n");
      out.write("                            ");

                                if (p.getAge() == null) {
                            
      out.write("\n");
      out.write("                            <input name=\"taille\" type=\"text\" maxlength=\"3\" class=\"form-control\" placeholder=\"Taille en cm\" required=\"\">\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                            <input name=\"taille\" value=\"");
      out.print(p.getAge());
      out.write("\" type=\"text\" class=\"form-control\" disabled=\"\">\n");
      out.write("                            ");

                    }
      out.write("\n");
      out.write("                            <p style=\"margin-top: 15px;\">Poid en Kg :</p>\n");
      out.write("                            ");

                                if (p.getPoid() == null) {
                            
      out.write("\n");
      out.write("                            <input name=\"poid\" type=\"text\" maxlength=\"3\" class=\"form-control\" placeholder=\"Poid en Kg\" required=\"\">\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                            <input name=\"poid\" value=\"");
      out.print(p.getPoid());
      out.write("\" type=\"text\" class=\"form-control\" disabled=\"\">\n");
      out.write("                            ");

                    }
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("                <input type=\"text\" name=\"id\" value=\"");
      out.print(q.getIdQ().toString());
      out.write("\" style=\"display: none;\">\n");
      out.write("                <article style=\"display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;\">\n");
      out.write("                    <!-- Send button -->\n");
      out.write("                    <button style=\"width: 40rem;margin-bottom: 40px;\" class=\"btn btn-info btn-block\" type=\"submit\">Modifier</button>\n");
      out.write("                </article>\n");
      out.write("            </form>\n");
      out.write("            ");

                        }
      out.write("\n");
      out.write("        </main>\n");
      out.write("        <!-- Footer -->\n");
      out.write("        <footer class=\"page-footer font-small stylish-color-dark pt-4 bg-dark\">\n");
      out.write("\n");
      out.write("            <!-- Footer Links -->\n");
      out.write("            <div class=\"container text-center text-md-left\">\n");
      out.write("\n");
      out.write("                <!-- Grid row -->\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                    <!-- Grid column -->\n");
      out.write("                    <div class=\"col-md-4 mx-auto\">\n");
      out.write("\n");
      out.write("                        <!-- Content -->\n");
      out.write("                        <h5 class=\"font-weight-bold text-uppercase mt-3 mb-4\" style=\"color:white !important;\">E-Medecine</h5>\n");
      out.write("                        <p style=\"color:white !important;\">Faites vos actes maintenant! \n");
      out.write("                            Bénéficier des meilleures services!</p>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Grid column -->\n");
      out.write("\n");
      out.write("                    <hr class=\"clearfix w-100 d-md-none\">\n");
      out.write("\n");
      out.write("                    <!-- Grid column -->\n");
      out.write("                    <div class=\"col-md-2 mx-auto\">\n");
      out.write("\n");
      out.write("                        <!-- Links -->\n");
      out.write("                        <h5 class=\"font-weight-bold text-uppercase mt-3 mb-4\" style=\"color:white !important;\">Liens</h5>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"professionnelSante.jsp\">Professionnel de santé</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"Rendezvous.jsp\">Rendez-Vous</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"medicament.jsp\">Médicaments</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"question.jsp\">Qestions</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"contact.jsp\">Contact</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!-- Grid column -->\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- Grid row -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- Footer Links -->\n");
      out.write("\n");
      out.write("            <hr>\n");
      out.write("\n");
      out.write("            <!-- Call to action -->\n");
      out.write("            <ul class=\"list-unstyled list-inline text-center py-2\">\n");
      out.write("                <li class=\"list-inline-item\">\n");
      out.write("                    <h5 style=\"color:white !important;\" class=\"mb-1\">Enregistrer gratuitement</h5>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"list-inline-item\">\n");
      out.write("                    <a href=\"index.jsp\" class=\"btn btn-danger btn-rounded\">S'inscrire!</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("            <!-- Call to action -->\n");
      out.write("\n");
      out.write("            <!-- Copyright -->\n");
      out.write("            <div class=\"footer-copyright text-center py-3\" style=\"color:white !important;\">© 2020 Copyright:\n");
      out.write("                <a href=\"index.jsp\"> E-Medecine.com</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- Copyright -->\n");
      out.write("\n");
      out.write("        </footer>\n");
      out.write("        <!-- Footer -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"js/javascript.js\" ></script>\n");
      out.write("        <script src=\"js/jquery.js\" ></script>\n");
      out.write("        <script>\n");
      out.write("            // Material Select Initialization\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('.mdb-select').materialSelect();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        ");

            } else
                //response.sendRedirect("/loginPatient.jsp");
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
