<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modele.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!DOCTYPE html>
<html lang="fr">

    <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>FlyerGenerator</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <script type="text/javascript" src="js/interface.js"></script>

    </head>

    <body>
        <!-- Navigation -->
        <jsp:include page="composants/menu.html"/>

        <!-- Page Content -->
        <div class="container" style="margin-top : 100px; margin-bottom: 100px;">
            <div class="row">
                <div class="col-lg-12">
                    <h1>Bienvenue <%= ((User)session.getAttribute("user")).getPseudo() %> !</h1>
                </div>

                <div class="col-lg-3">

                    <h3 class="my-4">Historique de vos événements</h3>
                    <div class="list-group">
                        <a href="Competition" class="list-group-item">Compétition</a>
                        <a href="Conference" class="list-group-item">Conférence</a>
                        <a href="Exposition" class="list-group-item">Exposition</a>
                        <a href="Spectacle" class="list-group-item">Spectacle</a>
                    </div>

                </div>
       
                <div class="col-lg-9">
                    <div style="text-align: center;">
                        <h2 class="my-4">Choisissez votre type d'évènement</h2>
                        <div>
                            <a href="interface.jsp?contenu=compet"><button type="button" class="btn btn-light">Compétition</button></a>
                            <a href="interface.jsp?contenu=conf"><button type="button" class="btn btn-light">Conférence</button></a>
                            <a href="interface.jsp?contenu=expo"><button type="button" class="btn btn-light">Exposition</button></a>
                            <a href="interface.jsp?contenu=spect"><button type="button" class="btn btn-light">Spectacle</button></a>
                        </div>
                    </div>
                    <c:choose>
                        <c:when test="${param.contenu == null || param.contenu == 'home'}">
                            <jsp:include page="composants/home.html"/>
                        </c:when>
                        <c:when test = "${param.contenu == 'compet'}">
                            <jsp:include page="form/formCompet.jsp"/>
                        </c:when>
                        <c:when test = "${param.contenu == 'conf'}">
                            <jsp:include page="form/formConf.jsp" />
                        </c:when>
                        <c:when test = "${param.contenu == 'expo'}">
                            <jsp:include page="form/formExpo.jsp" />
                        </c:when>
                        <c:when test = "${param.contenu == 'validation'}">
                            <jsp:include page="validation.jsp" />
                        </c:when>
                        <c:when test = "${param.contenu == 'spect'}">
                            <jsp:include page="form/formSpect.jsp" />
                        </c:when>
                    </c:choose>
                    
                    <div class="row">
                        <div style="text-align: center;">
                            
                        </div>
                    </div>  
                </div>             
            </div>
        </div>

        <!-- Footer -->
        <jsp:include page="composants/footer.html"/>
        <!-- Bootstrap core JavaScript -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>

    </body>

</html>
