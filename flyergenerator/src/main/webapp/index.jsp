<!--page d'acceuil-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="classes.ListeUser" %>
<jsp:useBean id="listU" class="classes.ListeUser" scope="application" />
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Flyer Generator</title>
</head>
<body>
<h1>Bienvenue sur Flyer Generator</h1>
<form method="post" action="Login">
        </br>
        <label>
            Si vous avez des compts,vous pouvez connection
            </br>
            sinon vous pouvez s'inscrire automatique
        </label>
        </br>
        <label>
            Entrez votre nom :
            <input type="text" name="nom">
        </label>
        </br>
        <label>
            Entre votre mot de passe :
            <input type="text" name="mot">
        </label>
        </br>
        <input type="submit" value="Connection/Inscription" />
</form>
</body>
</html>
