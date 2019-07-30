<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../fragments/header.jspf" %>
<br>
<a href="/admin/exercises/add">Dodaj nowe zadanie </a>
<br>
<h2>Lista zadan: </h2>
<table border="1">
    <tr>
        <th>Nazwa zadania</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.title}</td>
            <td>
                <a href="/admin/exercises/details?id=${exercise.id}">Szczegoly</a>
                <a href="/admin/exercises/update?id=${exercise.id}">Edytuj</a>
                <a href="/admin/exercises/delete?id=${exercise.id}">Usun</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../../fragments/footer.jspf" %>
</body>
</html>
