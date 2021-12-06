package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.e_medecine.entities.Patient;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Contact</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"icon\" href=\"img/Logo.png\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body style=\"background: #2980B9;  /* fallback for old browsers */\n");
      out.write("background: -webkit-linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9);  /* Chrome 10-25, Safari 5.1-6 */\n");
      out.write("background: linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n");
      out.write("\">\n");
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
      out.write("                            <a class=\"nav-link\" href=\"Rendezvous.jsp\">Rendez-Vous</a>\n");
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
      out.write("            \n");
      out.write("            <!--Section: Contact v.2-->\n");
      out.write("<section class=\"mb-4\">\n");
      out.write("\n");
      out.write("    <!--Section heading-->\n");
      out.write("    <h2 class=\"h1-responsive font-weight-bold text-center my-4\">Contacter Nous </h2>\n");
      out.write("    <!--Section description-->\n");
      out.write("    <p class=\"text-center w-responsive mx-auto mb-5\">Avez-vous des questions? N'hésitez pas à nous contacter directement. Notre équipe reviendra vers vous au sein de quelque heures pour vous aider.</p>\n");
      out.write("\n");
      out.write("    <div class=\"row\">\n");
      out.write("\n");
      out.write("        <!--Grid column-->\n");
      out.write("        <div class=\"col-md-9 mb-md-0 mb-5\">\n");
      out.write("            <form id=\"contact-form\" name=\"contact-form\" action=\"mail.php\" method=\"POST\">\n");
      out.write("\n");
      out.write("                <!--Grid row-->\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                    <!--Grid column-->\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"md-form mb-0\" style=\"padding-top: 10px !important;\">\n");
      out.write("                            ");

            if (session.getAttribute("patient") != null) {
        
            Patient p = (Patient) session.getAttribute("patient");
        
      out.write("\n");
      out.write("        <input type=\"text\" id=\"name\" placeholder=\"");
      out.print(p.getNomPat());
      out.write("\" name=\"name\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!--Grid column-->\n");
      out.write("\n");
      out.write("                    <!--Grid column-->\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"md-form mb-0\" style=\"padding-top: 10px !important;\">\n");
      out.write("                            <input type=\"text\" id=\"email\" placeholder=\"");
      out.print(p.getPrenomPat());
      out.write("\" name=\"email\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!--Grid column-->\n");
      out.write("        ");

        }
else{
        
      out.write("\n");
      out.write("                            <input type=\"text\" id=\"name\" placeholder=\"Votre nom\" name=\"name\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!--Grid column-->\n");
      out.write("\n");
      out.write("                    <!--Grid column-->\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"md-form mb-0\" style=\"padding-top: 10px !important;\">\n");
      out.write("                            <input type=\"text\" id=\"email\" placeholder=\"Votre email\" name=\"email\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!--Grid column-->\n");

}

      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!--Grid row-->\n");
      out.write("\n");
      out.write("                <!--Grid row-->\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"md-form mb-0\" style=\"margin-top: 10px !important;\">\n");
      out.write("                            <input type=\"text\" id=\"subject\" placeholder=\"Sujet\" name=\"subject\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!--Grid row-->\n");
      out.write("\n");
      out.write("                <!--Grid row-->\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                    <!--Grid column-->\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("                        <div class=\"md-form\" style=\"margin-top: 10px !important;\">\n");
      out.write("                            <textarea type=\"text\" id=\"message\" placeholder=\"Votre message\" name=\"message\" rows=\"2\" class=\"form-control md-textarea\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!--Grid row-->\n");
      out.write("                <div class=\"text-center\" style=\"margin-top: 10px !important;\">\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-primary\" value=\"Send\"/>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <div class=\"status\"></div>\n");
      out.write("        </div>\n");
      out.write("        <!--Grid column-->\n");
      out.write("\n");
      out.write("        <!--Grid column-->\n");
      out.write("        <div class=\"col-md-3 text-center\">\n");
      out.write("            <ul class=\"list-unstyled mb-0\">\n");
      out.write("\n");
      out.write("                <li><i class=\"fas fa-phone mt-4 fa-2x\"></i>\n");
      out.write("                    <p>+ 01 234 567 89</p>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li><i class=\"fas fa-envelope mt-4 fa-2x\"></i>\n");
      out.write("                    <p>contact@E-Medecine.com</p>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <!--Grid column-->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</section>\n");
      out.write("<!--Section: Contact v.2-->\n");
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
      out.write("                    <a href=\"#!\" class=\"btn btn-danger btn-rounded\">S'inscrire!</a>\n");
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
      out.write("    <script src=\"js/javascript.js\"> </script>\n");
      out.write("    <script src=\"js/jquery.js\"></script>\n");
      out.write("    <script src=\"js/printThis.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        $('#print').click(function(){\n");
      out.write("            $('.container').printThis({\n");
      out.write("                debug: false,               // show the iframe for debugging\n");
      out.write("                importCSS: true,            // import parent page css\n");
      out.write("                importStyle: false,         // import style tags\n");
      out.write("                 printContainer: true,       // print outer container/$.selector\n");
      out.write("                loadCSS: \"http://localhost:8080/E_Medecine/\",                // path to additional css file - use an array [] for multiple\n");
      out.write("                pageTitle: \"Mon contact\",              // add title to print page\n");
      out.write("                removeInline: false,        // remove inline styles from print elements\n");
      out.write("                removeInlineSelector: \"*\",  // custom selectors to filter inline styles. removeInline must be true\n");
      out.write("                printDelay: 333,            // variable print delay\n");
      out.write("             header: \"<h1>Mon contact</h1>\",               // prefix to html\n");
      out.write("                 footer: null,               // postfix to html\n");
      out.write("             base: false,                // preserve the BASE tag or accept a string for the URL\n");
      out.write("                 formValues: true,           // preserve input/form values\n");
      out.write("         canvas: false,              // copy canvas content\n");
      out.write("             doctypeString: '<!DOCTYPE html>', // enter a different doctype for older markup\n");
      out.write("        removeScripts: false,       // remove script tags from print content\n");
      out.write("        copyTagClasses: false,      // copy classes from the html & body tag\n");
      out.write("        beforePrintEvent: null,     // callback function for printEvent in iframe\n");
      out.write("        beforePrint: null,          // function called before iframe is filled\n");
      out.write("        afterPrint: null            // function called before iframe is removed\n");
      out.write("            });\n");
      out.write("        } );\n");
      out.write("    </script>\n");
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
