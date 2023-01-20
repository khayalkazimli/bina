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
    <title>Update employee profile</title>
</head>
<body>
    <h2>Zehmet olmasa isci melumatlarini daxil edin</h2>
    <form method="post" action="/employees/update">
        <input type="hidden" name="id" value="${employee.id}"><br/>
        Name: <input type="text" name="name" value="${employee.name}"><br/>
        Surname: <input type="text" name="surname" value="${employee.surname}"><br/>
        Salary: <input type="text" name="salary" value="${employee.salary}"><br/>
        <input type="submit" value="Update">
    </form>
</body>
</html>
