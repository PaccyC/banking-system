<%--
  Created by IntelliJ IDEA.
  User: paccy
  Date: 2/14/24
  Time: 7:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>CREATE ACCOUNT</title>
</head>
<body>
<h2>Create New Account</h2>
<form action="createAccountServelet" method="get">
<label for="name" >Name:</label>
    <input type="text" id="name" name="firstName" required> <br><br>

<label for="balance" >Initial Balance :</label>
    <input type="text" id="balance" name="balance" required> <br><br>

    <input type="submit" value="Create Account" required> <br><br>
</form>
</body>
</html>
