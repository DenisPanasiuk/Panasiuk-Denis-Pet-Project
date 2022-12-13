<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>403 page</title>

        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <hr/>

        <h1 style="text-align: center;">Sorry, but you do not have sufficient rights to go to this page | <a href="/welcome">Back!</a></h1>

        <hr/>

        <h4 style="text-align: center; color: #5898d6;">Error 403</h4>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>