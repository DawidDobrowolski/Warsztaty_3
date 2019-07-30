<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edycja wybranego zadania</h2>
<form action="/admin/exercises/update" method="POST">
    <div>
    <label>
        Name:
        <input type="text" name="title" value="${exercise.title}">
    </label>
    </div>
    <div>
    <h2>Opis zadania: </h2>
    <textarea name="description" rows="4" cols="50" placeholder="Prosze wpisac opis zadania...">
${exercise.description}</textarea>
    </div>
    <input type="submit" value="Zaktualizuj dane zadania">
</form>
</body>
</html>
