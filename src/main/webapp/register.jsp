
<html>
<head>
    <title>Register User</title>
</head>
<body>
<h2>Create New User</h2>
<form action="createCustomerServlet" method="post">
    <label for="name" >Name:</label>
    <input type="text" id="name" name="name" required> <br><br>

    <label for="age" >Age :</label>
    <input type="number" id="age" name="age" required> <br><br>

    <input type="submit" value="CREATE" required> <br><br>
</form>
</body>
</html>
