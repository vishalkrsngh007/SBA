<%@page import="com.iiht.evaluation.eloan.dao.ConnectionDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- write html code to read the application number and send to usercontrollers'
             displaystatus method for displaying the information
	-->
<jsp:include page="header.jsp"/>
<div align="justify"><a href="userhome1.jsp">Home</a><br></div>
<br/>
<form action ="user" method="post">
	<h2>Track your application</h2>
	<input type="hidden" value="displaystatus" name="action" /> 
	<label>Enter Application ID : 
	<input type="text" name="appID" />
	</label>
	<br/><br/>
	<input type="submit" name="Submit" />
</form>
<br/>
<div align="justify"><h3><%=request.getAttribute("appID")%></h3></div>

<jsp:include page="footer.jsp"/>

</body>
</html>