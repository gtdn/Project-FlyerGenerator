<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*" %>
<%@ page import="modele.Conference" %>
<%@ page import="java.util.List" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

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

    </head>

    <body>

        <!-- Navigation -->
        <jsp:include page="../composants/menu.html"/>

        <!-- Page Content -->
        <div class="container" style="margin-top : 100px; margin-bottom: 100px;">

            <div class="row">

                <div class="col-lg-3">

                    <h3 class="my-4">Choisissez votre type d'évènement</h3>
                    <div class="list-group">
                        <a href="Competition" class="list-group-item">Compétition</a>
                        <a href="Conference" class="list-group-item">Conférence</a>
                        <a href="Exposition" class="list-group-item">Exposition</a>
                        <a href="Spectacle" class="list-group-item">Spectacle</a>
                    </div>

                </div>
       
                <div class="col-lg-9">
                    <div style="text-align: center;">
                        <h2 class="my-4">Historique de vos évènement</h2>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                            <th scope="col">Nom</th>
                            <th scope="col">Lieu</th>
                            <th scope="col">Ville</th>
                            <th scope="col">Prix</th>
                            <th scope="col">Heure début</th>
                            <th scope="col">Date début</th>
                            <th scope="col">Thème</th>
                            <th scope="col">Nom Contact</th>
                            <th scope="col">Numéro contact</th>
                            <th scope="col">Mail contact</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.conferences}" var="conference">
                                <tr>
                                    <td scope="row">
                                        <c:out value="${ conference.getNom() }" />
                                    </td>
                                    <td scope="row">
                                        <c:out value="${ conference.getLieu() }" />
                                    </td>
                                    <td scope="row">
                                        <c:out value="${ conference.getVille() }" />
                                    </td>
                                    <td scope="row">
                                        <c:out value="${ conference.getPrix() }" />
                                    </td>
                                    <td scope="row">
                                        <c:out value="${ conference.getHeureDebut() }" />
                                    </td>
                                    <td scope="row">
                                        <c:out value="${ conference.getDateDebut() }" />
                                    </td>
                                    <td scope="row">
                                        <c:out value="${ conference.getResume()}" />
                                    </td>
                                    <td scope="row">
                                        <c:out value="${ conference.getContacts().getNom() }" />
                                    </td>
                                    <td scope="row">
                                        <c:out value="${ conference.getContacts().getNumero() }" />
                                    </td>
                                    <td scope="row">
                                        <c:out value="${ conference.getContacts().getMail() }" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                </div>             
            </div>
        </div>

        <!-- Footer -->
        <jsp:include page="../composants/footer.html"/>
        <!-- Bootstrap core JavaScript -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>

    </body>

</html>