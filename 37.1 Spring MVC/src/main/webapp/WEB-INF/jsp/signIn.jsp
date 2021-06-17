<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/14/2021
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body>
<form action = "/signIn" method = "post">
    <input name = "email" placeholder="Email">
    <input name = "password"  type = "password" placeholder="Password">
    <input type = "submit"  value="Sign In">
</form>

</body>
</html>
