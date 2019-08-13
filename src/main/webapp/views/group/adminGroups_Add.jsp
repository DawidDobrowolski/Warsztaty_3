<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add new group</h2>
<form action="/admin/groups/add" method="POST">
    <label>
        Name:
        <input type="text" name="name">
    </label>
    <input type="submit" value="Create new group">
</form>
</body>
</html>
