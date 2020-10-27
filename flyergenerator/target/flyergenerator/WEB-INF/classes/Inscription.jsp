<!--
page inscription
montrer le resultat de inscription
-->
<%@ page import="classes.User" %>
<jsp:useBean id="listU" class="classes.ListeUser" scope="application" />
<%
    User u = (User) session.getAttribute("user");
    //si on trouve pas user, c'est un nouveau utilisatur, on aller au page inscription
    listU.add(u);
%>

<style>
    .custombody{
        background-color: #7a7a7a;
    }

    .customfooter{
        position: absolute;
        bottom: 0;
        width: 100%;
        height: 10vh;
        line-height: 10vh;
        background-color: #f5f5f5;
    }

    .customcontainer{
        background-color: #f7f7f7;
        margin-left: 10%;
        margin-right: 10%;
        margin-bottom: 1%;
        margin-top: 1%;
        padding-left: 15%;
        padding-right: 15%;
        padding-top: 1%;
        padding-bottom: 1%;
    }
</style>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">


<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>Flyer Generator</title>
    </head>
    <body class="custombody">
        <nav class="navbar navbar-dark bg-dark">
            <span class="navbar-brand mb-0 h1">Flyer Generator</span>
            <a class="btn btn-light nav-link" href="Deco">Se déconnecter</a>
        </nav>
        <div class="customcontainer">
            <div>
                <p>Nom : <%=u.getNom()%></p>
                <p>Mot de passe : <%=u.getPassword()%></p>
            </div>
            <div>
                <a role="button" class="btn btn-secondary" href="index.jsp">
                    Page accueil
                </a>
                <a role="button" class="btn btn-secondary" href="pageUtilisateur.jsp">
                    Page utilisateur
                </a>
            </div>
        </div>
        <footer class="customfooter">
            <div class="container">
                <span class="text-muted">Mif10 - Groupe 08</span>
            </div>
        </footer>
    </body>
</html>