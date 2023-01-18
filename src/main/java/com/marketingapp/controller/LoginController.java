package com.marketingapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marketingapp.model.DAOService;
import com.marketingapp.model.DAOServiceImpl;

@WebServlet("/verifylogin")
public class LoginController extends HttpServlet{

	public LoginController() {
		super();
		 
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//System.out.println(email);
		//System.out.println(password);
		
		// call service and view layer
		
		DAOService service= new DAOServiceImpl();
		service.connectDB();
		boolean status = service.verifyCredentitals(email, password);
		
	    if (status==true) {
	    	HttpSession session = request.getSession(true);
	    	session.setAttribute("email", email);
	    	session.setMaxInactiveInterval(20);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/create_registration.jsp");
		rd.forward(request, response);
	    }else {
	    	request.setAttribute("error","Invalid Username or password");
	    	RequestDispatcher rd = request.getRequestDispatcher("login_reg.jsp");
	    	rd.forward(request, response);
	    }	
			
		}catch(Exception e) {
			e.printStackTrace();
			}
	}
}

