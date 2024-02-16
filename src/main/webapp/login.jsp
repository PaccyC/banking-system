
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register User</title>
</head>
<body>
<h2>Create New User</h2>
<form action="login-servlet" method="post">
    <label for="name" >Name:</label>
    <input type="text" id="name" name="name" required> <br><br>

    <label for="password" >Password :</label>
    <input type="password" id="password" name="password" required> <br><br>

    <input type="submit" value="LOGIN" required><br><br>
</form>
</body>
</html>
