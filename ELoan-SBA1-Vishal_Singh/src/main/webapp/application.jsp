<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body onload="myFunction()" style="background-color:powderblue;">
<!--
	write the html code to accept laon info from user and send to placeloan servlet
-->
<jsp:include page="header.jsp"/>

<div align="justify"><a href="userhome1.jsp">Home</a><br></div>
<br/>
<h2> Apply for loan</h2>

<form action ="user" method="post">
		  
		<br /> <label>First Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			type="text" name="First" />
		</label>
		 <br /> <br/>
		 
		 <label>Middle Name &nbsp;&nbsp; <input
			type="text" name="Middle" />
		</label> 
		<br /> <br/>
		
		<label>Last Name
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="Last" />
		</label>
		 <br /> <br/>
		 
		 <label>Date of App &nbsp;&nbsp;&nbsp; <input
			type="date" name="doa" />
		</label> 
		<br /> <br/>
		
		<label>Loan amount Requested &nbsp;&nbsp;&nbsp; <input
			type="text" name="requested" />	
		</label> 
		<br /> <br/>
		
		<label for="buisness struct"> Business Structure</label> 
		<select
			name="buisness struct" id="buisness struct">
			<option value="Buisness">Organization</option>
			<option value="Individual">Individual</option>
		</select> 
		<br/><br/>
		
		<label for="billingindicator"> Salaried</label> 
		<select
			name="billingindicator" id="billing indicator">
			<option value="Yes">Yes</option>
			<option value="No">No</option>
		</select> 
		<br/><br/>
		
		
		<label for="taxpayer"> Tax Payer</label> 
		<select
			name="taxpayer" id="taxpayer">
			<option value="Yes">Yes</option>
			<option value="No">No</option>
		</select> 
		<br/><br/>
		
		
		<label>Phone &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			type="text" name="phone" />
		</label> <br /> <br /> 
		
		
		<label>Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			type="text" name="email" />
		</label> <br /> <br /> 
		
		<label>Gender</label> <input type="radio"
			id="male" name="gender" value="male"> <label for="male">Male</label>&nbsp; 
			<input type="radio" id="male" name="gender" value="female"> 
			<label for="female">Female</label><br/> <br />

				
	 	<label for="loan type"> Loan Type</label> 
		<select
			name="loan type" id="loan type">
			<option value="Home Loan">Home Loan</option>
			<option value="Education">Education Loan</option>
			<option value="Personal Loan">Personal Loan</option>
			<option value="Vehicle Loan">Vehicle Loan</option>
		</select> 
		<br /> <br /> 
		
		<label>Address : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			type="text" name="address" />
		</label> <br /> <br /> 
		
		<input type="hidden" value="placeloan" name="action" /> 
			
		<input type="submit" name="Submit" />
	
	</form>
<br/><br/>

<h3><%=request.getAttribute("applnum")%></h3>

<jsp:include page="footer.jsp"/>
</body>
</html>