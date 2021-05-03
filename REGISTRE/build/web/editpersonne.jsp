<%-- 
    Document   : index
    Created on : 22 avr. 2021, 01:10:57
    Author     : JORD DJR
--%>

    <%@page import="com.dao.DAO"%>
<%@page import="com.bean.personne"%>
<%@page import="com.fonction.implement.PersonneDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@page import="java.sql.*" %>
            <%@page import="com.connection.Maconnection" %>


                <!DOCTYPE html>
                <html>

                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>JSP Page</title>

                    <link rel="stylesheet" href="styles.css" />
                </head>

                <body>

                    <%

    if (request.getParameter("submit")!=null)
    {
        DAO<personne> personnedao = new PersonneDAO(Maconnection.Connect());
        personne personne0 = new personne(Integer.valueOf(request.getParameter("fid")),request.getParameter("fname"),request.getParameter("ffonction"));
        if (personnedao.update(personne0)){
     %>
                        <script>
                            alert("Mise a jour effectuer avec succes");
                        </script>
                        <%   
        }
     }
    %>

                            <h3>FORMULAIRE</h3>

                            <div class="container">
                                <%

        DAO<personne> personnedao = new PersonneDAO(Maconnection.Connect());
        personne personne0 = personnedao.find(Integer.valueOf(request.getParameter("id")));
      
    %>

                                    <form action="#" method="POST">
                                        <label>NOM</label>
                                        <input type="text" id="fname" name="fname" placeholder="votre nom.." value="<%= personne0.getNOMPersonne() %>" required>

                                        <label>ID</label>
                                        <input type="text" id="fid" name="fid" placeholder="votre identifiant.." value="<%= personne0.getIDPersonne()%>" required>

                                        <label>Fonction</label>
                                        <select id="ffonction" name="ffonction">
            <option value="FRONT">FRONT</option>
            <option value="BACK">BACK</option>
            <option value="FULLSTACK">FULLSTACK</option>
          </select>

                                        <tr>
                                            <td> <input type="submit" value="MISE A JOUR" name="submit" id="submit"></td>
                                            <td> <a href="index.jsp"> GO BACK </a> </td>
                                        </tr>
                                    </form>

                                    <%

          %>
                            </div>



                </body>

                </html>