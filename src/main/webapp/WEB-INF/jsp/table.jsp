<%--
  Created by IntelliJ IDEA.
  User: o_ram
  Date: 31.08.2021
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table Generator with Spring</title>
</head>
<body>
    <h1>Welcome to Spring Boot</h1>
    <form method="post" action="table">
        Number of rows: <input type="number" name="row"/><br/>
        Number of columns: <input type="number" name="column"/><br/>
        <input type="submit" value="Generate table">
    </form>
</body>
</html>
