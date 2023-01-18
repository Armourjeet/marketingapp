package com.marketingapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutController() {
        super();
         
    }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  try {
		  
		HttpSession session = request.getSession(false);
		session.invalidate();
		
	    request.setAttribute("msg","Logout successfuly!!");
	      
		RequestDispatcher rd = request.getRequestDispatcher("login_reg.jsp");
    	rd.forward(request, response);
    	
	}catch(Exception e) {
		e.printStackTrace();
		}
	}
}
 