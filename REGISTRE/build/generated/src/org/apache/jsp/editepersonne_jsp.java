package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.connection.Maconnection;

public final class editepersonne_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("    \n");
      out.write("<link rel=\"stylesheet\" href=\"styles.css\"/>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h3>FORMULAIRE</h3>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("\n");
      out.write("        <form action=\"#\" method=\"POST\" >\n");
      out.write("          <label>NOM</label>\n");
      out.write("          <input type=\"text\" id=\"fname\" name=\"fname\" placeholder=\"votre nom..\" required>\n");
      out.write("\n");
      out.write("          <label>ID</label>\n");
      out.write("          <input type=\"text\" id=\"fid\" name=\"fid\" placeholder=\"votre identifiant..\" required>\n");
      out.write("\n");
      out.write("          <label>Fonction</label>\n");
      out.write("          <select id=\"ffonction\" name=\"ffonction\">\n");
      out.write("            <option value=\"FRONT\">FRONT</option>\n");
      out.write("            <option value=\"BACK\">BACK</option>\n");
      out.write("            <option value=\"FULSTACK\">FULSTACK</option>\n");
      out.write("          </select>\n");
      out.write("\n");
      out.write("          <input type=\"submit\" value=\"EDIT\" name=\"submit\" id=\"submit\">\n");
      out.write("        </form>\n");
      out.write(" \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
