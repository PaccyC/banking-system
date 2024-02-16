<%
  if (session.getAttribute("name") ==null){
    response.sendRedirect("login.jsp");
  }
%>

<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="logout">Logout</a>

<p> <%= session.getAttribute("name") %></p>
</body>
</html>