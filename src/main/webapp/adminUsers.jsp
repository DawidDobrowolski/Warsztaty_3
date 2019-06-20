<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>
<br>
<a href="/admin/users/add">Dodaj nowego uzytkownika</a>
<br>
<h2>Lista uzytkownikow: </h2>
<table border="1">
    <tr>
        <th>Nazwa uzytkownika</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${users}" var="us">
        <tr>
            <td>${us.username}</td>
            <td>
                <a href="/admin/users/update?id=${us.id}">Edytuj</a>
                <a href="/admin/users/delete?id=${us.id}">Usun</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="fragments/footer.jspf" %>
</body>
</html>
