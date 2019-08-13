<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Solution list</title>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>"/>
</head>
<body>
<%@include file="../../fragments/header.jspf" %>

<a href="/solutions/add">Add new solution</a>
<br><br>

<table class="table" border="1">
    <tr>
        <th>Excercise</th>
        <th>User</th>
        <th>Update date</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${solutions}" var="solution">
        <tr>
            <td>${solution.exercise.title}</td>
            <td>${solution.user.username}</td>
            <td>${solution.updated}</td>
            <td>
                <a href="/solutions/details?id=${solution.id}">Details</a>
                <a href="/solutions/update?id=${solution.id}">Edit</a>
                <a href="/solutions/delete?id=${solution.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../../fragments/footer.jspf" %>

</body>
</html>
