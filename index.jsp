<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style.css">
</head>
<body>
<!-- 
<div class="sidenav">
  <a href="add.jsp">Add</a>
  <a href="listall.jsp">List All</a>
  <a href="#clients">About</a>
  <a href="#contact">Contact</a>
</div>
 -->
 <%@ page errorPage="Error.jsp"%>
<%@ include file="sidebar.jsp" %>

<div class="main">
  <h1>Add a New Contact</h1>
  <p>A simple web app to add contacts to the MySQL DB. Using Java, MySQL, HTML, CSS</p>
  <p>Fill out form</p>
  <form action="add" method="post">
 	<label>Name</label>
 	<input type="text" name="name" maxlength="40" size="50" required>
 	<br>
 	<label>Email</label>
 	<input type="text" name="email" maxlength="50" size="50" >
 	<br>
 	<label>Phone</label>
 	<input type="text" name="phone" maxlength="45" size="50" required>
 	<br>
 	<input type="submit" >
 </form>
</div>
   
</body>
</html> 
