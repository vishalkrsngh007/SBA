package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.mysql.cj.xdevapi.Statement;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ConnectionDao connDao;
	
	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}
	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
	
		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName=registernewuser(request,response);
				break;
			case "validate":
				viewName=validate(request,response);
				break;
			case "placeloan":
				viewName=placeloan(request,response);
				break;
			case "application1":
				viewName=application1(request,response);
				break;
			case "editLoanProcess"  :
				viewName=editLoanProcess(request,response);
				break;
			case "registeruser":
				viewName=registerUser(request,response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;	
			case  "displaystatus" :
				viewName=displaystatus(request,response);
				break;
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	}
	private String validate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code to validate the user */
		ConnectionDao dao = new ConnectionDao("jdbc:mysql://localhost:3306/eLoan", "root", "Password");
		String r="";
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String dbpass =dao.getPassword(user);
		if(user.equals("admin") && pass.equals("admin")) {
			r="adminhome1.jsp";
			
		}
		else {
			if(pass.equals(dbpass)){
				r="userhome1.jsp";
			
			}else {
				r="errorPage.jsp";
			}
		}
		
		
	 return r;
	}
	
	private String placeloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write the code to place the loan information */
		ConnectionDao dao = new ConnectionDao("jdbc:mysql://localhost:3306/eLoan", "root", "Password");
		
		String first = request.getParameter("First");
		String middle = request.getParameter("Middle");
		String last = request.getParameter("Last");
		String DOA = request.getParameter("doa");
		String requested = request.getParameter("requested");
		String buisstruct = request.getParameter("buisness struct");
		String billingindicator = request.getParameter("billingindicator");
		String taxpayer = request.getParameter("taxpayer");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String loantype = request.getParameter("loan type");
		String address = request.getParameter("address");
	
		
		//String Gender = request.getParameter("gender");
		
		String r = dao.storeDetails(first,middle,last,DOA,requested,buisstruct,billingindicator,taxpayer, phone,email,gender,loantype,address);
		request.setAttribute("applnum", "Your Application number is :"+r);
		return "application.jsp";
	}
	private String application1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write the code to display the loan application page */
		
		return null;
	}
	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to edit the loan info */
		
		return null;
	}
	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to redirect page to read the user details */
		return "newuserui.jsp";
	}
	private String registernewuser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to create the new user account read from user 
		   and return to index page */
		return null;
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */
		
		return null;
	}
	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code the display the loan status based on the given application
		   number 
		*/
		ConnectionDao dao = new ConnectionDao("jdbc:mysql://localhost:3306/eLoan", "root", "Password");
		String appid = request.getParameter("appID");
		
		String a = dao.getStatus(appid);
		
		request.setAttribute("appID", "Your application is "+a);
		return "trackloan.jsp";
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to editloan page */
		ConnectionDao dao = new ConnectionDao("jdbc:mysql://localhost:3306/eLoan", "root", "Password");
		LoanInfo i = new LoanInfo();
		String a =request.getParameter("address");
		String b =request.getParameter("loanid");
		i.setAddress(a,b);
		String d = dao.getDetails(b);
		request.setAttribute("details", d);	
		return "editloan.jsp";
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		
		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		return null;
	}
}