<%@ page import="myserver.MyFirstServer.Cart" %><%--
  Created by IntelliJ IDEA.
  User: Чебурек
  Date: 19.03.2021
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Cart</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <% Cart cart = (Cart) session.getAttribute("cart");%>
    <p>Наименование: <%=cart.getName()%></p>
    <p>Количество: <%=cart.getQuantity()%></p>
</body>
</html>
