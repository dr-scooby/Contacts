<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.0 Transitional//EN">
<%@ page isErrorPage="true"%>
<%@ page import="java.io.*"%>
<HTML>
<HEAD>
<TITLE>Error </TITLE>

</HEAD>
<%@ include file="sidebar.jsp" %>
 
	<BODY>
	<div class="main">
		<TABLE BORDER=5 ALIGN="CENTER">
			<TR>
				<TH CLASS="TITLE">Error in Application
		</TABLE>
		<P>
		The Context Path <%= request.getContextPath() %>
		<P>
			Applicaton reported the following error: <I><%=exception%></I>.
			This problem occurred in the following place:
		<PRE>
			<%
				exception.printStackTrace(new PrintWriter(out));
			%>
		</PRE>
	</div>
	</BODY>
</HTML>
