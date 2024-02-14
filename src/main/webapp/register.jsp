<%--
  Created by IntelliJ IDEA.
  User: paccy
  Date: 2/14/24
  Time: 7:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register User</title>
</head>
<body>
<h2>Create New User</h2>
<form action="createCustomerServlet" method="get">
    <label for="name" >Name:</label>
    <input type="text" id="name" name="name" required> <br><br>

    <label for="age" >Age :</label>
    <input type="number" id="age" name="age" required> <br><br>

    <input type="submit" value="CREATE" required> <br><br>
</form>
</body>
</html>
