<!--page d'acceuil-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    function reveal() {
        var x = document.getElementById("mdp");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>

<style>
    .custombody{
        background-color: #7a7a7a;
    }

    .form{
        background-color: #f7f7f7;
        margin-left: 25%;
        margin-right: 25%;
        margin-bottom: 1%;
        margin-top: 1%;
        padding-left: 15%;
        padding-right: 15%;
        padding-top: 1%;
        padding-bottom: 1%;
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
        </nav>
        <div class="form">
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
        <footer class="customfooter">
            <div class="container">
                <span class="text-muted">Mif10 - Groupe 08</span>
            </div>
        </footer>
    </body>
</html>
