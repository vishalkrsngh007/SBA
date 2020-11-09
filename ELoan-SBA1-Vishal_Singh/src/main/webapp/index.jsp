<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eLoan system</title>
</head>
<body style="background-color:powderblue;">
	<!-- write the html code to read user credentials and send it to validateservlet
	    to validate and user servlet's registernewuser method if create new user
	    account is selected
	-->
<h1>Welcome to IBS</h1>
<h2> Login</h2>
	<form action="user" method="post">
		<label> User Name : <input type="text" name="username" />
		</label> <br />
		<br /> <label>Password : <input type="text" name="password" />
		</label> <br />
		<br /> <input type="hidden" value="validate" name="action" /> <input
			type="submit" name="Submit" />
			
		<br/><br/>
	 <label>  Not registered <a href="newuserui.jsp">click here</a></label>
	</form>
	
</body>
</html>