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
    <title>Title</title>
    <script src="<c:url value="../resources/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="../resources/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="../resources/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>"></head>
<body>
<h1>Panel administracyjny</h1>
<h2><a href="/admin/groups">Zarzadzanie grupami uzytkownikow</a></h2>
<h2><a href="/admin/users">Zarzadzanie uzytkownikami</a></h2>
<h2><a href="/admin/exercises">Zarzadzanie zadaniami</a></h2>
</body>
</html>
