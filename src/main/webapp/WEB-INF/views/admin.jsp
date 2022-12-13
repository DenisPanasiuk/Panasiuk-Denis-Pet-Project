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

        <title>Admin</title>

        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div style="text-align: center">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="post" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <h1>Admin page ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h1>
            </c:if>
        </div>

        <hr/>

        <h2 style="margin-left: 5px">All students:</h2>

        <div style="margin-left: 20px">
            <c:forEach var="user" items="${allUsers}">
                <c:if test="${user.id>1}">
                    <a href="/admin/oneStudent/${user.id}"> <h4>${user.name} ${user.surname}</h4></a>
                </c:if>
            </c:forEach>
        </div>

        <hr/>

        <form method="GET" action="/admin/newStudent">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Create new person</button>
        </form>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>