<%--
  Created by IntelliJ IDEA.
  User: ЕрежеповН
  Date: 21.12.2017
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save Student</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-student-style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/custom.js">
    </script>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>All students</h2>
    </div>
</div>

<div id="container">
    <form:form action="saveStudent" modelAttribute="student"
        method="POST">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/">Back</a>
    </p>
</div>

</body>
</html>
