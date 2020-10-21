<!--
page inscription
montrer le resultat de inscription
-->
<%@ page import="classes.User" %>
<jsp:useBean id="listU" class="classes.ListeUser" scope="application" />
<%
    User u = (User)session.getAttribute("user");
    //si on trouve pas user, c'est un nouveau utilisatur, on aller au page inscription
    listU.add(u);
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Flyer Generator</title>
</head>
<body>
<h1>Bienvenue sur Flyer Generator</h1>

    <h2>nom : <%=u.getNom()%></h2>
    </br>
    <h2>mot de pass : <%=u.getPassword()%></h2>
    </br>
    <p>
        <a href="index.jsp">Retourner au page acceuil</a>
    </p>
    </br>
    <p>
        <a href="pageUtilisateur.jsp">Aller au page utilisateur</a>
    </p>

</body>
</html>