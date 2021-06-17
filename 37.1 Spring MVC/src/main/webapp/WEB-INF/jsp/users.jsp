<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.itis.site.dto.AccountDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/6/2021
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Users</h1>
<table>
    <tr>
        <th>ID</th>
        <th>FIRST NAME</th>
        <th>LAST NAME</th>
        <th>EMAIL</th>
    </tr>
    <c:forEach items="${accounts}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.firstName}</td>
            <td>${account.lastName}</td>
            <td>${account.email}</td>
        </tr>
    </c:forEach>
    <%--    <%--%>
    <%--        List<AccountDto> accounts = (List<AccountDto>) request.getAttribute("accounts");--%>
    <%--        for (AccountDto account : accounts) {--%>
    <%--    %>--%>
    <%--    <tr>--%>
    <%--        <td><%=account.getId()%>--%>
    <%--        </td>--%>
    <%--        <td><%=account.getFirstName()%>--%>
    <%--        </td>--%>
    <%--        <td><%=account.getLastName()%>--%>
    <%--        </td>--%>
    <%--        <td><%=account.getEmail()%>--%>
    <%--        </td>--%>
    <%--    </tr>--%>
    <%--    <%}%>--%>
</table>
<form action="/users" method="post">
    <input type="text" name="firstName" placeholder="First Name">
    <input type="text" name="lastName" placeholder="Last Name">
    <input type="email" name="email" placeholder="Email">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" value="Add">
</form>
</body>
</html>
