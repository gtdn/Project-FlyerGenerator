<%@ page import="classes.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listU" class="classes.ListeUser" scope="application" />
<%
    User u = (User) session.getAttribute("user");
    //si on trouve pas user, c'est un nouveau utilisatur, on aller au page inscription
    if (!listU.trouverUser(u)) {
        response.sendRedirect("Inscription.jsp");
    }
%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<html>
    <style>
        .custombody{
            background-color: #7a7a7a;
        }

        .leftcontent{
            float: left;
            width: 20%;
            height: 90vh;
            background: #f7f7f7;
            padding: 1%;
        }

        .rightcontent{
            float: right;
            width: 80%;
            height: 90vh;
            background: #333333;
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

        .contents{
            min-height: 90vh;
            display: flex;
            flex-direction: column;
        }

        .innercontent{
            flex: 1;
            background-color: #7a7a7a;
        }

        .userdiv{
            padding: 1%;
            background-color: #e3e3e3;
        }
    </style>
    <script type="text/javascript">
        var categorie = "a1";
        function a1() {
            categorie = "a1";

        }
        function a2() {
            categorie = "a2";
        }
        function b1() {
            categorie = "b1";
        }
        function b2() {
            categorie = "b2";
        }
        //transferer choix par url
        function aller() {
            window.location.href = "visualFinal.jsp?cate=" + categorie
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
                        <h4>Catégories d'évènement</h4>
                        <div>
                            <h6>Categorie A</h6>
                            <input type="button" class="btn btn-light btn-sm" onclick="a1()" value="Ancienne saise A1"><br>
                            <input type="button" class="btn btn-light btn-sm" onclick="a2()" value="Ancienne saise A2" /><br>
                        </div>
                        <br>
                        <div>
                            <h6>Categorie B</h6>
                            <input type="button" class="btn btn-light btn-sm" onclick="b1()" value="Ancienne saise B1" /></br>
                            <input type="button" class="btn btn-light btn-sm" onclick="b2()" value="Ancienne saise B2"/></br>
                        </div>
                    </div>
                    <input type="button" class="btn btn-dark" onclick="aller()" value="Page de visuel final"/>
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
