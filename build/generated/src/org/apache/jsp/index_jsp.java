package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Accueil</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"icon\" href=\"img/Logo.png\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background: #2980B9;  /* fallback for old browsers */\n");
      out.write("          background: -webkit-linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9);  /* Chrome 10-25, Safari 5.1-6 */\n");
      out.write("          background: linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n");
      out.write("          \">\n");
      out.write("        ");

            //Récupération de l'objet patient de la session

            if (session.getAttribute("patient") != null) {

            //Envoie vers la espace patient
            this.getServletContext().getRequestDispatcher("/espacePatient.jsp").forward(request, response);
        } else if(session.getAttribute("prof") != null){
        //Envoie vers l'espace docteur
            this.getServletContext().getRequestDispatcher("/espaceDocteur.jsp").forward(request, response);
        }
            else {
        
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
      out.write("\n");
      out.write("        <main>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <h3 style=\"color:#04A4CC; text-align: center;\">Bienvenu dans E-Medecine !</h3><br>\n");
      out.write("            <a href=\"#con\">\n");
      out.write("                <p style=\"text-align: center;\"><button type=\"button\" class=\"btn btn-info\">Connexion / Inscription</button></p>\n");
      out.write("            </a>\n");
      out.write("            <!-- Slide show -->\n");
      out.write("            <article style=\"display: flex; justify-content: center;\">\n");
      out.write("                <div style=\"max-width: 1200px;\" id=\"carouselExampleIndicators\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                    <ol class=\"carousel-indicators\">\n");
      out.write("                        <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                        <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\n");
      out.write("                        <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\n");
      out.write("                    </ol>\n");
      out.write("                    <div class=\"carousel-inner\">\n");
      out.write("                        <div class=\"carousel-item active\">\n");
      out.write("                            <img src=\"img/acc1.jpg\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"carousel-item\">\n");
      out.write("                            <img src=\"img/acc2.jpg\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"carousel-item\">\n");
      out.write("                            <img src=\"img/acc3.jpg\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                        <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                        <span class=\"sr-only\">Previous</span>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\n");
      out.write("                        <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                        <span class=\"sr-only\">Next</span>\n");
      out.write("                    </a>\n");
      out.write("                </div>  \n");
      out.write("            </article>\n");
      out.write("            <!-- Slide show -->\n");
      out.write("            <!--Grid row-->\n");
      out.write("            <div class=\"row\" style=\"margin-top: 30px;\">\n");
      out.write("\n");
      out.write("                <!--Trouver un docteur-->\n");
      out.write("                <div class=\"col-md-6 mb-4\">\n");
      out.write("                    <!-- Card -->\n");
      out.write("                    <div class=\"card gradient-card\">\n");
      out.write("                        <div class=\"card-image\" style=\"background-color: green;\">\n");
      out.write("                            <!-- Content -->\n");
      out.write("                            <a href=\"professionnelSante.jsp\">\n");
      out.write("                                <div class=\"text-white d-flex h-100 mask blue-gradient-rgba\">\n");
      out.write("                                    <div class=\"first-content align-self-center p-3\">\n");
      out.write("                                        <h3 class=\"card-title\">Trouver un docteur</h3>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Content -->\n");
      out.write("                        <div class=\"card-body white\">\n");
      out.write("                            <h4 class=\"text-uppercase font-weight-bold my-4\">Details</h4>\n");
      out.write("                            <p  align=\"justify\">Ici vous pouvez trouver un médecin ou un spécialiste de santé le plus proche de votre région, vous pouvez consulter l'annuaire des professionnels de santé selon les critères que vous choisssez (région, spécialité, nom)</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Card -->\n");
      out.write("                </div>\n");
      out.write("                <!--Trouver un docteur-->\n");
      out.write("\n");
      out.write("                <!--Prendre un rendez-vous-->\n");
      out.write("                <div class=\"col-md-6 mb-4\">\n");
      out.write("                    <!-- Card -->\n");
      out.write("                    <div class=\"card gradient-card\">\n");
      out.write("                        <div class=\"card-image\" style=\"background-color: green;\">\n");
      out.write("                            <!-- Content -->\n");
      out.write("                            <a href=\"Rendezvous.jsp\">\n");
      out.write("                                <div class=\"text-white d-flex h-100 mask purple-gradient-rgba\">\n");
      out.write("                                    <div class=\"first-content align-self-center p-3\">\n");
      out.write("                                        <h3 class=\"card-title\">Prendre un rendez-vous</h3>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Content -->\n");
      out.write("                        <div class=\"card-body white\">\n");
      out.write("                            <h4 class=\"text-uppercase font-weight-bold my-4\">Details</h4>\n");
      out.write("                            <p align=\"justify\">Comme étant un patient vous pouvez  prendre un rendez-vous en ligne gratuitement, en toute rapidité et simplicité. A coté d'avoir un profil médical en ligne pour aider votre docteur à bien comprendre votre situation</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Card -->\n");
      out.write("                </div>\n");
      out.write("                <!--Prendre un rendez-vous-->\n");
      out.write("\n");
      out.write("                <!--Poser question-->\n");
      out.write("                <div class=\"col-md-6 mb-4\">\n");
      out.write("                    <!-- Card -->\n");
      out.write("                    <div class=\"card gradient-card\">\n");
      out.write("                        <div class=\"card-image\" style=\"background-color: green;\">\n");
      out.write("                            <!-- Content -->\n");
      out.write("                            <a href=\"question.jsp\">\n");
      out.write("                                <div class=\"text-white d-flex h-100 mask peach-gradient-rgba\">\n");
      out.write("                                    <div class=\"first-content align-self-center p-3\">\n");
      out.write("                                        <h3 class=\"card-title\">Poser question</h3>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Content -->\n");
      out.write("                        <div class=\"card-body white animated\">\n");
      out.write("                            <h4 class=\"text-uppercase font-weight-bold my-4\">Details</h4>\n");
      out.write("                            <p align=\"justify\">Les patients peuvent poser leurs propres questions de leurs problèmes de façon anonyme et sécurisée et les spécialistes de santé de leurs place les répondent et les guident chaccun selon sa spécialité</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Card -->\n");
      out.write("                </div>\n");
      out.write("                <!--Poser question-->\n");
      out.write("\n");
      out.write("                <!--Chercher un médicament-->\n");
      out.write("                <div class=\"col-md-6 mb-4\">\n");
      out.write("                    <!-- Card -->\n");
      out.write("                    <div class=\"card gradient-card\">\n");
      out.write("                        <div class=\"card-image\" style=\"background-color: green;\">\n");
      out.write("                            <!-- Content -->\n");
      out.write("                            <a href=\"medicament.jsp\">\n");
      out.write("                                <div class=\"text-white d-flex h-100 mask aqua-gradient-rgba\">\n");
      out.write("                                    <div class=\"first-content align-self-center p-3\">\n");
      out.write("                                        <h3 class=\"card-title\">Chercher un médicament</h3>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Content -->\n");
      out.write("                        <div class=\"card-body white\">\n");
      out.write("                            <h4 class=\"text-uppercase font-weight-bold my-4\">Details</h4>\n");
      out.write("                            <p align=\"justify\">Ici on vous donne un éspace ou vous pouvez chercher un médicament que vous avez besoin (par exemple car il n’est pas disponible dans les pharmacies), et au même temps vous pouvez le déposer comme un don</p>\n");
      out.write("                        </div>\n");
      out.write("                        <a name=\"con\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Card -->\n");
      out.write("                </div>\n");
      out.write("                <!--Chercher un médicament-->\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Block connexion / inscription prof et patient-->\n");
      out.write("            <div style=\"margin-bottom: 20px;margin-top: 20px;\">\n");
      out.write("                <article style=\"display: flex; justify-content: center;\">\n");
      out.write("                    <div class=\"card-deck\">\n");
      out.write("                        <!-- Patient -->\n");
      out.write("                        <div class=\"card\" style=\"width: 27rem;\">\n");
      out.write("                            <img src=\"img/patient.jpg\" style=\"height: 250px;\" class=\"card-img-top\" alt=\"...\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h5 class=\"card-title\">Vous êtes un patient ?</h5>\n");
      out.write("                                <p class=\"card-text\">Trouver un docteur de votre choix, prendre un rendez-vous, construire votre profil médical</p>\n");
      out.write("                                <p style=\"text-align: center;\">\n");
      out.write("                                    <a href=\"loginPatient.jsp\" class=\"btn btn-primary\">Se connecter</a>\n");
      out.write("                                    <a href=\"inscriptionPatient.jsp\" class=\"btn btn-primary\">S'inscrire</a>\n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Professionnel de santé -->\n");
      out.write("                        <div class=\"card\" style=\"width: 27rem;\">\n");
      out.write("                            <img src=\"img/docteur.jpg\" style=\"height: 250px;\" class=\"card-img-top\" alt=\"...\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h5 class=\"card-title\">Vous êtes un professionnel de santé ?</h5>\n");
      out.write("                                <p class=\"card-text\">Partager vos horaires et vos coordonnées pour bien faciliter la mise en contact avec vos patients</p>\n");
      out.write("                                <!-- Button -->\n");
      out.write("                                <p style=\"text-align: center;\">\n");
      out.write("                                    <a href=\"loginDocteur.jsp\" class=\"btn btn-primary\">Se connecter</a>\n");
      out.write("                                    <a href=\"inscriptionDocteur.jsp\" class=\"btn btn-primary\">S'inscrire</a>\n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
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
      out.write("                    <a href=\"#con\" class=\"btn btn-danger btn-rounded\">S'inscrire!</a>\n");
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
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"js/javascript.js\" />\n");
      out.write("        <script src=\"js/jquery.js\" />\n");
      out.write("        ");

            }
        
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
