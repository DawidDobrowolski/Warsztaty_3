<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edycja uzytkownika</h2>
<form method="post" action="/admin/users/update">
    <div>
        Prosze wybrac grupe:
        <select name="group">
            <c:forEach items="${groups}" var="group">
                <option
                        <c:if test="${group.id == user.group.id}">selected</c:if>
                        value="${group.id}">${group.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>
            Username:
            <input type="text" name="username" value="${user.username}">
        </label>
    </div>
    <div>
        <label>
            E-mail:
            <input type="email" name="email" value="${user.email}">
        </label>
    </div>
    <div>
        <label>
            Password:
            <input type="password" name="password">
        </label>
    </div>
    <input type="submit" value="Edytuj uzytkownika">
</form>
</body>
</html>
