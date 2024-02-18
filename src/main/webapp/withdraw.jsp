<%--
  Created by IntelliJ IDEA.
  User: paccy
  Date: 2/18/24
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Withdraw Money</title>
</head>
<body>
<h1>WithDraw Money</h1>
<form action="withdraw" method="post">
    <label for="userId">User ID:</label>
    <input type="text" id="userId" name="userId" required><br><br>
    <label for="amount">Amount to Withdraw:</label>
    <input type="number" id="amount" name="amount" required><br><br>
    <input type="submit" value="Withdraw">
</form>
</body>
</html>
