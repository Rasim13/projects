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
    <title>SignUp</title>
</head>
<body>
<form action = "/signUp" method = "post">
    <input name = "firstName" placeholder="First Name">
    <input name = "lastName" placeholder="Last Name">
    <input name = "email" placeholder="Email">
    <input name = "password"  type = "password" placeholder="Password">
    <input type = "submit"  value="Sign Up">
</form>

</body>
</html>
