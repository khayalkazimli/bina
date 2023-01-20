<%--
  Created by IntelliJ IDEA.
  User: o_ram
  Date: 31.08.2021
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Table Generator with Spring</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <c:forEach begin="1" end="${row}" step="1" var="i">
            <tr>
                <c:forEach begin="1" end="${column}" step="1" var="j">
                    <td>${i * j}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
