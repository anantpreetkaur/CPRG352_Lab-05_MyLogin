<%-- 
    Document   : login
    Created on : 27 Jul, 2022, 10:57:22 AM
    Author     : anant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login">
            <label>Username: </label>
            <input type="text" name="user" value="${user}">
            <br>
            <label>Password: </label>
            <input type="password" name="password" value="${password}">
            <input type="submit" value="Log_in">
        </form>
        <h2>${message}</h2>
    </body>
</html>
