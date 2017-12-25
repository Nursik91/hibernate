<%--
  Created by IntelliJ IDEA.
  User: ЕрежеповН
  Date: 22.12.2017
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/login"
               method="POST">
        <h2>Log in</h2>
        <span>${message}</span>
        <br/>
        Username:<input name="username" type="text"
            placeholder="Username"/>
        <br>
        Password:<input name="password" type="password"
            placeholder="Password">
        <input type="submit" value="Log in"/>
    </form:form>
</body>
</html>
