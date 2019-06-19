<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/14/19
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf"%>

<a href="/solutions/add">Dodaj nowe rozwiazanie</a>
<br><br>

<table border="1">
    <tr>
        <th>Excercise</th>
        <th>User</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
<c:forEach items="${solutions}" var="solution">
    <td>${solution.exercise.title}</td>
    <td>${solution.user.username}</td>
    <td>${solution.description}</td>
    <td><a href="/solutions/update?id=${solution.id}">Modyfikuj</a>
    <a href="/solutions/delete?id=${solution.id}">Usun</a></td>

</c:forEach>
</table>
<%@include file="fragments/footer.jspf"%>

</body>
</html>
