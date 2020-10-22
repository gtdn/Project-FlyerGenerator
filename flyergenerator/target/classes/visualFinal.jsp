<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .titre{
            width:100%;
            height:100px;
            background: rosybrown;
        }
        .milieu{
            width: 100%;
            height: 650px;
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
        .petiteImgGauche{
            margin-left:300px;
            height: 30px;
            width: 30px;
        }
        .petiteImgDroit{
            margin-left:20px;
            height: 30px;
            width: 30px;
        }
        .foot{
            width: 100%;
            height: 60px;
            background: darkkhaki;
        }
    </style>
    <script>
        function aller(){
            window.location.href="dernierRetouche.jsp"
        }
    </script>
</head>
<body>
    <div class="titre"></div>
    <div class="milieu">
        <div class="gauche">
            <%=request.getParameter("cate")%>
            <a href="pageUtilisateur.jsp">retorner au page de choix categorie</a>
        </div>
        <div class="droite">
            <img src="flechG.png" class="petiteImgGauche" alt="logo" />
            <img src="flechD.png" class="petiteImgDroit" alt="logo" />
        </div>
        <div class="foot">
            <input type="button" onclick="aller()" value="valider" style="margin-left: 500px;" />
        </div>
    </div>

</body>
</html>
