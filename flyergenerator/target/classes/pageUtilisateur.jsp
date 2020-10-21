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
    <h>Bienvenu <%=u.getNom()%></h>h>
</head>
<body>

<p><a href="Deco">Se déconnecter</a></p>
</body>
</html>
