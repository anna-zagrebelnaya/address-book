<%--
  Created by IntelliJ IDEA.
  User: Anka
  Date: 08.04.2015
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address-book</title>
</head>
<body>
    <form action="AddressBookServlet">
        Please log in<br>
        <input type="text" name="user">
        <input type="submit" value="Log in">
    </form>

    <form action="HelloServlet">
        <input type="submit" value="Get Hello bean">
    </form>
</body>
</html>
