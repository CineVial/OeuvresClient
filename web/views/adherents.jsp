<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:layout>
    <jsp:attribute name="title">
        Projet Oeuvre - Adherents
    </jsp:attribute>

    <jsp:body>
        <c:forEach items="${adherents}" var="adherent">
            ${adherent.nomAdherent} <br />
        </c:forEach>
    </jsp:body>
</tags:layout>