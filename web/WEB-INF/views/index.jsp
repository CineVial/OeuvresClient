<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:layout>
    <jsp:attribute name="title">
        Projet Oeuvre
    </jsp:attribute>

    <jsp:body>
        <div class="container" style="text-align:center">
            <h1>Bienvenue</h1>

            <img src="<c:url value="/resources/images/index.jpg"/>" alt="Mountain View">
        </div>
    </jsp:body>
</tags:layout>