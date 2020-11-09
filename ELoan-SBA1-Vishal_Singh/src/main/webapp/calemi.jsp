<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <!--
     Read the values from the admin servlet and cal emi and other details and send to
     to the same admin servlet to update the values in the database 
  --> 
 <form action="admin" method="post">
 	<input type="hidden" value="updatestatus" name="action" /> 
 	<h4>EMI : <%= (String)request.getAttribute("emi")%></h4>

		<label>Enter Application number :
		<input type= "text" name="Appid"/>
		</label>

	<label>Enter Duration :
	<input type= "text" name="duration"/>
	</label>
	<button type="submit" name="btn-submit">Approve loan</button>
	
	<h3>Loan ID :<%=request.getAttribute("details")%></h3>
</form>


</body>
</html>