<%--
  Created by IntelliJ IDEA.
  User: ЕрежеповН
  Date: 20.12.2017
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List of all students</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-student-style.css"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/custom.js">
    </script>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>All students</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <input type="button"
               onclick="goToSaveForm()"
               value="Add student"
               class="add-button"
        />
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Action</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <c:url var="updateLink" value="/showFormForUpdate">
                    <c:param name="studentId" value="${student.id}"/>
                </c:url>
                <tr>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.age}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
