package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Message</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        Aujourd'huit est : ");

        String jour  = (String) request.getAttribute("jour");
        out.println(jour);
        
      out.write("\n");
      out.write("        \n");
      out.write("        test hfml : ");

        String hfml  = (String) request.getAttribute("hfml");
        out.println(hfml);
        
      out.write("\n");
      out.write("        <form action=\"/E_Medecine/AjoutSpec\" method=\"post\">\n");
      out.write("            spec : <input type=\"text\" name=\"spec\" >\n");
      out.write("            <input type=\"submit\" value=\"ajout\">\n");
      out.write("        </form>\n");
      out.write("        <form action=\"/E_Medecine/TestDate\" method=\"post\">\n");
      out.write("            date : \n");
      out.write("            <input placeholder=\"Date nais\" type=\"date\" id=\"example\" class=\"form-control\" name=\"d\" required=\"\">\n");
      out.write("            <input name=\"hfml\" type=\"time\">\n");
      out.write("            <input type=\"submit\" value=\"Verif\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
