
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>TEst</title>
    </head>     
    <body>
        <div id="menu">
            <p><a href="test.jsp?contenu=compet">Afficher les passages</a></p>
        </div>        
        <c:choose>
            <c:when test="${param.contenu == null}">
                <jsp:include page="home.jsp" />
            </c:when>
            <c:when test="${param.contenu == \"compet\"}">
                <jsp:include page="formCompet.jsp" />
            </c:when>
        </c:choose>
    </body>
</html>
