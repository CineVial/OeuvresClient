<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:layout>
    <jsp:attribute name="title">
        Projet Oeuvre - Oeuvres
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <h1>Liste des Oeuvres</h1>

            <div class="jumbotron">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Etat</th>
                        <th>Prix</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${oeuvres}" var="oeuvre">
                    <tr>
                        <td> ${oeuvre.titreOeuvrevente}</td>
                        <td> ${oeuvre.etatOeuvrevente}</td>
                        <td> ${oeuvre.prixOeuvrevente}</td>
                        <td>
                            <a href="/oeuvres/modifier/${oeuvre.idOeuvrevente}" class="btn btn-primary" role="button">Modifier</a>
                            <a href="/oeuvres/supprimer/${oeuvre.idOeuvrevente}" class="btn btn-danger" role="button">Supprimer</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </jsp:body>
</tags:layout>
