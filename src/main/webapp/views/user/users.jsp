<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../fragments/header.jspf" %>

<h2>Lista uzytkownikow: </h2>
<table border="1">
    <tr>
        <th>Nazwa uzytkownika</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>
                <a href="/groups/users/user?id=${user.id}">Szczegoly</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../../fragments/footer.jspf" %>

</body>
</html>
