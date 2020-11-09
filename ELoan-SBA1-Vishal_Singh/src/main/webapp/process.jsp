<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- write the code to read application number, and send it to admincontrollers
	     callemi method to calculate the emi and other details also provide links
	     to logout and admin home page
	-->
<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<div align="right"><a href="adminhome1.jsp">Admin home</a></div>
<form action="admin" method="post">
	<h2>Process loan</h2>
	<label>Enter Application number :
	<input type= "text" name="Appid"/>
	</label>
	<label>Enter Duration :
	<input type= "text" name="time"/>
	</label>
	<input type="hidden" value="calemi" name="action" /> 
	<input type="submit" name="submit" value="Calculate EMI"/>
	
</form>
<br/><br/>
	
<jsp:include page="footer.jsp"/>
</body>
</html>