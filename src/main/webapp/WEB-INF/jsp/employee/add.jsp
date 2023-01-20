<%--
  Created by IntelliJ IDEA.
  User: Khayal Kazimli
  Date: 10/5/2021
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new employee</title>
</head>
<body>
    <h2>Zehmet olmasa isci melumatlarini daxil edin</h2>
    <form method="post" action="add">
        Name: <input type="text" name="name"><br/>
        Surname: <input type="text" name="surname"><br/>
        Salary: <input type="text" name="salary"><br/>
        <input type="submit" value="Add">
    </form>
</body>
</html>
