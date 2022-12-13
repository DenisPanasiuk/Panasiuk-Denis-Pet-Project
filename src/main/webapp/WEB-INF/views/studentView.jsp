<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

    <body>
        <div style="text-align: center" class="container">
            <h1>${oneStudent.name} ${oneStudent.surname} | <a href="/welcome">Back!</a></h1>
            <h2>Course: ${oneStudent.course} &nbsp; &nbsp; Sex: ${oneStudent.sex}</h2>
            <h2>Math: ${studentMarks.math} &nbsp; &nbsp; History: ${studentMarks.history}</h2>
            <h2>Biology: ${studentMarks.biology} &nbsp; &nbsp; Geography: ${studentMarks.geography}</h2>
            <h2>Chemistry: ${studentMarks.chemistry} &nbsp; &nbsp; English: ${studentMarks.english}</h2>
            <h1>Average mark ${averageMark}</h1>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
