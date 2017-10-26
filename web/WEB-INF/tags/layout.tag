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
        <jsp:doBody/>
    </body>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />" type="text/javascript"></script>
</html>