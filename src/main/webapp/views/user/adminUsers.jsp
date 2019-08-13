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
<%@include file="../../fragments/header.jspf" %>
<br>
<a href="/admin/users/add">Add new user</a>
<br>
<h2>User list: </h2>
<table border="1">
    <tr>
        <th>User name</th>
        <th>E-mail</th>
        <th>User group</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${users}" var="us">
        <tr>
            <td>${us.username}</td>
            <td>${us.email}</td>
            <td>${us.group.name}</td>
            <td>
                <a href="/admin/users/update?id=${us.id}">Edit</a>
                <a href="/admin/users/delete?id=${us.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../../fragments/footer.jspf" %>
</body>
</html>
