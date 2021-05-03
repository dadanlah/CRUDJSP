<%-- 
    Document   : index
    Created on : 22 avr. 2021, 01:10:57
    Author     : JORD DJR
--%>

<%@page import="com.dao.DAO"%>
<%@page import="com.bean.personne"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.fonction.implement.PersonneDAO"%>
<%@page import="com.fonction.implement.PersonneDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="com.connection.Maconnection" %>

<%
    
    
    if (request.getParameter("submit")!=null)
    {
        DAO<personne> personnedao = new PersonneDAO(Maconnection.Connect());
        personne personne0 = new personne(Integer.valueOf(request.getParameter("fid")),request.getParameter("fname"),request.getParameter("ffonction"));
        if (personnedao.create(personne0)){%>
        
        <script>
           window.location.assign("index.jsp");
           alert("personne ajoutee avec succes");
           
        </script>
        
<%
    } 
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
         
          DAO<personne> personnedao = new PersonneDAO(Maconnection.Connect());
        Set<personne> listePersonne = personnedao.findAll();        
          for( personne personne0 : listePersonne ){
              %>
        
          
          <tr>
              <td><%= personne0.getNOMPersonne()%></td>
            <td><%=personne0.getIDPersonne()%></td>
            <td><%= personne0.getNOMFonction()%></td>
            <td>
                [<a href="editpersonne.jsp?id=<%=personne0.getIDPersonne()%>">MODIFIER</a>]
                                &nbsp;
                [<a href="deletepersonne.jsp?id=<%=personne0.getIDPersonne()%>">SUPPRIMER</a>]
            </td>
          </tr> 
                  
          <%
              
                    } 

          %>
        </table>
                
         
  </td>
</tr>
  </table>
</div>

</body>

</html>

