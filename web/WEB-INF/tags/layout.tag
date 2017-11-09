<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="refresh" content="0;URL=javascript:fermer();">
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
        <title><jsp:invoke fragment="title"/></title>
    </head>

    <body>
        <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <a class="navbar-brand" href="/">Médiathèque</a>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuAdherent" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Gestion Adhérents
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="/adherents/ajouter">Ajouter</a>
                            <a class="dropdown-item" href="/adherents">Liste complète</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuOeuvre" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Gestion Oeuvre
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="/oeuvres">Ajouter</a>
                            <a class="dropdown-item" href="/oeuvres/ajouter">Liste complète</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <br/>

        <jsp:doBody/>

        <footer class="footer">
            <div class="container">
                <p class="text-muted text-center">Greyl - Paccaud - Roussel</p>
            </div>
        </footer>
    </body>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />" type="text/javascript"></script>
</html>