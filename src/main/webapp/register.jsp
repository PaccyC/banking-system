<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register User</title>
</head>
<body>
<h2>Create New User</h2>
<form action="register" method="post">
    <label for="name" >Name:</label>
    <input type="text" id="name" name="name" required> <br><br>

    <label for="age" >Age :</label>
    <input type="number" id="age" name="age" required> <br><br>
    <label for="email" >Email :</label>
    <input type="email" id="email" name="email" required> <br><br>

    <label for="password">Password : </label>
    <input type="password" id="password" name="password" required>

    <p >Account Type</p>
    <label for="current">Current Account</label>
    <input type="radio" id="current" name="accountType" value="current" required>

    <label for="savings">Savings Account</label>
    <input type="radio" id="savings" name="accountType" value="savings" required>
    <label for="balance" >Initial Balance :</label>
    <input type="text" id="balance" name="balance" required> <br><br>

    <input type="submit" value="CREATE" required> <br><br>
</form>
</body>
</html>
