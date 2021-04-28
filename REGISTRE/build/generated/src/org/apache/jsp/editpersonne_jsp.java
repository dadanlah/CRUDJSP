package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.connection.Maconnection;

public final class editpersonne_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    ");

    
 //  try{
    if (request.getParameter("submit")!=null)
    {
      Maconnection.Connect();
      String fonction = request.getParameter("ffonction");
      String iddd = request.getParameter("id");
      
          Connection connn = Maconnection.Connect();
          String uquery = "UPDATE fonction set NOMF=?"+" where IDP=? ";
           PreparedStatement states = connn.prepareStatement(uquery);
           states.setString(1,fonction);
           states.setString(2, iddd);
           states.executeQuery();
          uquery = "UPDATE personne set NOMP=?"+" where IDP=? ";
          fonction = request.getParameter("fname");
           states = connn.prepareStatement(uquery);
           states.setString(1,fonction);
           states.setString(2, iddd);
           states.executeQuery();
          uquery = "UPDATE fonction set IDP=?"+" where IDP=? ";
          fonction = request.getParameter("fid");
           states = connn.prepareStatement(uquery);
           states.setString(1,fonction);
           states.setString(2, iddd);
           states.executeQuery();
 
     
      out.write("     \n");
      out.write("           <script>\n");
      out.write("            \n");
      out.write("           alert(\"Mise a jour avec succes avec succes\");\n");
      out.write("           \n");
      out.write("        </script>\n");
      out.write("    ");
    
     }
    
      out.write("\n");
      out.write("    \n");
      out.write("<h3>FORMULAIRE</h3>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    ");

        try{
      Maconnection.Connect();
      String idd = request.getParameter("id");
          Connection conn = Maconnection.Connect();
          String query = "select personne.NOMP as NOM , personne.IDP as ID, fonction.NomF as FONCTION from personne inner join fonction on personne.IDP = fonction.IDP where personne.IDP=?";
           PreparedStatement state = conn.prepareStatement(query);
           
           state.setString(1, idd);
           ResultSet result = state.executeQuery();
          
          
            while(result.next()){
    
      out.write("\n");
      out.write("    \n");
      out.write("        <form action=\"#\" method=\"POST\" >\n");
      out.write("          <label>NOM</label>\n");
      out.write("          <input type=\"text\" id=\"fname\" name=\"fname\" placeholder=\"votre nom..\" value=\"");
      out.print( result.getString("NOM") );
      out.write("\" required>\n");
      out.write("\n");
      out.write("          <label>ID</label>\n");
      out.write("          <input type=\"text\" id=\"fid\" name=\"fid\" placeholder=\"votre identifiant..\" value=\"");
      out.print( result.getString("ID") );
      out.write("\" required>\n");
      out.write("\n");
      out.write("          <label>Fonction</label>\n");
      out.write("          <select id=\"ffonction\" name=\"ffonction\" >\n");
      out.write("            <option value=\"FRONT\">FRONT</option>\n");
      out.write("            <option value=\"BACK\">BACK</option>\n");
      out.write("            <option value=\"FULLSTACK\">FULLSTACK</option>\n");
      out.write("          </select>\n");
      out.write("\n");
      out.write("          <tr><td> <input type=\"submit\" value=\"MISE A JOUR\" name=\"submit\" id=\"submit\"></td>\n");
      out.write("              <td> <button class=\"btn info\" ><a href=\"index.jsp\">GO BACK</a></button></td>\n");
      out.write("          </tr>\n");
      out.write("        </form>\n");
      out.write("         \n");
      out.write("          ");

                    }conn.close();}
                   
    catch(Exception e)
            {
            out.print(e);
            }
          
      out.write("\n");
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
