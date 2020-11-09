<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Loans</title>
</head>
<body>
	<!-- write code to display all the loan details 
             which are received from the admin controllers' listall method
	--> 
<jsp:include page="header.jsp"/>
<div align="justify"><a href="userhome1.jsp">Home</a><br></div>
<form action ="admin" method="post">
	<h2>Not Approved List</h2>
	<input type="hidden" value="listall" name="action" /> 
	<input type="submit" name="Submit" value="Non Approved Loans" />
	<br/><br/><br/>
	 <h4>Application IDs: <%=request.getAttribute("listed")%> </h4>
	 <br/><br/><br/>
	 
	 <label>Enter Loan number to get details :
	 <input type="text" name="loanid">
	 <input type="submit" name="Submit" value="Details" />
	 <br/><br/>
	 <%=request.getAttribute("id") %>
	 
	 
	 </label>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>