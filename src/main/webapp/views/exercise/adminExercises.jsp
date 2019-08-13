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
<a href="/admin/exercises/add">Add new exercise</a>
<br>
<h2>Exercise list: </h2>
<table border="1">
    <tr>
        <th>Exercise name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.title}</td>
            <td>
                <a href="/admin/exercises/details?id=${exercise.id}">Details</a>
                <a href="/admin/exercises/update?id=${exercise.id}">Edit</a>
                <a href="/admin/exercises/delete?id=${exercise.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../../fragments/footer.jspf" %>
</body>
</html>
