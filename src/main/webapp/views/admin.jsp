<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>"></head>
<body>
<h1>Administrative panel</h1>
<h2><a href="/admin/groups">Manage user groups</a></h2>
<h2><a href="/admin/users">Manage users</a></h2>
<h2><a href="/admin/exercises">Manage exercises</a></h2>
</body>
</html>
