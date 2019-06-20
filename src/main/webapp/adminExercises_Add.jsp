<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 6/20/19
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dodanie nowego zadania</h2>
<form action="/admin/exercises/add" method="POST">
    <div>
    <label>
        Name:
        <input type="text" name="name">
    </label>
    </div>
    <div>
        <h2>Opis zadania: </h2>
        <textarea name="description" rows="4" cols="50" placeholder="Prosze wpisac opis zadania...">
</textarea>
    </div>
    <input type="submit" value="Stworz nowe zadanie">
</form>
</body>
</html>
