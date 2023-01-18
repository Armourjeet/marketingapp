package com.marketingapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {

	private Connection con;
	private Statement stmnt;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/marketingapp","root","test");
			stmnt = con.createStatement();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifyCredentitals(String email, String password) {
		try {
			 ResultSet result = stmnt.executeQuery("select* from login where email='"+email+"'and password ='"+password+"'");
			 return result.next();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean saveRegistration(String name, String city, String email, String mobile) {
		try {
			
			 stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		 
	}

	@Override
	public ResultSet getAllRegistrations() {
	 
		try {
			 ResultSet result = stmnt.executeQuery("select* from registration");
			 return result ;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void deleteRegistration(String email) {
		try {	
			 stmnt.executeUpdate("delete from registration where email='"+email+"'");
			
		}catch(Exception e){
			e.printStackTrace();
		} 
		
	}

	@Override
	public void UpdateReegistration(String email, String mobile) {
		try {	
			 stmnt.executeUpdate("update registration set mobile='"+mobile+"' where email='"+email+"'");
			
		}catch(Exception e){
			e.printStackTrace();
		} 
		
	}	
		
		
	}	 
	 
