<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 1:08 AM
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
<a href="/admin/groups/add">Dodaj nowa grupe</a>
<br>
<h2>Lista grup: </h2>
<table border="1">
    <tr>
        <th>Nazwa grupy</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.name}</td>
            <td>
                <a href="/admin/groups/update?id=${group.id}">Edytuj</a>
                <a href="/admin/groups/delete?id=${group.id}">Usun</a>

            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../../fragments/footer.jspf" %>
</body>
</html>
