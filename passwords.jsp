<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="data.Contact" %>
<%@ page import="data.Pass" %>
<%@ page errorPage="Error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">

<title>Listing all Contacts</title>
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
<!-- <div class="sidenav">
  <a href="add.jsp">Add</a>
  <a href="listall.jsp">List All</a>
  <a href="passwords.jsp">Password</a>
  <a href="#clients">About</a>
  <a href="#contact">Contact</a>
</div> -->
<%@ include file="sidebar.jsp" %>
<div class="main">
	<h1>Password Manager</h1>
	
	<% String message = (String) request.getAttribute("message"); %>
	The message: <%= message %>
	<br>
	${message}
	<br>
	<% String listing = (String)request.getAttribute("listing"); %>
	<% out.println(listing); %>
	<br>
	<% Integer x = (Integer) request.getAttribute("size"); 
	   if(x != null){   
		int size = x.intValue();
	   	out.println("Size: " + size);
	   }
	   %>
	<% ArrayList<Pass> cts = (ArrayList)request.getAttribute("pass"); 
	   if(cts != null){   
		out.println("cts size: " + cts.size()) ;
		}
	%>
	<br>
	 <table>
	  <tr> <!-- Table Header -->
	  <th>ID</th> <th>Name</th> <th>Email</th><th>Phone</th> <th>Action</th>
	  </tr>
	  <c:forEach var="con" items="${pass}">
	  <form  method="post">
	  	<tr>
	  		<td> <input type="text" name="id" readonly  value=" <c:out value='${con.id}' />"  /> </td>
	  		<td> <input type="text" name="title"         value=" <c:out value='${con.name}' />"  /> </td>
	  		<td> <input type="text" name="loginid"        value=" <c:out value='${con.email}' />"  /> </td>
	  		<td> <input type="text" name="password"        value=" <c:out value='${con.phone}' />"  /> </td>
	  		<td> <input type="submit" value="delete" formaction="deletepass" onClick='return confirmDelete()' >  </td>
	  		<td> <input type="submit" value="Update" formaction="updatepass"> </form> </td>
	  	</tr>
	  </c:forEach>
	 </table>
	 <br>
	
	 <div class="main">
	 <form action="addpass" method="post">
	 	<label for="title">Title</label>
	 	<input type="text" name="title" maxlength="40" size="50" required />
	 	<br>
	 	<label for="loginid">Login ID</label>
	 	<input type="text" name="loginid" maxlength="50" size="50" required />
	 	<br>
	 	<label for="password">Password</label>
	 	<input type="text" name="password" maxlength="45" size="50" required />
	 	<br>
	 	<label>Notes</label>
	 	<textarea name="notes" />
	 	<input type="submit" />
	 </form>
	</div>
	
</div>
</body>
</html>
