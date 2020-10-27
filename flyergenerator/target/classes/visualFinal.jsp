<%@ page import="classes.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listU" class="classes.ListeUser" scope="application" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%
    User u = (User) session.getAttribute("user");
    //si on trouve pas user, c'est un nouveau utilisatur, on aller au page inscription
    if (!listU.trouverUser(u)) {
        response.sendRedirect("Inscription.jsp");
    }
%>
<html>
    <style>
        .contents{
            min-height: 90vh;
            display: flex;
            flex-direction: column;
        }
        .innercontent{
            flex: 1;
            background-color: #7a7a7a;
        }
        .rightcontent{
            float: right;
            width: 80%;
            height: 90vh;
            background: #333333;
            padding: 1%;
        }
        .leftcontent{
            float: left;
            width: 20%;
            height: 90vh;
            background: #f7f7f7;
            padding: 1%;
        }
        .customfooter{
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 10vh;
            line-height: 10vh;
            background-color: #f5f5f5;
        }



    </style>
    <script>
        function aller1(){
            window.location.href="dernierRetouche.jsp"
        }
        function aller2(){
            window.location.href="pageUtilisateur.jsp"
        }
    </script>
    <head>
        <meta charset="utf-8">
        <title>Flyer Generator</title>
    </head>
<body>
    <nav class="navbar navbar-dark bg-dark">
        <span class="navbar-brand mb-0 h1">Flyer Generator</span>
        <a class="btn btn-light nav-link" href="Deco">Se déconnecter</a>
    </nav>
    <div class="contents">

        <div class="innercontent">
            <div class="rightcontent">
            </div>
            <div class="leftcontent">
                <div class="userdiv">
                    <h3>Hello, <%=u.getNom()%>!</h3>
                </div>
                <div>
                    <h6>Choisir image back</h6>
                    <input type="button" class="btn btn-light btn-sm" onclick="" value="Imgage Avant" /></br>
                    <input type="button" class="btn btn-light btn-sm" onclick="" value="Image Suivant"/></br>
                </div>
                <input type="button" class="btn btn-dark" onclick="aller1()" value="Valider votre choix"/>
                <input type="button" class="btn btn-dark" onclick="aller2()" value="Retourner page avant"/>
            </div>
        </div>

            <footer class="customfooter">
                <div class="container">
                    <span class="text-muted">Mif10 - Groupe 08</span>
                </div>
            </footer>
    </div>
</body>
</html>
