<!--page d'acceuil-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">



<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>Flyer Generator</title>
        <script type="text/javascript" src="../../js/connexion.js"></script>
        <link rel="stylesheet" href="../../css/style.css">
    </head>
    <body class="custombody">
        <jsp:include page="composants/nav.html"/>
        <div class="login-form">
            <form method="post" action="Login">
                <h1>Connexion</h1>
                <div class="form-group">
                    <label for="emailinput">Nom</label>
                    <input type="text" class="form-control" name="name" id="emailinput"
                           placeholder="Nom d'utilisateur" required="required">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Mot de passe</label>
                    <input type="password" class="form-control" name="pwd" id="mdp" required="required">
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1" onclick="reveal()">
                    <label class="form-check-label" for="exampleCheck1">Afficher le mot de passe</label>
                </div>
                <div>
                    <span class="text-muted">Si vous ne possédez pas de compte, il sera automatiquement créé.</span>
                </div>
                <button type="submit" class="btn btn-dark">Se connecter</button>
            </form>
        </div>
        <jsp:include page="composants/footerCo.html"/>
    </body>
</html>
