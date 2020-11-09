<%@page import="com.iiht.evaluation.eloan.model.LoanInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>
</head>
<body style="background-color:powderblue;">
	<!-- read the application number to edit from user and send to 
	     user controller to edit info
	-->
<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<div align="right"><a href="adminhome1.jsp">Admin Home</a></div>

<form action="user" method ="post">
	 <label>Enter Loan number to get details :
	 <input type="text" name="loanid">
	 <input type="submit" name="Submit" value="Details" />
	 <%=request.getAttribute("details") %>
	 <br/><br/>
	 <h4> Enter values need to edit</h4>
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
	 </label>
	 
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
				<label>Address : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			type="text" name="address" />
			<input type="hidden" value="editloan" name="action" /> 	
		</label> <br /> <br /> 
		<input type="submit" name="Submit" />
		

</form>
<%LoanInfo n = new LoanInfo(); %>
<h3><%n.getAddress();%> </h3>



<jsp:include page="footer.jsp"/>
</body>
</html>