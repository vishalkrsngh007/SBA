package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;


@WebServlet("/admin")
public class AdminController extends HttpServlet {
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
		String action =  request.getParameter("action");
		System.out.println(action);
		String viewName = "";
		try {
			switch (action) {
			case "listall" : 
				viewName = listall(request, response);
				break;
			case "process":
				viewName=process(request,response);
				break;
			case "calemi":
				viewName=calemi(request,response);
				break;
			case "updatestatus":
				viewName=updatestatus(request,response);
				break;
			case "logout":
				viewName = adminLogout(request, response);
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

	private String updatestatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code for updatestatus of loan and return to admin home page */
		ConnectionDao dao = new ConnectionDao("jdbc:mysql://localhost:3306/eLoan", "root", "Password");
		String appid =request.getParameter("Appid");
		String duration =request.getParameter("duration");
		String a= dao.loantype(appid);
		LoanDto d = new LoanDto();
		String s =d.setEmi(a,appid,duration);
		String em= d.getEmi();
		String b =dao.storetoloan(appid,duration,em);
		request.setAttribute("details", b);
		return "calemi.jsp";
	}
	private String calemi(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
	/* write the code to calculate emi for given applno and display the details */
		ConnectionDao dao = new ConnectionDao("jdbc:mysql://localhost:3306/eLoan", "root", "Password");
		String id =request.getParameter("Appid");
		String dur =request.getParameter("time");
		String a= dao.loantype(id);
		String amt= dao.amount(id);
		Integer i = Integer.parseInt(amt);
		Double emi =(double) 0;
		Integer n =Integer.parseInt(dur);
		switch (a) {
		case "Education" :
			Double r=10.45/100;
			emi=(i*r*(1+r)*n)/((1+r)*n-1);
			break;
		case "Home Loan" :
			Double h=8.45/100;
			emi=(i*h*(1+h)*n)/((1+h)*n-1);
			break;
		case "Personal Loan" :
			Double p=12.45/100;
			emi=(i*p*(1+p)*n)/((1+p)*n-1);
			break;
		case "Vehicle Loan" :
			Double v=9.45/100;
			emi=(i*v*(1+v)*n)/((1+v)*n-1);
			break;

		}
		long d =Math.round(emi);
		String s= Double.toString(d);
		request.setAttribute("emi", s);
		LoanDto dt = new LoanDto(id, i, d);
		dt.setEmi(a, id, dur);
	
	return "calemi.jsp";
}
	private String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
	/* return to process page */
		
		return  "process.jsp";
	}
	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write code to return index page */
		return null;
	}

	private String listall(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	/* write the code to display all the loans */
		ConnectionDao dao = new ConnectionDao("jdbc:mysql://localhost:3306/eLoan", "root", "Password");
		//List<String> all=dao.listall();
		String id= request.getParameter("loanid");
		String r = dao.loanId();
		request.setAttribute("listed",r);
		
		if(!id.isEmpty()) {
			String d = dao.getDetails(id);
			request.setAttribute("id", d);
			
		}
		return "listall.jsp";
	}

	
}