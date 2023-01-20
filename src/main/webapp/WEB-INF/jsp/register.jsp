<%--
  Created by IntelliJ IDEA.
  User: o_ram
  Date: 02.09.2021
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Registration</title>
    <style>
        .xeta {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Zehmet olmasa, butun melumatlari doldurun</h1>
    <form:form method="post" modelAttribute="userRegistrationForm">
        Ad: <form:input path="name" /> <br/>
        <span>
            <form:errors path="name" cssClass="xeta"/>
        </span> <br/>


        Soyad: <form:input path="surname" /> <br/>
        <span>
            <form:errors path="surname" cssClass="xeta"/>
        </span> <br/>

        Email: <form:input path="email" /> <br/>
        <span>
            <form:errors path="email" cssClass="xeta"/>
        </span> <br/>

        Mobil: <form:input path="mobile" /> <br/>
        <span>
            <form:errors path="mobile" cssClass="xeta"/>
        </span> <br/>

        Sifre: <form:password path="password" /> <br/>
        <span>
            <form:errors path="password" cssClass="xeta"/>
        </span> <br/>

        Sifrenin tekrar: <form:password path="passwordConfirm" /> <br/>
        <span>
            <form:errors path="passwordConfirm" cssClass="xeta"/>
        </span> <br/>

        <input type="submit" value="Qeydiyyatdan kec">
    </form:form>
</body>
</html>
