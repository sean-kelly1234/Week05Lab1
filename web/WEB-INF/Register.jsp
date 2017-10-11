<%-- 
    Document   : Register
    Created on : Oct 11, 2017, 1:40:11 PM
    Author     : 642202
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register User</h1>
        <form method="POST" action="">
            Username: <input type="text" name="username">  
            <input type="submit" value="Register">
            <input type="hidden" name="action" value="register">
        </form>
    </body>
</html>
