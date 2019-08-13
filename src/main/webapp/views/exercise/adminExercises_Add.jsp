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
<h2>Add new exercise</h2>
<form action="/admin/exercises/add" method="POST">
    <div>
    <label>
        Name:
        <input type="text" name="name">
    </label>
    </div>
    <div>
        <h2>Exercise description: </h2>
        <textarea name="description" rows="4" cols="50" placeholder="Please enter exercise description...">
</textarea>
    </div>
    <input type="submit" value="Create new exercise">
</form>
</body>
</html>
