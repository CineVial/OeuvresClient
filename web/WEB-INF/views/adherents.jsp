<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:layout>
    <jsp:attribute name="title">
        Projet Oeuvre - Adherents
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <h1>Liste des Adhérents</h1>

            <div class="jumbotron">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${adherents}" var="adherent">
                    <tr>
                        <td> ${adherent.nomAdherent}</td>
                        <td>
                            <a href="/adherents/modifier/${adherent.idAdherent}" class="btn btn-primary" role="button">Modifier</a>
                            <a href="/adherents/supprimer/${adherent.idAdherent}" class="btn btn-danger" role="button">Supprimer</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </jsp:body>
</tags:layout>