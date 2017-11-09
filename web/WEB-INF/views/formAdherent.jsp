<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:layout>
    <jsp:attribute name="title">
        Projet Oeuvre - Formulaire adhérent
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <h1>Adhérents</h1>

            <div class="jumbotron">
                <form:form method="post" modelAttribute="adherent" action="/adherents/insertion">
                    <form:hidden path="idAdherent" />

                    <form:label path="prenomAdherent"> Prénom : </form:label>
                    <form:input path="prenomAdherent" type="text" required="true" />

                    <form:label path="nomAdherent"> Nom : </form:label>
                    <form:input path="nomAdherent" type="text" required="true" />

                    <form:label path="villeAdherent"> Ville : </form:label>
                    <form:input path="villeAdherent" type="text" required="true" />

                    <button type="submit" class="btn btn-success">Enregistrer</button>
                </form:form>
            </div>
        </div>
    </jsp:body>
</tags:layout>