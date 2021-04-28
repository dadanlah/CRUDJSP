<%-- 
    Document   : index
    Created on : 22 avr. 2021, 01:10:57
    Author     : JORD DJR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="com.connection.Maconnection" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP Page</title>
    
<link rel="stylesheet" href="styles.css"/>
</head>
<body>

    <%
    
 //  try{
    if (request.getParameter("submit")!=null)
    {
      
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
 
     %>     
           <script>
            
           alert("Mise a jour avec succes avec succes");
           
        </script>
    <%    
     }
    %>
    
<h3>FORMULAIRE</h3>

<div class="container">
    <%
        try{
      Maconnection.Connect();
      String idd = request.getParameter("id");
          Connection conn = Maconnection.Connect();
          String query = "select personne.NOMP as NOM , personne.IDP as ID, fonction.NomF as FONCTION from personne inner join fonction on personne.IDP = fonction.IDP where personne.IDP=?";
           PreparedStatement state = conn.prepareStatement(query);
           
           state.setString(1, idd);
           ResultSet result = state.executeQuery();
          
          
            while(result.next()){
    %>
    
        <form action="#" method="POST" >
          <label>NOM</label>
          <input type="text" id="fname" name="fname" placeholder="votre nom.." value="<%= result.getString("NOM") %>" required>

          <label>ID</label>
          <input type="text" id="fid" name="fid" placeholder="votre identifiant.." value="<%= result.getString("ID") %>" required>

          <label>Fonction</label>
          <select id="ffonction" name="ffonction" >
            <option value="FRONT">FRONT</option>
            <option value="BACK">BACK</option>
            <option value="FULLSTACK">FULLSTACK</option>
          </select>

          <tr><td> <input type="submit" value="MISE A JOUR" name="submit" id="submit"></td>
              <!--<td> <input type="button"  value="GO BACK" onclick="goback()"></td>-->
              <td> <button class="btn info" > <a href="index.jsp"> GO BACK </a></button></td>
          </tr>
        </form>
         
          <%
                    }conn.close();}
                   
    catch(Exception e)
            {
            out.print(e);
            }
          %>
</div>



</body>

</html>

