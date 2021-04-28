<%-- 
    Document   : index
    Created on : 22 avr. 2021, 01:10:57
    Author     : JORD DJR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="com.connection.Maconnection" %>

<%
    
    try{
    if (request.getParameter("submit")!=null)
    {
        String nom      = request.getParameter("fname");
        String id       = request.getParameter("fid");
        String fonction = request.getParameter("ffonction");
        PreparedStatement pst;
       
        Connection conn = Maconnection.Connect();
        pst = conn.prepareStatement("Insert into personne values(?,?)");
        pst.setString(1, id);
        pst.setString(2, nom);
        pst.executeUpdate();
        pst = conn.prepareStatement("Insert into fonction values(?,?) ");
        pst.setString(1, fonction);
        pst.setString(2, id);
        pst.executeUpdate();
        conn.close();
    } }
    catch(Exception e)
            {
            out.print(e);
            }
%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP Page</title>
    
<link rel="stylesheet" href="styles.css"/>
</head>
<body>

<h3>FORMULAIRE</h3>

<div class="container">
<table>
<tr>
<td>
        <form action="#" method="POST" >
          <label>NOM</label>
          <input type="text" id="fname" name="fname" placeholder="votre nom.." required>

          <label>ID</label>
          <input type="text" id="fid" name="fid" placeholder="votre identifiant.." required>

          <label>Fonction</label>
          <select id="ffonction" name="ffonction">
            <option value="FRONT">FRONT</option>
            <option value="BACK">BACK</option>
            <option value="FULLSTACK">FULLSTACK</option>
          </select>

          <input type="submit" value="submit" name="submit" id="submit">
        </form>
 </td>
 <td>
        <table width="100%" cellpadding="5pt" border ="1pt">
          <tr>
            <th>NOM</th>
            <th>ID</th>
            <th>FONCTION</th>
            <th></th>   
          </tr>
          <%
          try{
          
          Connection conn = Maconnection.Connect();
          String query = "select personne.NOMP as NOM , personne.IDP as ID, fonction.NomF as FONCTION from personne inner join fonction on personne.IDP = fonction.IDP order by fonction.IDP asc ";
           PreparedStatement state = conn.prepareStatement(query);
          ResultSet result = state.executeQuery();
          
            while(result.next()){
                String id = result.getString("ID");
              %>
          
          
         
          
          <tr>
              <td><%=result.getString("NOM")%></td>
            <td><%=result.getString("ID")%></td>
            <td><%=result.getString("FONCTION")%></td>
            <td>
                [<a href="editpersonne.jsp?id=<%=id%>">MODIFIER</a>]
                                &nbsp;
                [<a href="deletepersonne.jsp?id=<%=id%>">SUPPRIMER</a>]
            </td>
          </tr> 
                  
          <%
              
                    } conn.close();}
          
            catch(Exception e)
            {
            out.print(e);
            }
             
          %>
        </table>
                
         
  </td>
</tr>
  </table>
</div>

</body>

</html>

