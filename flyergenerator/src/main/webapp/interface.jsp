<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="css/shop-homepage.css" rel="stylesheet">

    </head>

    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
            <a class="navbar-brand" href="#">Flyer Generator</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                    <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Mon compte</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Deconnexion</a>
                </li>
                </ul>
            </div>
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container" style="margin-top : 100px; margin-bottom: 100px;">

            <div class="row">

                <div class="col-lg-3">

                    <h3 class="my-4">Choississez votre type d'evenement</h3>
                    <div class="list-group">
                        <a href="interface.jsp?form=compet" class="list-group-item">Competion</a>
                        <a href="interface.jsp?form=conf" class="list-group-item">Conference</a>
                        <a href="interface.jsp?form=expo" class="list-group-item">Expostion</a>
                        <a href="interface.jsp?form=spect" class="list-group-item">Spectable</a>
                    </div>

                </div>
       
                <div class="col-lg-9">
                    <div style="text-align: center;">
                        <h2 class="my-4">Choississez votre type d'evenement</h2>
                        <div>
                            <button type="button" class="btn btn-light">Competion</button>
                            <button type="button" class="btn btn-light">Conference</button>
                            <button type="button" class="btn btn-light">Expostion</button>
                            <button type="button" class="btn btn-light">Spectable</button>
                        </div>
                    </div>

                    <div class="row">
                        <div style="text-align: center;">
                            <c:choose>
                                <c:when test = "${param.form == \"compet\"}">
                                    <jsp:include page="formCompet.jsp"/>
                                </c:when>
                                <c:when test = "${param.form == 'conf'}">
                                    <jsp:include page="formConf.jsp" />
                                </c:when>
                                <c:when test = "${param.form == 'expo'}">
                                    <jsp:include page="formExpo.jsp" />
                                </c:when>
                                <c:when test = "${param.form == 'spect'}">
                                    <jsp:include page="formSpect.jsp" />
                                </c:when>
                            </c:choose>
                        </div>
                    </div>  
                </div>             
            </div>
        </div>

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; FlyerGenerator</p>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>