<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:layout>
    <jsp:attribute name="title">
        Projet Oeuvre - Formulaire oeuvre
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <h1>Oeuvres</h1>

            <div class="jumbotron">
                <form:form method="post" modelAttribute="oeuvrevente" action="/oeuvres/insertion">
                    <form:hidden path="idOeuvrevente" />

                    <form:label path="titreOeuvrevente"> Titre : </form:label>
                    <form:input path="titreOeuvrevente" type="text" required="true" />

                    <form:label path="etatOeuvrevente"> Etat : </form:label>
                    <form:input path="etatOeuvrevente" type="text" required="true" maxlength="1"/>

                    <form:label path="prixOeuvrevente"> Prix : </form:label>
                    <form:input path="prixOeuvrevente" type="number" required="true" />

                    <form:label path="proprietaire">Propriétaire : </form:label>
                    <form:select path="proprietaire" items="${proprietaires}" itemLabel="nomProprietaire" itemValue="idProprietaire"/>

                    <button type="submit" class="btn btn-success">Enregistrer</button>
                </form:form>
            </div>
        </div>
    </jsp:body>
</tags:layout>