<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edycja wybranej grupy</h2>
<form action="/admin/groups/update" method="POST">
    <label>
        Name:
        <input type="text" name="name" value="${group.name}">
    </label>
    <input type="submit" value="Zaktualizuj dane grupy">
</form>
</body>
</html>
