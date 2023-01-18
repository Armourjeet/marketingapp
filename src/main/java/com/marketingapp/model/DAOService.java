package com.marketingapp.model;

import java.sql.ResultSet;

public interface DAOService {
	
	public void connectDB();
	
	public boolean verifyCredentitals(String email,String password);
	
	public boolean saveRegistration(String name, String city, String email,String mobile);

	public ResultSet getAllRegistrations();

	public void deleteRegistration(String email);

	public void UpdateReegistration(String email, String mobile);


}
