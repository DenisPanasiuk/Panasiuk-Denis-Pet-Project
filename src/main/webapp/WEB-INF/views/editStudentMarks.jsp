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
    </head>
    <body>
            <div style="text-align: center" class="container">
                <h1>${oneStudent.name} ${oneStudent.surname} | <a href="/admin">Back!</a></h1>
                <h2>Course: ${oneStudent.course} &nbsp; &nbsp; Sex: ${oneStudent.sex}</h2>
                <h3>Marks: <small><a href="/admin/oneStudent/${oneStudent.id}">Show student's marks</a></small></h3>
                <h4>Id: ${oneStudent.id}</h4>
            </div>

            <div style="display: flex; justify-content: center; text-align: center">
                <form:form method="POST" modelAttribute="studentMarks" class="form-signin" cssStyle="width: 60%;">
                    <h2 class="form-signin-heading" style="text-align: center">Changing marks</h2>
                <spring:bind path="math">
                <div style="text-align: right;" class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="container" style="display: table; text-align: right;">
                        <h3 style="display: table-cell; width: 1px; white-space: nowrap;" for="test">&emsp;&emsp;&ensp;Math:</h3>
                        <span style="display: table-cell; padding: 0 4px 0 6px; width: 70%">
                    <form:input cssStyle="text-align: center; width: 70%" type="text" path="math" class="form-control" placeholder="Math" autofocus="true"/>
                    <form:errors path="math"/>
                        </span>
                    </div>
                </div>
                </spring:bind>

                <spring:bind path="history">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="container" style="display: table;">
                        <h3 style="display: table-cell; width: 1px; white-space: nowrap;" for="test">&emsp;&nbsp;&nbsp;History:</h3>
                        <span style="display: table-cell; padding: 0 4px 0 6px; width: 70%">
                    <form:input cssStyle="text-align: center; width: 70%" type="text" path="history" class="form-control" placeholder="History"/>
                    <form:errors path="history"/>
                        </span>
                    </div>
                </div>
                </spring:bind>

                <spring:bind path="biology">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="container" style="display: table;">
                        <h3 style="display: table-cell; width: 1px; white-space: nowrap;" for="test">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Biology:</h3>
                        <span style="display: table-cell; padding: 0 4px 0 6px; width: 70%;">
                        <form:input cssStyle="text-align: center; width: 70%" type="text" path="biology" class="form-control"
                                    placeholder="Biology"/>
                        <form:errors path="biology"/>
                        </span>
                    </div>
                </div>
                </spring:bind>

                <spring:bind path="english">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <div class="container" style="display: table;">
                            <h3 style="display: table-cell; width: 1px; white-space: nowrap;" for="test">&emsp;&nbsp;&nbsp;English:</h3>
                            <span style="display: table-cell; padding: 0 4px 0 6px; width: 70%;">
                        <form:input cssStyle="text-align: center; width: 70%" type="text" path="english" class="form-control"
                                    placeholder="English"/>
                        <form:errors path="english"/>
                            </span>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="geography">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <div class="container" style="display: table;">
                            <h3 style="display: table-cell; width: 1px; white-space: nowrap;" for="test">Geography:</h3>
                            <span style="display: table-cell; padding: 0 4px 0 6px; width: 70%;">
                        <form:input cssStyle="text-align: center; width: 70%" type="text" path="geography" class="form-control"
                                    placeholder="Geography"/>
                        <form:errors path="geography"/>
                            </span>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="chemistry">
                    <div  class="form-group ${status.error ? 'has-error' : ''}">
                        <div class="container" style="display: table;">
                            <h3 style="display: table-cell; width: 1px; white-space: nowrap;" for="test">&nbsp;&nbsp;Chemistry:</h3>
                            <span style="display: table-cell; padding: 0 4px 0 6px; width: 70%;">
                                <form:input cssStyle="text-align: center; width: 70%" type="text" path="chemistry" class="form-control" name="test" id="test"
                                            placeholder="Chemistry"/>
                                <form:errors path="chemistry"/>
                            </span>
                        </div>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                </form:form>
            </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
