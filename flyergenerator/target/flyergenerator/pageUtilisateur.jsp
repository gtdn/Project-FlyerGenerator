<%@ page import="classes.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listU" class="classes.ListeUser" scope="application" />
<%
    User u = (User)session.getAttribute("user");
    //si on trouve pas user, c'est un nouveau utilisatur, on aller au page inscription
    if(!listU.trouverUser(u)){
        response.sendRedirect("Inscription.jsp");
    }
%>
<html>
<head>
    <title>Title</title>
    <style>
        .titre{
            width:100%;
            height:100px;
            background: rosybrown;
        }
        .gauche{
            float: left;
            height: 650px;
            width: 35%;
            background: lemonchiffon;
        }
        .droite{
            float: right;
            left: 20%;
            width: 65%;
            height: 650px;
            background: lightskyblue;
        }
        .foot{
            width: 100%;
            height: 60px;
            background: darkkhaki;
        }
        .milieu{
            width: 100%;
            height: 650px;
        }
        .flyer{
            margin-left: 50%;
        }
        .deconnection{
            margin-left: 80%;
        }
        .petiteImg{
            height: 30px;
            width: 30px;
        }
    </style>
    <script type="text/javascript">
        var categorie="a1";
        function a1(){
            categorie="a1";

        }
        function a2(){
            categorie="a2";
        }
        function b1(){
            categorie="b1";
        }
        function b2(){
            categorie="b2";
        }
        //transferer choix par url
        function aller(){
            window.location.href="visualFinal.jsp?cate="+categorie
        }
    </script>
</head>
<body>
<div class="titre">
    <p>
        <img src="search.png" class="petiteImg" alt="logo" />
        <p class="flyer">Flyer Generator</p>
        <a class="deconnection" href="Deco">Se déconnecter</a>
    </p>
</div>
<div class="milieu">
    <div class="droite">
    </div>
    <div class="gauche">
        <img src="search.png" class="petiteImg" alt="user" /></br>

        <h>Bienvenu <%=u.getNom()%></h></br>

        <a>event categorie</a></br>

        <a>Categorie A</a></br>
            <input type="button" onclick="a1()" value="Ancienne saise A1"></br>
            <input type="button" onclick="a2()" value="Ancienne saise A2" /></br>

        <a>Categorie B</a></br>
            <input type="button" onclick="b1()" value="Ancienne saise B1" /></br>
            <input type="button" onclick="b2()" value="Ancienne saise B2"/></br>

        <input type="button" onclick="aller()" value="aller au page de final visual"/>
    </div>
</div>
<div class="foot"></div>
</body>
</html>
