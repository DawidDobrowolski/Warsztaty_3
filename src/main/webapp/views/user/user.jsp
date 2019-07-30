<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../fragments/header.jspf"%>
<h3>Username: </h3>${user.username}
<h3>Email: </h3>${user.email}
<h3>Dodane rozwiazania zadan: </h3>


<table border="1">
    <tr>
        <th>Excercise</th>
        <th>Update date</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${solutions}" var="solution">
        <tr>
            <td>${solution.exercise.title}</td>
            <td>${solution.updated}</td>
            <td>
                <a href="/solutions/details?id=${solution.id}">Szczegoly</a>
            </td>
        </tr>
    </c:forEach>
</table>


<%@include file="../../fragments/footer.jspf"%>
</body>
</html>
