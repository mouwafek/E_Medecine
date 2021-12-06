package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.e_medecine.entities.Specialite;
import java.util.List;
import com.e_medecine.beans.SpecialiteModel;

public final class inscriptionDocteur_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Inscription docteur</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"icon\" href=\"img/logo1.png\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background: #00C9FF;  /* fallback for old browsers */\n");
      out.write("          background: -webkit-linear-gradient(to right, #92FE9D, #00C9FF);  /* Chrome 10-25, Safari 5.1-6 */\n");
      out.write("          background: linear-gradient(to right, #92FE9D, #00C9FF); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n");
      out.write("          \">\n");
      out.write("        <header style=\"z-index: 1000; position: fixed; width: 100%;\">\n");
      out.write("            <nav id=\"navbarmed\" class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.jsp\">\n");
      out.write("                    <img src=\"img/logo1.png\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n");
      out.write("                    <strong>E-Medecine</strong>\n");
      out.write("                </a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("                <div style=\"justify-content: flex-end;\" class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item active\" style=\"color : white; important;\">\n");
      out.write("                            <a class=\"nav-link\" href=\"index.jsp\">Accueil<span class=\"sr-only\">(current)</span></a>\n");
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
      out.write("            <br>\n");
      out.write("            ");
  /*Récupération des messages d'erreurs en cas d'existance des memes 
                données d'un autre prof ou cabinet*/
                String mes = (String) request.getAttribute("m");
                if (mes == null)
                    out.println("");
                else {
      out.write("\n");
      out.write("            <p style=\"background-color:red; text-align: center;\">");
out.println(mes);
                }
      out.write("</p>\n");
      out.write("                ");
 String cab = (String) request.getAttribute("cab");
                    if (cab == null)
                        out.println("");
                    else {
      out.write("\n");
      out.write("            <p style=\"background-color:red; text-align: center;\">");
out.println(cab);
                }
      out.write("</p>\n");
      out.write("            \n");
      out.write("            ");
 //Message d'erreur en cas de faut horaire 
                String lner = (String) request.getAttribute("lner");
                    if (lner == null)
                        out.println("");
                    else {
      out.write("\n");
      out.write("            <p style=\"background-color:red; text-align: center;\">");
out.println(lner);
                }
      out.write("</p>\n");
      out.write("            <!-- Formulaire d'infos cabinet-->\n");
      out.write("            <div style=\"margin-bottom: 20px;margin-top: 20px;\">\n");
      out.write("                <article style=\"display: flex; justify-content: center;margin-left: 20px;margin-right: 20px;\">\n");
      out.write("                    <div class=\"form\" style=\"width: 60rem;background-color: white;padding-left: 15px;padding-right: 15px;border-radius: 10px;\">\n");
      out.write("                        <form method=\"post\" action=\"/E_Medecine/InscriptionProf\" enctype=\"multipart/form-data\">\n");
      out.write("                            <h2 style=\"text-align: center;margin-top: 20px;\">Informations du cabinet</h2>\n");
      out.write("                            Gouvernorat :\n");
      out.write("                            <div class=\"input-group mb-3\">\n");
      out.write("                                <select name=\"gouv\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                    <option selected></option>\n");
      out.write("                                    <option>Ariana</option>\n");
      out.write("                                    <option>Béja</option>\n");
      out.write("                                    <option>Ben Arous</option>\n");
      out.write("                                    <option>Bizerte</option>\n");
      out.write("                                    <option>Gabès</option>\n");
      out.write("                                    <option>Gafsa</option>\n");
      out.write("                                    <option>Jendouba</option>\n");
      out.write("                                    <option>Kairouan</option>\n");
      out.write("                                    <option>Kasserine</option>\n");
      out.write("                                    <option>Kébili</option>\n");
      out.write("                                    <option>Le Kef</option>\n");
      out.write("                                    <option>Mahdia</option>\n");
      out.write("                                    <option>Manouba</option>\n");
      out.write("                                    <option>Médenine</option>\n");
      out.write("                                    <option>Monastir</option>\n");
      out.write("                                    <option>Nabeul</option>\n");
      out.write("                                    <option>Sfax</option>\n");
      out.write("                                    <option>Sidi Bouzid</option>\n");
      out.write("                                    <option>Siliana</option>\n");
      out.write("                                    <option>Sousse</option>\n");
      out.write("                                    <option>Tataouine</option>\n");
      out.write("                                    <option>Tozeur</option>\n");
      out.write("                                    <option>Tunis</option>\n");
      out.write("                                    <option>Zaghouan</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            Délégation :\n");
      out.write("                            <input type=\"text\"  class=\"form-control\" name=\"del\" required=\"\">\n");
      out.write("                            Adresse complète :\n");
      out.write("                            <textarea name=\"adcab\" class=\"form-control\" required=\"\"></textarea>\n");
      out.write("                            Téléphone fixe :\n");
      out.write("                            <input type=\"text\"  class=\"form-control\" name=\"telf\" required=\"\">\n");
      out.write("                            Description :\n");
      out.write("                            <textarea name=\"desc\" class=\"form-control\" required=\"\"></textarea>\n");
      out.write("                            Jours de travail : <br>\n");
      out.write("                            <table border=\"3\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Jour</td>\n");
      out.write("                                    <td>Lundi</td>\n");
      out.write("                                    <td>Mardi</td>\n");
      out.write("                                    <td>Mercredi</td>\n");
      out.write("                                    <td>Jeudi</td>\n");
      out.write("                                    <td>Vendredi</td>\n");
      out.write("                                    <td>Samedi</td>\n");
      out.write("                                    <td>Dimanche</td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Disponibilité</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"dispLundi\">\n");
      out.write("                                            <option selected=\"\">Fermé</option>\n");
      out.write("                                            <option>Ouvert</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"dispMardi\">\n");
      out.write("                                            <option selected=\"\">Fermé</option>\n");
      out.write("                                            <option>Ouvert</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"dispMercredi\">\n");
      out.write("                                             <option selected=\"\">Fermé</option>\n");
      out.write("                                            <option>Ouvert</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"dispJeudi\">\n");
      out.write("                                             <option selected=\"\">Fermé</option>\n");
      out.write("                                            <option>Ouvert</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"dispVendredi\">\n");
      out.write("                                             <option selected=\"\">Fermé</option>\n");
      out.write("                                            <option>Ouvert</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"dispSamedi\">\n");
      out.write("                                             <option selected=\"\">Fermé</option>\n");
      out.write("                                            <option>Ouvert</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"dispDimanche\">\n");
      out.write("                                             <option selected=\"\">Fermé</option>\n");
      out.write("                                            <option>Ouvert</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                            </table>\n");
      out.write("                            Prix par visite en dinar :\n");
      out.write("                            <input type=\"text\"  class=\"form-control\" name=\"prix\" required=\"\">\n");
      out.write("                            Acceptez-vous le paiment par carte bancaire? :\n");
      out.write("                            <div class=\"input-group mb-3\">\n");
      out.write("                                <select name=\"cb\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                    <option selected></option>\n");
      out.write("                                    <option>Oui</option>\n");
      out.write("                                    <option>Non</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("            </div>\n");
      out.write("            <!-- Formulaire d'infos professionnel de santé-->\n");
      out.write("            <div style=\"margin-bottom: 20px;margin-top: 20px;\">\n");
      out.write("                <article style=\"display: flex; justify-content: center;margin-left: 20px;margin-right: 20px;\">\n");
      out.write("                    <div class=\"form\" style=\"width: 70rem;background-color: white;padding-left: 15px;padding-right: 15px;border-radius: 10px;\">\n");
      out.write("                        <h2 style=\"text-align: center;margin-top: 20px;\">Informations personnelles</h2>\n");
      out.write("                        Nom :\n");
      out.write("                        <input type=\"text\" id=\"exampleForm2\" class=\"form-control\" name=\"nom\" required=\"\">\n");
      out.write("                        Prénom :\n");
      out.write("                        <input type=\"text\" id=\"exampleForm2\" class=\"form-control\" name=\"pren\" required=\"\">\n");
      out.write("                        Email :\n");
      out.write("                        <input type=\"email\" id=\"exampleForm2\" class=\"form-control\" name=\"mail\" required=\"\">\n");
      out.write("                        Mot de passe :\n");
      out.write("                        <input type=\"password\" id=\"exampleForm2\" class=\"form-control\" name=\"pass\" required=\"\">\n");
      out.write("                        Date de naissance : \n");
      out.write("                        <input placeholder=\"Date nais\" type=\"date\" id=\"example\" class=\"form-control\" name=\"dnais\" required=\"\">\n");
      out.write("                        Genre :\n");
      out.write("                        <div class=\"input-group mb-3\">\n");
      out.write("                            <select name=\"genre\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                <option selected></option>\n");
      out.write("                                <option>Male</option>\n");
      out.write("                                <option>Femelle</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        Adresse physisque :\n");
      out.write("                        <textarea name=\"adrsph\" class=\"form-control\" required=\"\"></textarea>\n");
      out.write("                        Téléphone mobile :\n");
      out.write("                        <input type=\"text\" id=\"exampleForm2\" class=\"form-control\" name=\"tel\" required=\"\">\n");
      out.write("                        Spécialité :\n");
      out.write("                        <div class=\"input-group mb-3\">\n");
      out.write("                            <select name=\"spec\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                <option selected></option>\n");
      out.write("                                ");

                                    SpecialiteModel sm = new SpecialiteModel();
                                    List<Specialite> ls = sm.listerSpecialite();
                                    for (int i = 0; i < ls.size(); i++) {
                                
      out.write("\n");
      out.write("                                <option>");
      out.print(ls.get(i).getNomSpec());
      out.write("</option>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        Diplome(s) et expériences :\n");
      out.write("                        <textarea name=\"dip\" class=\"form-control\" required=\"\"></textarea>\n");
      out.write("                        Photo d'identité :\n");
      out.write("                        <input type=\"file\" name=\"ident\" class=\"form-control\" required=\"\">\n");
      out.write("                        Vous faites des visites à domicile aux patients?\n");
      out.write("                        <div class=\"input-group mb-3\">\n");
      out.write("                            <select name=\"vdom\" class=\"custom-select\" id=\"inputGroupSelect01\" required=\"\">\n");
      out.write("                                <option selected></option>\n");
      out.write("                                <option>Oui</option>\n");
      out.write("                                <option>Non</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <p style=\"text-align: center;\">\n");
      out.write("                            <input type=\"submit\" value=\"S'inscrire\" class=\"btn btn-primary\" style=\"margin-top: 20px;\">\n");
      out.write("                        </p>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </article>\n");
      out.write("            </div>\n");
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
      out.write("    </script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"js/javascript.js\" />\n");
      out.write("    <script src=\"js/jquery.js\" />\n");
      out.write("</body>\n");
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
