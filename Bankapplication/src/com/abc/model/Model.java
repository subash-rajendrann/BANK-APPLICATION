package com.abc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class Model {
       private String name;
       private String cusid;
       private int accno;
       private String pswd;
       private String email;
       private int balance;
       private int  raccno;
       private int amt;
   public ArrayList lacc=new ArrayList(); 
   public ArrayList lemail=new ArrayList(); 
   public ArrayList lamt=new ArrayList(); 
	public  ArrayList al=new ArrayList();
      public   ArrayList sal=new ArrayList();
      public  ArrayList ral=new ArrayList();

private Connection con;PreparedStatement pstmt;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCusid() {
	return cusid;
}
public void setCusid(String cusid) {
	this.cusid = cusid;
}
public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}
public String getPswd() {
	return pswd;
}
public void setPswd(String pswd) {
	this.pswd = pswd;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public int getRaccno() {
	return raccno;
}
public void setRaccno(int raccno) {
	this.raccno = raccno;
}
public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
public Model() throws Exception {
 Class.forName("com.mysql.cj.jdbc.Driver");
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "root123");
System.out.println("loading driver and establishing connection is completed");
	
	
}
public Boolean register() throws SQLException {
	String s ="insert into customerdetails values(?,?,?,?,?,?) ";
	 pstmt=con.prepareStatement(s);
	pstmt.setString(1, name);
	pstmt.setString(2, pswd); 
	pstmt.setString(3, cusid);
	pstmt.setInt(4, accno);
	pstmt.setInt(5, balance);
	pstmt.setString(6,email);
	
	int x=pstmt.executeUpdate();
	
	if(x>0) {
		return true;
	}
	return false;
	
	
}
public boolean logic() throws SQLException {
	String s = " select * from customerdetails where custid=?  and  password=?";
	pstmt =con.prepareStatement(s);
	pstmt.setString(1, cusid);
	pstmt.setString(2, pswd);
	ResultSet res= pstmt.executeQuery();
	while(res.next()==true) {
		accno=res.getInt("accno");
		return true;
	}
	return false;
}
public boolean checkbal() throws SQLException {
	String s="select balance from customerdetails where accno=?";
	pstmt=con.prepareStatement(s);
	pstmt.setInt(1, accno);
	ResultSet res=pstmt.executeQuery();
	while(res.next()==true) {
		balance=res.getInt("balance");
		return true;
	}
	
	return false;
}
public boolean changePassword() throws SQLException {
	String s ="update customerdetails set password=? where accno=?";
	pstmt=con.prepareStatement(s);
	pstmt.setString(1, pswd);
	pstmt.setInt(2, accno);
	int x=pstmt.executeUpdate();
	if(x>0) {
	
	return true;}
	else {
		return false;
	}
}
public boolean transferamt() throws SQLException {
	 String s1="select * from customerdetails where accno=?";
	 pstmt=con.prepareStatement(s1);
	 pstmt.setInt(1, raccno);
	 ResultSet res=pstmt.executeQuery();
	 while(res.next()==true) {
		 String s2="update customerdetails set balance=balance-? where accno=?";
		 pstmt=con.prepareStatement(s2);
   	 pstmt.setInt(1, balance);
		 pstmt.setInt(2, accno);
		 int res1=pstmt.executeUpdate();
		 if(res1>0) {
			       int x=res.getInt("balance");
			       if(x>0) {
			    	   String s3="update customerdetails set balance=balance+? where accno=?";
			    	   pstmt=con.prepareStatement(s3);
			    	   pstmt.setInt(1, balance);
			    	   pstmt.setInt(2, raccno);
			    	   int res2=pstmt.executeUpdate();
			    	   if(res2>0) {
			    		   String s4="insert into GetStatement values(?,?,?)";
			    		   pstmt=con.prepareStatement(s4);
			    		   pstmt.setInt(1, accno);
			    		   pstmt.setInt(2, raccno);
			    		   pstmt.setInt(3, balance);
			    		   int y=pstmt.executeUpdate();
			    		   if(y>0) {
			    			   return true;
			    		   }
			    		   else {
			    			   return false;
			    		   }
			    		   
			    	   }
			       }
		 }
	 }
	return false;
}
public ArrayList getstatement() throws SQLException {
	String s ="select * from GetStatement where accno=?";
	pstmt=con.prepareStatement(s);
	pstmt.setInt(1, accno);
	ResultSet res=pstmt.executeQuery();
	while(res.next()==true) {
		sal.add(res.getInt("accno"));
		ral.add(res.getInt("raccno"));
		al.add(res.getInt("balance"));
	}
	
	return al;
}
public boolean loanhistory() throws SQLException {
	String s ="select * from customerdetails where accno=?";
	pstmt=con.prepareStatement(s);
	pstmt.setInt(1, accno);
	ResultSet res=pstmt.executeQuery();
	 
   while(res.next()==true) {

		accno=res.getInt("accno");
   email=res.getString("email");
	   String s1 ="insert into LoanHistory values(?,?,?)";
	   pstmt=con.prepareStatement(s1);
	   pstmt.setInt(1,accno);
	   pstmt.setString(2, email);
	   pstmt.setInt(3, amt);
	   int x =pstmt.executeUpdate();
	   if(x>0) {
		   return true;
	   }
   }
	
	return false;
}
public ArrayList getloanhistory() throws SQLException {
	String s ="select * from loanhistory where accno=?";
	pstmt=con.prepareStatement(s);
	pstmt.setInt(1, accno);
 ResultSet res=pstmt.executeQuery();
 while(res.next()==true) {
	 lacc.add(res.getInt("accno"));
	 lemail.add(res.getString("email"));
	 lamt.add(res.getInt("loanamt"));
	 
 }
	return lacc;
}
}
