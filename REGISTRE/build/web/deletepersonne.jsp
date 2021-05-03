<%-- 
    Document   : deletepersonne
    Created on : 24 avr. 2021, 11:18:46
    Author     : JORD DJR
--%>

<%@page import="com.bean.personne"%>
<%@page import="com.dao.DAO"%>
<%@page import="com.fonction.implement.PersonneDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connection.Maconnection"%>

        <%
      String iddd = request.getParameter("id");
       DAO<personne> personnedao = new PersonneDAO(Maconnection.Connect());
        if (personnedao.delete(personnedao.find(Integer.valueOf("id")))){
        %>
        <script>
           window.location.assign("index.jsp");
           alert("personne supprimee avec succes");
           
        </script>
        <%
        }
        %>