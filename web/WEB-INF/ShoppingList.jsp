<%-- 
    Document   : ShoppingList
    Created on : Oct 11, 2017, 1:37:39 PM
    Author     : 642202
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hi ${sessionScope.username}
        <a href="ShoppingList?action=logout">Logout</a> 
        <hr>
        <div>
            <form action="" method="POST">
                Add item: <input type="text" name="item" autofocus>
                <input type="submit" value="add">
                <input type="hidden" name="action" value="add">
            </form>
            <br>
            <br>
            <c:if test="${sessionScope.shoppingList != null}">
                <form action="" method="POST">
                    <c:forEach items="${sessionScope.shoppingList}" var="item" varStatus="status">
                        <input type="radio" name="list" value="${status.index}"> ${item}<br>
                    </c:forEach>
                        <input type="submit" value="delete">
                        <input type="hidden" name="action" value="delete">
                </form>
            </c:if>
        </div>
    </body>
</html>
