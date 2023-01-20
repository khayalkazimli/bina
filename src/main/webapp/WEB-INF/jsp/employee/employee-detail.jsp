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
    <title>Employees Profile</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <c:choose>
        <c:when test="${not empty employee}">
            <h2>Employee Profile</h2>
            ID: ${employee.id} <br/>
            NAME: ${employee.name} <br/>
            SURNAME: ${employee.surname} <br/>
            SALARY: ${employee.salary} <br/>
        </c:when>
        <c:otherwise>
            <h2>Employee not found!</h2>
        </c:otherwise>
    </c:choose>

    <%--or--%>
<%--    <h2>Employee Profile</h2>--%>
<%--    ID: ${employee.id} <br/>--%>
<%--    NAME: ${employee.name} <br/>--%>
<%--    SURNAME: ${employee.surname} <br/>--%>
<%--    SALARY: ${employee.salary} <br/>--%>
</body>
</html>
