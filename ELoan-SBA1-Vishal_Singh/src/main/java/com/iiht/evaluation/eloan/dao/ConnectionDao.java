package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;

public class ConnectionDao {
	private static final long serialVersionUID = 1L;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	private String password;
	private String firstname;
	private String LoanType;
	private String status;


	public ConnectionDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }


	public  Connection connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	// put the relevant DAO methods here..
	public String getPassword(String user) {

		try {
			
			PreparedStatement stmt;
			jdbcConnection = connect();
			stmt = jdbcConnection.prepareStatement("Select password from eLoan.login where username=?;");
			stmt.setString(1, user);
			ResultSet result =stmt.executeQuery();
			while(result.next()){
				password = result.getString("password");
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return password;
	
	}


	public String storeDetails(String first, String middle, String last, String dOA, String requested, String buisstruct,
			String billingindicator, String taxpayer, String phone, String email, String gender, String loantype,
			String address) {
		// TODO Auto-generated method stub
		LoanInfo l = new LoanInfo();
		this.firstname = first;
		String middlename=middle;
		String lastname=last;
		String doa=dOA;
		String loanrequested=requested;
		String buisnessstruct=buisstruct;
		String billindi=billingindicator;
		String taxpay=taxpayer;
		String Email=email;
		String Gender=gender;
		String Phone=phone;
		this.LoanType=loantype;
		String Address=address;
		String Appid="";


		
		try {
			
			PreparedStatement stmt;
			jdbcConnection = connect();
			stmt = jdbcConnection.prepareStatement("insert ignore into eLoan.loanapplication(firstname,middlename,lastname,typeofloan,amtrequested,dateofapp,businessstruct,billingindi,taxpayer,phone,address,email,gender) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println(firstname);
			System.out.println(LoanType);
			stmt.setString(1, first);
			stmt.setString(2, middle);
			stmt.setString(3, last);
			stmt.setString(4, loantype);
			stmt.setString(5, requested);
			stmt.setString(6, dOA);
			stmt.setString(7, buisstruct);
			stmt.setString(8, billingindicator);
			stmt.setString(9, taxpayer);
			stmt.setString(10, phone);
			stmt.setString(11, address);
			stmt.setString(12, email);
			stmt.setString(13, gender);
			stmt.executeUpdate();
			
			stmt = jdbcConnection.prepareStatement("SELECT appid from eLoan.loanapplication where firstname=? and typeofloan=?;");
			stmt.setString(1, first);
			stmt.setString(2, loantype);
			ResultSet r =stmt.executeQuery();
			while(r.next()) {
				Appid =r.getString("appid");
			}

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Appid;
		
		
	}
	

	public String getStatus(String appid) {

		ResultSet r;
		try {
			
			PreparedStatement stmt;
			jdbcConnection = connect();
			stmt = jdbcConnection.prepareStatement("SELECT applicationstatus from eLoan.loanapplication where appid =?;");
			stmt.setString(1, appid);
			r = stmt.executeQuery();
			while(r.next()){
				 this.status = r.getString("applicationstatus");
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.status;
		
	}

	public String getDetails(String appid) {
		ResultSet r = null;
		
		PreparedStatement stmt;
		String a="";
		String b="";
		String c="";
		String d="";
		String e="";
		String f="";
		String g="";
		String h="";
		String i="";
		String j="";
		String k="";
		String l="";
		String m="";
		String n="";
		
		try {
			jdbcConnection = connect();
			stmt = jdbcConnection.prepareStatement("SELECT * from eLoan.loanapplication where appid =?;");
			stmt.setString(1,appid);
			r = stmt.executeQuery();
			while(r.next()){
				a=a+r.getString("firstname");
				b=r.getString("middlename");
				c=r.getString("lastname");
				d=r.getString("typeofloan");
				e=r.getString("amtrequested");
				f=r.getString("dateofapp");
				g=r.getString("businessstruct");
				h=r.getString("billingindi");
				i=r.getString("taxpayer");
				j=r.getString("phone");
				k=r.getString("address");
				l=r.getString("email");
				m=r.getString("gender");
				n=r.getString("applicationstatus");
			
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "First name :"+a+",\nMiddele Name :"+b+",\nLast Name :"+c+",\nLoan Type:"+d+",\nAmount Requested :"+e+",\nDate of application :"+
				",\nBuisness Structure :"+g+",\nBilling Indicator:"+h+",\nTax Payer :"+i+",\nPhone :"+j+",\nAddress :"+k+",\nEmail :"+l+",\nGender:"+m+
				",\nApplication Status :"+n;

		
	}
	
	public String loanId() {
	
		String a = "";

		try {
			PreparedStatement stmt;
			jdbcConnection = connect();
			
			stmt = jdbcConnection.prepareStatement("SELECT * from eLoan.loanapplication where applicationstatus ='Not Approved';");		
			ResultSet r = stmt.executeQuery();
			while(r.next()){
				String temp = r.getString("appid");
				a=temp+" , "+a;	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return a;
		
	}
	
	public String loantype(String id) {
		
		String a = "";

		try {
			PreparedStatement stmt;
			jdbcConnection = connect();
			
			stmt = jdbcConnection.prepareStatement("SELECT * from eLoan.loanapplication where appid =?;");
			stmt.setString(1, id);
			ResultSet r = stmt.executeQuery();
			while(r.next()){
				a = r.getString("typeofloan");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return a;
		
	}
	public String amount(String id) {
		
		String a = "";

		try {
			PreparedStatement stmt;
			jdbcConnection = connect();
			
			stmt = jdbcConnection.prepareStatement("SELECT * from eLoan.loanapplication where appid =?;");
			stmt.setString(1, id);
			ResultSet r = stmt.executeQuery();
			while(r.next()){
				a = r.getString("amtrequested");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return a;
		
	}
	
	public String storetoloan(String Appid, String duration, String emi) {
		

		String apid="";
		String sanc="";
		String l="";
		PreparedStatement stmt;

		try {
			jdbcConnection = connect();
			stmt = jdbcConnection.prepareStatement("select * from eLoan.loanapplication where appid=?;");
			stmt.setString(1, Appid);
			ResultSet r = stmt.executeQuery();
				while(r.next()){
					apid = r.getString("appid");
					sanc= r.getString("amtrequested");
				}

			stmt = jdbcConnection.prepareStatement("insert ignore into eLoan.loantable(appid,amountsanctioned,emimonthly,duration) values(?,?,?,?);");
			stmt.setString(1, apid);
			stmt.setString(2, sanc);
			stmt.setString(4, duration);
			stmt.setString(3, emi);
			stmt.executeUpdate();
			
			stmt = jdbcConnection.prepareStatement("update eLoan.loantable set lcd=DATE_ADD(loanapproveddate, INTERVAL duration MONTH), psd=DATE_ADD(loanapproveddate, INTERVAL 1 MONTH) Where appid=?;");
			stmt.setString(1, apid);
			stmt.executeUpdate();
	 
			stmt =jdbcConnection.prepareStatement("update eLoan.loanapplication set applicationstatus ='Approved' where appid =?;");
			stmt.setString(1, Appid);
			stmt.executeUpdate();
			
			stmt= jdbcConnection.prepareStatement("select loanid from eLoan.loantable where appid=?;");
			stmt.setString(1, apid);
			r= stmt.executeQuery();
			 	while(r.next()) {
			 		l = r.getString("loanid");
			 	}
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
		
		
		
	}
	
	public void updateaddress(String a, String id) {
		
		
		try {
			
			jdbcConnection =connect();
			PreparedStatement stmt = jdbcConnection.prepareStatement("update eLoan.loanapplication INNER JOIN eLoan.loantable ON eLoan.loantable.appid = eLoan.loanapplication.appid SET eLoan.loanapplication.address =? where eLoan.loantable.loanid =?;");
			stmt.setString(1, a);
			stmt.setString(2, id);
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
}
	

	
