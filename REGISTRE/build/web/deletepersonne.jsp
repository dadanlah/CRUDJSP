<%-- 
    Document   : deletepersonne
    Created on : 24 avr. 2021, 11:18:46
    Author     : JORD DJR
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connection.Maconnection"%>

        <%
     
     
      String iddd = request.getParameter("id");
      
          Connection conn = Maconnection.Connect();
          String uquery = "Delete from personne where IDP=? ";
           PreparedStatement states = conn.prepareStatement(uquery);
           states.setString(1, iddd);
           states.executeQuery();
          uquery = "Delete from fonction where IDP=? ";
           states = conn.prepareStatement(uquery);
           states.setString(1, iddd);
           states.executeQuery();
           conn.close();
        %>
        <script>
           window.location.assign("index.jsp");
           alert("personne supprimee avec succes");
           
        </script>