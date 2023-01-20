<%--
  Created by IntelliJ IDEA.
  User: o_ram
  Date: 31.08.2021
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <h2><a href="add">Yeni isci elave et</a></h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Salary</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${employees}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.salary}</td>
            <td><a href="/employees/${emp.id}">View</a> &nbsp;
                <a href="/employees/${emp.id}/update">Update</a>&nbsp;
                <a href="/employees/${emp.id}/delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr></tr>
</table>
</body>
</html>
