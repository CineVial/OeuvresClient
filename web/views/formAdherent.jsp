<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:layout>
    <jsp:attribute name="title">
        Projet Oeuvre - Formulaire adhérent
    </jsp:attribute>

    <jsp:body>
        <form:form method="post" modelAttribute="adherent" action="/adherents/insertion">
            <form:hidden path="idAdherent" />

            <form:input path="nomAdherent" />
        </form:form>
    </jsp:body>
</tags:layout>