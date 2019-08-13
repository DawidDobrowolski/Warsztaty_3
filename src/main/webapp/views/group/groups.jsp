<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../fragments/header.jspf" %>

<h2>Group list: </h2>
<table border="1">
    <tr>
        <th>Group name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.name}</td>
            <td>
                <a href="/groups/users?id=${group.id}">Users</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../../fragments/footer.jspf" %>

</body>
</html>
