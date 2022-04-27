<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="data.Contact" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>

<link rel="stylesheet" href="style.css">

<script LANGUAGE="JavaScript">

function confirmDelete()
{
var agree=confirm("Are you sure you wish to Delete?");
if (agree)
 return true ;
else
 return false ;
}

</script>

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
<h1>Contacts</h1>

<% String message = (String) request.getAttribute("message"); %>
The message: <%= message %>
<br>
${message}
<br>
<% String listing = (String)request.getAttribute("listing"); %>
<% out.println(listing); %>
<br>
<% 
   Integer x = (Integer) request.getAttribute("size"); 
	   if(x!=null){
	   int size = x.intValue();
	   out.println("Size: " + size);
   }
   %>
<% 
  ArrayList<Contact> cts = (ArrayList)request.getAttribute("contacts"); 
  if(cts != null) {
	  out.println("cts size: " + cts.size()) ;
  }  
	  %>
  
<br>
 <table>
  <tr> <!-- Table Header -->
  <th>ID</th> <th>Name</th> <th>Email</th><th>Phone</th> <th>Action</th>
  </tr>
  <c:forEach var="con" items="${contacts}">
  <form  method="post">
  	<tr>
  		<td> <input type="text" name="id" readonly  value=" <c:out value='${con.id}' />"  /> </td>
  		<td> <input type="text" name="name"         value=" <c:out value='${con.name}' />"  /> </td>
  		<td> <input type="text" name="email"        value=" <c:out value='${con.email}' />"  /> </td>
  		<td> <input type="text" name="phone"        value=" <c:out value='${con.phone}' />"  /> </td>
  		<td> <input type="submit" value="delete" formaction="delete" onClick='return confirmDelete()' >  </td>
  		<td> <input type="submit" value="Update" formaction="update"> </form> </td>
  	</tr>
  </c:forEach>
 </table>
 <br>
 <div>
 <div>
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
</div>
</div>
</body>
</html>
