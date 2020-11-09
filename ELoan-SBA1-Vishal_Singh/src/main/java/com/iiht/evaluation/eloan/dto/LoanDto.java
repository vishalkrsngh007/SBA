package com.iiht.evaluation.eloan.dto;

import com.iiht.evaluation.eloan.dao.ConnectionDao;

public class LoanDto {
	private String applno;
	private int amtRequested;
	private String emi;
	public LoanDto() {
		
	}
	public LoanDto(String applno, int amtRequested, long emi) {
		super();
		this.applno = applno;
		this.amtRequested = amtRequested;
	}
	public String getApplno() {
		return applno;
	}
	public void setApplno(String applno) {
		this.applno = applno;
	}
	public int getAmtRequested() {
		return amtRequested;
	}
	public void setAmtRequested(int amtRequested) {
		this.amtRequested = amtRequested;
	}
	public String getEmi() {
		System.out.println(emi);
		return emi;
	}
	public String setEmi(String type,String appid,String dur) {
		Double emi1 = null;
		ConnectionDao dao = new ConnectionDao("jdbc:mysql://localhost:3306/eLoan", "root", "Password");
		
		String amt= dao.amount(appid);
		Integer i = Integer.parseInt(amt);
		Integer n =Integer.parseInt(dur);
		switch (type) {
		case "Education" :
			Double r=10.45/100;
			emi1=(i*r*(1+r)*n)/((1+r)*n-1);
			break;
		case "Home Loan" :
			Double h=8.45/100;
			emi1=(i*h*(1+h)*n)/((1+h)*n-1);
			break;
		case "Personal Loan" :
			Double p=12.45/100;
			emi1=(i*p*(1+p)*n)/((1+p)*n-1);
			break;
		case "Vehicle Loan" :
			Double v=9.45/100;
			emi1=(i*v*(1+v)*n)/((1+v)*n-1);
			break;

		}
		long d =Math.round(emi1);
		String emi= Double.toString(d);
		
		return this.emi = emi;
	}

	
	
	

}
