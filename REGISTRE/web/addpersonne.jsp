<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter personnes</title>
        <link rel="stylesheet" href="styles.css"/>
    </head>
    <body>
        
        <h2>Ajouter personne</h2>
                
        <form action="addpersonne.jsp" method="post">
                            Nom : <br>
                <input type="text" name="nom" required>
                <br>
                            ID : <br>
                <input type="text" name="id" required>
                <br><br>
                <input type="submit" value="AJOUTER">

        </form>
            
    </body>
</html>
