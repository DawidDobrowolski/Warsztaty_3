<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/19/19
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="fragments/header.jspf"%>
<h3>Exercise: </h3>${exercise.title}
<h3>User: </h3>${user.username}
<h3>Description: </h3>${description}
<%@include file="fragments/footer.jspf"%>
</body>
</html>
